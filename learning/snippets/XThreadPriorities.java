package snippets;

import java.util.Random;

/**
 * Tests the Thread priorities of a Java program by letting threads run "unlimited amounts" of work for a fixed period
 * of time, counting how much work they get done.
 * 
 * @author Endre Stølsvik
 */
public class XThreadPriorities {

    static volatile boolean _runThreads;

    public static final int PARALLELS = Runtime.getRuntime().availableProcessors();

    public static final int RUNNING_WARMUP_SECONDS = 1;

    public static final int RUNNING_SECONDS = 60 * 1;

    public static void main(String[] args) throws InterruptedException {
        // Run warmup
        run(RUNNING_WARMUP_SECONDS);
        System.out.println("Warmup complete.");
        Thread.sleep(500);
        System.out.println("Running test.");
        // Run test
        Runner[][] runners = run(RUNNING_SECONDS);

        // Dump results.
        System.out.println("Thread MIN_PRIORITY:[" + Thread.MIN_PRIORITY + "], NORM_PRIORITY:[" + Thread.NORM_PRIORITY
                + "], MAX_PRIORITY:[" + Thread.MAX_PRIORITY + "].");

        double totalDummy = 0;
        long totalWork = 0;
        for (int j = 0; j < runners[0].length; j++) {
            int pri = runners[0][j]._priority;
            String msg = "Pri:" + pri + " - ";
            long total = 0;
            for (int i = 0; i < runners.length; i++) {
                totalDummy = runners[i][j]._dummy;
                assert pri == runners[i][j]._priority;
                long counter = runners[i][j]._counter;
                total += counter;
                msg += " " + counter;
            }
            totalWork += total;
            System.out.println(total + " - " + msg);
        }
        System.out.println("TotalWork: [" + totalWork + "] (TotalyDummy: [" + totalDummy + "]).");
    }

    private static Runner[][] run(int seconds) throws InterruptedException {
        _runThreads = true;
        int priorities = Thread.MAX_PRIORITY - Thread.MIN_PRIORITY + 1;
        Runner[][] runners = new Runner[PARALLELS][priorities];
        // Make threads
        for (int i = 0; i < PARALLELS; i++) {
            int pri = Thread.MIN_PRIORITY;
            for (int j = 0; j < priorities; j++) {
                runners[i][j] = new Runner(pri++);
            }
        }
        // Start threads.
        for (int i = 0; i < PARALLELS; i++) {
            for (int j = 0; j < priorities; j++) {
                runners[i][j].start();
            }
        }
        // Run all threads for whatever number of seconds.
        Thread.sleep(seconds * 1000);
        // Ask threads to stop.
        _runThreads = false;
        // Make sure they're stopped by joining them
        for (int i = 0; i < PARALLELS; i++) {
            for (int j = 0; j < priorities; j++) {
                runners[i][j].join();
            }
        }
        return runners;
    }

    private static class Runner extends Thread {
        final Random _random = new Random();
        final int _priority;

        public Runner(int priority) {
            this._priority = priority;
        }

        long _counter = 0;
        double _dummy = 0;

        @Override
        public void run() {
            Thread.currentThread().setPriority(_priority);
            while (_runThreads) {
                _counter++;
                _dummy += (_random.nextDouble() * 2 - 1) / 123.579 * (_random.nextDouble() * 2 - 1);
            }
        }
    }
}
package snippets;

import java.lang.management.ManagementFactory;
import java.util.Random;

public class ThreadPriorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, world");
		ThreadPriorityTest hw = new ThreadPriorityTest();
		if(args.length == 4 && 
				args[0] != null && !(args[0].isEmpty()) && 
				args[1] != null && !(args[1].isEmpty()) && 
				args[2] != null && !(args[2].isEmpty()) &&
				args[3] != null && !(args[3].isEmpty()))
		{
			System.out.println("Sleeping for 20 seconds before start");
			try {
				Thread.currentThread().sleep(20 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hw.start(args[0], args[1], args[2], args[3]);
		}
		else
		{
			System.out.println("Usage: timeInSeconds threadCount priority1 priority2");
			System.out.println("Running with default values");
			System.out.println("Sleeping for 20 seconds before start");
			try {
				Thread.currentThread().sleep(20 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hw.start("5", "2", ""+Thread.MIN_PRIORITY, ""+Thread.MAX_PRIORITY);
		}
		
		System.out.println(ManagementFactory.getRuntimeMXBean().getName());
	}
	
	public void start(String seconds, String threadCount, String priority1, String priority2)
	{
		int secondsInt = Integer.parseInt(seconds);
		int threadCountInt = Integer.parseInt(threadCount);
		int threadPriority1 = Integer.parseInt(priority1);
		int threadPriority2 = Integer.parseInt(priority2);
		MyThread[] threadArray = new MyThread[threadCountInt];
		for(int i=0; i<threadCountInt/2; i++)
		{
			threadArray[i] = new MyThread(threadPriority1, "th"+i);
		}
		
		for(int i=threadCountInt/2; i<threadCountInt; i++)
		{
			threadArray[i] = new MyThread(threadPriority2, "th"+i);
		}

		try 
		{
			for(int i=0; i<threadCountInt; i++)
			{
				threadArray[i].start();
			}
			
			Thread.sleep(secondsInt * 1000);

			for(int i=0; i<threadCountInt; i++)
			{
				threadArray[i].stopThread();
			}

			for(int i=0; i<threadCountInt; i++)
			{
				threadArray[i].join();
			}

			double set1Count =0;
			for(int i=0; i<threadCountInt/2; i++)
			{
				set1Count += threadArray[i].getStats();
			}
			System.out.println("Avg for set1: " + set1Count / (threadCountInt/2));
			
			double set2Count = 0;
			for(int i=threadCountInt/2; i<threadCountInt; i++)
			{
				set2Count += threadArray[i].getStats();
			}
			System.out.println("Avg for set2: " + set2Count / (threadCountInt/2));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class MyThread extends Thread
	{
		final Random _random = new Random();
		boolean stop = false;
		final int _priority;
        long _counter = 0;
        double _dummy = 0;
		private String name;
		
        public MyThread(int priority, String name) {
            this._priority = priority;
            this.name = name;
        }
        
		@Override
		public void run() {
			System.out.println("Started thread: " + name + " with priority: " + _priority);
			Thread.currentThread().setPriority(_priority);
			Thread.currentThread().setName(name);
			
			while(!stop)
			{
				_counter++;
                _dummy += (_random.nextDouble() * 2 - 1) / 123.579 * (_random.nextDouble() * 2 - 1);
			}
		}
		
		public void stopThread()
		{
			stop = true;
		}
		
		public long getStats()
		{
			System.out.println("counter of thread "+ name +" with priority "+ _priority + " is: \t" + (_counter)/(1024*1024) + "M");
			return _counter;
		}
	}

}

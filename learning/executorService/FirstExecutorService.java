package executorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirstExecutorService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
		ExecutorService e = new ThreadPoolExecutor(2, 3, 10,  TimeUnit.MILLISECONDS, workQueue);
		e.submit(new task(15, "th1"));
		e.submit(new task(30, "th2"));
		e.submit(new task(45, "th3"));
		e.submit(new task(50, "th4"));
		while(e.isTerminated())
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

class task implements Runnable
{
	private int waitDuration;
	private String name;

	@Override
	public void run() {
		System.out.println("Started "+name);
		try {
			Thread.sleep(waitDuration * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished "+name);
	}
	
	public task(int duration, String threadName) {
		this.waitDuration = duration;
		this.name = threadName;
	}
}
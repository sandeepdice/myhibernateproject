package temp.atomicInteger;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	/**
	 * @param args
	 */
	public AtomicBoolean sharedBoolean = new AtomicBoolean(false);
//	public boolean sharedBoolean = false;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AtomicBooleanTest obj = new AtomicBooleanTest();
		new Thread(obj.new myRunnable()).start();
		new Thread(obj.new myRunnable()).start();
		new Thread(obj.new myRunnable()).start();
		Thread.sleep(10000);
		obj.sharedBoolean.set(true);
//		obj.sharedBoolean = true;
	}

	class myRunnable implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread started..");
			while(!sharedBoolean.get())
//			while(!sharedBoolean)
			{
//				System.out.println("In loop..");
			}
			System.out.println("Exiting..");
		}
		
	}
}

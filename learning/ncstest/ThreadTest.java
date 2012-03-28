package ncstest;

public class ThreadTest 
{
	public static void main(String[] args) 
	{
		
		/*
		 * Q1 - will this print equal or not equal?
		 */
		
		if(" string ".trim() == "string")
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		/*
		 * Q2 - Will this program exit as soon as main thread exits? or it prints "exiting thread" and only then exit?
		 */
		
		myThread th = new myThread();
		th.start();
		int[] array = new int[20];
		array[20] = 2;
	}
}

class myThread extends Thread
{
	@Override
	public void run() 
	{
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting thread");
		
	}
}

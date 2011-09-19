package snippets;

public class TestThread  extends Thread
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Counter c = new Counter();
		TestThread t1 = new TestThread(c);
		TestThread t2 = new TestThread(c);
		
		t1.start();
		t2.start();
		try
		{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted");
		}
		
		System.out.println(c.getCount());
	}
	
	
	Counter counter;
	
	TestThread(Counter c)
	{
		this.counter = c;
	}
	
	@Override
	public void run() {
		counter.count();
	}

}

class Counter
{
	int count = 0;
	
	void inc(int n)
	{
		count += n;
	}
	
	void count()
	{
		for(int i=1; i<=10; i++)
		{
			inc(1);
		}
	}
	
	int getCount()
	{
		return count;
	}
}

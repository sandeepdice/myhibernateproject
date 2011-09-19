package snippets;

import java.util.concurrent.atomic.AtomicInteger;

public class WrapperTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AtomicInteger a = new AtomicInteger(0);
		incrementA(a);
		System.out.println(a);

	}

	private static void incrementA(AtomicInteger a)
	{
		a.incrementAndGet();
		a.addAndGet(10);
		System.out.println(a);
	}

}

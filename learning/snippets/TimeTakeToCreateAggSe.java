package snippets;

public class TimeTakeToCreateAggSe
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}

package temp;

public class SleepTest {
	public static void main(String[] args) {
		new SleepTest();
	}
	SleepTest()
	{
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

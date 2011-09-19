package snippets;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Timer purgeTimer = new Timer("::Purge");
		int purgeInt = 60;
		System.out.println(new Date());
		purgeTimer.schedule(new PurgeTimerTask(), purgeInt * 1000, purgeInt * 1000);
	}

}

class PurgeTimerTask extends TimerTask
{
	@Override
	public void run()
	{
		System.out.println(new Date() + " invoked");
	}
}

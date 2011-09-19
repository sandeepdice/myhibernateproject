package snippets;

import java.text.DateFormat;
import java.util.Date;

public class UnixTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tMin = (new Date()).getTime()/1000L;
		long tSec = (new Date()).getTime();
		System.out.println("currentTime: "+ new Date(new Date().getTime()));
		System.out.println("currentTime in millisec: "+ new Date().getTime());
		System.out.println("tMin: "+ tMin*1000);
		System.out.println("tMin in new Date(tMin): "+ new Date(tMin*1000));
		System.out.println("tSec: "+ tSec);
		System.out.println("tSec in new Date(tSec): "+ new Date(tSec));		
		System.out.println((new Date()));
		System.out.println((new Date(1284002520)));
		System.out.println(DateFormat.getDateTimeInstance().format(1000*((new Date()).getTime()/1000L)));
	}
}
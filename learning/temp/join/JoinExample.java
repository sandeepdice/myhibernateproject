package temp.join;

import java.util.HashMap;
import java.util.HashSet;

public class JoinExample extends Thread {
public static void main(String[] args) {
	JoinExample je = new JoinExample();
	je.start();
}

public void run()
{
	try 
	{
		this.join();
	} 
	catch (InterruptedException e) 
	{
	
	}
	
	HashMap hm = new HashMap();
	HashSet hs = new HashSet();
}
}

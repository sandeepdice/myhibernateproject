package snippets;

import java.util.HashMap;

public class NullValueCastTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		A a = null;
		B b = (B) a;
		
		HashMap hm = new HashMap(1);
		hm.get(null);
	} 

}

class A
{
	
}

class B extends A
{
	
}

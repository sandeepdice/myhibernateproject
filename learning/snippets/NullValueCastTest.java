package snippets;

import java.util.HashMap;

public class NullValueCastTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		A123 a = null;
		B123 b = (B123) a;
		
		HashMap hm = new HashMap(1);
		hm.get(null);
	} 

}

class A
{
	
}

class B extends A123
{
	
}

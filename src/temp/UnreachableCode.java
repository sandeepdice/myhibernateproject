package temp;

public class UnreachableCode {
public static void main(String[] args) {
	try
	{
		
	}
	catch(Exception e)
	{
		
	}
	finally
	{
		// if we uncomment the two lines beolow, the last print line is unreachable
//		throw new Exception();
	}
//	System.out.println("unreachable code??");
}
}

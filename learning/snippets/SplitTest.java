package snippets;

public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String x = "lte.test.mnc012.mcc345.gprs";
		String[] parts = x.split("\\.");
		System.out.println(parts.length);
		for(String string : parts)
		{
			System.out.println(string);
		}
		
		
	}

}

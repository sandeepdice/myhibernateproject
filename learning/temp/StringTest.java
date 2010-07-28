package temp;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "--Enriched.CRMS--";
		System.out.println(s.subSequence(2, s.lastIndexOf("--")));
	}

}

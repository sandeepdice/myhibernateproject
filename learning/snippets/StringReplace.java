package snippets;

public class StringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc =='%s' || def == '%s'";
		System.out.println(s.replace("%s", "TEST"));

	}

}

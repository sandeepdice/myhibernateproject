package myregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {
	public static void main(String[] args) {
		Pattern pattern1 = Pattern.compile("123");
		Matcher matcher1 = pattern1.matcher("123");
		boolean pattern1FoundIsLineSourceEventStart = matcher1.matches();

			System.out.println(pattern1FoundIsLineSourceEventStart);
	}
}

package myregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {
	public static void main(String[] args) {
		Pattern pattern1 = Pattern.compile("[INFO|DEBUG|TRACE]\\s*$");
		Matcher matcher1 = pattern1.matcher("2010-07-12 02:16:40 PDT [testdummySubscriberComponent2 ] DEBUG Field:");
		boolean pattern1FoundIsLineSourceEventStart = matcher1.find();

			System.out.println(pattern1FoundIsLineSourceEventStart);
	}
}

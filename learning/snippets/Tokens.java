package snippets;

import java.util.StringTokenizer;

public class Tokens {
public static void main(String[] args) {
	StringTokenizer tokens = new StringTokenizer("a,ba,c",",");
	while(tokens.hasMoreTokens())
	{
		System.out.println(tokens.nextToken());
	}
}
}

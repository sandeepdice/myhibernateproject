package snippets;

public class StaticInit {
public static void main(String[] args) {
	
}
public void staticInitTest()
{
	static int x;
}

}

class superclass
{
	static void method() {
	}
	protected String step2(String str1, String str2) { return str1; }
}

class childclass extends superclass
{
	// can be less restrictive but not more restrictive
	public String step2(String str2, String str1) { return str1; }
	void method(int x) {
		
	}
	// compile error if we remove kw static
	static void method() {
		
	}
}

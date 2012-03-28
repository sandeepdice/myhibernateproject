package bcstest;

public class Test {
	public static void main(String[] args) {
		byte b1=10, b2=20, b3;
		short s=10;
		// compile error on both statements below
//		b3 = s;
//		b3= b1*b2;
	}
}

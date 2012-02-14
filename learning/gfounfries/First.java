package gfounfries;

public class First {

	/**
	 * @param args
	 */
	static boolean a, b, c;
	static int z;

	public static void main(String[] args) {
		boolean x = (a = true) | (b = true) && (c = true);
		System.out.println("x=" + x + " a= " + a + " b=" + b + " c=" + c);
		
		int[] a2 = {1, 2}, a3 = {3,4,5}, a4={6,7,8,9};
		int[] [] a1 = {a2, a3, a4};
//		System.out.println(a1[3][1] + ", " + a1[1][2] + ", " + a1[2][3]);
		
		int[] i = {1,2,3};
		Object obj = i;
//		i = obj; // Compile error. Cast needed
		
		for(z=1;z<3;z++) System.out.print(z);
		System.out.println();
		for(int z=1;z<3;z++) System.out.print(z);
		int z;
		System.out.println();
		for(z=0;z<2;z++) System.out.print(z);
		
		int a11=1; long b11=2;
		System.out.println(m(a11) + ", " + m(b11));
	}

	static String m(float x) {return "float";}
	static String m(double x) {return "double";}
}

interface A
{
//	final void method1();
//	synchronized void method2();
	public void method3();
	abstract void method4();
//	native void method5();
}

/*
	* 1. What's LookupDispatchAction in struts
	* 2. What's struts action & action mapping
	* 3. What's IOC in spring
	* 4. How do you configure hibernate?
	* 5. Write hbm.xml
*/
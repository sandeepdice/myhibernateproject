package temp;

public class AbstractClassExample {}

interface interfaceExample
{
	public void method1();
	public void method2();
	public void method3();
}

abstract class abstractExample implements interfaceExample
{
	public void method3() {} 
}

class A extends abstractExample
{
	public void method1() { 
		// blank method 
		}
	public void method2() {
		
	}
}

class B extends abstractExample
{
	public void method1() {}
	public void method2() {}
}
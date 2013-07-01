package behavioral.templatemethod;

/**
 * I guess "Template Method" more meaningful than "Method Template". In template
 * method, we define steps of algorithm in abstract class and allows subclass to
 * provide implementation for one or more steps.
 * 
 * This way, algorithm is protected in template method. Algorithm is not known
 * by specific classes.
 * 
 * New implementations just need to override a couple of methods but not entire
 * algorithm. Methods defined in abstract (parent) class are non-abstract
 * 
 * In this example, beverage preparation algorithm is in BevarageMaker. Specific
 * steps for Tea and Coffee are in their respective classes.
 * 
 * In JDK:
 * 
 * Template method (recognizable by behavioral methods which already have a
 * "default" behavior defined by an abstract type)
 * 
 * 1. All non-abstract methods of java.io.InputStream, java.io.OutputStream,
 * java.io.Reader and java.io.Writer.
 * 
 * 2. All non-abstract methods of java.util.AbstractList, java.util.AbstractSet
 * and java.util.AbstractMap.
 * 
 * 3. javax.servlet.http.HttpServlet, all the doXXX() methods by default sends a
 * HTTP 405 "Method Not Allowed" error to the response. You're free to implement
 * none or any of them.
 * 
 * @author ray55577
 * 
 */

abstract class BevarageMaker {
	void prepareBevarage() {
		boilWater();
		addBeveragePowderAndBrew();
		pourInCup();
		addCondiments();
	}

	abstract void addCondiments();

	private void pourInCup() {
		System.out.println("Pouring beverage in cup");
	}

	abstract void addBeveragePowderAndBrew();

	private void boilWater() {
		System.out.println("Boiling water");
	}
}

class Tea extends BevarageMaker {

	@Override
	void addCondiments() {
		System.out.println("Adding lemon ");
	}

	@Override
	void addBeveragePowderAndBrew() {
		System.out.println("Adding Tea powder and brewing....");
	}
}

class Coffee extends BevarageMaker {

	@Override
	void addCondiments() {
		System.out.println("Adding Milo to make it a Mocha");
	}

	@Override
	void addBeveragePowderAndBrew() {
		System.out.println("Adding Italia Coffee powder");
	}

}

public class TemplateMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tea tea1 = new Tea();
		Coffee coffee1 = new Coffee();
		tea1.prepareBevarage();
		coffee1.prepareBevarage();

	}

}
package hibernate.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("applicationContext.xml");
	public static void main(String[] args) {
		testClass bean= (testClass) ac.getBean("testClassObj");
        System.out.println("Retrieved string: " + bean.getMyString());
    }
}

class testClass
{
	private String myString;

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}
}
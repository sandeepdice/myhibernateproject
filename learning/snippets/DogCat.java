package snippets;

public class DogCat {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Dog d1 = new Dog();
		d1.bark();
		Dog d2 = new Dog();
		d2.bark();
		
		Cat c1 = new Cat();
		c1.meow();
		Cat c2 = new Cat();
		c2.meow();
		Cat c3 = new Cat();
		c3.meow();
		
		System.out.println(d1.getCounter());
		System.out.println(c1.getCounter());
	}
	
}

class Animal
{
	static int counter = 0;
	int getCounter()
	{
		return counter;
	}
	static void inc()
	{
		counter++;
	}
}

class Dog extends Animal
{
	void bark()
	{
		inc();
	}
}

class Cat extends Animal
{
	void meow()
	{
		inc();
	}
}
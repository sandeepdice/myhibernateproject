package temp;

public class ChildThread {
	public static void main(String[] args) {
		new MyThread("hell").start();
	}
}

class MyThread extends Thread
{
	String name;
	MyThread(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Started thread: " + name);
		while (name.equals("hell"))
		{
			new MyThread("name").start();
		}
		System.out.println("Ended thread: " + name);
	}
}
package snippets;

class A123 {
	private void m1() {
		System.out.println("A.m1");
	}

	public void m2() {
		m1();
		System.out.println("A.m2");
	}
	
	public void m1(int i) {
        System.out.println("A.m1:"+i);
	}
}

class B123 extends A123 {
	public void m1() {
		System.out.println("B.m1");
	}

	public void m2() {
		System.out.println("B.m2");
	}
	
	public void m1(long i) {
        System.out.println("B.m1:"+i);
	}
}

class test {
	public static void main(String[] s) {
		B123 b = new B123();
		b.m2();
		
		test t = new test();
        StringBuffer String = new StringBuffer("  Trim Me  ");
        t.trimIt(String);
        System.out.println(String);
        
        B123 b123 = new B123();
        b123.m1(999999); // Line-1

        A123 a123 = new B123();
        a123.m1(999999);    // Line-2
        
        /*
        for(int i=0; i < 10; i = i++ ) {
            System.out.println("Processing..." + i);
        }
        */
        
        Thread mth = new Thread(new myRunnable());
        mth.start();
	}
	
	public void trimIt(StringBuffer s) {
        s.trimToSize();
    }
}

class myThread extends Thread {

    public void run() {
        System.out.println("In myThread.run()");
    }
}

class myRunnable implements Runnable {

    public void run() {
        System.out.println("In myRunnable.run()");
    }
}
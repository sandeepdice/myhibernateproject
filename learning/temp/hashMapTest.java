package temp;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class hashMapTest {
	public static void main(String[] args) {
		LinkedHashMap hm = new LinkedHashMap();
		myClass m1 = new myClass(10);
		myClass m2 = new myClass(20);
		myClass m3 = new myClass(30);
		
		hm.put(m1.hashCode(), m1);
		hm.put(m1.hashCode(), m2);
		hm.put(m1.hashCode(), m3);
		
		System.out.println(((myClass)hm.get(9)).x);
	}
}

class myClass
{
	public int x;
	myClass(int x)
	{
		this.x = x;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 9;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.x==((myClass)obj).x;
	}
}

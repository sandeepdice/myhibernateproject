package temp;

import java.util.ArrayList;
import java.util.List;

public class Prime10001 {

	static int itrCounter=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=1; int number = 3;
		System.out.println(System.currentTimeMillis());
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		while (x < 10001)
		{
			itrCounter++;
			if(prime(number, list))
			{
				list.add(number);
				x++;
			}
			number++;
		}
		System.out.println(System.currentTimeMillis());
		System.out.println("10001th prime: " + (number-1));
		System.out.println("itrCounter: "+itrCounter);
	}
	
	static boolean prime(int x, List<Integer> list)
	{
		for(Integer i : list)
		{
			itrCounter++;
			if(x%i == 0)
				return false;
		}
		return true;
	}

}

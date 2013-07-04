package codility.train;

import java.util.Set;
import java.util.TreeSet;


public class Alpha2010 {

	Set<Integer> distinctArray = new TreeSet<Integer>();
	int lastDistinctIndex;

	public int solution(int[] A) {
		// write your code here...
		// check its existance in distinct array
		if(A == null)
			return 0;
		else if (A.length == 0)
			return 0;
		else {
			int index = 0;
			for (int i : A) {
				// if it exists ignore
				// else add to list, assign index to lastDistinctIndex
				if (!(distinctArray.contains(i))) {
					distinctArray.add(i);
					lastDistinctIndex = index;
				}
				index++;
			}
			return lastDistinctIndex;
		}
	}

	public static void main(String[] args) {
		Alpha2010 s = new Alpha2010();
		System.out.println(s.solution(new int[] { }));
	}
}

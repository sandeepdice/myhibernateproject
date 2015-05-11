package ta.test;

import junit.framework.Assert;

import org.junit.Test;

import ta.findcommonancestor.MyFindCommonAncestor;

public class CommonAncestorTest {

	@Test
	public void test() {
		MyFindCommonAncestor find = new MyFindCommonAncestor();
		
		/*
		 *     
		 *     E-F
              /   \
		   A-B-C-D-G
		 */
		Assert.assertEquals("B", find.findCommmonAncestor(new String[]{"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, "D", "F"));
		Assert.assertEquals(null, find.findCommmonAncestor(new String[]{"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, "A", "A"));		
		Assert.assertEquals(null, find.findCommmonAncestor(new String[]{"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, null, null));
		Assert.assertEquals(null, find.findCommmonAncestor(new String[]{"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, "J", "J"));		
		
		/*
		 *      
		 *     E-F
              /   \
		   A-B-C-D-G------------O----P
		        \              /    /
		         H - L - M - N     /
		          \               /
		           I - J - K------
		 */
		Assert.assertEquals("B", find.findCommmonAncestor(new String[]{"P","O","N","M","L","K","J","I","H", 
				"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"O","K"},{"N","G"},{"M"},{"L"},{"H"},{"J"},{"I"},{"H"},{"C"},
				{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, 
				"K", "F"));
		Assert.assertEquals("B", find.findCommmonAncestor(new String[]{"P","O","N","M","L","K","J","I","H", 
				"G", "F", "E", "D", "C", "B", "A"}, 
				new String[][] {{"O","K"},{"N","G"},{"M"},{"L"},{"H"},{"J"},{"I"},{"H"},{"C"},
				{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}, 
				"O", "M"));
	}

}

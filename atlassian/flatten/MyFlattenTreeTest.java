package flatten;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class MyFlattenTreeTest {

	@Test(expected=IllegalArgumentException.class)
	public void nullTree() {
		Tree<Integer> tree = null;
		
		MyFlattenTree<Integer> flattener = new MyFlattenTree<Integer>();
		flattener.flattenInOrder(tree);
	}

	@Test
	public void justLeaf() {
		Tree<Integer> loneLeafTree = new Tree.Leaf<Integer>(new Integer(1));
		
		MyFlattenTree<Integer> flattener = new MyFlattenTree<Integer>();
		List<Integer> inorderList = flattener.flattenInOrder(loneLeafTree);
		
		Assert.assertEquals(Integer.valueOf(1), inorderList.get(0));
	}

	/**
	 *   /|\
 		1 2 3
		would result in the list [1,2,3].
	 */

	@Test
	public void damnSimpleTree() {
		Tree.Leaf<Integer> l1 = new Tree.Leaf<Integer>(new Integer(1));
		Tree.Leaf<Integer> l2 = new Tree.Leaf<Integer>(new Integer(2));
		Tree.Leaf<Integer> l3 = new Tree.Leaf<Integer>(new Integer(3));
		Tree<Integer> tree = new Tree.Node(l1, l2, l3);		
		MyFlattenTree<Integer> flattener = new MyFlattenTree<Integer>();
		List<Integer> inorderList = flattener.flattenInOrder(tree);
		
		Assert.assertEquals(Integer.valueOf(1), inorderList.get(0));
		Assert.assertEquals(Integer.valueOf(2), inorderList.get(1));
		Assert.assertEquals(Integer.valueOf(3), inorderList.get(2));
	}
	
	/**
	 *   /|\
 		1 | 6
  		 /|\
 		5 4 9
		would result in the list [1,5,4,9,6].
	 */
	@Test
	public void simpleTree() {
		// Case 1
		Tree.Leaf<Integer> leftMostLoneLeaf = new Tree.Leaf<Integer>(new Integer(1));
		Tree.Leaf<Integer> rightMostLoneLeaf = new Tree.Leaf<Integer>(new Integer(6));
		
		Tree.Leaf<Integer> leftLeaf = new Tree.Leaf<Integer>(new Integer(5));
		Tree.Leaf<Integer> middleLeaf = new Tree.Leaf<Integer>(new Integer(4));
		Tree.Leaf<Integer> rightLeaf = new Tree.Leaf<Integer>(new Integer(9));
		
		Tree.Node<Integer> middleNode = new Tree.Node<Integer>(leftLeaf,middleLeaf,rightLeaf);
		Tree<Integer> tree = new Tree.Node(leftMostLoneLeaf, middleNode, rightMostLoneLeaf);
		
		MyFlattenTree<Integer> flattener = new MyFlattenTree<Integer>();
		List<Integer> inorderList = flattener.flattenInOrder(tree);
		
		Assert.assertEquals(Integer.valueOf(1), inorderList.get(0));
		Assert.assertEquals(Integer.valueOf(5), inorderList.get(1));
		Assert.assertEquals(Integer.valueOf(4), inorderList.get(2));
		Assert.assertEquals(Integer.valueOf(9), inorderList.get(3));
		Assert.assertEquals(Integer.valueOf(6), inorderList.get(4));
	}

/**
 *    /|\
	 1 | 6
	  /|\
	 5 | \
	   |  \
	  /|\  \
	 2 3 4  \
	       / | \
	      7  8  9
 
 [1,5,2,3,4,7,8,9,6]

 */
	@Test
	public void littleComplexTree() {
		// Case 1
		Tree.Leaf<Integer> l1 = new Tree.Leaf<Integer>(new Integer(1));
		Tree.Leaf<Integer> l2 = new Tree.Leaf<Integer>(new Integer(2));
		Tree.Leaf<Integer> l3 = new Tree.Leaf<Integer>(new Integer(3));
		Tree.Leaf<Integer> l4 = new Tree.Leaf<Integer>(new Integer(4));
		Tree.Leaf<Integer> l5 = new Tree.Leaf<Integer>(new Integer(5));
		Tree.Leaf<Integer> l6 = new Tree.Leaf<Integer>(new Integer(6));
		Tree.Leaf<Integer> l7 = new Tree.Leaf<Integer>(new Integer(7));
		Tree.Leaf<Integer> l8 = new Tree.Leaf<Integer>(new Integer(8));
		Tree.Leaf<Integer> l9 = new Tree.Leaf<Integer>(new Integer(9));
		
		Tree.Node<Integer> n1 = new Tree.Node<Integer>(l2,l3,l4);
		Tree.Node<Integer> n2 = new Tree.Node<Integer>(l7,l8,l9);
		Tree.Node<Integer> n3 = new Tree.Node<Integer>(l5,n1,n2);
		
		Tree<Integer> tree = new Tree.Node(l1, n3, l6);
		
		MyFlattenTree<Integer> flattener = new MyFlattenTree<Integer>();
		List<Integer> inorderList = flattener.flattenInOrder(tree);

		// [1,5,2,3,4,7,8,9,6]
		Assert.assertEquals(Integer.valueOf(1), inorderList.get(0));
		Assert.assertEquals(Integer.valueOf(5), inorderList.get(1));
		Assert.assertEquals(Integer.valueOf(2), inorderList.get(2));
		Assert.assertEquals(Integer.valueOf(3), inorderList.get(3));
		Assert.assertEquals(Integer.valueOf(4), inorderList.get(4));
		Assert.assertEquals(Integer.valueOf(7), inorderList.get(5));
		Assert.assertEquals(Integer.valueOf(8), inorderList.get(6));
		Assert.assertEquals(Integer.valueOf(9), inorderList.get(7));
		Assert.assertEquals(Integer.valueOf(6), inorderList.get(8));
	}

}

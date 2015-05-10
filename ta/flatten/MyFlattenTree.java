/**
 * 
 */
package flatten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeep
 *
 */

class LeafFunction<T, Triple<Tree<T>>> implements Function<P, R>
{

	
}

public class MyFlattenTree<T> implements FlattenTree<T> {

	List <T> list = new ArrayList<T>();
	
	@Override
	public List<T> flattenInOrder(Tree<T> tree) {
		return null;
		// if tree's left is Leaf, get the leaf and add to list
		// if tree.get().isLeft() is true, tree.get().ifLeft(function to traverse Leaf)
		// if tree.get().isLeft() is false, tree.get().ifRight(function to traverse Triple)
		// else tree.get
		
		// if tree's mid is Leaf, get the leaf and add to list
		// if tree's left is a Node, flatten the node
		
		// if tree's right is Leaf, get the leaf and add to list
		// if tree's right is a Node, flatten the node
	}

	public static void main(String[] args) {
		Tree.Leaf<Integer> leftMostLoneLeaf = new Tree.Leaf<Integer>(new Integer(1));
		Tree.Leaf<Integer> rightMostLoneLeaf = new Tree.Leaf<Integer>(new Integer(6));
		
		Tree.Leaf<Integer> rightLeaf = new Tree.Leaf<Integer>(new Integer(5));
		Tree.Leaf<Integer> leftLeaf = new Tree.Leaf<Integer>(new Integer(4));
		Tree.Leaf<Integer> middleLeaf = new Tree.Leaf<Integer>(new Integer(9));
		
		Tree<Integer> middleNode = new Tree.Node<Integer>(leftLeaf,middleLeaf,rightLeaf);
//		Tree<Integer> rootNode = new Tree.Node<Integer>(leftMostLoneLeaf,middleNode,rightMostLoneLeaf);
		Tree<Tree<Integer>> tree = Tree.Node.tree(leftMostLoneLeaf, middleNode, rightMostLoneLeaf);
		
//		List<Tree<Integer>> list = new MyFlattenTree<Tree<Integer>>().flattenInOrder(tree);
		Either<Integer, Triple<Tree<Integer>>> either = middleNode.get();
		Either<Integer, Triple<Tree<Integer>>> eitherLeaf = rightLeaf.get();
		Either<Tree<Integer>, Triple<Tree<Tree<Integer>>>> treeEither = tree.get();
		System.out.println(either);
		System.out.println(eitherLeaf);
		System.out.println(treeEither);
	}

}

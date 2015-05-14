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

class LeafFunction<T> implements Function<T, T>
{
	@Override
	public T apply(T p) {
		return p;
	}
}

public class MyFlattenTree<T> implements FlattenTree<T> {

	List <T> list = new ArrayList<T>();
	LeafFunction<T> leafFunction = new LeafFunction<T>();
	LeafFunction<Triple<Tree<T>>> nodeFunction = new LeafFunction<Triple<Tree<T>>>();
	
	@Override
	public List<T> flattenInOrder(Tree<T> tree) {
		// if tree.get() is null, throw IllegalArgumentException
		if(tree==null)
			throw new IllegalArgumentException();
		else
		{
			Either<T, Triple<Tree<T>>> leafOrNode = tree.get();
			// if tree.get() isLeft is true, return list with one element
			if(leafOrNode.isLeft())
			{
				T item = leafOrNode.ifLeft(leafFunction);
				list.add(item);
			}
			// if tree.get() isLeft is false, it's a triple.
			else
			{
				Triple<Tree<T>> triple = leafOrNode.ifRight(nodeFunction);
				// then call flattenInOrder(triple.left). add the returned list to end of my current list.
				flattenInOrder(triple.left());
				// then call flattenInOrder(triple.middle). add the returned list to end of my current list.
				flattenInOrder(triple.middle());
				// then call flattenInOrder(triple.right). add the returned list to end of my current list.
				flattenInOrder(triple.right());
			}
		}
		return list;
	}
}

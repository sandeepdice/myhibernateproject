package iteration;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
	public static void main(String[] args) {
		MyFolderOriginal<Integer, Integer> folderOrig = new MyFolderOriginal<Integer, Integer>();
		MyFolder<Integer, Integer> folderOrigNonRec = new MyFolder<Integer, Integer>();
		Queue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		System.out.println(folderOrig.fold(queue.poll(), queue, new FunctionImpl()));
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println(folderOrigNonRec.fold(queue.poll(), queue, new FunctionImpl()));
	}
}

class FunctionImpl implements Function2<Integer, Integer, Integer> {
	@Override
	public Integer apply(Integer t, Integer u) {
		return t + u;
	}
}

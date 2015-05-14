package iteration;

import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U> {

	@Override
	public U fold(U u, Queue<T> queue, Function2<T, U, U> function) {
		T t;

		if(u == null || queue == null || function == null)
            throw new IllegalArgumentException();

        if (queue.isEmpty()) {
            return u;
        }

        U u2 = function.apply(queue.poll(), u);
		while((t = queue.poll()) != null)
		{
			u2 = function.apply(t, u2);
		}
		return u2;
	}
}
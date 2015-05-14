package iteration;

import java.util.Queue;

public class MyFolderOriginal<T, U> implements Folder<T, U>
{
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
         return fold(function.apply(ts.poll(), u), ts, function);
    }
}

// 99666 98852
// registrar's office: 2709 0979
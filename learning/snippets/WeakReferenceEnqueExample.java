package snippets;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceEnqueExample
{
	public static void main(String[] args) throws InterruptedException
	{
		String weakString = "Help me";
		ReferenceQueue<String> refQ = new ReferenceQueue<String>();
		WeakReference<String> weakRef = new WeakReference<String>(weakString, refQ);
		// there is no more "hard reference to the string"
		weakString = null;
		// there is no object in ReferenceQueue
		System.out.println(refQ.poll());
		// put the object in the ReferenceQueue
		weakRef.enqueue();
		
		// The ReferenceQueue class makes it easy to keep track of dead references. 
		// If you pass a ReferenceQueue into a weak reference's constructor, the reference 
		// object will be automatically inserted into the reference queue when the object 
		// to which it pointed becomes garbage. You can then, at some regular interval, process 
		// the ReferenceQueue and perform whatever cleanup is needed for dead references.
		
		// We use same ReferenceQueue in application to track all dead weak references
		
		while (true)
		{
			// There will be returned "Help me" until the garbage collector will "kill"
			// "weak" string. This will be done after some time because there are no
			// more strong references to the string. After that will be returned a null
			// object.
			System.out.println(weakRef.get());
			// only one time there will be returned a refenrece to the String object
			System.out.println(refQ.poll());
			Thread.sleep(1000);
		}
	}
}
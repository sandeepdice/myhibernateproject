package codejam.qualifier2011;

public class Tuple
{
	String name;
	int position;
	boolean done;
	Tuple prev;
	
	public Tuple getPrev() {
		return prev;
	}
	public void setPrev(Tuple prev) {
		this.prev = prev;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}

package codejam;

import java.util.ArrayList;

public class BotTest
{
	int numberOfButtonsToPress;
	ArrayList<Tuple> positions = new ArrayList<Tuple>(); 
	BotTest()
	{
		
	}
	public void addTuple(Tuple tuple) {
		positions.add(tuple);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Tuple tuple : positions)
		{
			sb.append(tuple.name + " " + tuple.position + " ");
		}
		return sb.toString();
	}
}
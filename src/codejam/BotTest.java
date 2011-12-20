package codejam;

import java.util.ArrayList;

public class BotTest
{
	int numberOfButtonsToPress;
	ArrayList<Tuple> positions = new ArrayList<Tuple>();
	ArrayList<Tuple> orangeBots = new ArrayList<Tuple>();
	ArrayList<Tuple> blueBots = new ArrayList<Tuple>();
	
	public ArrayList<Tuple> getBlueBots() {
		return blueBots;
	}

	public ArrayList<Tuple> getOrangeBots() {
		return orangeBots;
	}
	
	BotTest()
	{
		
	}
	public void addTuple(Tuple tuple) {
		positions.add(tuple);
	}
	
	public void addBlueTuple(Tuple tuple) {
		blueBots.add(tuple);
	}
	
	public void addOrangeTuple(Tuple tuple) {
		orangeBots.add(tuple);
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
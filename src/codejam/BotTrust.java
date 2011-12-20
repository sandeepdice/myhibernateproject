package codejam;

import java.io.FileNotFoundException;

public class BotTrust {
	FileProcessor fp;
	String fileName;
	
	public BotTrust(String args) {
//		fileName = args[1];
		fileName = args;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		BotTrust instance = new BotTrust("c:\\sandeep\\personal\\codejam\\test1.txt");
		BotTests tests = instance.processFile(instance.fileName);
		
		Bot orangeBot = new BotImpl("O", 1);
		Bot blueBot = new BotImpl("B", 1);
		
		int testCounter = 0;
		
		for(BotTest test: tests.botTests)
		{
			int itrCounter = 0;
			System.out.println("**** Test: " + test);
			System.out.printf("%25s | %25s\n", "orangeBot", "blueBot");
			System.out.println("*****************************************************");
			orangeBot.restPositions();
			blueBot.restPositions();
			
			for(Tuple tuple : test.positions)
			{
				while(!(orangeBot.isPressed() || blueBot.isPressed()))
				{
					itrCounter++;
					orangeBot.processInput(tuple);
					blueBot.processInput(tuple);
					System.out.printf("%25s | %25s\n", orangeBot, blueBot);
				}
				orangeBot.resetPressed();
				blueBot.resetPressed();
			}
			System.out.println("Case #"+(testCounter++)+ " " + itrCounter);
		}
	}
	
	public BotTests processFile(String file) throws FileNotFoundException
	{
		fp = new FileProcessor(file);
		BotTests tests = fp.processFile();
		return tests;
	}
}

interface Bot
{
	void processInput(Tuple tuple);
	void restPositions();
	boolean isPressed();
	void resetPressed();
	void setNextPosition(Tuple tuple);
}

class BotImpl implements Bot
{
	boolean pressed = false;
	String name;
	int requestedPosition;
	int currentPosition;
	String currentRequestedBot;
	String currentStatus;
	
	public BotImpl(String name, int initPosition) {
		this.name = name;
		this.requestedPosition = initPosition;
	}
	
	@Override
	public boolean isPressed() {
		return (pressed == true);
	}

	@Override
	public void processInput(Tuple tuple) {
		
		this.setNextPosition(tuple);
		
		if(currentPosition < requestedPosition)
		{
			currentPosition++;
			currentStatus = "moved to position: " + currentPosition;
		}
		else if(currentPosition == requestedPosition && currentRequestedBot.equals(name))
		{
			pressed = true;
			currentStatus = "pressed button " + requestedPosition;
		}
		else if(currentPosition > requestedPosition)
		{
			currentPosition--;
			currentStatus = "moved to position: " + currentPosition;
		}
	}

	@Override
	public void resetPressed() {
		pressed = false;
	}

	@Override
	public void setNextPosition(Tuple tuple) {
		if (tuple.name.equalsIgnoreCase(name))
		{
			this.currentRequestedBot = tuple.name;
			this.requestedPosition = tuple.position;
		}
	}
	
	@Override
	public String toString() {
		return currentStatus;
	}

	@Override
	public void restPositions() {
		this.currentPosition = this.requestedPosition = 1;
		pressed = false; currentRequestedBot = name;
	}
}
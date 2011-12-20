package codejam;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BotTrust {
	FileProcessor fp;
	String fileName;
	
	public BotTrust(String args) {
//		fileName = args[1];
		fileName = args;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		BotTrust instance = new BotTrust("resources\\simple.txt");
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
			orangeBot.setProcessList(test.getOrangeBots());
			blueBot.setProcessList(test.getBlueBots());
			
			
			for(Tuple tuple : test.positions)
			{
				while(!tuple.isDone())
				{
					boolean orangeDone = orangeBot.process();
					boolean blueDone = blueBot.process();
					if(orangeDone) orangeBot.press(orangeBot.getCurrentIndex());
					if(blueDone) blueBot.press(blueBot.getCurrentIndex());
					System.out.printf("%25s | %25s\n", orangeBot, blueBot);
				}
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
	boolean process();
	void press(int currentIndex);
	void restPositions();
	void setProcessList(ArrayList<Tuple> processList);
	int getCurrentIndex();
}

class BotImpl implements Bot
{
	ArrayList<Tuple> processList;
	boolean pressed = false;
	String name;
	int requestedPosition;
	int currentPosition;
	String currentRequestedBot;
	String currentStatus;
	int currentIndex = 0;

	public void setProcessList(ArrayList<Tuple> processList) {
		this.processList = processList;
	}

	public BotImpl(String name, int initPosition) {
		this.name = name;
		this.requestedPosition = initPosition;
	}
	
	@Override
	public boolean process() {
		
		Tuple tuple = processList.get(currentIndex);
		
		if(currentPosition < tuple.position)
		{
			currentPosition++;
			currentStatus = "moved to position: " + currentPosition;
		}
		else if(currentPosition == tuple.position && ((tuple.prev.name.equals("BEGIN") || tuple.prev.isDone())))
		{
			return true;
		}
		else if(currentPosition > tuple.position)
		{
			currentPosition--;
			currentStatus = "moved to position: " + currentPosition;
		}
		else
		{
			currentStatus = "Waiting at: " + currentPosition;
		}
		return false;
	}

	@Override
	public String toString() {
		return currentStatus;
	}

	@Override
	public void restPositions() 
	{
		this.currentPosition = this.requestedPosition = 1;
		this.currentIndex = 0;
		pressed = false; currentRequestedBot = name; 
	}

	@Override
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	@Override
	public void press(int currentIndex) {
		Tuple tuple = processList.get(currentIndex);
		tuple.done = true;
		currentStatus = "pressed button " + currentIndex;
		this.currentIndex++;
	}

}
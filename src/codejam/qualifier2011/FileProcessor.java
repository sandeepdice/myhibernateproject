package codejam.qualifier2011;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor
{
	String fileName;
	public FileProcessor(String file) {
		this.fileName = file;
	}
	
	public BotTests processFile() throws FileNotFoundException
	{
		BufferedReader bis = new BufferedReader(new FileReader(fileName));
		BotTests tests = new BotTests();
		String line;
		try 
		{
			line = bis.readLine();
			tests.numberOfCases = Integer.parseInt(line);
			while((line = bis.readLine()) != null)
			{
				BotTest test = processLine(line);
				tests.addTest(test);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tests;
	}

	public BotTest processLine(String line) {
		String[] eventArr = line.split(" ", 0);
		BotTest test = new BotTest();
		test.numberOfButtonsToPress = Integer.parseInt(eventArr[0]);
		int index = 1;
		Tuple prev = null;
		Tuple BEGIN = new Tuple();
		BEGIN.name = "BEGIN";
		while (index < eventArr.length)
		{
			Tuple tuple = new Tuple();
			if (prev != null) 
				tuple.prev = prev;
			else
				tuple.prev = BEGIN;
			tuple.name = eventArr[index++];
			tuple.position = Integer.parseInt(eventArr[index++]);
			test.addTuple(tuple);
			if(tuple.name.equals("O")) {
				test.addOrangeTuple(tuple);
			}
			else {
				test.addBlueTuple(tuple);
			}
			prev = tuple;
		}
		
		return test;
	}
}
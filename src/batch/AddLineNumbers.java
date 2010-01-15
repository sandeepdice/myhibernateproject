package batch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.omg.CORBA.CharSeqHolder;

public class AddLineNumbers {
	static char[] findChar = {','};
	String replaceChar = "_";
public static void main(String[] args) throws FileNotFoundException {
	InputStream stream = new FileInputStream("resources/category.data");
	Scanner scanner = new Scanner(stream);
	int i=1;
	String nextLine;
	int categoryLine=0;
	boolean masterCategory = false;
	/*
	while(scanner.hasNextLine())
	{
		nextLine = scanner.nextLine();
		if(!nextLine.trim().isEmpty())
		{
			nextLine = nextLine.replaceAll(","," &");
			if(masterCategory)
			{
				System.out.println("" + i +"," +nextLine+","+nextLine+",0");
				masterCategory = false;
			}
			else
			{
				System.out.println("" + i +"," +nextLine+","+nextLine+","+categoryLine);
			}
			++i;
		}
		else
		{
			System.out.println("");
			masterCategory = true;
			categoryLine = i;
		}
	} 
	*/
	System.out.println(parseFile("resources/category.data"));
}
static List<List> parseFile(String fileName) {
	String nextLine;
	List resultList = new ArrayList(4);
	List categoryIdList = new ArrayList<Integer>();
	List categoryNameList = new ArrayList<String>();
	List categoryDescriptionList = new ArrayList<String>();
	List parentCategoryIdList = new ArrayList<Integer>();
	try {
		InputStream stream = new FileInputStream(fileName);
		Scanner scanner = new Scanner(stream);
		while(scanner.hasNextLine())
		{
			nextLine = scanner.nextLine();
			if(!nextLine.trim().isEmpty())
			{
				StringTokenizer tokenizer = new StringTokenizer(nextLine, ",");
				categoryIdList.add(tokenizer.hasMoreTokens()?new Integer(tokenizer.nextToken()):new Integer(0));
				categoryNameList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
				categoryDescriptionList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
//				System.out.println(tokenizer.nextToken());
				parentCategoryIdList.add(tokenizer.hasMoreTokens()?new Integer(tokenizer.nextToken()):new Integer(0));
			}
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	resultList.add(categoryIdList);
	resultList.add(categoryNameList);
	resultList.add(categoryDescriptionList);
	resultList.add(parentCategoryIdList);
	return resultList;
}
}

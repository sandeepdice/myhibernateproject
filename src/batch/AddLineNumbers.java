package batch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import org.omg.CORBA.CharSeqHolder;

class MyException extends RuntimeException
{
	
}

class ExceptionA extends Exception{}
class ExceptionB extends ExceptionA{}


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
	boolean[] x = new boolean[10];
	System.out.println("boolean primitive: "+x[0]);
	Boolean[] boolArray = new Boolean[10];
	System.out.println("boolean object: "+boolArray[0]);
	
	Vector v = new Vector(10);
	v.add(new Integer(2));
	System.out.println(v.elementAt(0));
	
	HashSet myset = new HashSet();
	myset.add(new Integer(2));
	myset.add(new Integer(2));
	System.out.println("HashSet size: "+myset.size());
	
	try
	{
		throw new NullPointerException();
	}
	catch(NullPointerException e)
	{
		
	}
	finally
	{
		throw new NullPointerException();
	}
	
	
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
//	System.out.println(parseFile("resources/category.data"));
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

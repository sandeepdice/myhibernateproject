package codejam.qualifier2011;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;



public class FileProcessorTest {
	static FileProcessor fp;
	
	@BeforeClass
	static public void setup() {
	}
	
	@Test
	public void sizeTest() throws FileNotFoundException
	{
		fp = new FileProcessor("resources\\A-small-practice.in");
		Assert.assertEquals(20, fp.processFile().numberOfCases);
	}
	
	@Test
	public void contentTest() throws FileNotFoundException
	{
		fp = new FileProcessor("resources\\A-small-practice.in");
		BotTests tests = fp.processFile();
		
		Assert.assertTrue(tests.numberOfCases == 20);
		Assert.assertTrue(tests.botTests.size() == 20);
		
		BotTest test1 = tests.botTests.get(0);
		Assert.assertNotNull(test1);
		Assert.assertTrue(test1.positions.size() == 4);
		Assert.assertTrue(test1.numberOfButtonsToPress == 4);
		
		Tuple t1 = test1.positions.get(0);
		Assert.assertTrue(t1.name.equals("O"));
		Assert.assertTrue(t1.position == 2);
		
		Tuple t2 = test1.positions.get(1);
		Assert.assertTrue(t2.name.equals("B"));
		Assert.assertTrue(t2.position == 1);

		Tuple t3 = test1.positions.get(2);
		Assert.assertTrue(t3.name.equals("B"));
		Assert.assertTrue(t3.position == 2);

		Tuple t4 = test1.positions.get(3);
		Assert.assertTrue(t4.name.equals("O"));
		Assert.assertTrue(t4.position == 4);
	}
	
	@Test
	public void lastLineTest() throws FileNotFoundException 
	{
		// 10 O 36 B 64 B 72 O 42 B 1 O 34 O 64 O 88 B 42 O 71
		
		fp = new FileProcessor("resources\\A-small-practice.in");
		BotTests tests = fp.processFile();
		
		BotTest test1 = tests.botTests.get(19);
		Assert.assertNotNull(test1);
		Assert.assertTrue(test1.positions.size() == 10);
		Assert.assertTrue(test1.numberOfButtonsToPress == 10);
		
		Tuple t1 = test1.positions.get(0);
		Assert.assertTrue(t1.name.equals("O"));
		Assert.assertTrue(t1.position == 36);
		
		Tuple t2 = test1.positions.get(1);
		Assert.assertTrue(t2.name.equals("B"));
		Assert.assertTrue(t2.position == 64);

		Tuple t3 = test1.positions.get(2);
		Assert.assertTrue(t3.name.equals("B"));
		Assert.assertTrue(t3.position == 72);

		Tuple t4 = test1.positions.get(3);
		Assert.assertTrue(t4.name.equals("O"));
		Assert.assertTrue(t4.position == 42);

		Tuple t5 = test1.positions.get(4);
		Assert.assertTrue(t5.name.equals("B"));
		Assert.assertTrue(t5.position == 1);

		Tuple t6 = test1.positions.get(5);
		Assert.assertTrue(t6.name.equals("O"));
		Assert.assertTrue(t6.position == 34);

		Tuple t7 = test1.positions.get(6);
		Assert.assertTrue(t7.name.equals("O"));
		Assert.assertTrue(t7.position == 64);

		Tuple t8 = test1.positions.get(7);
		Assert.assertTrue(t8.name.equals("O"));
		Assert.assertTrue(t8.position == 88);

		Tuple t9 = test1.positions.get(8);
		Assert.assertTrue(t9.name.equals("B"));
		Assert.assertTrue(t9.position == 42);

		Tuple t10 = test1.positions.get(9);
		Assert.assertTrue(t10.name.equals("O"));
		Assert.assertTrue(t10.position == 71);
	}
	
	@Test
	public void simpleTest() throws FileNotFoundException
	{
		fp = new FileProcessor("resources\\simple.txt");
		BotTests tests = fp.processFile();
		
		Assert.assertTrue(tests.numberOfCases == 3);
		Assert.assertTrue(tests.botTests.size() == 3);
		
		BotTest test1 = tests.botTests.get(0);
		Assert.assertNotNull(test1);
		Assert.assertTrue(test1.positions.size() == 4);
		Assert.assertTrue(test1.numberOfButtonsToPress == 4);
		
		Tuple t1 = test1.positions.get(0);
		Assert.assertTrue(t1.name.equals("O"));
		Assert.assertTrue(t1.position == 2);
		
		Tuple t2 = test1.positions.get(1);
		Assert.assertTrue(t2.name.equals("B"));
		Assert.assertTrue(t2.position == 1);

		Tuple t3 = test1.positions.get(2);
		Assert.assertTrue(t3.name.equals("B"));
		Assert.assertTrue(t3.position == 2);

		Tuple t4 = test1.positions.get(3);
		Assert.assertTrue(t4.name.equals("O"));
		Assert.assertTrue(t4.position == 4);
	}
}

package citi;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class CharAuditorTest {

	CharAuditor auditor;
	
	@Before
	public void setup() {
		auditor = new CharAuditorImpl();
	}
	
	@Test
	public void sortCharsTest()
	{
		Assert.assertEquals("abc", auditor.sortChars("bac"));
		Assert.assertEquals(null, auditor.sortChars(null));
		Assert.assertEquals("0123", auditor.sortChars("1230"));
		Assert.assertEquals("123ab", auditor.sortChars("ab123"));
		Assert.assertEquals("", auditor.sortChars(""));
	}
	
	@Test
	public void getFirstNSortedCharsTest()
	{
		Assert.assertEquals("a", auditor.getFirstNSortedChars("bac", 1));
		Assert.assertEquals("0123", auditor.getFirstNSortedChars("1230", 4));
		Assert.assertEquals("12", auditor.getFirstNSortedChars("ab123", 2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void getFirstNSortedCharsTestException()
	{
		Assert.assertEquals(null, auditor.getFirstNSortedChars("bac", 10));
	}
	
	@Test
	public void getCharCountsTest()
	{
		Map<Character, Integer> map;
		map = auditor.getCharCounts("input");
		Assert.assertEquals(1, map.get('i').intValue());
		
		map = auditor.getCharCounts(null);
		Assert.assertEquals(null, map);
		
		map = auditor.getCharCounts("");
		Assert.assertEquals(null, map);
	}
	
	@Test
	public void getUniqueCharsSortedByPrevalenceTest()
	{
		Assert.assertEquals("utpni", auditor.getUniqueCharsSortedByPrevalence("input"));
		Assert.assertEquals("leoh", auditor.getUniqueCharsSortedByPrevalence("hello"));
		Assert.assertEquals("leoh", auditor.getUniqueCharsSortedByPrevalence("lelho"));
		Assert.assertEquals("cba", auditor.getUniqueCharsSortedByPrevalence("aabbbcccc"));
		Assert.assertEquals("dcba", auditor.getUniqueCharsSortedByPrevalence("aabbbccccdddd"));
	}
}

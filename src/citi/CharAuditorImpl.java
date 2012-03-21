package citi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CharAuditorImpl implements CharAuditor {

	int validateAndReturnLength(String input)
	{
		if(input == null) return 0;
		
		int length = input.length();
		
		return length;
	}
	
	@Override
	public Map<Character, Integer> getCharCounts(String input) {
		
		int length = validateAndReturnLength(input);
		
		if(length ==0) return null;
		
		char[] charArray = new char[length];
		input.getChars(0, length, charArray, 0);
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : charArray)
		{
			if (map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		return map;
	}

	@Override
	public String getFirstNSortedChars(String input, int topN) {
		return this.sortChars(input).substring(0, topN);
	}

	@Override
	public String getUniqueCharsSortedByPrevalence(String input) {
		
		int length = validateAndReturnLength(input);
		
		if(length == 0) return input;
		
		Map<Character, Integer> inputMap = getCharCounts(input);
		
		Map<Integer, StringBuilder> items = new TreeMap<Integer, StringBuilder>(Collections.reverseOrder());
		
		for(Map.Entry<Character, Integer> entry : inputMap.entrySet())
		{
			if(items.containsKey(entry.getValue()))
			{
				StringBuilder sb = items.get(entry.getValue());
				sb.append(entry.getKey());
				items.put(entry.getValue(), sb);
			}
			else
			{
				StringBuilder sb = new StringBuilder();
				sb.append(entry.getKey());
				items.put(entry.getValue(), sb);
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		for (Map.Entry<Integer, StringBuilder> entry : items.entrySet())
		{
			result.append(entry.getValue());
		}
		
		return result.toString();
	}

	@Override
	public String sortChars(String input) {
		
		int length = validateAndReturnLength(input);
		
		if(length == 0) return input;
		
		char[] charArray = new char[length];
		input.getChars(0, length, charArray, 0);
		Arrays.sort(charArray);
		return convertArrayToString(charArray);
	}
	
	String convertArrayToString(char[] array)
	{
		StringBuilder string = new StringBuilder();
		for(char ch : array)
		{
			string.append(ch);
		}
		return string.toString();
	}

	class CharTreeObject
	{
		char c;
		int count;
	}

}

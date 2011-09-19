package snippets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigSurTrafficEditor
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader;
		BufferedWriter writer;
		String eventFile = "C:\\Sandeep\\CAAF\\IQ-QoSAPrdSupport\\t14caaf3\\filterd.log";
		reader = new BufferedReader(new FileReader(eventFile));
		String targetFile = "C:\\Sandeep\\CAAF\\IQ-QoSAPrdSupport\\t14caaf3\\filterd.log.new";
		;
		writer = new BufferedWriter(new FileWriter(targetFile));
		String line = reader.readLine();
		while (line != null)
		{
			if (line.contains(",list,") && !line.contains("["))
			{
				String[] eventArr = line.split(",", 3);
				if (eventArr.length < 3)
				{
					line = reader.readLine();
					continue;
				}
				String fieldName = eventArr[0];
				String dataType = eventArr[1];
				String dataValue = eventArr[2];
				if ((dataValue.contains("#")) || (dataValue.trim().length() == 0))
				{
					writer.write(fieldName + "," + dataType + ",[" + dataValue + "]\n");
					// System.out.println(fieldName + "," + dataType + ",[" + dataValue + "]");
				}
				else if (dataValue.length() != 0)
				{
					writer.write(fieldName + "," + dataType + ",[" + dataValue + "$integer]\n");
					// System.out.println(fieldName + "," + dataType + ",[" + dataValue + "$integer]");
				}
			}
			else if (line.contains(",list,") && line.contains("[") && !line.contains("#"))
			{
				String[] eventArr = line.split(",", 3);
				if (eventArr.length < 3)
				{
					line = reader.readLine();
					continue;
				}
				String fieldName = eventArr[0];
				String dataType = eventArr[1];
				String dataValue = eventArr[2];
				if (dataValue.contains(","))
				{
					dataValue = dataValue.trim();

					if (matchesEBIQCIs(dataValue))
					{
						String list1 = dataValue.substring(1, dataValue.indexOf("], [")+1);
						String list2 = dataValue.substring(dataValue.indexOf("], [") + 3, dataValue.length() - 1);
						writer.write(fieldName + "," + dataType + ",[" + processList(list1) + ", " + processList(list2) + "]\n");
					}
					else if (matchesList(dataValue))
					{
						writer.write(fieldName + "," + dataType + "," + processList(dataValue) + "\n");
					}
/*					else
					{
						int x = dataValue.lastIndexOf("]");
						if (x > 0)
						{
							dataValue = dataValue.substring(1, x);
							String[] dataValueArray = dataValue.split(",");
							String dataValueQualified = "";
							int counter = 0;
							for (String s : dataValueArray)
							{
								counter++;
								s = s.trim();
								if (s.length() > 0)
								{
									dataValueQualified += s + "$integer";
									if (counter < dataValueArray.length)
									{
										dataValueQualified += ",";
									}
								}
							}
							writer.write(fieldName + "," + dataType + ",[" + dataValueQualified + "]\n");
						}
					}*/
				}
			}
			else
			{
				writer.write(line + "\n");
				// System.out.println(line);
			}
			line = reader.readLine();
		}
		reader.close();
		writer.close();
	}


	private static String processList(String dataValue)
	{
		int x = dataValue.lastIndexOf("]");
		String dataValueQualified = "";
		if (x > 0)
		{
			dataValue = dataValue.substring(1, x);
			String[] dataValueArray = dataValue.split(",");
			int counter = 0;
			for (String s : dataValueArray)
			{
				counter++;
				s = s.trim();
				if (s.length() > 0)
				{
					dataValueQualified += s + "$integer";
					if (counter < dataValueArray.length)
					{
						dataValueQualified += ",";
					}
				}
			}
		}
		return "[" + dataValueQualified + "]";
	
	}


	private static boolean matchesList(String txt)
	{
		String re1 = ".*?"; // Non-greedy match on filler
		String re2 = "(\\[.*?\\])"; // Square Braces 1

		boolean b = false;
		Pattern p = Pattern.compile(re1 + re2, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(txt);
		if (m.find())
		{
			b = true;
			String sbraces1 = m.group(1);
			System.out.print("(" + sbraces1.toString() + ")" + "\n");
		}
		return b;
	}


	private static boolean matchesEBIQCIs(String txt)
	{
		String re1 = ".*?"; // Non-greedy match on filler
		String re2 = "(\\[.*?\\])"; // Square Braces 1
		String re3 = "(,)"; // Any Single Character 1
		String re4 = ".*?"; // Non-greedy match on filler
		String re5 = "(\\[.*?\\])"; // Square Braces 2

		boolean b = false;
		Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = p.matcher(txt);
		if (m.find())
		{
			b = true;
			String sbraces1 = m.group(1);
			String c1 = m.group(2);
			String sbraces2 = m.group(3);
			System.out.println("( sq brksts 1 " + sbraces1.toString() + ")" + "(" + c1.toString() + ")" + "("
					+ sbraces2.toString() + ")");
		}
		return b;
	}

}

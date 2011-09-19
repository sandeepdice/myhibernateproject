package snippets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigSurTrafficEditor1
{
	private Pattern p, p2;


	public static void main(String[] args) throws IOException
	{
		(new SigSurTrafficEditor1()).doCleanup(args);
	}


	private boolean checkIfContainsLineWithOnlyTimestamp(String line)
	{
		if (p2 == null)
		{
			String re1 = "(\\d+)"; // Integer Number 1
			String re2 = "(-)"; // Any Single Character 1
			String re3 = "(\\d+)"; // Integer Number 2
			String re4 = "(\\s+)"; // White Space 1
			String re5 = "((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)";

			p2 = Pattern.compile(re1 + re2 + re3 + re4 + re5, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		}
		Matcher m = p2.matcher(line);
		return (m.find());
	}// end-of-checkIfContainsLineWithOnlyTimestamp


	private final int countOccurrences(String str, char c)
	{
		int count = 0;
		int length = str.length();
		for (int i = 0; i < length; i++)
		{
			if (str.charAt(i) != c) continue;
			count++;
		}

		return count;
	}// end-of-countOccurrences


	/**
	 * @param args
	 * @throws IOException
	 */
	private void doCleanup(String[] args) throws IOException
	{
		BufferedReader reader;
		BufferedWriter writer;
		String eventFile = args[0]; // input file
		reader = new BufferedReader(new FileReader(eventFile));
		String targetFile = args[0] + ".afterCleanUp"; // output file

		// String[] logLevelStrs1 = { "] DEBUG Field: ", "] ERROR Field: ", "]  INFO Field: ", "] TRACE Field: ",
		// "]  WARN Field: " };
		String[] logLevelStrs1 = { "Field: " };
		String[] logLevelStrs2 = { "] DEBUG", "] ERROR", "]  INFO", "] TRACE", "]  WARN" };

		writer = new BufferedWriter(new FileWriter(targetFile));
		String line = reader.readLine();
		while (line != null)
		{
			// Remove the leading timestamp and log level information
			int indexOfLogLevelStr = -1;
			int ctr = 0;
			for (String s : logLevelStrs1)
			{
				indexOfLogLevelStr = line.indexOf(s);
				if (indexOfLogLevelStr > 0)
					break;
				else
					ctr++;
			}
			if (indexOfLogLevelStr > 0)
			{
				line = line.substring(indexOfLogLevelStr + logLevelStrs1[ctr].length());
			}

			// Remove empty lines
			indexOfLogLevelStr = -1;
			ctr = 0;
			for (String s : logLevelStrs2)
			{
				indexOfLogLevelStr = line.indexOf(s);
				if (indexOfLogLevelStr > 0)
					break;
				else
					ctr++;
			}
			if (indexOfLogLevelStr > 0)
			{
				line = line.substring(indexOfLogLevelStr + logLevelStrs2[ctr].length());
			}

			// Remove "</record>"
			if (line.contains("</record>"))
			{
				line = "";
			}

			// Remove "Received event:["
			if (line.contains("Received event:["))
			{
				line = "";
			}

			// Remove line containing only timestamp
			if (checkIfContainsLineWithOnlyTimestamp(line))
			{
				line = "";
			}

			// Remove trailing and leading white spaces
			line = line.trim();

			if (line.length() > 0)
			{
				int numStars = countOccurrences(line, "*".charAt(0));
				boolean isRecordNo = line.startsWith("<record no=");
				if (numStars > 2 || isRecordNo)
				{
					if (line.contains("***Source Event***") || isRecordNo)
					{
						line = "--Record--";
						writer.write(line + "\n");
					}
				}
				else
				{

					// int index = 0;
					// for (String strDeclaration : strDeclarationArray)
					// {
					// if (line.contains(strDeclaration))
					// {
					// line = line.replace(strDeclaration, ",string,");
					// }
					// strDeclarationReplacementCtr[index]++;
					// index++;
					// }

					line = x(line);

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
								System.out.println("HERE");
							}
							else
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
							}
						}
					}
					else
					{
						writer.write(line + "\n");
						// System.out.println(line);
					}
				}
			}
			line = reader.readLine();
		}
		reader.close();
		writer.close();
	}// end-of-doCleanup


	private String join(String fieldName, String dataValueType, String fieldValue)
	{
		StringBuilder sb = new StringBuilder(120);
		sb.append(fieldName).append(",");
		if (dataValueType.equalsIgnoreCase("string") || dataValueType.equalsIgnoreCase("dataValueType"))
		{
			sb.append(dataValueType).append(",").append(fieldValue);
		}
		else if (dataValueType.equalsIgnoreCase("list"))
		{
			sb.append(dataValueType).append(",");
			sb.append("[").append(fieldValue).append("]");
		}
		else
		{
			sb.append(dataValueType).append(",").append(fieldValue);
		}

		String line = sb.toString();
		return line;
	}// end-of-join


	private boolean matchesEBIQCIs(String txt)
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
	}// end-of-matchesEBIQCIs


	private String x(String line)
	{
		if (p == null)
		{
			String re1 = "((?:[a-zA-Z0-9\\.\\_\\d\\-]+)\\.(?:[a-zA-Z0-9\\-\\_]+)|(?![\\w\\.\\_]))"; // Fully Qualified Domain
			// Name 1
			String re2 = ".*?"; // Non-greedy match on filler
			// String re3 = "((?:[a-z][a-z][0-9]+))"; // Word 1
			String re3 = "([0-9]+:[a-zA-Z0-9]+)"; // Word 1
			String re4 = ".*?"; // Non-greedy match on filler
			String re5 = "(Value)"; // Word 2
			String re6 = "(\\s+)"; // White Space 1
			String re7 = "(=)"; // Any Single Character 1
			String re8 = "(.*)";

			p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		}
		Matcher m = p.matcher(line);
		if (m.find())
		{
			String fqdn1 = m.group(1);
			String word1 = m.group(2);
			int indexOfColon = word1.indexOf(":");
			if (word1.length() > (indexOfColon + 1))
			{
				word1 = word1.substring(indexOfColon + 1);
			}

			String valueContent = m.group(6);
			if (valueContent != null)
			{
				valueContent = valueContent.trim();
			}

			line = join(fqdn1, word1, valueContent);
		}
		else
		{
			System.out.println("no match found for line --> " + line);
		}

		return line;
	}

}

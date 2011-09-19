package snippets;

public class FormattedPrint {
	static int tabCount = 0;
	public static void main(String[] args) {
		String toFormat = "{MME1.Src.1.src_5_3.E_VOL}";
		print(0, toFormat);
	}
	static void print(int index, String toFormat)
	{
		int startIndex = toFormat.indexOf("{", 0);
		int nextOpenBraceIndex = toFormat.indexOf('{', startIndex);
		int nextCloseBraceIndex = toFormat.indexOf('}', startIndex);
		
		while(startIndex >= 0)
		{
			System.out.println("{");
			printTabs(tabCount);
			String stringToPrint = toFormat.substring(startIndex+1, nextCloseBraceIndex-1);
			System.out.print(stringToPrint);
			if(nextOpenBraceIndex > nextCloseBraceIndex)
			{
				tabCount++;
				printTabs(tabCount);
				System.out.print(toFormat.substring(startIndex, nextCloseBraceIndex));
			}
			else if(nextCloseBraceIndex > nextOpenBraceIndex)
			{
				print(nextOpenBraceIndex, toFormat.substring(nextOpenBraceIndex));
			}
			else
			{
				print(nextCloseBraceIndex, toFormat.substring(startIndex+1));
			}
			
		}		
	}
	static void printTabs(int count)
	{
		for(int i=0; i<count; i++) System.out.print("\t");
	}
}

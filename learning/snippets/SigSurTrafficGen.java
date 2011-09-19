package snippets;

import java.nio.ByteBuffer;

public class SigSurTrafficGen
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		for(int lebi = 2; lebi < 10; lebi++)
		{
			SigSurTrafficGen.createSessionTraffic(lebi*1000000, lebi, 5);
		}
	}
	
	public static String createSessionTraffic(int imsi, int lebi, int noOfEbi)
	{
		String eventHeader = "--Record--\n";
		String integerType = "$integer";
		String comma = ","; 
		String closeBrace = "]";
		String openBrace = "[";
		String hashString = "#";
		String eventName = "CreateSession.EventName,string,CreateSession\n";
		String imsiField = "CreateSession.IMSI,string,"+imsi+"\n";
		String lebiField = "CreateSession.LEBI,list,"+openBrace+lebi+integerType+closeBrace+"\n";
		String apnField = "CreateSession.APN,OctetString,a1b2c3d4\n";
		System.out.print(eventHeader);
		System.out.print(eventName);
		System.out.print(imsiField);
		System.out.print(lebiField);
		System.out.print(apnField);
		StringBuffer createdEbiField = new StringBuffer("CreateSession.CreatedEBI,list,"+openBrace);
		for(int i = lebi; i < lebi + noOfEbi; i++)
		{
			createdEbiField.append(""+i+integerType+comma);
		}
		createdEbiField.deleteCharAt(createdEbiField.length()-1);
		createdEbiField.append(closeBrace);
		System.out.println(createdEbiField);
		StringBuffer ebiQcisField = new StringBuffer("CreateSession.EBIQCIs,list,"+openBrace+openBrace);
		for(int i = lebi; i < lebi + noOfEbi ; i++)
		{
			ByteBuffer masterByteBuffer = ByteBuffer.allocate(16);
			masterByteBuffer.putLong(1);
			masterByteBuffer.putLong(i);
			int value = byteArrayToInt(masterByteBuffer.array(), 16);
			ebiQcisField.append(""+value+integerType+comma);
		}
		ebiQcisField.deleteCharAt(ebiQcisField.length()-1);
		ebiQcisField.append(closeBrace+openBrace);
		for(int i = lebi, j = 1; j <= 2 ; j++, i++)
		{
			i += noOfEbi;
			ByteBuffer masterByteBuffer = ByteBuffer.allocate(16);
			masterByteBuffer.putLong(1);
			masterByteBuffer.putLong(i);
			int value = byteArrayToInt(masterByteBuffer.array(), 16);
			ebiQcisField.append(""+value+integerType+comma);
		}
		ebiQcisField.deleteCharAt(ebiQcisField.length()-1);
		ebiQcisField.append(closeBrace+closeBrace);
		System.out.println(ebiQcisField);
		StringBuffer fteidsField = new StringBuffer("CreateSession.FTEIDs,list,"+openBrace);
		for(int ebiIndex = lebi; ebiIndex < lebi + noOfEbi ; ebiIndex++)
		{
			for(int interfaceIndex = 1; interfaceIndex <= 2; interfaceIndex++)
			{
				fteidsField.append(""+ebiIndex+hashString+interfaceIndex+hashString+(ebiIndex*1000+interfaceIndex)+hashString+ebiIndex+".2.2."+interfaceIndex+comma);
			}
		}
		fteidsField.deleteCharAt(fteidsField.length()-1);
		fteidsField.append(closeBrace);
		System.out.println(fteidsField);
		return "";
	}
	
	public static int byteArrayToInt(byte[] b, int size)
	{
		int value = 0;
		for (int index = size; index > 0; index--)
		{
			int byteAtIndex = b[size - index];
			value += (byteAtIndex * Math.pow(2, index));
		}
		return value / 2;
	}
}

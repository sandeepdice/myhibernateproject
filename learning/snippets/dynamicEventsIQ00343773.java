package snippets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class dynamicEventsIQ00343773 {
	public static void main(String[] args) throws IOException {
		PrintWriter out;
		out = new PrintWriter(new FileWriter("C:\\Sandeep\\CAAF\\IQ00343773\\IQ00343773-1.txt"));
		StringBuilder s = new StringBuilder();;
		s.append("--Record--\n");
		s.append("S1AP_PathSwitch.TransDuration,duration,20\n");
		s.append("S1AP_PathSwitch.TranStatus,string,failure\n");
		s.append("S1AP_PathSwitch.MessageType,integer,3\n");
		s.append("S1AP_PathSwitch.EventName,string,S1AP_PathSwitch\n");
		s.append("IP.Dst,ipv4address,010.010.001.001\n");
		String standardString = s.toString();
		for(int j=1; j<=13; j++)
		{
			out.write(standardString);
			out.write("IP.Src,ipv4address,010.010.001.0"+j+"\n");
		}
		out.flush();
		
		StringBuilder s1 = new StringBuilder();;
		s1.append("--Record--\n");
		s1.append("S1AP_PathSwitch.TransDuration,duration,10\n");
		s1.append("S1AP_PathSwitch.TranStatus,string,failure\n");
		s1.append("S1AP_PathSwitch.MessageType,integer,3\n");
		s1.append("S1AP_PathSwitch.EventName,string,S1AP_PathSwitch\n");
		s1.append("IP.Dst,ipv4address,010.010.001.001\n");
		String standardString1 = s1.toString();
		for(int j=14; j<=40; j++)
		{
			out.write(standardString1);
			out.write("IP.Src,ipv4address,010.010.001.0"+j+"\n");
		}
		out.flush();
		
		StringBuilder s2 = new StringBuilder();;
		s2.append("--Record--\n");
		s2.append("S1AP_PathSwitch.TransDuration,duration,10\n");
		s2.append("S1AP_PathSwitch.TranStatus,string,failure\n");
		s2.append("S1AP_PathSwitch.MessageType,integer,3\n");
		s2.append("S1AP_PathSwitch.EventName,string,S1AP_PathSwitch\n");
		s2.append("IP.Dst,ipv4address,010.010.001.001\n");
		String standardString2 = s2.toString();
		for(int j=13; j<=30; j++)
		{
			out.write(standardString2);
			out.write("IP.Src,ipv4address,010.011.001.0"+j+"\n");
		}
		out.flush();
		
		StringBuilder s3 = new StringBuilder();;
		s3.append("--Record--\n");
		s3.append("S1AP_PathSwitch.TransDuration,duration,20\n");
		s3.append("S1AP_PathSwitch.TranStatus,string,failure\n");
		s3.append("S1AP_PathSwitch.MessageType,integer,3\n");
		s3.append("S1AP_PathSwitch.EventName,string,S1AP_PathSwitch\n");
		s3.append("IP.Dst,ipv4address,010.010.001.001\n");
		String standardString3 = s3.toString();
		for(int j=1; j<=12; j++)
		{
			out.write(standardString3);
			out.write("IP.Src,ipv4address,010.011.001.0"+j+"\n");
		}		
		out.flush();
	}
}

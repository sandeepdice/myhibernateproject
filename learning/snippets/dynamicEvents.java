package snippets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * --Record--
S1AP.IMSI,string,1
S1AP_PathSwitch.DstIPV4,ipaddress,010.010.001.002
S1AP_PathSwitch.SrcPort,integer,3001
S1AP_PathSwitch.SrcIPV4,ipaddress,010.010.001.003
S1AP_PathSwitch.Src,ipv4address,010.010.001.003
Record.FIDRVersion,integer,1.1.001
ThisRecord.EventName,string,Record
ThisRecord.Timestamp,timestamp,1297739478
S1AP_PathSwitch.TransDuration,duration,15
S1AP_PathSwitch.TranStatus,string,failure
Record.DataFeedVersion,integer,IPCDataFeedVersion
S1AP_PathSwitch.StartTime,integer,1297739478
Record.DataFeedIdentifier,string,IPCDataFeed
S1AP_PathSwitch.EndTime,integer,1297739493
Record.ProducerIPaddress,ipv4address,ProducerIPAddress
Record.ProducerHostname,string,ProducerHostName
Transaction.EventName,string,Transaction
S1AP_PathSwitch.ReleasedErabIdSize,integer,0
Transaction.ProtocolId,integer,2034
S1AP_PathSwitch.EUtranCGI,integer,05f5e110040989
S1AP_PathSwitch.Cause,integer,1024
Transaction.ProtocolName,string,S1AP
S1AP_PathSwitch.ReleasedErabCauseSize,integer,0
S1AP_PathSwitch.MessageType,integer,3
S1AP_PathSwitch.EventName,string,S1AP_PathSwitch
S1AP.MMEUEID,integer,1152
S1AP_PathSwitch.ErabIdSize,integer,0
S1AP_PathSwitch.Timeout,integer,0
S1AP.EventName,string,S1AP
S1AP.TransactionId,integer,2455396246412591104
S1AP_PathSwitch.DstPort,integer,3002
S1AP.ProtocoalType,integer,2034
S1AP_PathSwitch.Dst,ipv4address,010.010.001.002
S1AP_PathSwitch.DstHostname,integer,eNodeB4
S1AP.ENodeBUEID,integer,6043
S1AP_PathSwitch.DerivedCause,integer,1
S1AP_PathSwitch.DerivedFailedErabId,list,null
IP.DstIPV4,ipaddress,010.010.001.002
IP.SrcIPV4,ipaddress,010.010.001.003
IP.DstHostname,integer,eNodeB4
IP.DstPort,integer,3002
IP.SrcPort,integer,3001
IP.Dst,ipv4address,010.010.001.0
IP.EventName,string,IP
IP.Src,ipv4address,010.010.001.003


 *
 */
public class dynamicEvents {
	public static void main(String[] args) throws IOException {
		PrintWriter out;
		out = new PrintWriter(new FileWriter("c:\\temp\\logs\\dynamic-events-src.txt"));
		StringBuilder s = new StringBuilder();;
		s.append("--Record--\n");
		s.append("S1AP_PathSwitch.DstIPV4,ipaddress,010.010.001.002\n");
		s.append("S1AP_PathSwitch.SrcPort,integer,3001\n");
		s.append("S1AP_PathSwitch.SrcIPV4,ipaddress,010.010.001.003\n");
		s.append("S1AP_PathSwitch.Src,ipv4address,010.010.001.003\n");
		s.append("Record.FIDRVersion,integer,1.1.001\n");
		s.append("ThisRecord.EventName,string,Record\n");
		s.append("ThisRecord.Timestamp,timestamp,1297739478\n");
		s.append("S1AP_PathSwitch.TransDuration,duration,15\n");
		s.append("S1AP_PathSwitch.TranStatus,string,failure\n");
		s.append("Record.DataFeedVersion,integer,IPCDataFeedVersion\n");
		s.append("S1AP_PathSwitch.StartTime,integer,1297739478\n");
		s.append("Record.DataFeedIdentifier,string,IPCDataFeed\n");
		s.append("S1AP_PathSwitch.EndTime,integer,1297739493\n");
		s.append("Record.ProducerIPaddress,ipv4address,ProducerIPAddress\n");
		s.append("Record.ProducerHostname,string,ProducerHostName\n");
		s.append("Transaction.EventName,string,Transaction\n");
		s.append("S1AP_PathSwitch.ReleasedErabIdSize,integer,0\n");
		s.append("Transaction.ProtocolId,integer,2034\n");
		s.append("S1AP_PathSwitch.EUtranCGI,integer,05f5e110040989\n");
		s.append("S1AP_PathSwitch.Cause,integer,1024\n");
		s.append("Transaction.ProtocolName,string,S1AP\n");
		s.append("S1AP_PathSwitch.ReleasedErabCauseSize,integer,0\n");
		s.append("S1AP_PathSwitch.MessageType,integer,3\n");
		s.append("S1AP_PathSwitch.EventName,string,S1AP_PathSwitch\n");
		s.append("S1AP.MMEUEID,integer,1152\n");
		s.append("S1AP_PathSwitch.ErabIdSize,integer,0\n");
		s.append("S1AP_PathSwitch.Timeout,integer,0\n");
		s.append("S1AP.EventName,string,S1AP\n");
		s.append("S1AP.TransactionId,integer,2455396246412591104\n");
		s.append("S1AP_PathSwitch.DstPort,integer,3002\n");
		s.append("S1AP.ProtocoalType,integer,2034\n");
		s.append("S1AP_PathSwitch.Dst,ipv4address,010.010.001.002\n");
		s.append("S1AP_PathSwitch.DstHostname,integer,eNodeB4\n");
		s.append("S1AP.ENodeBUEID,integer,6043\n");
		s.append("S1AP_PathSwitch.DerivedFailedErabId,list,null\n");
		s.append("IP.DstIPV4,ipaddress,010.010.001.002\n");
		s.append("IP.SrcIPV4,ipaddress,010.010.001.003\n");
		s.append("IP.DstHostname,integer,eNodeB4\n");
		s.append("IP.DstPort,integer,3002\n");
		s.append("IP.SrcPort,integer,3001\n");
		s.append("IP.Dst,ipv4address,010.010.001.001\n");
		s.append("IP.EventName,string,IP\n");
		s.append("IP.Src,ipv4address,010.010.001.0\n");
		String standardString = s.toString();
		String imsi = "S1AP.IMSI,string,";
		String cause = "S1AP_PathSwitch.DerivedCause,string,";
		String newLine = "\n";
		for(int i=1; i<=20; i++)
		{
			for(int j=1; j<=20; j++)
			{
				out.write(standardString);
				out.println(cause+i);
				out.println(imsi+j);
			}
		}
		out.flush();
	}
}

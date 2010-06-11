package temp;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUri {
	public static void main(String[] args) throws IOException {
		File f = new File("c:\\temp\\TestDefnSchema.java");
//		System.out.println(f.toURI());
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\temp\\events.txt"));
		String line = reader.readLine();
		Event event = null;
		while(line != null)
		{
			if(line.startsWith("--") && line.endsWith("--"))
			{
				if(event != null)
				{
					System.out.println("Adding event to list");
				}
//				event = new SourceEventImpl(EventType.SOURCE_EVENT);
				event = new Event(new Object(), 1, new Object());
				System.out.println("created event.. " + line.substring(2, line.lastIndexOf("--")));
				line = reader.readLine();
				continue;
			}
			int eventNameIndex = line.indexOf(",");
			String fieldName = line.substring(0, eventNameIndex);
			int dataTypeIndex = line.indexOf(",", eventNameIndex+1);
			String dataType = line.substring(eventNameIndex+1, dataTypeIndex);
			String dataValue = line.substring(dataTypeIndex+1);
			System.out.println("Adding field: " + fieldName + " " + dataType + " " + dataValue);
//			event.addField(new FieldId(fieldName), new DataValueString(DataValueType.getDataValueType(dataType), dataValue));
			line = reader.readLine();
		}
		if(event != null)
		{
			System.out.println("Adding event to list");
		}
	}
}

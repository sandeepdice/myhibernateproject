package temp.log4j;

import java.io.File;
import java.util.Enumeration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class mylogging {
public static void main(String[] args) {
	String filename = "C:\\config\\all_components_log4j.xml";
	File configFile = null;
	configFile = new File(filename);
	DOMConfigurator.configure(configFile.toString());
	Enumeration<?> loggers = LogManager.getCurrentLoggers();
	while (loggers.hasMoreElements())
	{
		Logger l = (Logger)loggers.nextElement();
		System.out.println(l.getName());
		l.info("Logger "+l.getName()+" initialised");
	}
}
}

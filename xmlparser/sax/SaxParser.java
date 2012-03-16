package sax;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxParser extends DefaultHandler {
	List<Settings> settings;
	private Settings currentSettings;
	private boolean serverPortEncountered;
	private boolean hostEncountered;
	private boolean portEncountered;
	private boolean dbNameEncountered;
	private boolean tblNameEncountered;
	
	public static void main(String[] args) {
		SaxParser parser = new SaxParser(); 
		parser.run();
		System.out.println(parser.currentSettings.serverPort);
		System.out.println(parser.currentSettings.dbPort);
		System.out.println(parser.currentSettings.dbName);
		System.out.println(parser.currentSettings.tblName);
		System.out.println(parser.currentSettings.dbHost);
	}
	
	public void run()
	{
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(this);
			parser.setErrorHandler(this);
			
			parser.parse(new InputSource("input.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startElement(String uri, String name, String qName, Attributes atts)
	{
		if(qName.equals("settings"))
		{
			this.currentSettings = new Settings(); 
			this.settings.add(currentSettings);
		}
		
		if(qName.equals("serverport"))
		{
			this.serverPortEncountered = true; 
		}
		
		if(qName.equals("host"))
		{
			this.hostEncountered = true;
		}

		if(qName.equals("port"))
		{
			this.portEncountered = true;
		}

		if(qName.equals("dbname"))
		{
			this.dbNameEncountered = true;
		}

		if(qName.equals("tblname"))
		{
			this.tblNameEncountered = true;
		}
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {
		if (this.serverPortEncountered) {
			String serverPortStr = new String(ch, start, length);
			this.currentSettings.serverPort = Integer.parseInt(serverPortStr);
			this.serverPortEncountered = false;
		}
		
		if (this.hostEncountered) {
			this.currentSettings.dbHost = new String(ch, start, length);
			this.hostEncountered = false;
		}
		
		if (this.portEncountered) {
			String serverPortStr = new String(ch, start, length);
			this.currentSettings.dbPort = Integer.parseInt(serverPortStr);
			this.portEncountered = false;
		}
		
		if (this.dbNameEncountered) {
			this.currentSettings.dbName = new String(ch, start, length);
			this.dbNameEncountered = false;
		}
		
		if (this.tblNameEncountered) {
			this.currentSettings.tblName = new String(ch, start, length);
			this.tblNameEncountered = false;
		}
	}
	
	public void endElement(String uri, String name, String qName)
	{
		
	}
	
	public SaxParser() {
		settings = new ArrayList<Settings>();
	}
}

class Settings
{
	int serverPort;
	String dbHost;
	int dbPort;
	String dbName;
	String tblName;
}

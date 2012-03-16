package utils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.Test;
import org.xml.sax.SAXException;

import utils.DOMParser;


public class DOMParserTest {
	
	@Test
	public void test() throws SAXException, IOException, ParserConfigurationException {
		DOMParser parser = new DOMParser();
		Assert.assertTrue(parser.parseFile("resources/input.xml"));
		Assert.assertTrue(parser.getServerPort()==18000);
		Assert.assertTrue(parser.getServerHost().equals("127.0.0.1"));
		Assert.assertTrue(parser.getDbPort()==6432);
		Assert.assertTrue(parser.getDbName().equals("dict"));
		Assert.assertTrue(parser.getTableName().equals("terms"));
	
	}
	
	@Test(expected=IOException.class)
	public void invalidFileTest() throws SAXException, IOException, ParserConfigurationException {
		DOMParser parser = new DOMParser();
		parser.parseFile("resources/input123.xml");
	}

}

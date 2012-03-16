package utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parses XML input XML file using DOM
 * 
 * @author Sandeep
 * @date 08-Feb-2012
 */

public class DOMParser {
	protected final Log logger = LogFactory.getLog(getClass());
	private Document doc = null;
	private String serverHost;
	private int serverPort;
	private int dbPort;
	private String dbName;
	private String tableName;

	/*
	 * Main function - Parses File
	 */
	public boolean parseFile(String fileName) throws SAXException, IOException,
			ParserConfigurationException {
		if (fileName == null || fileName.isEmpty()) {
			return false;
		}
		doc = parserXML(new File(fileName));
		processNode(doc, 0, "");
		return true;
	}

	/*
	 * Processes all nodes & extracts values
	 */
	public void processNode(Node node, int level, String parentNodeName) {
		NodeList nl = node.getChildNodes();

		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			Node nestedNode = nl.item(i);
			extractValues(nestedNode, parentNodeName);
			processNode(nl.item(i), level + 1, nestedNode.getNodeName());
		}
	}

	/*
	 * Extracts values from node
	 */
	private void extractValues(Node node, String parentNodeName) {
		if (node != null && parentNodeName != null) {
			String nodeValue = node.getNodeValue();
			if (parentNodeName.equals("serverport"))
				this.serverPort = Integer.parseInt(nodeValue);
			else if (parentNodeName.equals("host"))
				this.serverHost = nodeValue;
			else if (parentNodeName.equals("port"))
				this.dbPort = Integer.parseInt(nodeValue);
			else if (parentNodeName.equals("dbname"))
				this.dbName = nodeValue;
			else if (parentNodeName.equals("tblname"))
				this.tableName = nodeValue;
		}
	}

	public Document parserXML(File file) throws SAXException, IOException,
			ParserConfigurationException {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(file);
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public int getDbPort() {
		return dbPort;
	}

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
package snippets;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DocumentBuilderHelloWorld
{

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse("C:\\Sandeep\\CAAF\\IQ00345190\\enricher.xml");
		doc.getChildNodes();
		int i=0;
		while(doc.getChildNodes().item(i) != null)
		{
			Node node = doc.getChildNodes().item(i);
			System.out.println(node.getTextContent());
//			node.getTextContent()
			i++;
		}
		
	}

}

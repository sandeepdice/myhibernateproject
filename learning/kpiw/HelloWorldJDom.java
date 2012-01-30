package kpiw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class HelloWorldJDom {

	/**
	 * @param args
	 * @throws JDOMException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new FileInputStream("build.xml"));
		Element re = doc.getRootElement();
		List children = re.getChildren("path");
		Iterator iter = children.iterator();
		
		Element el = createElement();
		
//		while(iter.hasNext())
//		{
			Element pathElement = (Element) iter.next();
			pathElement.addContent(el);
			pathElement.setAttribute("test", "value");
			System.out.println(pathElement.getAttributeValue("id"));
//		}
		
		XMLOutputter outp = new XMLOutputter();
		outp.output(doc, System.out);
		
	}

	private static Element createElement() {
		Element e = new Element("fileset");
		e.setAttribute("dir", "junkdir");
		e.setAttribute("includes", "\"*.jar\"");
		System.out.println(e.getText());
		return e;
	}

}

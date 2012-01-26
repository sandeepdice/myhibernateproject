package myjdom;

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

public class JDOMTemplateManipulator {

	/**
	 * @param args
	 * @throws JDOMException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Element el = createElement();
		System.out.println(el.getText());
		/*
		Document doc = builder.build(new FileInputStream("resources/template/user_template_files/operations.xml"));
		Element re = doc.getRootElement();
		List children = re.getChildren("customContextMenus");
		Iterator iter = children.iterator();
		
		
		while(iter.hasNext())
		{
			Element pathElement = (Element) iter.next();
			pathElement.addContent(el);
			pathElement.setAttribute("test", "value");
			System.out.println(pathElement.getAttributeValue("id"));
		}
		
		XMLOutputter outp = new XMLOutputter();
		outp.output(doc, System.out);
		*/
		
	}

	private static Element createElement() {
		Element e = new Element("menu");
		e.setAttribute("menuLabel", "Launch KPI-A");
		e.setAttribute("name", "kpia");
		e.setAttribute("url", "http://172.22.92.15/kpiwDrilldown.html?dmsHost={host}&qosmId={pname}&" +
				"startTime={chartStartSec}&endTime={chartEndSec}&selectedInterval={chartPointSec}&interval={chartIntervalSec}");
		Element e1 = new Element("canvasMenus");
		e1.setAttribute("type", "single");
		e1.addContent(e);
		
		System.out.println(e1.getText());
		return e1;
	}

}

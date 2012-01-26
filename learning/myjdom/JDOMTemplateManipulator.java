package myjdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDOMTemplateManipulator {

	/**
	 * @param args
	 * @throws JDOMException
	 * @throws IOException
	 */
	static SAXBuilder builder = new SAXBuilder();
	static XMLOutputter outp = new XMLOutputter();
	static Element newCanvasMenus = createElement("172.22.92.15");
	
	public static void main(String[] args) throws JDOMException, IOException 
	{
		Format format = Format.getRawFormat();
		format.setOmitDeclaration(true);
		outp.setFormat(format);
		File[] files = new File("C:/temp/conf_kpiw/user_data").listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				File[] userFiles = file.listFiles();
				for (File userFile : userFiles) {
					if (userFile.getName().contains("operations.xml")) {
						processFile(userFile, builder, outp, newCanvasMenus);
					}
				}
			}
		}
	}

	private static void processFile(File userFile, SAXBuilder builder, XMLOutputter outp, Element newCanvasMenus)
			throws JDOMException, IOException 
	{
		Document doc = builder.build(new FileInputStream(userFile));
		
		File newFile = new File(userFile.getAbsolutePath() + ".new");
		
		Element rootElement = doc.getRootElement();
		Element customContextMenus = rootElement.getChild("customContextMenus");

		customContextMenus.addContent(newCanvasMenus);

		outp.output(doc, new FileOutputStream(newFile));
	}

	private static Element createElement(String ipAddress) {
		Element e = new Element("menu");
		e.setAttribute("menuLabel", "Launch KPI-A");
		e.setAttribute("name", "kpia");
		e.setAttribute(
				"url",
				"http://" + ipAddress +"/kpiwDrilldown.html?dmsHost={host}&qosmId={pname}&"
						+ "startTime={chartStartSec}&endTime={chartEndSec}&selectedInterval={chartPointSec}&interval={chartIntervalSec}");
		Element e1 = new Element("canvasMenus");
		e1.setAttribute("type", "single");
		e1.addContent(e);
		return e1;
	}

}

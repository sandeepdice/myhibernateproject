package kpiw;

/**
 * @author Sandeep Rayapudi
 * @date 27-Jan-2012
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDOMKPIWTemplatePatch {

	/**
	 * @param args
	 * @throws JDOMException
	 * @throws IOException
	 */
	final static XMLOutputter outp = new XMLOutputter();
	static String ipAddress;
	final static Format formatOmitDeclaration = Format.getRawFormat();
	final static Format formatIncludeDeclaration = Format.getRawFormat();
	
	public static void main(String[] args) throws JDOMException, IOException 
	{
		if(args.length != 3)
		{
			System.out.println("usage: java JDOMKPIWTemplatePatch <install/restore> <ipaddress> <kpiw-conf-root-location>");
			return;
		}
		
		if(args[0].equals("install"))
		{
			ipAddress = args[1];
			installPatch(args[1], args[2]);
		}
		else if (args[0].equals("restore"))
		{
			restorePatch(args[2]);
		}
		else
		{
			System.out.println("invalid option. Choose install/restore");
			return;
		}
	}
	
	private static void restorePatch(String kpiwConfDir) throws IOException {
		File[] userTemplateFiles = new File(kpiwConfDir+"/user_data").listFiles();
		Map<String, Boolean> fileRestoreStatus = restoreUserFiles(userTemplateFiles);
		for(String folderName : fileRestoreStatus.keySet())
		{
			if(fileRestoreStatus.get(folderName) != null && fileRestoreStatus.get(folderName)==true)
				System.out.println("restore successful for user folder: " + folderName);
			else if(fileRestoreStatus.get(folderName) != null && fileRestoreStatus.get(folderName)==false)
				System.out.println("restore failed for user folder: " + folderName);
		}
		
		File[] templateFolderContents = new File(kpiwConfDir+"/user_template_files").listFiles();
		if(restoreTemplateFile(templateFolderContents))
			System.out.println("restore successful for template folder");
		else
			System.out.println("restore failed for template folder");
	}

	private static boolean restoreTemplateFile(File[] templateFolderContents) throws IOException {
		for (File dirContent : templateFolderContents) {
			if (dirContent.getName().equals("IQ00211136_backup") && dirContent.isDirectory()) 
			{
				File[] backupDirContents = dirContent.listFiles();
				for(File backupFile : backupDirContents)
				{
					if(backupFile.getName().endsWith("operations.xml"))
					{
						FileUtils.copyFile(backupFile, new File(dirContent.getParentFile()+"/operations.xml"));
					}
				}
				FileUtils.deleteDirectory(dirContent);
				return true;
			}
		}
		return false;
	}

	private static Map<String, Boolean> restoreUserFiles(File[] dirContents) throws IOException {
		Map<String, Boolean> fileRestoreStatus = new HashMap<String, Boolean>();
		for (File dirContent : dirContents) {
			if (dirContent.isDirectory()) {
				fileRestoreStatus.put(dirContent.getName(), restoreDirectory(dirContent));
			}
		}
		return fileRestoreStatus;
	}

	private static boolean restoreDirectory(File direcotry) throws IOException {
		File[] userFiles = direcotry.listFiles();
		for (File userFile : userFiles) 
		{
			if (userFile.getName().equals("IQ00211136_backup") && userFile.isDirectory()) 
			{
				File[] backupDirContents = userFile.listFiles();
				for(File backupFile : backupDirContents)
				{
					if(backupFile.getName().endsWith("operations.xml"))
					{
						FileUtils.copyFile(backupFile, new File(userFile.getParentFile()+"/operations.xml"));
					}
				}
				FileUtils.deleteDirectory(userFile);
				return true;
			}
		}
		return false;
	}

	private static void installPatch(String ipAddress, String kpiwConfDir) throws JDOMException, IOException {
		formatOmitDeclaration.setOmitDeclaration(true);
		formatIncludeDeclaration.setOmitDeclaration(false);
		
		File[] userTemplateFiles = new File(kpiwConfDir+"/user_template_files").listFiles();
		updateTemplateFiles(userTemplateFiles);
		
		File[] userDataFiles = new File(kpiwConfDir+"/user_data").listFiles();
		updateTemplateFiles(userDataFiles);		
	}

	private static void updateTemplateFiles(File[] dirContents) throws JDOMException, IOException {
		for (File dirContent : dirContents) {
			if (dirContent.isDirectory()) {
				outp.setFormat(formatOmitDeclaration);
				processDirectory(dirContent);
			}
			else if (dirContent.isFile() && dirContent.getName().endsWith("operations.xml")) {
				outp.setFormat(formatIncludeDeclaration);
				processFile(dirContent);
			}
		}		
	}

	private static void processDirectory(File direcotry) throws JDOMException, IOException {
		File[] userFiles = direcotry.listFiles();
		for (File userFile : userFiles) {
			if (userFile.getName().endsWith("operations.xml")) {
				processFile(userFile);
			}
		}
	}

	private static void processFile(File userFile)
			throws JDOMException, IOException 
	{
		SAXBuilder builder = new SAXBuilder();
		Element newCanvasMenus = createElement(ipAddress);
		Document doc = builder.build(new FileInputStream(userFile));
		
		new File(userFile.getParentFile()+"/IQ00211136_backup").mkdir();
		File backupFile = new File(userFile.getParentFile()+"/IQ00211136_backup/operations.xml"); 
		
		FileUtils.copyFile(userFile, backupFile, true);
		
		Element rootElement = doc.getRootElement();
		Element customContextMenus = rootElement.getChild("customContextMenus");

		customContextMenus.addContent(newCanvasMenus);
		customContextMenus.addContent("\n");

		outp.output(doc, new FileOutputStream(userFile));
		System.out.println("File: " + userFile + " is updated & old version backed up to " + userFile.getParent()+"/IQ00211136_backup");
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
		e1.addContent("\n");
		e1.addContent(e);
		e1.addContent("\n");
		return e1;
	}

}

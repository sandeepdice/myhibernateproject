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
	final static String MENU = "menu";
	final static String MENU_LABEL = "menuLabel";
	final static String LAUNCH_KPIA = "Launch KPI-A";
	final static String NAME = "name";
	final static String KPIA = "kpia";
	final static String URL = "url";
	final static String CANVAS_MENUS = "canvasMenus";
	final static String TYPE = "type";
	final static String SINGLE = "single";
	final static String CUSTOM_CONTEXT_MENUS = "customContextMenus";
	final static String BACKUP_FOLDER_NAME = "IQ00211136_backup";
	
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
			if (dirContent.getName().equals(BACKUP_FOLDER_NAME) && dirContent.isDirectory()) 
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
			if (userFile.getName().equals(BACKUP_FOLDER_NAME) && userFile.isDirectory()) 
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
			if (dirContent.isDirectory() && !(dirContent.getName().endsWith(BACKUP_FOLDER_NAME))) {
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
		
		Element rootElement = doc.getRootElement();
		Element customContextMenus = rootElement.getChild(CUSTOM_CONTEXT_MENUS);
		
		if(!checkLaunchKpiaMenuExists(customContextMenus))
		{
			new File(userFile.getParentFile()+"/" + BACKUP_FOLDER_NAME).mkdir();
			File backupFile = new File(userFile.getParentFile()+"/" + BACKUP_FOLDER_NAME + "/operations.xml"); 
			
			FileUtils.copyFile(userFile, backupFile, true);
			
			customContextMenus.addContent(newCanvasMenus);
			customContextMenus.addContent("\n");

			outp.output(doc, new FileOutputStream(userFile));
			System.out.println("File: " + userFile + " is updated & old version backed up to " + userFile.getParent()+"/" + BACKUP_FOLDER_NAME);			
		}
		else
		{
			System.out.println("File: " + userFile + " already contains "+ LAUNCH_KPIA +" menu. No update required");
		}
	}

	private static boolean checkLaunchKpiaMenuExists(Element customContextMenus) {
		List<Element> list = customContextMenus.getChildren();
		for(Element element : list)
		{
//			Element element = list.next();
			if(element.getName()==CANVAS_MENUS && element.getAttribute(TYPE).getValue().equals(SINGLE))
			{
				List<Element> childList = element.getChildren();
				for(Element childElement : childList)
				{
//					Element childElement = childIter.next();
					if(childElement.getName().equals(MENU) && childElement.getAttribute(MENU_LABEL).getValue().equals(LAUNCH_KPIA) 
							&& childElement.getAttribute(NAME).getValue().equals(KPIA) 
							&& !(childElement.getAttribute(URL).getValue().isEmpty()))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	private static Element createElement(String ipAddress) {
		Element e = new Element(MENU);
		e.setAttribute(MENU_LABEL, LAUNCH_KPIA);
		e.setAttribute(NAME, KPIA);
		e.setAttribute(
				URL,
				"http://" + ipAddress +"/kpiwDrilldown.html?dmsHost={host}&qosmId={pname}&"
						+ "startTime={chartStartSec}&endTime={chartEndSec}&selectedInterval={chartPointSec}&interval={chartIntervalSec}");
		Element e1 = new Element(CANVAS_MENUS);
		e1.setAttribute(TYPE, SINGLE);
		e1.addContent("\n");
		e1.addContent(e);
		e1.addContent("\n");
		return e1;
	}

}

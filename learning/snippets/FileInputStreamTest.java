package snippets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		String cfgFileLoc = "c:\\temp\\temp.txt";
		fis = new FileInputStream(new File(cfgFileLoc));
		System.out.println(fis==null);
	}

}

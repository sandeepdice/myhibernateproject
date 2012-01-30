package snippets;

import java.io.File;

public class MkDirTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File tempDir = new File("C:/temp/Error_Initial_Context_Fail.pcap");
		new File(tempDir.getParentFile()+"/nestedTemp").mkdir();
		
		System.out.println(tempDir.getParentFile());
	}

}

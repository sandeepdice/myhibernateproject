package snippets;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class BackupFileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File tempDir = new File("C:/temp/Error_Initial_Context_Fail.pcap");
		new File(tempDir.getParentFile()+"/nestedTemp").mkdir();
		File backupDir = new File(tempDir.getParentFile()+"/nestedTemp");
		File backupFile = new File(tempDir.getParentFile()+"/nestedTemp/Error_Initial_Context_Fail.pcap");
		FileUtils.copyFile(tempDir, backupFile, true);
		FileUtils.copyFile(backupFile, tempDir, false);
		FileUtils.deleteDirectory(backupDir);
	}

}

class A12300
{
	static void method() {}
}

class B12300 extends A12300
{
	void method() {}
}

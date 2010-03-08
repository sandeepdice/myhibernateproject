package standalone.beans;

import org.springframework.web.multipart.MultipartFile;

public class AddItem extends Item {
	private MultipartFile file;
	
	public void setFile(MultipartFile file) {
	    this.file = file;
	}
	
	public MultipartFile getFile() {
	    return file;
	}
}

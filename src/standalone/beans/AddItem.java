package standalone.beans;

public class AddItem extends Item {
	private byte[] file;
	
    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFile() {
        return file;
    }
}

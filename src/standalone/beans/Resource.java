package standalone.beans;

public class Resource {
	int resourceId;
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContext) {
		fileContent = fileContext;
	}
	String resourceName;
	String resourceType;
	byte[] fileContent;
	
	public Resource(int resId, String resName, String resType, byte[] file) {
		this.resourceId = resId;
		this.resourceName = resName;
		this.resourceType = resType;
		this.fileContent = file;
	}
	
}

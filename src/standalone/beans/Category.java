package standalone.beans;

public class Category
{
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(long categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	long categoryId;
	long categoryName;
	String description;	
}
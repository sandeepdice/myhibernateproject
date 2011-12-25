package hibernatebook.ch01;

public class UserInfo implements java.io.Serializable
{
	private Long userID;
	private String firstName;
	private String lastName;
	private Integer age;
	public String toString() 
	{
		return "UserInfo (UserID=" + userID + " First Name=" + firstName + " Last Name=" + lastName
		+ " Age=" + age + ")";
	}
	public void setUserID(Long userID) 
	{
		this.userID = userID;
	}
	public Long getUserID() 
	{
		return userID;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}
	public Integer getAge() 
	{
		return age;
	}
}
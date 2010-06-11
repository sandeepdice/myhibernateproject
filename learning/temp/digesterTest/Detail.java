package temp.digesterTest;

import java.io.File;
import java.util.Vector;

import org.apache.commons.digester.Digester;

public class Detail {
	  private String age;
	  private String education;
	  public Detail() {
	  }
	  public void setAge(String age){
	    this.age = age;
	    System.out.println("Age is "+this.age);
	  }
	  public void setEducation(String education) {
	    this.education = education;
	    System.out.println("education is "+this.education);
	 }
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return age + " " + education + " ";
	}
	}
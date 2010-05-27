package temp.digesterTest;

import java.io.File;
import java.util.Vector;

import org.apache.commons.digester.Digester;

public class Person {
	  private String name;
	  private Vector<Detail> details;
	  public Person() {
	    details = new Vector();
	  }
	  public void setName( String name ) {
	    this.name = name;
	    System.out.println("name " +this.name);
	  }
	  public void addDetail(Detail detail ) {
	    details.addElement(detail);
	  }
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		  String detailsString = new String();
		  for(Detail detail : details)
		  {
			  detailsString += detail.toString();
		  }
		return name + " " + detailsString + " ";
	}
	}
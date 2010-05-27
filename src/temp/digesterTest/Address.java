package temp.digesterTest;

import java.io.File;
import java.util.Vector;

import org.apache.commons.digester.Digester;

public class Address {
	  private String addressLine1;
	  private String addressLine2;
	  public Address() {}
	  public void setAddressLine1( String addressLine1 ) {
	    this.addressLine1 = addressLine1;
	    System.out.println("addressLine 1 is "+this.addressLine1);
	  }
	  public void setAddressLine2( String addressLine2 ) {
	    this.addressLine2 = addressLine2;
	  }
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return addressLine1 + " " + addressLine2 + " ";
	}
	}
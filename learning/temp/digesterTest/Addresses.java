package temp.digesterTest; 
import java.util.Vector;


public class Addresses {
	  private Vector<Address> addresses;
	  private Vector<Person> persons;
	  public Addresses() {
	    addresses = new Vector();
	    persons = new Vector();
	  }
	  public void addAddress(Address address ) {
	    addresses.addElement(address );
	  }
	  public void addPerson(Person person ) {
	    persons.addElement( person );
	  }
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		String addressesString = new String();
		String personString = new String();
		for(Address add : addresses)
		{
			addressesString += add.toString();
		}
		for(Person person : persons)
		{
			personString += person.toString();
		}
		return addressesString + "***" + personString;
	}
	}
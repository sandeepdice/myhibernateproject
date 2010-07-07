package temp;

/**
 * 	LinkedHashMap vs. HashMap?
	A LinkedHashMap differs from HashMap in that the order of elements is maintained.
	A HashMap has a better performance than a LinkedHashMap because a LinkedHashMap needs the expense of maintaining the linked list. 
	The LinkedHashMap implements a normal hashtable, but with the added benefit of the keys of the hashtable being stored as a doubly-linked list.
	Both of their methods are not synchronized.
 */

import java.util.LinkedHashMap;
 
public class JavaLinkedHashMapExample {
 
  public static void main(String[] args) {
 
    //create object of LinkedHashMap
    LinkedHashMap lHashMap = new LinkedHashMap();
 
    /*
      Add key value pair to LinkedHashMap using
      Object put(Object key, Object value) method of Java LinkedHashMap class,
      where key and value both are objects
      put method returns Object which is either the value previously tied
      to the key or null if no value mapped to the key.
    */
 
    lHashMap.put("One", new Integer(1));
    lHashMap.put("Two", new Integer(2));
    Object obj = lHashMap.get("Two");
    System.out.println(obj);  
    lHashMap.put("Two", new Integer(3));
 
    /*
      Please note that put method accepts Objects. Java Primitive values CAN NOT
      be added directly to LinkedHashMap. It must be converted to corrosponding
      wrapper class first.
    */
 
    //retrieve value using Object get(Object key) method of Java LinkedHashMap class
    obj = lHashMap.get("Two");
    System.out.println(obj);   
 
    /*
      Please note that the return type of get method is an Object. The value must
      be casted to the original class.
    */
 
 
  }
}
package snippets;

/*
 * Main.java
 *
 * @author www.javadb.com
 */
public class byteArray {
    
    /*
     * This method converts an byte array to a String object.
     */
    
    public void convertByteArrayToString() {
        
        byte[] byteArray = new byte[] {37,-13};
        
        String value = new String(byteArray);
        
        System.out.println(value);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new byteArray().convertByteArrayToString();
    }
}

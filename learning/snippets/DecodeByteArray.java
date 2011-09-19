package snippets;

import java.nio.ByteBuffer;

public class DecodeByteArray
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		byte[] tenInArray = convert(100000000);
		System.out.println(tenInArray.length);
		System.out.println("Array follows: ");
		for(int i=0; i < tenInArray.length; i++)
		{
			System.out.println(tenInArray[i]);
		}
		System.out.println("Byte to Array: ");
		System.out.println(byteArrayToInt(tenInArray, 0));
		
		ByteBuffer bbuf = ByteBuffer.allocate(10);
	}
	
	private static byte[] convert(int value)
	{
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
	}
	
  public static int byteArrayToInt(byte[] b, int offset) {
    int value = 0;
    for (int i = 0; i < 4; i++) {
        int shift = (4 - 1 - i) * 8;
        value += (b[i + offset] & 0x000000FF) << shift;
    }
    return value;
  }
}

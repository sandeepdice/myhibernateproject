package snippets;

import java.nio.ByteBuffer;

public class ByteBufferTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ByteBuffer masterByteBuffer = ByteBuffer.allocate(16);
		masterByteBuffer.putLong(9);
		masterByteBuffer.putLong(3);
		System.out.println(byteArrayToInt(masterByteBuffer.array(), 16));
	}


	public static int byteArrayToInt(byte[] b, int size)
	{
		int value = 0;
		for (int index = size; index > 0; index--)
		{
			int byteAtIndex = b[size - index];
			value += (byteAtIndex * Math.pow(2, index));
		}
		return value / 2;
	}
}

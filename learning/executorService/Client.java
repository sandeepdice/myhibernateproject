package executorService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket = new Socket("localhost", 4444);
		
		PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
		
		pw.print("bye");
		
		pw.close();
		clientSocket.close();
	}
}

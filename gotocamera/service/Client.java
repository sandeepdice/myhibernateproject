package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket clientSocket = new Socket("localhost", 4444);
		
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
		
		ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MILLISECONDS, workQueue);
		
		for(int i=0; i<10; i++)
		{
			executorService.submit(new InputThread(10, "thread:"+i, 4444, false));
		}
		executorService.submit(new InputThread(10, "", 4444, true));
		
//		clientSocket.close();
	}
}

class InputThread implements Runnable
{
	private String name;
	private int waitTime;
	private int portNumber;
	private boolean byeThread;

	@Override
	public void run() {
		System.out.println("started thread: " + name);
		PrintWriter pw = null;
		try {
			Socket clientSocket = new Socket("localhost", portNumber);
			pw = new PrintWriter(clientSocket.getOutputStream(), true);
			if(byeThread) pw.print("bye");
			pw.print(name + ":10");
			pw.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to get output stream from socket. Thread name: " + name);
		}
	}
	
	InputThread(int waitTime, String name, int portNumber, boolean byeThread)
	{
		this.waitTime = waitTime;
		this.name = name;
		this.portNumber = portNumber;
		this.byeThread = byeThread;
	}
}

package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	public static void main(String[] args) {
		ServerSocket server;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(
				10);
		ExecutorService executorService = new ThreadPoolExecutor(2, 3, 10,
				TimeUnit.MILLISECONDS, workQueue);
		try {
			server = new ServerSocket(4444);
			Socket client;
			BufferedReader in = null;

			while ((client = server.accept()) != null) {

				in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				String inputLine;
				inputLine = in.readLine();
				if (inputLine.equalsIgnoreCase("bye"))
				{
					System.out.println("Shutting down server...");
					break;
				}
				else
				{
					String[] splitArray = inputLine.split(":");
					int waitTime = Integer.parseInt(splitArray[1]);
					executorService.execute(new EventProcessorTask(waitTime, "th"+waitTime));
				}
				System.out.println(inputLine);
			}
			in.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		executorService.shutdownNow();
	}
}

class EventProcessorTask implements Runnable {
	private int waitDuration;
	private String name;

	@Override
	public void run() {
		System.out.println("Started " + name);
		try {
			Thread.sleep(waitDuration * 1000);
		} catch (InterruptedException e) {
			System.out.println("Thread: " + name + " interrupted");
		}
		System.out.println("Finished " + name);
	}

	public EventProcessorTask(int duration, String threadName) {
		this.waitDuration = duration;
		this.name = threadName;
	}
}

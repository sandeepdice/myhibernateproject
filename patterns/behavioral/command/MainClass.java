package behavioral.command;

public class MainClass {
	public static void main(String[] args) {
		Fan fan = new Fan();
		FanOnCommand fanOnCommand = new FanOnCommand(fan);
		Invoker invoker = new Invoker();

		/**
		 * Here we're creating a invoker object. This can be assigned with any
		 * type of command
		 */

		invoker.setCommand(fanOnCommand);
		
		/**
		 * Once we assign it we can just invoke the invoker. 
		 */
		
		invoker.buttonPressed();
	}
}
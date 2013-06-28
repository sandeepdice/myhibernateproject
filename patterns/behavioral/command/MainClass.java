package behavioral.command;

public class MainClass {
	public static void main(String[] args) {
		Fan fan = new Fan();
		FanOnCommand fanOnCommand = new FanOnCommand(fan);
		Invoker invoker = new Invoker();
		invoker.setCommand(fanOnCommand);
	}
}
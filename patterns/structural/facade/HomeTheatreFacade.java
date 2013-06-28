package structural.facade;

/**
 * Here, we have many subcomponents like Lights, Amplifier, Speaker, Projector and Screen.
 * We want to create simplified interface to client so it don't need to work on subcomponents.
 * 
 *  So, A facade not only simplifies an interface, it decouples a client from a subsystem of components
 *  
 *  Facade and Adapter are different. Adapter converts from one interface to other while facade's intent is to simplify 
 * @author ray55577
 *
 */

public class HomeTheatreFacade {

	public HomeTheatreFacade(Lights lights2, Amplifier amplifier2,
			Speaker speaker2, Projector projector2, Screen screen2, DVD dvd) {
		this.lights = lights2;
		this.amplifier = amplifier2;
		this.speaker = speaker2;
		this.projector = projector2;
		this.screen = screen2;
		this.dvd = dvd;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HomeTheatreFacade htf = new HomeTheatreFacade(new Lights(), new Amplifier(), new Speaker(), new Projector(), new Screen(), new DVD("Hulk"));
		htf.startMovie();
		System.out.println();
		System.out.println();
		System.out.println();
		htf.stopMovie();
	}

	private Lights lights;
	private Amplifier amplifier;
	private Speaker speaker;
	private Projector projector;
	private Screen screen;
	private DVD dvd;

	void startMovie()
	{
		lights.lightsOff();
		amplifier.amplify();
		speaker.soundhigh();
		projector.projectorOn();
		screen.screenon();
		dvd.startDvd();
	}
	
	void stopMovie()
	{
		amplifier.turnOffAmplifier();
		lights.lightsOn();
		speaker.turnOffSpeaker();
		projector.turnOffProjector();
		screen.turnOffScreen();
		dvd.stopDvd();
	}
}

class Amplifier {
	void amplify() { System.out.println("Amplified"); }
	void turnOffAmplifier() { System.out.println("Amplifier turned off");}
}

class Speaker {
	void soundhigh() {System.out.println("sound++");}
	void turnOffSpeaker() {System.out.println("speaker off");}
}

class Projector {
	void projectorOn() {System.out.println("projector turned on");}
	void turnOffProjector() {System.out.println("projector turned off");}
}

class Screen {
	void screenon() {System.out.println("screen on");}
	void turnOffScreen() {System.out.println("screen turned off");}
}

class Lights {
	void lightsOff() {System.out.println("lights off");}
	void lightsOn() {System.out.println("lights on");}
}

class DVD {
	String movieName;
	void startDvd() {System.out.println("movie: " + movieName + " playing");}
	void stopDvd() {System.out.println("move: "  + movieName + " playing stopped");}
	DVD(String movieName)
	{
		this.movieName = movieName;
	}
}
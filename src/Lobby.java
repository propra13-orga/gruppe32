

import game.Server;

import javax.swing.JFrame;

public class Lobby extends JFrame {

	public Lobby(String rolle, String ip) {
		
		/* Frame erzeugen, Eigenschaften festlegen. */
		
		if (rolle.equals("Server")) {
			
			/* Server starten. */
			new Server();
		} else {
			
			/* Client starten. */
			new Client(ip);
		}
	}

}

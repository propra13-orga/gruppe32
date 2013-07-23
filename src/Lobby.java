import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Lobby extends JFrame implements ActionListener {

	/** Textareas im Fenster */
	TextArea eingabe;
	TextArea ausgabe;
	/** Button im Fenster */
	JButton send;
	
	private Server server;
	private Client client;

	Lobby(String rolle, String ip) throws Exception {
		
		init(rolle);
	
    if (rolle.equals("Server")) {
			
			// Server starten. 
    	try{
			this.server = new Server(this);
			this.server.start();
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
		} else {
			try{
			// Client starten. 
			this.client = new Client(this, ip);
			this.client.start();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * initialisiert das Fenster
	 * 
	 * @param Titel
	 */
	void init(String rolle) {
		setLocation(400, 400);
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.setTitle(rolle);

		/* initialisert TextAreas */
		eingabe = new TextArea();
		ausgabe = new TextArea();

		/* initialisiert Button */
		send = new JButton();

		/* ActionListener wird erzeugt */
		send.setText("Abschicken");
		send.setActionCommand("Send");
		send.addActionListener(this);

		this.setLayout(new BorderLayout());

		/* Container für alle Fragmente im unteren Teil des Fensters */
		Container unten = new Container();
		unten.setLayout(new BorderLayout());
		unten.add(eingabe, BorderLayout.CENTER);
		unten.add(send, BorderLayout.EAST);

		this.add(unten, BorderLayout.SOUTH);
		this.add(ausgabe, BorderLayout.CENTER);
		
	}

	/**
	 * verkettet die einzelnen Ausgaben miteinander
	 * @param add
	 */
	public void addAusgabe(String add) {
		String temp = ausgabe.getText();
		temp += add;
		ausgabe.setText(temp);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Send")) {
			String ausgabe = eingabe.getText() + "\n";
			
			if (server != null) {
				
				server.print(ausgabe);
			} else {
				
				client.print(ausgabe);
			}
		}
	}
}


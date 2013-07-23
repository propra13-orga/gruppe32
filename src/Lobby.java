import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Lobby extends JFrame implements ActionListener {

	/** Textareas im Fenster */
	TextArea eingabe;
	TextField ausgabe;
	/** Button im Fenster */
	JButton send;
	JButton bereit;
	
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
		try {
			this.setTitle(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* initialisert TextAreas */
		eingabe = new TextArea();
		ausgabe = new TextField();
		ausgabe.setEditable(false);  
		
		/* initialisiert Button */
		send = new JButton();
		bereit = new JButton();

		/* ActionListener wird erzeugt */
		send.setText("Abschicken");
		send.setActionCommand("Send");
		send.addActionListener(this);
		
		bereit.setText("Bereit für Netzwerk");
		bereit.setActionCommand("Bereit");
		bereit.addActionListener(this);

		this.setLayout(new BorderLayout());

		/* Container für alle Fragmente im unteren Teil des Fensters */
		Container unten = new Container();
		unten.setLayout(new BorderLayout());
		unten.add(eingabe, BorderLayout.CENTER);
		unten.add(send, BorderLayout.EAST);
		unten.add(bereit, BorderLayout.WEST);

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
				eingabe.setText("");
			} else {
				
				client.print(ausgabe);
				eingabe.setText("");
			}
		}
		
		if (e.getActionCommand().equals("Bereit")) {
			bereit.setEnabled(false);
			String bereit = " ist bereit zum Spielen\n";
			
			if (server != null) {
				
				server.print(bereit);
				
			} else {
				
				client.print(bereit);
				
			}
		}
	}
}


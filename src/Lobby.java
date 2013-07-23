/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Lobby extends JFrame implements ActionListener{
	
	private static Client Client;
		
	//Variablen fuer das Chatfenster
	public static JFrame mainWindow = new JFrame();
	static JButton send = new JButton();
	private static JLabel message = new JLabel("Nachricht: ");
	public static JTextField messageFenster = new JTextField(20);
	private static JLabel conversation = new JLabel();
	public static JTextArea conversationTextfeld = new JTextArea();
	private static JScrollPane conversationScroll = new JScrollPane();
	
	
	public Lobby(String rolle, String ip) {
		
		// Frame erzeugen, Eigenschaften festlegen. 
			mainWindow.setTitle("Chat: "+rolle);
			mainWindow.setSize(370,320);
			mainWindow.setLocation(220,180);
			mainWindow.setResizable(false);
			mainWindow.setVisible(true);
			mainWindow.setBackground(new java.awt.Color(255, 255, 255));
			mainWindow.getContentPane().setLayout(null);
			
			send.setBackground(new java.awt.Color(0, 0, 255));
			send.setForeground(new java.awt.Color(255, 255, 255));
			send.setText("Senden");
			mainWindow.getContentPane().add(send);
			send.setBounds(250, 40, 81, 25);
					
			message.setText("Nachricht:");
			mainWindow.getContentPane().add(message);
			message.setBounds(10, 10, 60, 20);
			
			messageFenster.setForeground(new java.awt.Color(0, 0, 255));
			messageFenster.requestFocus();
			mainWindow.getContentPane().add(messageFenster);
			messageFenster.setBounds(70, 4, 260, 30);
			
			conversation.setHorizontalAlignment(SwingConstants.CENTER);
			conversation.setText("Unterhaltung");
			mainWindow.getContentPane().add(conversation);
			conversation.setBounds(100, 70, 140, 16);
			
			conversationTextfeld.setColumns(20);
			conversationTextfeld.setFont(new java.awt.Font("Tahoma", 0, 12));
			conversationTextfeld.setForeground(new java.awt.Color(0, 0, 255));
			conversationTextfeld.setLineWrap(true);
			conversationTextfeld.setRows(5);
			conversationTextfeld.setEditable(false);
			
			conversationScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			conversationScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			conversationScroll.setViewportView(conversationTextfeld);
			mainWindow.getContentPane().add(conversationScroll);
			conversationScroll.setBounds(10, 90, 330, 180);
				
		
		
		
		if (rolle.equals("Server")) {
			
			// Server starten. 
			new Server();
		} else {
			
			// Client starten. 
			new Client(ip, Server.PORT);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(send)){
			//send();
		}
		}
	
	

}*/

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Lobby extends JFrame {

	/** Textareas im Fenster */
	TextArea eingabe;
	TextArea ausgabe;
	/** Button im Fenster */
	JButton send;
	PrintWriter outPW;
	BufferedReader inBR;
	ActionListener x;

	Lobby(String rolle, PrintWriter out, BufferedReader in) throws Exception {
		outPW = out;
		inBR = in;
		init(rolle);
	
    if (rolle.equals("Server")) {
			
			// Server starten. 
    	try{
			new Server();
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
		} else {
			try{
			// Client starten. 
			new Client();
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
		x = new Action(outPW, inBR, eingabe);
		send.setText("Abschicken");
		send.setActionCommand("Send");
		send.addActionListener(x);

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
}

class Action implements ActionListener {
	PrintWriter outPW;
	BufferedReader inBR;
	TextArea eingabe;

	/**
	 * 
	 * @param out
	 * @param in
	 * @param Text
	 */
	Action(PrintWriter out, BufferedReader in, TextArea Text) {
		outPW = out;
		inBR = in;
		eingabe = Text;
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Send")) {
			String Ausgabe = eingabe.getText() + "\n";
			outPW.print(Ausgabe);
			outPW.flush();
		}
	}
}


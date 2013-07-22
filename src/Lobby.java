import java.awt.event.ActionEvent;
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
		
		/* Frame erzeugen, Eigenschaften festlegen. */
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
			
			/* Server starten. */
			new Server();
		} else {
			
			/* Client starten. */
			new Client(ip, Server.PORT);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(send)){
			//send();
		}
		}
	
	

}

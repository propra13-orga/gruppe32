
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ServerGUI{
	
	private static Client ChatClient;
	static String UserName = "Anonymous";
	final static String HOST = "127.0.0.1";
	
	//Variablen fuer das Chatfenster
	public static JFrame mainWindow = new JFrame();
	
	private static JButton connect = new JButton();
	private static JButton disconnect = new JButton();
	private static JButton send = new JButton();
	
	private static JLabel message = new JLabel("Nachricht: ");
	public static JTextField messageFenster = new JTextField(20);
	private static JLabel conversation = new JLabel();
	public static JTextArea conversationTextfeld = new JTextArea();
	private static JScrollPane conversationScroll = new JScrollPane();
	private static JLabel online = new JLabel();
	public static JList onlineList = new JList();
	private static JScrollPane onlineScroll = new JScrollPane();
	private static JLabel loggedInAs = new JLabel();
	private static JLabel loggedInBox = new JLabel();
	
	//Variablen im Log-In Fenster
	public static JFrame logInWindow = new JFrame();
	public static JTextField userNameBox = new JTextField(20);
	private static JButton enter = new JButton("Eingabe");
	private static JLabel enterUserName = new JLabel("Usernamen eingeben: ");
	private static JPanel login = new JPanel();
	
	
	
	public static void connect()
	{
		try
		{
			
			Socket socket = new Socket(HOST,Server.PORT);
			System.out.println("Verbunden mit: " + HOST);
			
			ChatClient = new Client(socket);
			
			//Sendet Usernamen an die Online Liste
			PrintWriter OUT = new PrintWriter(socket.getOutputStream());
			OUT.println(UserName);
			OUT.flush();
			
			Thread X = new Thread(ChatClient);
			X.start();
		}
		catch(Exception X)
		{
			System.out.print(X);
			JOptionPane.showMessageDialog(null, "Server antwortet nicht.");
			System.exit(0);
		}
	}
	
	public static void logInWindow()
	{
		logInWindow.setTitle("Wie ist dein Name?");
		logInWindow.setSize(400,100);
		logInWindow.setLocation(250,200);
		logInWindow.setResizable(false);
		login = new JPanel();
		login.add(enterUserName);
		login.add(userNameBox);
		login.add(enter);
		logInWindow.add(login);
		
		loginAction();
		logInWindow.setVisible(true);
		}
	
	public static void chatWindow()
	{
		mainWindow.setTitle(UserName);
		mainWindow.setSize(450,500);
		mainWindow.setLocation(220,180);
		mainWindow.setResizable(false);
		configureChatWindow();
		chatWindowAction();
		mainWindow.setVisible(true);
	}
	
	public static void configureChatWindow()
	{
		mainWindow.setBackground(new java.awt.Color(255, 255, 255));
		mainWindow.setSize(500,320);
		mainWindow.getContentPane().setLayout(null);
		
		send.setBackground(new java.awt.Color(0, 0, 255));
		send.setForeground(new java.awt.Color(255, 255, 255));
		send.setText("Senden");
		mainWindow.getContentPane().add(send);
		send.setBounds(250, 40, 81, 25);
		
		disconnect.setBackground(new java.awt.Color(0, 0, 255));
		disconnect.setForeground(new java.awt.Color(255, 255, 255));
		disconnect.setText("Disconnect");
		mainWindow.getContentPane().add(disconnect);
		disconnect.setBounds(10, 40, 110, 25);
		
		connect.setBackground(new java.awt.Color(0, 0, 255));
		connect.setForeground(new java.awt.Color(255, 255, 255));
		connect.setText("Verbinden");
		mainWindow.getContentPane().add(connect);
		connect.setBounds(130, 40, 110, 25);
		
	
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
		
		online.setHorizontalAlignment(SwingConstants.CENTER);
		online.setText("Zurzeit online");
		online.setToolTipText("");
		mainWindow.getContentPane().add(online);
		online.setBounds(250, 70, 130, 16);
		

		onlineList.setForeground(new java.awt.Color(0, 0, 255));

		
		onlineScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		onlineScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		onlineScroll.setViewportView(onlineList);
		mainWindow.getContentPane().add(onlineScroll);
		onlineScroll.setBounds(348, 90, 130, 180);
		
		loggedInAs.setFont(new java.awt.Font("Tahoma", 0, 12));
		loggedInAs.setText("Eingeloggt als");
		mainWindow.getContentPane().add(loggedInAs);
		loggedInAs.setBounds(348, 0, 140, 15);
		
		loggedInBox.setHorizontalAlignment(SwingConstants.CENTER);
		loggedInBox.setFont(new java.awt.Font("Tahoma", 0, 12));
		loggedInBox.setForeground(new java.awt.Color(255, 0, 0));
		loggedInBox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		mainWindow.getContentPane().add(loggedInBox);
		loggedInBox.setBounds(340, 17, 150, 20);
		
	}
	
	public static void loginAction(){
		enter.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				enterAction();}
			
			}
		);
	}

	public static void enterAction(){
		if(!userNameBox.getText().equals("")){
			UserName = userNameBox.getText().trim();
			loggedInBox.setText(UserName);
			Server.CurrentUsers.add(UserName);
			mainWindow.setTitle(UserName + "'s Chat Fenster");
			logInWindow.setVisible(false);
			
			connect();
		}
		else{
			JOptionPane.showMessageDialog(null, "Bitte gib einen Namen ein!");}
	}
	
	public static void chatWindowAction(){
		connect.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				logInWindow();}
		}
		);
		
		send.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				sendAction();}
		}
		);
		
		disconnect.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				disconnectAction();}
		}
		);
			
	}
		
	
	
	
	public static void sendAction(){
		if(!messageFenster.getText().equals("")){
			ChatClient.send(messageFenster.getText());
			messageFenster.requestFocus();
		}
	}
	
	public static void disconnectAction(){
		try{
			ChatClient.disconnect();
		}
		catch(Exception Y) {Y.printStackTrace();}
	}
	
	
}

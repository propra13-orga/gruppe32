import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client extends Panel implements Runnable{
	
	//fuer graphische Ausgabe
	private TextField tf = new TextField();
	private TextArea ta = new TextArea();
	
	//Socket, der uns mit dem Server verbindet
	private Socket socket;
	
	//Streams vom SOcket, die wir dem Server mitteilen
	private DataOutputStream dout;
	private DataInputStream din;
	
	
	//Konstruktor
	public Client(String host, int port){
		setLayout(new BorderLayout());
		
		add("North", tf);
		add("Center", ta);
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processMessage(e.getActionCommand());
			}
		});
		
		//Verbindung zum Server
		try{
			socket = new Socket(host,port);
			System.out.println("Verbunden mit "+socket);
			din = new DataInputStream(socket.getInputStream());
			dout = new DataOutputStream(socket.getOutputStream());
			
			//Thread um Nachrichten zu empfangen
			new Thread(this).start();
		}
		catch(IOException ie){
			System.out.println(ie);
		}
	
	}
	/**
	 * wird aufgerufen, wenn Nutzer etwas schreibt
	 * @param message Nachricht, die getippt wird
	 */
	private void processMessage(String message){
		try{
			//zum Server senden
			dout.writeUTF(message);
			
			//Texteingabefeld leeren
			tf.setText("");
		}
		catch(IOException ie){
			System.out.println(ie);
		}
			
	}
	
	public void run(){
		try{
			while(true){
				//Nachricht abspeichern
				String message = din.readUTF();
				
				//Im Textfenster anzeigen
				ta.append(message+"\n");
			}
		}
			catch(IOException ie){
				System.out.println(ie);
			}
	}
	
	
}

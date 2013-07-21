
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread implements Runnable{
	
	protected Socket client;
	//protected DataInputStream in;
	//protected PrintStream out;
	//protected Server server;
	
	BufferedReader inputServer = null;
	BufferedWriter outputClient = null; 
	
	
	public Client(String ip, int port){
		try{
			//Verbindung Socket mit Server
			client = new Socket(ip,port);				
		}
		catch(IOException e) {System.out.print(e);}
	}
	
	
	
	public void run()
	{
		try {
			
			//BufferedReader um Daten vom Server zu lesen
			inputServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// BufferedWriter um Daten zum Server zu senden
			outputClient = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Daten zum Server senden
			/*
			String toServer = ???;
			outputClient.write(toServer);
			outputClient.newLine();
			outputClient.flush();
			*/

			// Auf Antwort vom Server warten
			String fromServer = inputServer.readLine();
			        
	         
	      }
	      catch(IOException e) {
	         System.out.print("Fehler");
	      }
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(Lobby.send)){
			
		}
		}
		

}

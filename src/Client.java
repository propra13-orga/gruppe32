/*
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread implements Runnable{
	
	protected Socket client;
	
	BufferedReader input = null;
	BufferedWriter output = null; 
	
	
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
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// BufferedWriter um Daten zum Server zu senden
			output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Daten zum Server senden
			
			String toServer = ???;
			outputClient.write(toServer);
			outputClient.newLine();
			outputClient.flush();
			

			// Auf Antwort vom Server warten
			String fromServer = input.readLine();
			        
	         
	      }
	      catch(IOException e) {
	         System.out.print("Fehler");
	      }
	}
	
	
		

}*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	Lobby frame;
	Socket socket = null;
	static PrintWriter out = null;
	static BufferedReader in = null;
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Konstruktor
	 */
	Client() {
		try {
			socket = new Socket(Interface.ip, 5000);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			frame = new Lobby("Client", out, in);
		} catch (Exception e) {
			System.exit(1);
		} // catch
	} // Chatter

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			String incoming;
			try {
				incoming = in.readLine();
				frame.addAusgabe(incoming);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

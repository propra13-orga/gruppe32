/*import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread implements Runnable{
	
	final static int PORT = 5000;
	ServerSocket server = null;
	Socket socket = null;
	BufferedReader input = null;
	BufferedWriter output = null; 

	
		
	public Server(){
		try{
			server = new ServerSocket(PORT);
			System.out.println("Auf Clients warten...");
		
		}
		catch(IOException e) {System.out.print(e);}
		
		
	}

	
	public void run(){
		
		try
		{
			// auf Client zum Verbinden warten
			socket = server.accept();

			// BufferedReader um Daten zu lesen
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// BufferedWriter um Daten zum Client zu schicken
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			
			// Warten auf den Client
			
			String fromClient = input.readLine();
			output.write(fromClient);
			output.newLine();
			output.flush(); 
		
			
			
		} catch (IOException e)
		{
			System.err.println("Fehler beim Warten auf Verbindungen:"+e);
			System.exit(1);
		}
	}
	

	
	
}*/


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
public class Server extends Thread {
	Lobby frame;
	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	static PrintWriter out = null;
	static BufferedReader in = null;

	Server() throws Exception {
		serverSocket = new ServerSocket(5000);
	}

	public void run() {
		while (true) {
			try {
				clientSocket = serverSocket.accept(); // Warte auf Verbindung
				out = new PrintWriter(clientSocket.getOutputStream(), true);// Ausgabestrom
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Eingabestrom
				frame = new Lobby("Server", out, in);
				while (true){
					String incoming = in.readLine();
					frame.addAusgabe(incoming);
				}
			}catch (IOException e) {
				System.out.println("Fehler - ServerSocket.accept()");
			}// catch
 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}// while
	}
}

/*
class Verwalter {
	public static void main(String[] args) {
		try {
			//Server und Client Thread werden erstellt 
			new Server().start(); // Server
			new Client().start(); // Client
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/


import java.awt.event.ActionEvent;
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
			/*
			String fromClient = input.readLine();
			output.write(fromClient);
			output.newLine();
			output.flush(); 
		*/
			
			
		} catch (IOException e)
		{
			System.err.println("Fehler beim Warten auf Verbindungen:"+e);
			System.exit(1);
		}
	}
	

	
	
}

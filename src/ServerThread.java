import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread{
	
	private Server server;
	
	//Socket, der zum Client verbunden ist
	private Socket socket;
	
	//Konstruktor
	public ServerThread(Server server, Socket socket){
		
		//Speichern der Parameter
		this.server = server;
		this.socket = socket;
		
		start();
	}
	
	/**
	 * laeuft in separatem Thread wenn start() im Konstruktor aufgerufen wird
	 */
	public void run(){
		try{
			//DataInputStream (Client benutzt DataOutputStream zum Schreiben)
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			while(true){
				//naechste Nachricht lesen
				String message = din.readUTF();
				System.out.println("Sendet "+message);
				
				//zu allen Clients verschicken
				server.sendToAll(message);
			}
			
		}
		catch(EOFException ie){	
			
		}
		
		catch(IOException ie){	
		ie.printStackTrace();
		}
		
		finally{
			//falls Verbindung getrennt wird
			server.removeConnection(socket);
		}
				
	}
}

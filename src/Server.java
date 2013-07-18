import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;


public class Server {

	//Server der f�r neue Verbingungen verwendet wird
	private ServerSocket ss;
	
	//um nicht jedes Mal neuen DataOutputSTream zu erzeugen
	private Hashtable outputStreams = new Hashtable();
	
	//Konstruktor
	public Server(int port) throws IOException{
		listen(port);
	}
	
	private void listen(int port)throws IOException{
		//Server Socket
		ss = new ServerSocket(port);
		System.out.println("Warten auf "+ss);
		
		//um alle Verbindungen zu akzeptieren
		while(true){
			//n�chste eingehende Verbindung auffangen
			Socket s = ss.accept();
			
			System.out.println("Verbindung "+s);
			
			//DataOutputStream
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			//Speichern des Streams
			outputStreams.put(s, dout);
			
			new ServerThread(this, s);
		}
	}
	
	//Aufz�hlung aller Output-Streams (f�r jeden CLient)
	Enumeration getOutputStreams(){
		return outputStreams.elements();
	}
	
	/**
	 * sendet Nachricht an alle Clients
	 * @param message Nachricht, die versendet wird
	 */
	void sendToAll(String message){
		synchronized(outputStreams){
			// Schleife �ber alle Clients
			for (Enumeration e = getOutputStreams(); e.hasMoreElements();){
				DataOutputStream dout = (DataOutputStream)e.nextElement();
				
			//Versenden der Nachricht
				try{
					dout.writeUTF(message);
					
				}
				catch(IOException ie){System.out.println(ie);}
			}
		}
	}
	
	/**
	 * entfernt Socket und dazugehoerigen Output Stream 
	 * (aufgerufen falls eine Verbindung zum Client nicht mehr da ist)
	 * @param s
	 */
	void removeConnection(Socket s){
		synchronized(outputStreams){
			System.out.println("Entferne Verbindung zu "+s);
			//Entfernen
			outputStreams.remove(s);
			
			//Sichergehen, dass geschlossen wurde
			try{
				s.close();
				
			}catch(IOException ie){
				System.out.println("Fehler beim Schlie�en von "+s);
				ie.printStackTrace();
			}
		}
	}
	
	/*
	 * nur zum testen
	 */
	static public void main(String args[])throws Exception{
		//int port = Integer.parseInt(args[0]);
		new Server(5000);
	}
	
	
	
	
	
	
}

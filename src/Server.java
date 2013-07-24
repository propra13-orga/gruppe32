import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
public class Server extends Thread {
	
	private Lobby frame;
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	public Server(Lobby lobby) {
		
		this.frame = lobby;
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		
		try {
			clientSocket = serverSocket.accept(); // Warte auf Verbindung
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			
			while (true) {
				try{
					Object incoming = in.readObject();
					if (incoming instanceof String){
						incoming = (String)incoming;
						frame.addAusgabe(incoming+"\n");
					}
					else if(incoming instanceof int[]){
						incoming = (int[])incoming;
						//PvPMain.recieve(incoming);
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}catch (IOException e) {
			System.out.println("Fehler - ServerSocket.accept()");
		}catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// while

	public void print(String ausgabe) {
		try{
		String printer = ("Server: "+ausgabe);
		out.writeObject(printer);
		out.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
				
	}
	public void transfer(int[] transferArray){
		try{
			out.writeObject(transferArray);
			out.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}


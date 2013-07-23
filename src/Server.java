import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
public class Server extends Thread {
	
	private Lobby frame;
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

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
			out = new PrintWriter(clientSocket.getOutputStream(), true);// Ausgabestrom
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Eingabestrom
			
			while (true){
				String incoming = in.readLine();
				frame.addAusgabe(incoming);
			
			}
		}catch (IOException e) {
			System.out.println("Fehler - ServerSocket.accept()");
		}catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// while

	public void print(String ausgabe) {
		
		out.print("Server: "+ausgabe+"\n");
		out.flush();
		
		
	}
}


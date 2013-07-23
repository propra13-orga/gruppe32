import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	
	private Lobby frame;
	private Socket socket = null;
	public static PrintWriter out = null;
	public static BufferedReader in = null;

	/**
	 * Konstruktor
	 */
	public Client(Lobby lobby, String ip) {
		
		this.frame = lobby;
		
		try {
			socket = new Socket(ip, 5000);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			System.exit(1);
		} // catch
	} 

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

	public void print(String ausgabe) {
		out.print("Client: "+ausgabe+"\n");
		out.flush();
		(Server.out).print("Client: "+ausgabe+"\n");
		(Server.out).flush();
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	
	private Lobby frame;
	private Socket socket = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;

	/**
	 * Konstruktor
	 */
	public Client(Lobby lobby, String ip) {
		
		this.frame = lobby;
		
		try {
			socket = new Socket(ip, 5000);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.exit(1);
		} // catch
	} 

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			try{
				Object incoming = in.readObject();
				if (incoming instanceof String){
					incoming = (String)incoming;
					frame.addAusgabe(incoming+"\n");
				}
				else if(incoming instanceof double[]){
					double[] incoming2 = (double[])incoming;
					PvPMain.recieve(incoming2);
				}
				else if(incoming instanceof int[]){
					frame.setOppReady();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public void print(String ausgabe) {
		try{
			String printer = ("Client: "+ausgabe);
			out.writeObject(printer);
			out.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
				
	}
	public void transfer(double[] transferArray){
		try{
			out.writeObject(transferArray);
			out.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public void setReady(){
		int[] ready = new int[0];
		
		try{
			out.writeObject(ready);
			out.flush();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
}

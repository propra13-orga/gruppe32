import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerReturn implements Runnable {

	Socket socket;
	private Scanner INPUT;
	private PrintWriter OUT;
	String MESSAGE = "";
	
	public ServerReturn(Socket X){
		this.socket = X;
	}
	
	public void CheckConnection() throws IOException{
		if(!socket.isConnected()){
			for(int i = 1; i <= Server.ConnectionArray.size(); i++){
				if(Server.ConnectionArray.get(i) == socket){
					Server.ConnectionArray.remove(i);
				}
			}
			
			for(int i = 1; i <= Server.ConnectionArray.size(); i++){
				Socket TEMP_SOCK = (Socket) Server.ConnectionArray.get(i-1);
				PrintWriter TEMP_OUT = new PrintWriter (TEMP_SOCK.getOutputStream());
				TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName() + " disconnected!");
				TEMP_OUT.flush();
				System.out.println(TEMP_SOCK.getLocalAddress().getHostName() + " disconnected!");
				
			}
		}
	}
	
	public void run(){
		try{
			try{
				INPUT = new Scanner(socket.getInputStream());
				OUT = new PrintWriter(socket.getOutputStream());
				
				while(true){
					CheckConnection();
					
					if(!INPUT.hasNext())
					{return;}
					
					MESSAGE = INPUT.nextLine();
					
					System.out.println("Client schreibt: " + MESSAGE);
					
					for(int i = 1; i <= Server.ConnectionArray.size(); i++){
						Socket TEMP_SOCK = (Socket) Server.ConnectionArray.get(i-1);
						PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
						TEMP_OUT.println(MESSAGE);
						TEMP_OUT.flush();
						System.out.println("Gesendet an: " + TEMP_SOCK.getLocalAddress().getHostName());
					}
				}
			}
			finally
			{
				socket.close();
				
			}
		}
		catch(Exception X) {System.out.println(X);}
	}
}

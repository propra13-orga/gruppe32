import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	
	final static int PORT = 5000;

	public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
	public static ArrayList<String> CurrentUsers = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException
	{
		try
		{
			
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Auf Clients warten...");
			
			while(true)
			{
				Socket SOCK = server.accept();
				ConnectionArray.add(SOCK);
				
				System.out.println("Client verbunden von: " + SOCK.getLocalAddress().getHostName());
				
				addUserName(SOCK);
				
				ServerReturn CHAT = new ServerReturn(SOCK);
				Thread X = new Thread(CHAT);
				X.start();
			}
		}
		
		catch(Exception X) {System.out.print(X);}
	}
	
	public static void addUserName(Socket X) throws IOException
	{
		Scanner INPUT = new Scanner(X.getInputStream());
		String UserName = INPUT.nextLine();
		CurrentUsers.add(UserName);
		
		for(int i = 1; i <= Server.ConnectionArray.size(); i++)
		{
			Socket TEMP_SOCK = (Socket) Server.ConnectionArray.get(i-1);
			PrintWriter OUT = new PrintWriter (TEMP_SOCK.getOutputStream());
			OUT.println("#?!" + CurrentUsers);
			OUT.flush();
		}
	}
}

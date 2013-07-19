import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable
{
	public static final int PORT = 8765;
	public static ServerSocket listen;
	public static Vector connections;
	Thread connect;

	public Server()
	{
		try
		{
			listen = new ServerSocket(PORT);
		} catch (IOException e)
		{
			System.err.println("Fehler beim Erzeugen der Sockets:"+e);
			System.exit(1);
		}

		connections = new Vector();

		connect = new Thread(this);
		connect.start();
	}

	public void run()
	{
		try
		{
			while(true)
			{
				Socket client=listen.accept();

				Connection c = new Connection(this, client);
				connections.addElement(c);
			}
		} catch (IOException e)
		{
			System.err.println("Fehler beim Warten auf Verbindungen:"+e);
			System.exit(1);
		}
	}

	
	public static void broadcast(String msg)
	{
		int i;
		Connection you;

		for (i=0; i<connections.size(); i++)
		{
			you = (Connection) connections.elementAt(i);
			you.out.println(msg);
		}
	}
	
	public static void main(String[] args){
		new Server();
	}
}

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Chatapplet extends Applet implements Runnable
{
	public static final int PORT = 8765;
	Socket socket;
	DataInputStream in;
	PrintStream out;
	TextField inputfield;
	TextArea outputarea;
	Thread thread;

	/**
	 * Methode, die Chatfenster erstellt
	 */
	public void init()
	{
		//Eingabefeld und Textfenster
		inputfield = new TextField();
		outputarea = new TextArea();
		outputarea.setFont( new Font("Dialog", Font.PLAIN, 12));
		outputarea.setEditable(false);

		this.setLayout(new BorderLayout());
		this.add("South", inputfield);
		this.add("Center", outputarea);

		//Graphische Eigenschaften wie Farbe des Hintergrunds
		this.setBackground(Color.lightGray);
		this.setForeground(Color.black);
		inputfield.setBackground(Color.white);
		outputarea.setBackground(Color.white);
	}

	/**
	 * versucht Verbindung zum Server aufzubauen
	 */
	public void start()
	{
		try
		{
			socket = new Socket(this.getCodeBase().getHost(), PORT);
			in = new DataInputStream(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e)
		{
			this.showStatus(e.toString());
			say("Verbindung zum Server fehlgeschlagen!");
			System.exit(1);
		}

		say("Verbindung zum Server aufgenommen...");

		if (thread == null)
		{
			thread = new Thread(this);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		}
	}


	public void stop()
	{
		try
		{
			socket.close();
		} catch (IOException e)
		{
			this.showStatus(e.toString());
		}

		if ((thread !=null) && thread.isAlive())
		{
			thread.stop();
			thread = null;
		}
	}


	public void run()
	{
		String line;

		try
		{
			while(true)
			{
				line = in.readLine();
				if(line!=null)
					outputarea.appendText(line+'\n' );
			}
		} catch (IOException e) { say("Verbindung zum Server abgebrochen"); }
	}


	/**
	 * 
	 */
	public boolean action(Event e, Object what)
	{
		if (e.target==inputfield)
		{
			String inp=(String) e.arg;

			out.println(inp);
			//Eingabefeld leeren
			inputfield.setText("");
			return true;
		}

		return false;
	}

/**
 * Gibt Nachricht im Chatfenster ueber den aktuellen Stand aus 
 * @param msg Nachricht die angezeigt wird
 */
	public void say(String msg)
	{	
		outputarea.appendText("*** "+msg+" ***\n");
	}
}
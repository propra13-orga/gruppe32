import java.applet.Applet;
import java.awt.BorderLayout;


public class ClientApplet extends Applet{
	public void init(){
		String host = getParameter("host");
		int port = 5000;
		//int port = Integer.parseInt(getParameter("port"));
		setLayout(new BorderLayout());
		add("Center", new Client(host,port));
	}
}

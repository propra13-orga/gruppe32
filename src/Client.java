
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client implements Runnable
{

	Socket socket;
	Scanner input;
	Scanner send = new Scanner(System.in);
	PrintWriter OUT;
	
	public Client(Socket X){
		this.socket = X;
	}
	
	public void run(){
		try{
			try{
				input = new Scanner(socket.getInputStream());
				OUT = new PrintWriter(socket.getOutputStream());
				OUT.flush();
				checkStream();
			}
			finally{
				socket.close();
			}
		}
		catch(Exception X) {System.out.print(X);}
	}
	
	public void disconnect() throws IOException{
		OUT.println(ServerGUI.UserName + " wurde disconnected.");
		OUT.flush();
		socket.close();
		JOptionPane.showMessageDialog(null, "Du wurdest disconnected!");
		System.exit(0);
	}
	
	public void checkStream(){
		while(true){
			receive();
		}
	}
	
	public void receive(){
		if(input.hasNext()){
			String MESSAGE = input.nextLine();
			
			if(MESSAGE.contains("#?!")){
				String TEMP1 = MESSAGE.substring(3);
				TEMP1 = TEMP1.replace("[", "");
				TEMP1 = TEMP1.replace("]", "");
				
				String[] CurrentUsers = TEMP1.split(", ");
				
				ServerGUI.onlineList.setListData(CurrentUsers);
			}
			else{
				ServerGUI.conversationTextfeld.append(MESSAGE + "\n");
			}
		}
	}
	
	public void send(String X){
		OUT.println(ServerGUI.UserName + ": " + X);
		OUT.flush();
		ServerGUI.messageFenster.setText("");
	}
}

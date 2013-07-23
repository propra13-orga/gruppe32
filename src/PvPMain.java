import java.io.*;
import java.net.*;


public class PvPMain{
	public static double[] transferArray = new double[6];
	public static double[] recieveArray = new double[6];
	public static boolean aktiv;
	public static boolean isServer;
	
	public static int connectionCounter;
	
	public PvPMain(boolean server, int leben, double startSchaden, int startMana, int startFarbe){
		connectionCounter=0;
		isServer = server;
		PvPSpieler.setLeben(leben);
		PvPSpieler.setSchaden(startSchaden);
		PvPGegner.setSchaden(startSchaden);
		PvPSpieler.setFarbe(startFarbe);
		PvPGegner.setFarbe(startFarbe);
		Spielfeld.initSpielfeldPvP();
		if (server){
			PvPSpieler.setXY(1, 1);
			PvPGegner.setXY(19, 14);
			aktiv=true;
		}
		else{
			PvPGegner.setXY(1, 1);
			PvPSpieler.setXY(19, 14);
			aktiv=false;
			clientConnect();
		}
		PvPDisplay.spielfeldDarstellen();	
	}
	
	public static void aktion(String taste){
		if(aktiv){
			if (taste=="w"){
				PvPAktion.figurAttack(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="a"){
				PvPAktion.figurAttack(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());			
			}
			if (taste=="s"){
				PvPAktion.figurAttack(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="d"){
				PvPAktion.figurAttack(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="links"){
				PvPAktion.figurBewegen(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="rechts"){
				PvPAktion.figurBewegen(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="oben"){
				PvPAktion.figurBewegen(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="unten"){
				PvPAktion.figurBewegen(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="leer"){
				PvPSpieler.schildZauber();
			}

		}
		aktiv=false;
		if(isServer){
			serverAccept();
		}
		else{
			clientConnect();
		}
		
	}
	
	public static void updateTransferArray(){
		transferArray[0]=PvPSpieler.getX();
		transferArray[1]=PvPSpieler.getY();
		transferArray[2]=PvPSpieler.getSchaden();
		transferArray[3]=PvPSpieler.getRuestung();
		transferArray[4]=PvPSpieler.getFarbe();
		transferArray[5]=PvPSpieler.getSchildInt();
	}
	public static void recieveAuswerten(){
		int newX = (int)recieveArray[0];
		int newY = (int)recieveArray[1];
		PvPGegner.setXY(newX, newY);
		PvPGegner.setSchaden(recieveArray[2]);
		PvPGegner.setRuestung(recieveArray[3]);
		int newFarbe = (int)recieveArray[4];
		PvPGegner.setFarbe(newFarbe);
		if(recieveArray[5]==1){
			PvPGegner.setSchild(true);
		}
		else{
			PvPGegner.setSchild(false);
		}
		PvPSpieler.schadenBekommen(recieveArray[6]);
		aktiv=true;
	}
	public static void clientConnect(){
		try{
			Socket socket = new Socket("localhost", 7777);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transferArray);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			recieveArray = (double[]) ois.readObject();
			connectionCounter++;
			if ((connectionCounter%2)!=0){
				aktiv=true;
				recieveAuswerten();
			}
			socket.close();
		}
		catch (UnknownHostException e) {
	        e.printStackTrace();
	    } 
		catch (IOException e) {
	        e.printStackTrace();
	    }
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void serverAccept(){
		 try
		    {
		        ServerSocket server = new ServerSocket(7777);
		        Socket socket = server.accept();
		        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(transferArray);
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				recieveArray = (double[]) ois.readObject();
				connectionCounter++;
				if ((connectionCounter%2)==0){
					aktiv=true;
					recieveAuswerten();
				}
				server.close();
		    }
		 catch (IOException e) {
		        e.printStackTrace();
		    }
		 catch (ClassNotFoundException e){
				e.printStackTrace();
		 }
		 
	}
}
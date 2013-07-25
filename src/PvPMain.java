import java.io.*;
import java.net.*;


public class PvPMain{
	public static double[] transferArray = new double[7];
	public static boolean aktiv;
	public static boolean isServer;
	public static Server myServer;
	public static Client client;
	
	public static int connectionCounter;
	
	public PvPMain(boolean server,Server newServer, Client newClient, int leben, double startSchaden, int startMana, int startFarbe){
		connectionCounter=0;
		isServer = server;
		PvPSpieler.setLeben(leben);
		PvPSpieler.setSchaden(startSchaden);
		PvPGegner.setSchaden(startSchaden);
		PvPSpieler.setFarbe(startFarbe);
		PvPGegner.setFarbe(startFarbe);
		Spielfeld.initSpielfeldPvP();
		
		if (server){
			myServer = newServer;
			PvPSpieler.setXY(1, 1);
			PvPGegner.setXY(18, 11);
		}
		else{
			client = newClient;
			PvPGegner.setXY(1, 1);
			PvPSpieler.setXY(18, 11);
		}
		PvPDisplay.spielfeldDarstellen();
		Interface.startPvp();
	}
	
	public static void aktion(String taste){
		
			if (taste=="w"){
				PvPAktion.figurAttack(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="a"){
				PvPAktion.figurAttack(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());			
			}
			else if (taste=="s"){
				PvPAktion.figurAttack(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="d"){
				PvPAktion.figurAttack(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="links"){
				PvPAktion.figurBewegen(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="rechts"){
				PvPAktion.figurBewegen(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="oben"){
				PvPAktion.figurBewegen(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="unten"){
				PvPAktion.figurBewegen(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			else if (taste=="leer"){
				PvPSpieler.schildZauber();
			}
			transfer();
		
	}
	
	public static void transfer(){
		transferArray[0]=PvPSpieler.getX();
		transferArray[1]=PvPSpieler.getY();
		transferArray[2]=PvPSpieler.getSchaden();
		transferArray[3]=PvPSpieler.getRuestung();
		transferArray[4]=PvPSpieler.getFarbe();
		transferArray[5]=PvPSpieler.getSchildInt();
		if(isServer){
			myServer.transfer(transferArray);
		}
		else{
			client.transfer(transferArray);
		}
		transferArray[6]=0;
	}
	public static void recieve(double[] recieveArray){
		int newX = (int)recieveArray[0];
		int newY = (int)recieveArray[1];
		PvPGegner.moveTo(newX, newY);
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
	}
	
}
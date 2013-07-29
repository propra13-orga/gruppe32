import java.io.*;
import java.net.*;

/**
 * 
 * Klasse die das Netzwerkspiel starten, die Array-kommunikation ausf�hrt und auswertet
 *
 */
public class PvPMain{
	//public static double[] transferArray = new double[7];
	public static boolean aktiv;
	public static boolean isServer;
	public static Server myServer;
	public static Client client;
	public static double damageTransfer;
	public static int connectionCounter;
	public static int checkLoose=0;
	
	/**
	 * 
	 * Konstruktor
	 * @param server boolean ob man server oder client ist
	 * @param newServer Sever-intanz aus lobby
	 * @param newClient Client-instanz aus lobby
	 * @param leben start-leben
	 * @param startSchaden start-schaden
	 * @param startMana start-mana
	 * @param startFarbe start-farbe
	 */
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
	
	/**
	 * initiert aktion in PvPAktion abh�ngig von gedr�ckter taste
	 * @param taste gedr�ckte taste als String
	 */
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
	
	/**
	 * leitet die wichtigen werte �ber netzwerkverbindung weiter
	 */
	public static void transfer(){
		double[] transferArray = new double[9];
		transferArray[0]=PvPSpieler.getX();
		transferArray[1]=PvPSpieler.getY();
		transferArray[2]=PvPSpieler.getSchaden();
		transferArray[3]=PvPSpieler.getRuestung();
		transferArray[4]=PvPSpieler.getFarbe();
		transferArray[5]=PvPSpieler.getSchildInt();
		transferArray[6]=damageTransfer;
		transferArray[7]=PvPSpieler.getHP();
		transferArray[8]=checkLoose;
		if(isServer){
			myServer.transfer(transferArray);
		}
		else{
			client.transfer(transferArray);
		}
		damageTransfer=0;
	}
	
	/**
	 * verwertet die werte in recieveArray
	 * @param recieveArray array mit den wichtigen werten, die �ber netzwerkverbindung weitergegeben werden
	 */
	public static void recieve(double[] recieveArray){
		if(recieveArray[8]==1){
			win();
		}
		else{
			int newX = (int)recieveArray[0];
			int newY = (int)recieveArray[1];
			PvPGegner.moveTo(newX, newY);
			PvPGegner.setSchaden(recieveArray[2]);
			PvPGegner.setRuestung(recieveArray[3]);
			int newFarbe = (int)recieveArray[4];
			PvPGegner.setFarbe(newFarbe);
			PvPGegner.setHP(recieveArray[7]);
			if(recieveArray[5]==1){
				PvPGegner.setSchild(true);
			}
			else{
				PvPGegner.setSchild(false);
			}
			if(recieveArray[6]>0){
				PvPSpieler.schadenBekommen(recieveArray[6]);
			}
		}
	}
	
	/**
	 * l�sst den spieler verlieren
	 */
	public static void loose(){
		checkLoose=1;
		transfer();
		Interface.gameOver();
	}
	
	/**
	 * l�sst den spieler gewinnen
	 */
	public static void win(){
		Interface.sieg();
	}
}
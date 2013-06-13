import java.awt.event.*;
//import java.lang.Object.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.KeyListener.*; 
import javax.swing.*;


/**
 * Main-Klasse wird direkt zu Start des Programms aufgerufen,
 * von hier aus wird das Menue aufgerufen, die Bewegungsabfragen definiert 
 * und Objekte fuer Darstellung, Spielfeld und Aktion werden erstellt
 *
 */
public class Main extends JFrame implements ActionListener, KeyListener {

private Spielfeld mySpielfeld;
private Aktion aktion;
protected static int spielGestartet=0;
public static boolean storytellerBoolean;
public static final int RECHTS = 0;
public static final int UNTEN = 1;
public static final int LINKS = 2;
public static final int OBEN= 3;

public static final int BODEN = 0;
public static final int MAUER = 1;
public static final int START = 2;
public static final int ZIEL = 3;
public static final int FALLE = 4;
public static final int MOB = 5;
public static final int FIGUR = 6;
public static final int SIEG = 7;
public static final int CHECKPOINT = 8;
public static final int STORYTELLER = 9;
public static final int MUENZEN = 15;
public static final int SHOP1 = 18;
public static final int SHOP2 = 19;
public static final int SHOP3 = 20;
public static final int FARBEGELB = 12;
public static final int FARBEBLAU = 10;
public static final int FARBEROT = 11;
public static final int GELB = 0;
public static final int BLAU = 1;
public static final int ROT = 2;
public static final int HPTRANK = 16;
public static final int MANATRANK= 17;
public static final int HPTRANKSHOP = 21;
public static final int MANATRANKSHOP= 22;




/**
 * Menue wird aufgerufen
 * 
 */
public static void main(String[] args) {
		
		Menu menu = new Menu();
	}


/**
 * Objekte fuer Darstellung, Spielfeld und Aktion werden erstellt
 * 
 */
public Main(String title){
	super(title);
	aktion = new Aktion();
	mySpielfeld = new Spielfeld();
}



/**
 * Methode gibt an, was passiert, wenn man die Buttons drueckt
 * 
 */
public void actionPerformed(ActionEvent event) {
	
	//wenn der Button 'starten' gedrueckt wird, soll sich Fenster mit Spielfeld oeffnen
	if (event.getSource().equals(Menu.starten)){
		StdDraw.clear();
		spielGestartet=1;
		aktion.setLevel(0);
		aktion.setRaum(0);
		Figur.resetPlayerStats();
		Menu.levelDarstellen(0,0); // stellt das aktuelle/erste level dar
		Aktion.reachedCheckpoint=false;
			
	}
	
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource().equals(Menu.ende)){
		System.exit(0);
	}

/**
 * Methode kyeTyped: KeyEvent,
 * jedoch nicht genutzt
 * 	
 */
}
public void keyTyped(KeyEvent k){
	
}

/**
 * Methode keyPressed: KeyEvent:
 * Tasten werden mit Bewegungsfunktionen innerhalb des Programms belegt
 * 
 */
public void keyPressed(KeyEvent k){
	if(spielGestartet == 1){
			if (k.getKeyCode() == KeyEvent.VK_RIGHT){
				aktion.figurBewegen(RECHTS); 
			}
			else if (k.getKeyCode() == KeyEvent.VK_DOWN){
				aktion.figurBewegen(UNTEN);
			}
			else if (k.getKeyCode() == KeyEvent.VK_LEFT){
				aktion.figurBewegen(LINKS);
			}
			else if (k.getKeyCode() == KeyEvent.VK_UP){
				aktion.figurBewegen(OBEN);
			}
			else if (k.getKeyCode() == KeyEvent.VK_SPACE){
				Figur.schildZauber();
			}
	}
}

/**
 * Methode keyReleased : KeyEvent, 
 * jedoch nicht genutzt
 * 
 */
public void keyReleased(KeyEvent k){
	
}


}

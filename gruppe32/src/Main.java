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
private static final int RECHTS = 0;
private static final int UNTEN = 1;
private static final int LINKS = 2;
private static final int OBEN= 3;



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
		spielGestartet=1;
		aktion.setLevel(0);
		Figur.resetManaHP();
		Menu.levelDarstellen(0); // stellt das aktuelle/erste level dar
		
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
 * Pfeiltasten werden mit Bewegungsfunktionen innerhalb des Programms belegt
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

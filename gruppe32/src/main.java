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
int aktuellesLevel=0;
int spielGestartet=0;
//private JFrame frame;


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
	mySpielfeld = new Spielfeld();
	aktion = new Aktion();
}



/**
 * Methode gibt an, was passiert, wenn man die Buttons drueckt
 * 
 */
public void actionPerformed(ActionEvent event) {
	
	//wenn der Button 'starten' gedrueckt wird, soll sich Fenster mit Spielfeld oeffnen
	if (event.getSource() == Menu.starten){
		spielGestartet=1;
		Menu.levelDarstellen(0); // stellt das aktuelle/erste level dar
		
	}
	
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource() == Menu.ende){
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
	
			if (k.getKeyCode() == KeyEvent.VK_RIGHT){
				aktion.figurBewegen(0); 
			}
			else if (k.getKeyCode() == KeyEvent.VK_DOWN){
				aktion.figurBewegen(1);
			}
			else if (k.getKeyCode() == KeyEvent.VK_LEFT){
				aktion.figurBewegen(2);
			}
			else if (k.getKeyCode() == KeyEvent.VK_UP){
				aktion.figurBewegen(3);
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

import java.awt.event.*;
//import java.lang.Object.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.KeyListener.*; 
import javax.swing.*;


/**
 * 
 * Main
 *
 */
public class Main extends JFrame implements ActionListener, KeyListener {

private Spielfeld mySpielfeld;
private Aktion aktion;
int aktuellesLevel=0;
int spielGestartet=0;
//private JFrame frame;


/**
 * 
 * Menue wird aufgerufen
 */
public static void main(String[] args) {
		
		Menu menu = new Menu();
	}


/**
 * 
 * Objekte für Darstellung, Spielfeld und Aktion werden erstellt
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

	
}
public void keyTyped(KeyEvent k){
	
}

public void keyPressed(KeyEvent k){
	// KeyEvent-funktion 
	
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

public void keyReleased(KeyEvent k){
	
}





}

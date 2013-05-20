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
private Darstellung darstellung;
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
	darstellung = new Darstellung();
	aktion = new Aktion();
}





/**
 * Test: KeyListener im Menue
 * 
 */
public void keyTyped(KeyEvent k){

}

public void keyPressed(KeyEvent k){
	//test der KeyEvent-funktion im menue
	if (k.getKeyCode() == KeyEvent.VK_RIGHT){
		System.exit(0);
	}
}

public void keyReleased(KeyEvent k){
	
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


/**
 * Methodenkommentar:
 * ... Alternative zum starten 
 * "Spielfeld();" greift dann hier drauf zu und fuehrt aus
 * 
 * NOCH FEHLERHAFT!!!! <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 * (Wegen Vermischung von Swing und StdDraw?)
 * 
 */
//public static void Spielfeld(){
	//JFrame Spielfeld = new JFrame("Game");
	//Spielfeld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//Spielfeld.setSize(880,660);
	//Spielfeld.setVisible(true);
	//Spielfeld.addWindowListener(new Board());
	//Spielfeld.levelsErstellen(); //berechnet die werte fuer alle levels
	//Spielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
//}

}




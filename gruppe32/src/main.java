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


public static void main(String[] args) {
		
		
		Menu menu = new Menu();
	}

/**
 * 
 * @param title
 */
public Main(String title){
	super(title);
	mySpielfeld = new Spielfeld();
	darstellung = new Darstellung();
	aktion = new Aktion();
}





/**
 * Methodenkommentar:
 * Test: KeyListener im Menue
 * 
 */
public void keyTyped(KeyEvent k){

}

public void keyPressed(KeyEvent k){
		if (k.getID() == KeyEvent.VK_A){
			
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
		StdDraw.setCanvasSize(880,660); // oeffnet ein StdDraw fenster
		darstellung.levelDarstellen(0); // stellt das aktuelle/erste level dar
	}
	
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource() == Menu.ende){
		System.exit(0);
	}
	
	//test der KeyEvent-funktion im menue
	if(event.getID() == KeyEvent.VK_DOWN){
		StdDraw.setCanvasSize(880,660); // oeffnet ein StdDraw fenster
		darstellung.levelDarstellen(0); // stellt das aktuelle/erste level dar
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




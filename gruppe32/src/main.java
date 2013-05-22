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
static int spielGestartet=0;
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
 * Test: KeyListener im Menue
 * 
 */





/**
 * Methode gibt an, was passiert, wenn man die Buttons drueckt
 * 
 */
public void actionPerformed(ActionEvent event) {
	
	//wenn der Button 'starten' gedrueckt wird, soll sich Fenster mit Spielfeld oeffnen
	if (event.getSource().equals(Menu.starten)){
		spielGestartet=1;
		Menu.levelDarstellen(0); // stellt das aktuelle/erste level dar
		Aktion.aktuellesLevel = 0;
	}
	
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource().equals(Menu.ende)){
		System.exit(0);
	}

	
}
public void keyTyped(KeyEvent k){

}

public void keyPressed(KeyEvent k){
	//test der KeyEvent-funktion im menue
	if (spielGestartet==1){
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
}

public void keyReleased(KeyEvent k){
	
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

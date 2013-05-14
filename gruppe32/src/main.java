import java.awt.event.*;
//import java.lang.Object.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.KeyListener.*; 
import javax.swing.*;


/**
 * Klassenkommentar:
 * Menueerstellung
 *
 */
public class Main extends JFrame implements ActionListener, KeyListener {

//Buttons sollen nur in dieser Klasse verwendet werden -->private
private JButton starten;
private JButton ende;
private Spielfeld mySpielfeld;


int spielGestartet=0;
//private JFrame frame;


public static void main(String[] args) {
		
		Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame soll geschlossen werden koennen
		frame.setSize(880,660); //Groesse vom frame
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(frame);	
	}


public Main(String title){
	//frame = new JFrame();
	//menu = new JMenuBar();
	
	super(title);
	
	starten = new JButton("Spiel starten"); //neuer Button
	starten.setBounds(200,200,160,40); //legt Groesse und Position fest
	starten.addActionListener(this); //damit was passiert, wenn man Buttons drueckt
	add(starten); //wird der Oberflaeche hinzugefuegt
	
	ende = new JButton("Beenden"); //folgendes analog zu starten-Button (mit geaenderten Koordinaten)
	ende.setBounds(440,200,160,40);
	ende.addActionListener(this);
	ende.addKeyListener(this); //test KeyListener
	add(ende);
	
	mySpielfeld = new Spielfeld();
}





/**
 * Methodenkommentar:
 * Test: KeyListener im Menue
 * 
 */
public void keyTyped(KeyEvent k){

}

public void keyPressed(KeyEvent k){
	if (k.getKeyCode()==KeyEvent.VK_DOWN){
		mySpielfeld.levelsErstellen(); //berechnet die werte fuer alle levels
		StdDraw.setCanvasSize(880,660); // oeffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
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
	if (event.getSource() == starten){
		
		//Spielfeld();
		mySpielfeld.levelsErstellen(); //berechnet die werte fuer alle levels
		StdDraw.setCanvasSize(880,660); // oeffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
	}
	
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource() == ende){
		System.exit(0);
	}
	
	//test der KeyEvent-funktion im menue
	if(event.getID() == KeyEvent.VK_DOWN){
		mySpielfeld.levelsErstellen(); //berechnet die werte fuer alle levels
		StdDraw.setCanvasSize(880,660); // oeffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
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




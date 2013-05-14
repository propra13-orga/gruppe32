import java.awt.event.*;
//import java.lang.Object.*;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.awt.event.KeyListener.*; 
import javax.swing.*;

public class Main extends JFrame implements ActionListener,KeyListener{

//Buttons sollen nur in dieser Klasse verwendet werden -->private
private JButton starten;
private JButton ende;
private Spielfeld mySpielfeld;
int spielGestartet=0;
//private JFrame frame;
public static void main(String[] args) {
		
		Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//frame soll geschlossen werden können
		frame.setSize(800,660); //Groesse vom frame
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(frame);
		
		
	}

public Main(String title){
	//frame = new JFrame();
	//menu= new JMenuBar();
	
	starten = new JButton("Spiel starten"); //neuer Button
	starten.setBounds(200,10,160,40); //legt Groesse und Position fest
	starten.addActionListener(this); //damit was passiert, wenn man Buttons drueckt
	add(starten); //wird der Oberflaeche hinzugefuegt
	
	ende = new JButton("Beenden");
	ende.setBounds(440,10,160,40);
	ende.addActionListener(this);
	ende.addKeyListener(this);
	add(ende);
	
	mySpielfeld = new Spielfeld();
}

/**
 * Methode gibt an, was passiert, wenn man die Buttons drueckt
 * 
 */
public void keyTyped(KeyEvent k){

}
public void keyPressed(KeyEvent k){
	if (k.getKeyCode()==KeyEvent.VK_DOWN){
		mySpielfeld.levelsErstellen(); //berechnet die werte für alle levels
		StdDraw.setCanvasSize(880,660); // öffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
	}
}
public void keyReleased(KeyEvent k){
	
}
public void actionPerformed(ActionEvent event) {
	//wenn der Button 'starten' gedrueckt wird soll sich Fenster mit Spielfeld oeffnen
	if (event.getSource()==starten){
		mySpielfeld.levelsErstellen(); //berechnet die werte für alle levels
		StdDraw.setCanvasSize(880,660); // öffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
	}
	//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
	if(event.getSource()==ende){
		System.exit(0);
	}
	if(event.getID()==KeyEvent.VK_DOWN){
		mySpielfeld.levelsErstellen(); //berechnet die werte für alle levels
		StdDraw.setCanvasSize(880,660); // öffnet ein StdDraw fenster
		mySpielfeld.levelDarstellen(); // stellt das aktuelle/erste level dar
	}
	}

}




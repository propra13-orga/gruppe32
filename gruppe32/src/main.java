import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.*;

public class main extends JFrame implements ActionListener{

//Buttons sollen nur in dieser Klasse verwendet werden -->private
private JButton starten;
private JButton ende;
private Spielfeld mySpielfeld;

public static void main(String[] args) {
		
		main frame = new main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//frame soll geschlossen werden können
		frame.setSize(400,400); //Groesse vom frame
		frame.setLayout(null);
		frame.setVisible(true);
	}

public main(String title){
	
	starten = new JButton("Spiel starten"); //neuer Button
	starten.setBounds(120,40,160,40); //legt Groesse und Position fest
	starten.addActionListener(this); //damit was passiert, wenn man Buttons drueckt
	add(starten); //wird der Oberflaeche hinzugefuegt
	
	ende = new JButton("Beenden");
	ende.setBounds(120,120,160,40);
	ende.addActionListener(this);
	add(ende);
	
	mySpielfeld = new Spielfeld();
}

/**
 * Methode gibt an, was passiert, wenn man die Buttons drueckt
 * 
 */
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
}

}
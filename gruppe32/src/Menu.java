import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * 
 * erstellt das Menu
 *
 */
public class Menu extends JFrame{

	public static JButton starten;
	public static JButton ende;
	
	public Menu(){
		Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame soll geschlossen werden koennen
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(880,660); //Groesse vom frame
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(frame);
		
		// Button "Starten"
		starten = new JButton("Spiel starten"); //neuer Button
		starten.setBounds(200,10,160,40); //legt Groesse und Position fest
		starten.addActionListener(frame); //damit was passiert, wenn man Buttons drueckt
		frame.add(starten); //wird der Oberflaeche hinzugefuegt
		
		// Button "Beenden"
		ende = new JButton("Beenden"); //folgendes analog zu starten-Button (mit geaenderten Koordinaten)
		ende.setBounds(440,10,160,40);
		ende.addActionListener(frame);
		frame.add(ende);
	}
	
	public void menuOeffnen(){
		
	}

}

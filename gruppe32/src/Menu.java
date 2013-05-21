import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * 
 * erstellt das Menu
 *
 */
public class Menu{

	public static JButton starten;
	public static JButton ende;
	public static StdDraw std;
	public static Main main;
	public static int reihe;
	public static int spalte;
	public Menu(){
		
		std.setCanvasSize(880, 660);
		
		/**Main frame = new Main("Menü");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame soll geschlossen werden koennen
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(880,660); //Groesse vom frame
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(frame);
		
		*/ //Button "Starten"
		starten = new JButton("Spiel starten"); //neuer Button
		starten.setBounds(200,10,160,40); //legt Groesse und Position fest
		starten.addActionListener(std.frame); //damit was passiert, wenn man Buttons drueckt
		starten.setFocusable(false);
		std.frame.add(starten); //wird der Oberflaeche hinzugefuegt
		
		// Button "Beenden"
		ende = new JButton("Beenden"); //folgendes analog zu starten-Button (mit geaenderten Koordinaten)
		ende.setBounds(440,10,160,40);
		ende.addActionListener(std.frame);
		std.frame.add(ende);
		
		std.frame.addKeyListener(std.frame);
	
	
	}
	
	public void menuOeffnen(){
		
	}

	public static void levelDarstellen(int level) {
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.setXscale(0.0,800);
		StdDraw.setYscale(0,600);
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==0){
					StdDraw.picture(20+40*spalte,20+40*reihe, "boden.jpg"); 
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==1){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mauer.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==2){
					StdDraw.picture(20+40*spalte,20+40*reihe, "start.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==3){
					StdDraw.picture(20+40*spalte,20+40*reihe, "ziel.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==4){
					StdDraw.picture(20+40*spalte,20+40*reihe, "falle.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==5){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mob.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==6){
					StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
	
	/**
	 * Methodenkommentar:
	 * Stellt die figur an den neuen koordinaten dar, und ueberschreibt sie am ausgangspunkt
	 * 
	 */
	public static void figurBewegen(int level, int vonX, int vonY, int nachX, int nachY ){
		
		
		StdDraw.picture(20+40*vonX,20+40*vonY, "boden.jpg");
		
		
		StdDraw.picture(20+40*nachX,20+40*nachY+1, "spielfigur.jpg");
		
	}
	public static void figurReset(int level,int x, int y){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==6){
					StdDraw.picture(20+40*x,20+40*y,"boden.jpg");
					StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
					Aktion.setFigurXY(spalte, reihe);
			}
		}
		}
	}
	
}

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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

	
	private static final int BODEN = 0;
	private static final int MAUER = 1;
	private static final int START = 2;
	private static final int ZIEL = 3;
	private static final int FALLE = 4;
	private static final int MOB = 5;
	private static final int FIGUR = 6;
	private static final int SIEG = 7;
	private static final int CHECKPOINT = 8;
	
	private static final int BREITE = 880;
	private static final int HOEHE = 660;
	/**
	 * Methode oeffnet das Menue
	 * 
	 */
	public Menu(){
		
		std.setCanvasSize(BREITE, HOEHE);
			
		//Button "Starten"
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
	
	
	
	/**
	 * Methode menuOeffnen() noch nicht genutzt
	 * 
	 */
	public void menuOeffnen(){
		
	}
	
	
/**
 * Darstellung des Spielfelds (Grafische Ausgabe)
 * 
 */
	public static void levelDarstellen(int level) {
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.setXscale(0.0,800);
		StdDraw.setYscale(0,600);
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==BODEN){
					StdDraw.picture(20+40*spalte,20+40*reihe, "boden.jpg"); 
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==MAUER){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mauer.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)== START){
					StdDraw.picture(20+40*spalte,20+40*reihe, "start.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==ZIEL){
					StdDraw.picture(20+40*spalte,20+40*reihe, "ziel.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==FALLE){
					StdDraw.picture(20+40*spalte,20+40*reihe, "falle.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==MOB){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mob.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==FIGUR){
					StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
					Aktion.setFigurXY(spalte, reihe);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==SIEG){

					StdDraw.picture(20+40*spalte,20+40*reihe, "sieg.jpg");
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==CHECKPOINT){
					StdDraw.picture(20+40*spalte,20+40*reihe, "checkpoint.jpg");
				}

			}
		}
	}
	
	
	
	/**
	 * Methodenkommentar:
	 * Stellt die Figur an den neuen Koordinaten dar, und ueberschreibt sie am ausgangspunkt
	 * 
	 */
	public static void figurBewegen(int level, int vonX, int vonY, int nachX, int nachY ){
		
		StdDraw.picture(20+40*vonX,20+40*vonY, "boden.jpg");
		StdDraw.picture(20+40*nachX,20+40*nachY+1, "spielfigur.jpg");	
	}
	
	
	
	/**
	 * Methoden setzt Figur zu Ausgangskoordinaten zurueck
	 *
	 */
	public static void figurReset(int level,int x, int y){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==FIGUR){
					StdDraw.picture(20+40*x,20+40*y,"boden.jpg");
					StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
		/**
		 * 
		 * Methodenkommentar:
		 * Setzt die Spielfigur zum Ziel des gegebenen levels
		 * 
		 */
	
		public static void figurZumZiel(int level){
			if (level == 0){
				figurBewegen(level,1,5,17,1);
				Aktion.setFigurXY(17, 1);
			}
			else if (level==1){
				figurBewegen(level,17,13,10,1);
				Aktion.setFigurXY(10, 1);
			}
			else if (level==2){
				figurBewegen(level,10,13,1,3);
				Aktion.setFigurXY(1, 3);
			}
			else if (level==3){
				//figurBewegen(level,0,0,-1,-1);
			}
		}
		public static void gameOver(){
			StdDraw.picture(400,300, "gameover.jpg");
			Main.spielGestartet=0;
			/*JFrame fenster = new JFrame("Game Over");
		    
			   fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fenster schließen 
			   JLabel label = new JLabel("Game Over!", JLabel.CENTER);
			   fenster.getContentPane().add(label);// dem fenster das label hinzufügen
			   fenster.setSize(300, 200);
			   fenster.setVisible(true);// fenster anzeigen
			   gameOver=false;
			*/
		}
		
		public static void sieg(){
			StdDraw.picture(400,300, "gewonnen.jpg");
			Main.spielGestartet=0;
			/*JFrame fenster = new JFrame("Spiel gewonnen!");
			fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fenster schließen 
			JLabel label = new JLabel("Herzlichen Glückwunsch! Du hast gewonnen!", JLabel.CENTER);
			fenster.getContentPane().add(label);// dem fenster das label hinzufügen
			fenster.setSize(300, 200);
			fenster.setVisible(true);// fenster anzeigen
			*/
		}
	
	
}

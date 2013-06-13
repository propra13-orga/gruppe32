import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	private static int hpCheck;
	private static int manaCheck;
	

	private static final String MAUERIMG = "Images\\mauer.jpg";
	private static final String BODENIMG = "Images\\boden.jpg";
	private static final String CHECKPOINTIMG = "Images\\checkpoint.jpg";
	private static final String EMPTYHEARTIMG = "Images\\emptyHeart.jpg";
	private static final String EMPTYMANAIMG = "Images\\emptyMana.jpg";
	private static final String FALLEIMG = "Images\\falle.jpg";
	private static final String FULLHEARTIMG = "Images\\fullHeart.jpg";
	private static final String FULLMANAIMG = "Images\\fullMana.jpg";
	private static final String GAMEOVERIMG = "Images\\gameover.jpg";
	private static final String GEWONNENIMG = "Images\\gewonnen.jpg";
	private static final String HALFHEARTIMG = "Images\\halfHeart.jpg";
	private static final String HALFMANAIMG = "Images\\halfMana.jpg";
	private static final String MOBIMG = "Images\\mob.jpg";
	private static final String SIEGIMG = "Images\\sieg.jpg";
	private static final String SPIELFIGURIMG = "Images\\spielfigur.jpg";
	private static final String STARTIMG = "Images\\start.jpg";
	private static final String ZIELIMG = "Images\\ziel.jpg";
	private static final String FIGURGELB = "Images\\figurGelb.jpg";
	private static final String FIGURROT = "Images\\figurRot.jpg";
	private static final String FIGURBLAU = "Images\\figurBlau.jpg";
	private static final String FIGURGELBSCHILD = "Images\\figurGelbSchild.jpg";
	private static final String FIGURROTSCHILD = "Images\\figurRotSchild.jpg";
	private static final String FIGURBLAUSCHILD = "Images\\figurBlauSchild.jpg";
	private static final String FARBEGELBIMG = "Images\\farbeGelb.jpg";
	private static final String FARBEROTIMG = "Images\\farbeRot.jpg";
	private static final String FARBEBLAUIMG = "Images\\farbeBlau.jpg";
	private static final String STORYTELLERIMG = "Images\\storyteller.jpg";
	private static final String MUENZENIMG = "Images\\muenze.jpg";
	private static final String HPTRANKIMG = "Images\\hpTrank.jpg";
	private static final String MANATRANKIMG = "Images\\manaTrank.jpg";
	
	private static final int BREITE = 990;
	private static final int HOEHE = 660;
	
	
	/**
	 * Methode oeffnet das Menue
	 * 
	 */
	public Menu(){
		
		std.setCanvasSize(BREITE, HOEHE);
			
		//Button "Starten"
		starten = new JButton("Spiel starten"); //neuer Button
		starten.setBounds(260,0,160,40); //legt Groesse und Position fest
		starten.addActionListener(std.frame); //damit was passiert, wenn man Buttons drueckt
		starten.setFocusable(false);
		std.frame.add(starten); //wird der Oberflaeche hinzugefuegt
		
		// Button "Beenden"
		ende = new JButton("Beenden"); //folgendes analog zu starten-Button (mit geaenderten Koordinaten)
		ende.setBounds(450,0,160,40);
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
	public static void levelDarstellen(int level,int raum) {
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.setXscale(0.0,900);
		StdDraw.setYscale(0,600);
		StdDraw.show(0);
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<13;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.BODEN
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==13) //13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==14)){ //13: X steht in level.txt fuer die Stelle neben dem Ziel
																					//14: Y steht in level.txt fuer die Stelle neben dem Checkpoint
					StdDraw.picture(20+40*spalte,20+40*reihe, BODENIMG); 
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.MAUER){
					StdDraw.picture(20+40*spalte,20+40*reihe, MAUERIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)== Main.START){
					StdDraw.picture(20+40*spalte,20+40*reihe, STARTIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.ZIEL){
					StdDraw.picture(20+40*spalte,20+40*reihe, ZIELIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FALLE){
					StdDraw.picture(20+40*spalte,20+40*reihe, FALLEIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.MOB){
					StdDraw.picture(20+40*spalte,20+40*reihe, MOBIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FIGUR){
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.SIEG){

					StdDraw.picture(20+40*spalte,20+40*reihe, SIEGIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.CHECKPOINT){
					StdDraw.picture(20+40*spalte,20+40*reihe, CHECKPOINTIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FARBEBLAU){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEBLAUIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FARBEGELB){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEGELBIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FARBEROT){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEROTIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.STORYTELLER){
					StdDraw.picture(20+40*spalte,20+40*reihe, STORYTELLERIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.MUENZEN){
					StdDraw.picture(20+40*spalte,20+40*reihe, MUENZENIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.HPTRANK){
					StdDraw.picture(20+40*spalte,20+40*reihe, HPTRANKIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.MANATRANK){
					StdDraw.picture(20+40*spalte,20+40*reihe, MANATRANKIMG);
				}

			}
		}
				

	
		displayPlayerHP(Figur.getHP());
		displayPlayerMana(Figur.getMana());
		displayPlayerStats();
		StdDraw.show();
	}
	
	
	
	/**
	 * Methodenkommentar:
	 * Stellt die Figur an den neuen Koordinaten dar, und ueberschreibt sie am ausgangspunkt
	 * 
	 */
	public static void figurBewegen(int level, int vonX, int vonY, int nachX, int nachY ){
		
		StdDraw.picture(20+40*vonX,20+40*vonY, BODENIMG);
		//StdDraw.picture(20+40*nachX,20+40*nachY, SPIELFIGURIMG);
		displayPlayer(Figur.getFarbe(),nachX,nachY);
	}
	
	
	
	/**
	 * Methoden setzt Figur zu Ausgangskoordinaten zurueck
	 *
	 */
	public static void figurReset(int level,int raum, int x, int y){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==Main.FIGUR){
					StdDraw.picture(20+40*x,20+40*y,BODENIMG);
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
		/**
		 * 
		 * Methodenkommentar:
		 * Setzt die Spielfigur zum Ziel des vorherigen Levels, wenn man einen Raum zurueck geht
		 * 
		 */
	public static void figurZumZiel(int level, int raum){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==13){
					StdDraw.picture(20+40*Aktion.getFigurX(),20+40*Aktion.getFigurY(),BODENIMG);
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
	/**
	 * Setzt Figur zurueck zum Checkpoint
	 * @param level
	 * @param raum
	 */
	public static void figurZumCheckpoint(int level, int raum){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==14){
					StdDraw.picture(20+40*Aktion.getFigurX(),20+40*Aktion.getFigurY(),BODENIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
	
	
		/**
		 * 
		 * blendet 'Game Over' ein und setzt spielGestartet zurueck auf 0
		 * 
		 */
		public static void gameOver(){
			StdDraw.picture(400,300, GAMEOVERIMG);
			Main.spielGestartet=0;			
		}
		
		
		
		/**
		 * 
		 * blendet 'Gewonnen' ein und setzt spielGestartet zurueck auf 0
		 * 
		 */
		public static void sieg(){
			StdDraw.picture(400,300, GEWONNENIMG);
			Main.spielGestartet=0;			
		}
		
		
		
		/**
		 * 
		 * zeigt aktuelle HP oben links ueber dem Spielfeld an
		 * @param hp
		 * 
		 */
		public static void displayPlayerHP(double hp){	
			for (hpCheck=1; hpCheck<=Figur.MAXHP; hpCheck++){
				if ((hpCheck>hp)&(hp>hpCheck-1)){
					StdDraw.picture(-10+20*hpCheck,610,HALFHEARTIMG);
				}
				else if(hpCheck<=hp){
					StdDraw.picture(-10+20*hpCheck,610,FULLHEARTIMG);
				}
				else{
					StdDraw.picture(-10+20*hpCheck,610,EMPTYHEARTIMG);
				}
				
			}
		}
		
		
		
		/**
		 * 
		 * zeigt aktuelle Mana oben rechts ueber dem Spielfeld an
		 * @param mana
		 * 
		 */
		public static void displayPlayerMana(double mana){	
			for (manaCheck=1; manaCheck<=Figur.MAXMANA; manaCheck++){
				if ((manaCheck>mana)&(mana>manaCheck-1)){
					StdDraw.picture(810-20*manaCheck,610,HALFMANAIMG);
				}
				else if(manaCheck<=mana){
					StdDraw.picture(810-20*manaCheck,610,FULLMANAIMG);
				}
				else{
					StdDraw.picture(810-20*manaCheck,610,EMPTYMANAIMG);
				}
				
			}
		}
		
		
		
		
		/**
		 * 
		 * veraendert die Farbe der Spielfigur
		 * @param farbe
		 * @param x
		 * @param y
		 * 
		 */
		public static void displayPlayer(int farbe, int x, int y){
			if (farbe == Main.GELB){
				if (Figur.schildBool()==false){
					StdDraw.picture(20+40*x,20+40*y, FIGURGELB);
				}
				else{
					StdDraw.picture(20+40*x,20+40*y, FIGURGELBSCHILD);
				}
			}
			else if (farbe == Main.BLAU){
				if (Figur.schildBool()==false){
					StdDraw.picture(20+40*x,20+40*y, FIGURBLAU);
				}
				else{
					StdDraw.picture(20+40*x,20+40*y, FIGURBLAUSCHILD);
				}
			}
			else if (farbe== Main.ROT){
				if (Figur.schildBool()==false){
					StdDraw.picture(20+40*x,20+40*y, FIGURROT);
				}
				else{
					StdDraw.picture(20+40*x,20+40*y, FIGURROTSCHILD);
				}
			}
			
		}
		
		/**
		 * zeigt rechts neben dem Spielfeld folgende Werte an:
		 * - Leben der Spielfigur
		 * - Schadensfaktor, die eine Figur bekommt, wenn sie auf Gegner trifft
		 * - Ruestungsfaktor, die Figur an entsprechender Stelle bekommt
		 * - Manafaktor, die Figur an entsprechender Stelle bekommt
		 * - das aktuelle Level und den aktuellen Raum
		 * - aktuelles HP
		 * - aktuelles Mana
		 * - akutelle Muenzen
		 */
		public static void displayPlayerStats(){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(920, 300, 100, 500);
			StdDraw.setPenColor();
			StdDraw.textLeft(820, 550, "Leben:"+Figur.getLeben());
			StdDraw.textLeft(820, 530, "Schaden:"+Figur.getSchaden());
			StdDraw.textLeft(820, 510, "Ruestung:"+Figur.getRuestung());
			StdDraw.textLeft(820, 490, "Manafaktor:"+Figur.getManaFaktor());
			StdDraw.textLeft(820, 470,"Raum: "+(Aktion.getLevel()+1)+"-"+(Aktion.getRaum()+1));
			StdDraw.textLeft(820, 450, "HP:"+Figur.getHP());
			StdDraw.textLeft(820, 430, "Mana:"+Figur.getMana());
			StdDraw.textLeft(820, 410, "Muenzen:"+Figur.getMuenzen());
			if (Aktion.reachedCheckpoint==true){
				StdDraw.textLeft(820, 390, "Checkpoint:"+(Aktion.checkpointMerkeLevel+1)+"-"+(Aktion.checkpointMerkeRaum+1));
			    StdDraw.picture(870,360,CHECKPOINTIMG);
			    }
			
		}
		
		
		
		/**
		 * Storyteller erzaehlt seine Geschichte
		 * 
		 */
		public static void storyteller(){
			
			if ((Aktion.getLevel()==0)&(Aktion.getRaum()==0)){ //Storyteller am Anfang (Level 1, Raum 1)
				StdDraw.text(400, 560, "Früher war dies ein friedliches Plätzchen, aber dann kamen die Trolle und legten Fallen aus... ");
				StdDraw.text(400, 540, "Und das nur, um ihr Essen besser würzen zu können!");
					//if (k.getKeyCode() == KeyEvent.VK_RIGHT | k.getKeyCode() == KeyEvent.VK_DOWN | k.getKeyCode() == KeyEvent.VK_LEFT | k.getKeyCode() == KeyEvent.VK_UP){
					//	Main.storytellerBoolean(False); 
					//}
			}
			else if ((Aktion.getLevel()==0)&(Aktion.getRaum()==1)){ //Storyteller vor dem Checkpoint (Level 1, Raum 2)
				StdDraw.text(400, 570, "Da bist du ja schon! Pass auf, dort unten steht die beste Erfindung, seit die fiesen Trolle es hier runter geschafft haben.");
				StdDraw.text(400, 550, "Diese rote Flagge da ist ein CHECKPOINT! Wenn du sie berührst und im weiteren Verlauf deines Abenteuers stirbst,");
				StdDraw.text(400, 530, "wirst du hier wiederbelebt werden. Und, habe ich zu viel versprochen? Die Idee ist ja wohl genial!");
			}
			else if ((Aktion.getLevel()==2)&(Aktion.getRaum()==2)){ //Storyteller im Endraum (Level 3, Raum 3)
				StdDraw.text(400, 560, "Fast hast du es geschafft!!! Berühre diese Flagge dort und du kannst beruhigt nach Hause zurückkehren");
				StdDraw.text(400, 540, "und dich als Sieger feiern lassen. Aber lass dich nicht auf den letzten Metern von den Trollen erwischen!");
			}		
		}
	
}

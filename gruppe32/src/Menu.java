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
	private static int hpCheck;
	private static int manaCheck;

	private static final String MAUERIMG = "Images/mauer.jpg";
	private static final String BODENIMG = "Images/boden.jpg";
	private static final String CHECKPOINTIMG = "Images/checkpoint.jpg";
	private static final String EMPTYHEARTIMG = "Images/emptyHeart.jpg";
	private static final String EMPTYMANAIMG = "Images/emptyMana.jpg";
	private static final String FALLEIMG = "Images/falle.jpg";
	private static final String FULLHEARTIMG = "Images/fullHeart.jpg";
	private static final String FULLMANAIMG = "Images/fullMana.jpg";
	private static final String GAMEOVERIMG = "Images/gameover.jpg";
	private static final String GEWONNENIMG = "Images/gewonnen.jpg";
	private static final String HALFHEARTIMG = "Images/halfHeart.jpg";
	private static final String HALFMANAIMG = "Images/halfMana.jpg";
	private static final String MOBIMG = "Images/mob.jpg";
	private static final String SIEGIMG = "Images/sieg.jpg";
	private static final String SPIELFIGURIMG = "Images/spielfigur.jpg";
	private static final String STARTIMG = "Images/start.jpg";
	private static final String ZIELIMG = "Images/ziel.jpg";
	private static final String FIGURGELB = "Images/figurGelb.jpg";
	private static final String FIGURROT = "Images/figurRot.jpg";
	private static final String FIGURBLAU = "Images/figurBlau.jpg";
	private static final String FARBEGELBIMG = "Images/farbeGelb.jpg";
	private static final String FARBEROTIMG = "Images/farbeRot.jpg";
	private static final String FARBEBLAUIMG = "Images/farbeBlau.jpg";
	private static final String STORYTELLERIMG = "Images/storyteller.jpg";
	
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
	public static void levelDarstellen(int level) {
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.setXscale(0.0,900);
		StdDraw.setYscale(0,600);
		StdDraw.show(0);
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.BODEN
						|(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==13)){
					StdDraw.picture(20+40*spalte,20+40*reihe, BODENIMG); 
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.MAUER){
					StdDraw.picture(20+40*spalte,20+40*reihe, MAUERIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)== Main.START){
					StdDraw.picture(20+40*spalte,20+40*reihe, STARTIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.ZIEL){
					StdDraw.picture(20+40*spalte,20+40*reihe, ZIELIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FALLE){
					StdDraw.picture(20+40*spalte,20+40*reihe, FALLEIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.MOB){
					StdDraw.picture(20+40*spalte,20+40*reihe, MOBIMG);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FIGUR){
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.SIEG){

					StdDraw.picture(20+40*spalte,20+40*reihe, SIEGIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.CHECKPOINT){
					StdDraw.picture(20+40*spalte,20+40*reihe, CHECKPOINTIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FARBEBLAU){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEBLAUIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FARBEGELB){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEGELBIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FARBEROT){
					StdDraw.picture(20+40*spalte,20+40*reihe, FARBEROTIMG);
				}
				else if(Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.STORYTELLER){
					StdDraw.picture(20+40*spalte,20+40*reihe, "storyteller.jpg");
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
	public static void figurReset(int level,int x, int y){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==Main.FIGUR){
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
		 * Setzt die Spielfigur zum Ziel des gegebenen levels
		 * 
		 */
	
	public static void figurZumZiel(int level){
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==13){
					StdDraw.picture(20+40*Aktion.getFigurX(),20+40*Aktion.getFigurY(),BODENIMG);
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					displayPlayer(Figur.getFarbe(),spalte,reihe);
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
		
		
		public static void gameOver(){
			StdDraw.picture(400,300, GAMEOVERIMG);
			Main.spielGestartet=0;			
		}
		
		public static void sieg(){
			StdDraw.picture(400,300, GEWONNENIMG);
			Main.spielGestartet=0;			
		}
		
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
		
		public static void displayPlayer(int farbe, int x, int y){
			if (farbe == Main.GELB){
				StdDraw.picture(20+40*x,20+40*y, FIGURGELB);
			}
			else if (farbe == Main.BLAU){
				StdDraw.picture(20+40*x,20+40*y, FIGURBLAU);
			}
			else if (farbe== Main.ROT){
				StdDraw.picture(20+40*x,20+40*y, FIGURROT);
			}
		}
		
		public static void displayPlayerStats(){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(920, 300, 100, 500);
			StdDraw.setPenColor();
			StdDraw.textLeft(820, 550, "Leben:"+Figur.getLeben());
			StdDraw.textLeft(820, 500, "Schaden:"+Figur.getSchaden());
			StdDraw.textLeft(820, 450, "Ruestung:"+Figur.getRuestung());
			StdDraw.textLeft(820, 400, "Manafaktor:"+Figur.getManaFaktor());
		}
	
}

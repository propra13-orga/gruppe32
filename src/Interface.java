
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 * 
 * erstellt das Menu (2 Buttons: 'Spiel starten' und 'Beenden')
 * faengt Key-Aktionen ab
 * stellt Level grafisch dar
 *
 */
public class Interface extends JFrame implements ActionListener, KeyListener{

	/**
	 * Richtungen
	 */
	public static final int RECHTS = 0;
	public static final int UNTEN = 1;
	public static final int LINKS = 2;
	public static final int OBEN= 3;


	/**
	 * Bilder 
	 */
	public static final String MAUERIMG = "Images\\mauer.jpg";
	public static final String VERSTECKTERGANGIMG = "Images\\mauer.jpg";
	public static final String BODENIMG = "Images\\boden.jpg";
	public static final String CHECKPOINTIMG = "Images\\checkpoint.jpg";
	public static final String EMPTYHEARTIMG = "Images\\emptyHeart.jpg";
	public static final String EMPTYMANAIMG = "Images\\emptyMana.jpg";
	public static final String FALLEIMG = "Images\\falle.jpg";
	public static final String FULLHEARTIMG = "Images\\fullHeart.jpg";
	public static final String FULLMANAIMG = "Images\\fullMana.jpg";
	public static final String GAMEOVERIMG = "Images\\gameover.jpg";
	public static final String GEWONNENIMG = "Images\\gewonnen.jpg";
	public static final String HALFHEARTIMG = "Images\\halfHeart.jpg";
	public static final String HALFMANAIMG = "Images\\halfMana.jpg";
	public static final String MOBIMG = "Images\\mob.jpg";
	public static final String SIEGIMG = "Images\\sieg.jpg";
	public static final String SPIELFIGURIMG = "Images\\spielfigur.jpg";
	public static final String STARTIMG = "Images\\start.jpg";
	public static final String ZIELIMG = "Images\\ziel.jpg";
	public static final String FIGURGELB = "Images\\figurGelb.jpg";
	public static final String FIGURROT = "Images\\figurRot.jpg";
	public static final String FIGURBLAU = "Images\\figurBlau.jpg";
	public static final String FIGURGELBSCHILD = "Images\\figurGelbSchild.jpg";
	public static final String FIGURROTSCHILD = "Images\\figurRotSchild.jpg";
	public static final String FIGURBLAUSCHILD = "Images\\figurBlauSchild.jpg";
	public static final String FARBEGELBIMG = "Images\\farbeGelb.jpg";
	public static final String FARBEROTIMG = "Images\\farbeRot.jpg";
	public static final String FARBEBLAUIMG = "Images\\farbeBlau.jpg";
	public static final String STORYTELLERIMG = "Images\\storyteller.jpg";
	public static final String MUENZENIMG = "Images\\muenze.jpg";
	public static final String SHOP1IMG = "Images\\shop1.jpg";
	public static final String SHOP2IMG = "Images\\shop2.jpg";
	public static final String SHOP3IMG = "Images\\shop3.jpg";
	public static final String HPTRANKIMG = "Images\\hpTrank.jpg";
	public static final String MANATRANKIMG = "Images\\manaTrank.jpg";
	public static final String BOSS1IMG = "Images\\boss1.jpg";
	public static final String BOSS2IMG = "Images\\boss2.jpg";
	public static final String BOSS3IMG = "Images\\boss3.jpg";
	public static final String SCHLUESSELIMG = "Images\\schluessel.jpg";
	public static final String TORIMG = "Images\\tor.jpg";
	public static final String PORTALIMG = "Images\\portal.jpg";
	public static final String STANDHEREIMG = "Images\\standhere.jpg";
	public static final String FELDVORSTANDHEREEINSIMG = "Images\\boden.jpg";
	public static final String FELDVORSTANDHEREZWEIIMG = "Images\\boden.jpg";
	public static final String DOPPELPORTALLINKSIMG = "Images\\portal.jpg";
	public static final String DOPPELPORTALRECHTSIMG = "Images\\portal.jpg";
	
	
	/**
	 * Spielfeldelemente
	 */
	public static final int BODEN = 0;
	public static final int VERSTECKTERGANG = 26;
	public static final int MAUER = 1;
	public static final int START = 2;
	public static final int ZIEL = 3;
	public static final int FALLE = 4;
	public static final int MOB = 5;
	public static final int FIGUR = 6;
	public static final int SIEG = 7;
	public static final int CHECKPOINT = 8;
	public static final int STORYTELLER = 9;
	public static final int MUENZEN = 15;
	public static final int SHOP1 = 18;
	public static final int SHOP2 = 19;
	public static final int SHOP3 = 20;
	public static final int FARBEGELB = 12;
	public static final int FARBEBLAU = 10;
	public static final int FARBEROT = 11;
	public static final int GELB = 0;
	public static final int BLAU = 1;
	public static final int ROT = 2;
	public static final int HPTRANK = 16;
	public static final int MANATRANK= 17;
	public static final int HPTRANKSHOP = 21;
	public static final int MANATRANKSHOP= 22;
	public static final int BOSS1= 23;
	public static final int BOSS2= 24;
	public static final int BOSS3= 25;
	public static final int SCHLUESSEL= 27;
	public static final int TOR= 28;
	
	public static final int PORTAL= 29;
	public static final int STANDHERE= 30;
	public static final int FELDVORSTANDHEREEINS= 31;
	public static final int FELDVORSTANDHEREZWEI= 32;
	
	public static final int DOPPELPORTALLINKS= 33;
	public static final int DOPPELPORTALRECHTS= 34;
		
	/**
	 * Spielfeldgroesse
	 */
	private static final int BREITE = 990;
	private static final int HOEHE = 660;
	
	
	/**
	 * Magic Numbers
	 */
	public static final double ZUFALL1 = 0.33;
	public static final double ZUFALL2 = 0.66;
	public static final double ZUFALL3 = 0.90;
	
	public static final double ZUFALL4 = 0.25;
	public static final double ZUFALL5 = 0.5;
	public static final double ZUFALL6 = 0.75;
	public static final double ZUFALL7 = 0.85;
	public static final double EINEINHALB = 1.5;
	
	public static final int ARRAYDREI = 3;
	public static final int ARRAYVIER = 4;
	
	public static final int CHARZIEL = 3;
	public static final int CHARFALLE = 4;
	public static final int CHARMOB = 5;
	public static final int CHARFIGUR = 6;
	public static final int CHARSIEG = 7;
	public static final int CHARCHECKPOINT = 8;
	public static final int CHARSTORYTELLER = 9;
	public static final int CHARMUENZE =36;
	public static final int CHARSHOP1 = 83;
	public static final int CHARSHOP2 = 79;
	public static final int CHARSHOP3 = 80;
	public static final int CHARHPTRANKSHOP = 72;
	
	
	public static final int ZEHN = 10;
	public static final int ZWOELF = 12;
	public static final int BEIZIEL = 13;
	public static final int BEICHECKPOINT = 14;
	public static final int FUENFZEHN = 15;
	
	public static final int PIC1 = 20;
	public static final int PIC2 = 40;
	
	public static final int FUENFUNDZWANZIG = 25;
	public static final int DREISSIG = 30;
	public static final int ZWEIUNDDREISSIG = 32;
	public static final int FUENFUNDDREISSIG = 35;
	
	
	public static final int VIERZIG = 40;
	public static final int EINUNDVIERZIG = 41;
	public static final int ZWEIUNDVIERZIG = 42;
	public static final int DREIUNDVIERZIG = 43;
	public static final int ACHTUNDVIERZIG = 48;
	public static final int SECHZIG = 60;
	public static final int EINUNDSECHZIG = 61;
	public static final int ZWEIUNDSECHZIG = 62;
	public static final int SECHSUNDSECHZIG = 66;
	public static final int EINUNDSIEBZIG = 71;
	public static final int ACHZIG = 80;
	
	public static final int SIEBENUNDSIEBZIG = 77;
	
	
	public static final int ZWEIUNDACHZIG = 82;
	
	public static final int VIERUNDACHZIG = 84;
	public static final int SECHSUNDACHZIG = 86;
	public static final int ACHTUNDACHZIG = 88;
	public static final int NEUNUNDACHZIG = 89;
	public static final int NEUNZIG = 90;
	public static final int EINUNDNEUNZIG = 91;
	public static final int DREIUNDNEUNZIG = 93;
	public static final int EINHUNDERT = 100;
	public static final int EINHUNDERTZEHN = 110;
	public static final int EINHUNDERTZWOELF = 112;
	public static final int EINHUNDERTDREISSIG = 130;
	public static final int EINHUNDERTFUENFZIG = 150;
	public static final int EINHUNDERTSECHZIG = 160;
	public static final int EINHUNDERTSIEBZIG = 170;
	public static final int EINHUNDERTFUENFUNDZWANZIG = 125;
	public static final int ZWEIHUNDERT = 200;
	public static final int ZWEIHUNDERTZWANZIG = 220;
	public static final int ZWEIHUNDERTFUENFZIG = 250;
	public static final int ZWEIHUNDERTSECHZIG = 260;	
	public static final int DREIHUNDERT = 300;
	public static final int DREIHUNDERTDREISSIG = 330;
	public static final int DREIHUNDERTFUENFZIG = 350;
	public static final int DREIHUNDERTSIEBZIG = 370;
	public static final int DREIHUNDERTNEUNZIG = 390;
	
	public static final int HOEHETEXT = 400;
	public static final int BREITETEXT1 = 530;
	public static final int BREITETEXT2 = 540;
	public static final int BREITETEXT3 = 550;
	public static final int BREITETEXT4 = 560;
	public static final int BREITETEXT5 = 570;
	public static final int BREITETEXT6 = 450;
	public static final int BREITETEXT7 = 480;
	public static final int BREITETEXT8 = 500;
	
	public static final int BREITEBILDGROSS = 400;
	public static final int HOEHEBILDGROSS = 300;
	
		
	public static final int VIERHUNDERTZEHN = 410;
	public static final int VIERHUNDERTDREISSIG = 430;
	public static final int VIERHUNDERTSIEBZIG = 470;
	public static final int VIERHUNDERTNEUNZIG = 490;
	public static final int FUENFHUNDERTZEHN = 510;
	
	
	
	public static final int SECHSHUNDERT = 600;
	public static final int SECHSHUNDERTZEHN = 610;
	public static final int ACHTHUNDERTZEHN = 810;
	public static final int ACHTHUNDERTZWANZIG = 820;
	public static final int NEUNHUNDERT = 900;
	public static final int NEUNHUNDERTZWANZIG = 920;
	public static final int VIEL = 1000000000;
	
	public static final int SPALTEN = 20;
	public static final int REIHEN = 13;
	
	/**
	 * Spieler- und Gegneranzahl
	 */
	private int playerZahl;
	private static int gegnerZahl=0;
	
	/**
	 * Objekte vom Typ Spieler, Gegner und Boss
	 */
	public static Spieler[] player = new Spieler[2];
	private Gegner[] gegner = new Gegner[SPALTEN];
	private Boss3 boss3;
	
	
	
	/**
	 * Level und Raum
	 */
	public static int level;
	public static int raum;
	
	
	private int checkStartZiel;
	
	
	private int[] gegnerAttack = new int[ARRAYDREI];
	private int[] playerAttack = new int[ARRAYDREI];
	
	private static int aktiveCheckpoint=0;
	private static int[] checkpointArray = new int[ARRAYVIER];
	
	public static boolean toCheckpoint;
	
	
	/**
	 * hier werden die Buttons deklariert
	 */
	public static JButton starten;
	public static JButton ende;
	
	/**
	 * Reihe und Spalte für das Spielfeld
	 */
	public static int reihe;
	public static int spalte;

	private int counter;
	private int counter2;
	private int counter3;
	private int returner;
	private static boolean spielGestartet;
	
	
    /**
     * Methode oeffnet das Menue
     * @param args String
     */
		public static void main(String[] args){
		StdDraw.setCanvasSize(BREITE, HOEHE);
		//neuer Button
		starten = new JButton("Spiel starten");
		//legt Groesse und Position fest
		starten.setBounds(ZWEIHUNDERTSECHZIG,0,EINHUNDERTSECHZIG,PIC2); 
		//damit was passiert, wenn man Buttons drueckt
		starten.addActionListener(StdDraw.frame); 
		starten.setFocusable(false);
		//wird der Oberflaeche hinzugefuegt
		StdDraw.frame.add(starten); 
		
		// Button "Beenden"
		//folgendes analog zu starten-Button (mit geaenderten Koordinaten)
		ende = new JButton("Beenden");
		ende.setBounds(BREITETEXT6,0,EINHUNDERTSECHZIG,PIC2);
		ende.addActionListener(StdDraw.frame);
		StdDraw.frame.add(ende);
		
		StdDraw.frame.addKeyListener(StdDraw.frame);
		
		
	}
	
	public Interface(){
	
		}
	
	/**
	 * Gibt Level zurueck
	 * @return level aktuelles Level 
	 */
	public static int getLevel(){
		return level;
	}
	
	/**
	 * Gibt Raum zurueck
	 * @return raum aktueller Raum 
	 */
	public static int getRaum(){
		return raum;
	}
	
	
	/**
	 * Button-Reaktionen: Spiel "starten" und "beenden"
	 * @param event Action event
	 */
	public void actionPerformed(ActionEvent event) {
		
		//wenn der Button 'starten' gedrueckt wird, soll sich Fenster mit Spielfeld oeffnen
		if (event.getSource().equals(starten)){
			StdDraw.clear();
			StdDraw.setXscale(0.0,NEUNHUNDERT);
			StdDraw.setYscale(0,SECHSHUNDERT);
			if (!Spielfeld.initSpielfeld()){
				spielGestartet=true;
				raum=0;
				level=0;
				aktiveCheckpoint=0;
				player[0]= new Spieler(0);
				// stellt das aktuelle/erste level dar
				levelDarstellen();
				Aktion.reachedCheckpoint=false;
			}
			
		}
		
		//wenn der Button 'schliessen' gedrueckt wird, soll sich das Menuefenster schliessen
		if(event.getSource().equals(ende)){
			System.exit(0);
		}

		
		
	}	
	
	/**
	 * Methode keyTyped: KeyEvent,
	 * jedoch nicht genutzt
	 * @param k Key Event	
	 * 
	 */
	public void keyTyped(KeyEvent k){
		
	}

	/**
	 * Methode keyPressed: KeyEvent:
	 * Tasten werden mit Bewegungsfunktionen innerhalb des Programms belegt
	 * bei Tastendruck bewegen sich auch alle Gegner
	 * 
	 */
	public void keyPressed(KeyEvent k){
		toCheckpoint=false;
		if(spielGestartet){
			StdDraw.show(0);
			/*Key Aktionen:*/
		     	/*Bewegung nach Rechts*/
				if (k.getKeyCode() == KeyEvent.VK_RIGHT){
					checkStartZiel = player[0].bewegen(RECHTS);
					alleGegnerBewegen(); 
				}
				/*Bewegung nach Unten*/
				else if (k.getKeyCode() == KeyEvent.VK_DOWN){
					checkStartZiel = player[0].bewegen(UNTEN);
					alleGegnerBewegen();
				}
				/*Bewegung nach Links*/
				else if (k.getKeyCode() == KeyEvent.VK_LEFT){
					checkStartZiel = player[0].bewegen(LINKS);
					alleGegnerBewegen();
				}
				/* Bewegung nach Oben*/
				else if (k.getKeyCode() == KeyEvent.VK_UP){
					checkStartZiel = player[0].bewegen(OBEN);
					alleGegnerBewegen();
				}
				/* zum zaubern*/
				else if (k.getKeyCode() == KeyEvent.VK_SPACE){
					player[0].schildZauber();
				}
				/* Angriff oben*/
				else if (k.getKeyCode() == KeyEvent.VK_W){
					playerAttack(OBEN);
					alleGegnerBewegen();
				}
				/*Angriff links*/
				else if (k.getKeyCode() == KeyEvent.VK_A){
					playerAttack(LINKS);
					alleGegnerBewegen();
				}
				/*Angriff unten*/
				else if (k.getKeyCode() == KeyEvent.VK_S){
					playerAttack(UNTEN);
					alleGegnerBewegen();
				}
				/*Angriff rechts*/
				else if (k.getKeyCode() == KeyEvent.VK_D){
					playerAttack(RECHTS);
					alleGegnerBewegen();
				}			
				
				/*Aktion nach Erreichen des Ziels*/
				if (checkStartZiel == ZIEL){
					gegnerZahl=0;
					nextRoom();
					levelDarstellen();
					player[0].moveTo(Spielfeld.getStartpunkt(level,raum)[0], Spielfeld.getStartpunkt(level,raum)[1]);
				}
				/*Aktion beim Zurueckgehen zum Start*/
				else if(checkStartZiel == START){
					gegnerZahl=0;
					previousRoom();
					levelDarstellen();
					player[0].moveTo(Spielfeld.getZielpunkt(level,raum)[0], Spielfeld.getZielpunkt(level,raum)[1]);
				}
				/*aktion beim Checkpoint*/
				if (toCheckpoint){
					gegnerZahl=0;
					levelDarstellen();
					player[0].moveTo(checkpointArray[2], checkpointArray[ARRAYDREI]);
				}				
				
			StdDraw.show();
		}
	}
	/**
	 * ruft fuer jeden Gegner gegnerAktion auf
	 */
	public void alleGegnerBewegen(){
		for (counter=0;counter<gegnerZahl;counter++){
			if (spielGestartet){
				gegnerAktion(counter);
			}
		}
	}
	
	/**
	 * bestimmt die Aktionen von Gegnern
	 * @param id 'Nummer' des Gegners
	 */
	public void gegnerAktion(int id){
		gegnerAttack=gegner[id].bewegen();
		if (gegnerAttack[0]==1){
			if (player[ getPlayerID(gegnerAttack[1],gegnerAttack[2]) ].schadenBekommen( gegner[id].getSchaden() )){
				toCheckpoint=true;
			}
		}
	}
	
	/**
	 * Angriff auf Mob und Bosse
	 * @param richtung Richtung in die angegriffen wird
	 */
	public void playerAttack(int richtung){
		playerAttack=player[0].playerAttack(richtung);
		if (playerAttack[0]==MOB){
			gegner[ getGegnerID(playerAttack[1],playerAttack[2]) ].schadenBekommen( player[0].getSchaden() );
		}
		else if (playerAttack[0]==BOSS3){
			boss3.schadenBekommen( player[0].getSchaden() );
			if (player[0].schadenBekommen(boss3.getSchaden())){
				toCheckpoint=true;
			}
		}
	}
	
	/**
	 * Methode keyReleased : KeyEvent, 
	 * jedoch nicht genutzt
	 * @param k Key Event
	 * 
	 */
	public void keyReleased(KeyEvent k){
		
	}

	
	
	
	
/**
 * Darstellung des Spielfelds (Grafische Ausgabe)
 * 
 */
	public void levelDarstellen() {
		gegnerZahl=0;
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.show(0);
		for (spalte=0;spalte<SPALTEN;spalte++) {
			for(reihe=0;reihe<REIHEN;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BODEN
						/*
						 * 13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
						 * 13: X steht in level.txt fuer die Stelle neben dem Ziel
						 * 14: Y steht in level.txt fuer die Stelle neben dem Checkpoint
						 */
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BEIZIEL) 
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BEICHECKPOINT)){
																					
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, BODENIMG); 
				}
				/* Mauer*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MAUER){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, MAUERIMG);
				}
				/* Versteckter Gang*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==VERSTECKTERGANG){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, VERSTECKTERGANGIMG);
				}
				/* Startpunkt*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)== START){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, STARTIMG);
				}
				/*Zielpunkt*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==ZIEL){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, ZIELIMG);
				}
				/*Falle*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FALLE){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FALLEIMG);
				}
				/*Mob*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MOB){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, MOBIMG);
					gegner[gegnerZahl] = new Gegner(ZEHN, spalte, reihe, OBEN, 0, 2, gegnerZahl,MOB);
					gegnerZahl++;
				}
				/*Spielfigur*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FIGUR){
					//StdDraw.picture(20+40*spalte,20+40*reihe, SPIELFIGURIMG);
					player[0].setXY(spalte,reihe);
				}
				/*Sieg*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SIEG){

					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, SIEGIMG);
				}
				/*Checkpoint*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==CHECKPOINT){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, CHECKPOINTIMG);
				}
				/*blaue Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEBLAU){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FARBEBLAUIMG);
				}
				/*gelbe Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEGELB){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FARBEGELBIMG);
				}
				/*rote Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEROT){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FARBEROTIMG);
				}
				/* Storyteller*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==STORYTELLER){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, STORYTELLERIMG);
				}
				/*Muenze*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MUENZEN){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, MUENZENIMG);
				}
				/* Shop erster Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP1){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, SHOP1IMG);
				}
				/* Shop zweiter Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP2){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, SHOP2IMG);
				}
				/* Shop dritter Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP3){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, SHOP3IMG);
				}
				/* HP-Trank*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==HPTRANK){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, HPTRANKIMG);
				}
				/* Manatrank*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MANATRANK){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, MANATRANKIMG);
				}
				/*HP-Trankshop*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==HPTRANKSHOP){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, HPTRANKIMG);
				}
				/* Mana-Trankshop*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MANATRANKSHOP){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, MANATRANKIMG);
				}
				/*Boss 1*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS1){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, BOSS1IMG);
					gegner[gegnerZahl] = new Gegner(SPALTEN, spalte, reihe, LINKS, 0, ARRAYVIER, gegnerZahl,BOSS1);
					gegnerZahl++;
				}
				/*Boss 2*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS2){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, BOSS2IMG);
					gegner[gegnerZahl] = new Gegner(FUENFUNDZWANZIG, spalte, reihe, RECHTS, 0, ARRAYVIER, gegnerZahl,BOSS2);
					gegnerZahl++;
				}
				/* Boss 3*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS3){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, BOSS3IMG);
					boss3 = new Boss3(spalte,reihe);
				}
				/*Schluessel*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SCHLUESSEL){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, SCHLUESSELIMG);
				}
				/*Tor*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==TOR){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, TORIMG);
				}
				/*Portal*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==PORTAL){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, PORTALIMG);
				}
				/*stand here*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==STANDHERE){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, STANDHEREIMG);
				}
				/*Feld 1 vor stand here*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FELDVORSTANDHEREEINS){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FELDVORSTANDHEREEINSIMG);
				}
				/*Feld 2 vor stand here*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FELDVORSTANDHEREZWEI){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, FELDVORSTANDHEREZWEIIMG);
				}
				/*linke Seite von Doppelportal*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==DOPPELPORTALLINKS){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, DOPPELPORTALLINKSIMG);
				}
				/*rechte Seite von Doppelportal*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==DOPPELPORTALRECHTS){
					StdDraw.picture(PIC1+PIC2*spalte,PIC1+PIC2*reihe, DOPPELPORTALRECHTSIMG);
				}
			}
			
		}
				

	
		player[0].display();
		StdDraw.show();
	}
	
	/**
	 * erhoeht raum bzw. level um eins
	 */
	public static void nextRoom(){
		if (raum<2){
			raum++;
		}
		else {
			level++;
			raum=0;
			aktiveCheckpoint=level*2;	
		}
	}
	/**
	 * zieht eins ab von raum bzw. level
	 */
	public static void previousRoom(){
		if (raum>0){
			raum--;
		}
		if ((raum==0) & (level>0)){
			level--;	
			raum=2;
		}
	}
	
	/**
	 * geht einen Checkpoint weiter
	 */
	public static void nextCheckpoint(){
		aktiveCheckpoint++;
	}
	
	
	/**
	 * setzt als level und raum die Werte des letzten Checkpoints
	 */
	public static void toCheckpoint(){
		gegnerZahl=0;
		checkpointArray=Spielfeld.getCheckpoint(aktiveCheckpoint);
		level=checkpointArray[0];
		raum=checkpointArray[1];
	}
	
	
	
		/**
		 * 
		 * blendet 'Game Over' ein
		 * Spiel kann von neuem gestartet werden
		 * 
		 */
		public static void gameOver(){
			StdDraw.picture(BREITEBILDGROSS,HOEHEBILDGROSS, GAMEOVERIMG);
			spielGestartet=false;
			Aktion.feldervorstandhere = false;
		}
		
		
		
		/**
		 * 
		 * blendet 'Gewonnen' ein
		 * Spiel kann von neuem gestartet werden
		 * 
		 */
		public static void sieg(){
			StdDraw.picture(BREITEBILDGROSS,HOEHEBILDGROSS, GEWONNENIMG);
			spielGestartet=false;			
		}
		
	
		
		
		
		/**
		 * Storyteller erzaehlt seine Geschichte
		 * abhaengig vom Raum
		 * 
		 */
		public static void storyteller(){
			//Storyteller am Anfang (Level 1, Raum 1)
			if ((level==0)&(raum==0)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT4,
						"Früher war dies ein friedliches Plätzchen, aber dann kamen die Trolle und legten Fallen aus... ");
				StdDraw.text(HOEHETEXT, BREITETEXT2, "Und das nur, um ihr Essen besser würzen zu können!");
									
			}
			//Storyteller vor dem Checkpoint (Level 1, Raum 2)
			else if ((level==0)&(raum==1)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT5, 
						"Da bist du ja schon! Pass auf, dort unten steht die beste Erfindung, " +
						"seit es die fiesen Trolle hier runter geschafft haben.");
				StdDraw.text(HOEHETEXT, BREITETEXT3, 
						"Diese rote Flagge da ist ein CHECKPOINT! Wenn du sie berührst und im weiteren Verlauf deines " +
						"Abenteuers stirbst,");
				StdDraw.text(HOEHETEXT, BREITETEXT1,
						"wirst du hier wiederbelebt werden. Und, habe ich zu viel versprochen? Die Idee ist ja wohl genial!");
				
			}
			//Storyteller für 1. Quest "Versteckter Gang" (Level 1, Raum 3) (Mauerstück als versteckter Durchgang)
			else if ((level==0)&(raum==2)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT5, 
						"Auch wenn es alle dementieren: In manchen Ausnahmesituationen hilft es,");
				StdDraw.text(HOEHETEXT, BREITETEXT3, 
						"auch mal mit dem Kopf durch die Wand zu gehen!");
			}
			//Storyteller vor dem Checkpoint (Level 2, Raum 1)
			else if ((level==1)&(raum==0)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT4, 
						"Das hier ist der einzige Shop hier unten. Decke dich gut ein, denn du wirst " +
						"nicht so schnell wieder die Möglichkeit finden,");
				StdDraw.text(HOEHETEXT, BREITETEXT2, 
						"deine Gesundheit und dein Mana zu regenerieren! Jeder Trank kostet genau eine Münze!");

			}
			//Storyteller für 2. Quest "Schlüssel und Tor" (Level 2, Raum 2) (Sammeln von zwei Schlüsseln, sodass Tor aufgeht)
			else if ((level==1)&(raum==1)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT5, 
						"Ja ich weiß, da ist ein verschlossenes Tor... Mich stört es da ja auch!");
				StdDraw.text(HOEHETEXT, BREITETEXT3, 
						"Die Trolle haben es errichtet, wer sonst! Aber sie haben auch die Schlüssel dafür...");
				StdDraw.text(HOEHETEXT, BREITETEXT1, 
						"Man braucht 2 Schlüssel, um das Tor zu öffen, denn es ist ein doppelt gesichertes Tor!");
				
			}
			//Storyteller für 1. Co-Op-Quest "Doppelportal" (Level 3, Raum 1) 
			//(beide Spieler muessen vor einem stand-here-Pfeil stehen, sodass das Portal wie auf Knopfdruck geoeffnet werden kann)
			else if ((level==2)&(raum==0)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT5, 
						"Manchmal macht man hier unten ganz merkwürdige Entdeckungen...");
				StdDraw.text(HOEHETEXT, BREITETEXT3, 
						"Die Trolle haben anscheinend einen Faible für Hindernisse");
				StdDraw.text(HOEHETEXT, BREITETEXT1, 
						" auf den Wegen... und für Knopfmechanismen!");
				
			}
			//Storyteller für 2. Co-Op-Quest "Portal" (Level 3, Raum 2) (nur wenn beide Spieler das Doppelportal ansteuern, laesst es sich oeffnen)
			else if ((level==2)&(raum==1)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT3, "Gemeinsam seid ihr stark!!!");
				
			}
			//Storyteller im Endraum (Level 3, Raum 3)
			else if ((level==2)&(raum==2)){ 
				StdDraw.text(HOEHETEXT, BREITETEXT5, 
						"Fast hast du es geschafft!!! Besiege den Endgegner und berühre die Flagge");
				StdDraw.text(HOEHETEXT, BREITETEXT3, 
						"und du kannst beruhigt nach Hause zurückkehren und dich als Sieger feiern lassen.");		
				StdDraw.text(HOEHETEXT, BREITETEXT1, 
						"Aber lass dich nicht auf den letzten Metern von den Trollen erwischen!");
				
			}		
			
		
		}
		/**
		 * Spieler bekommt Schaden durch einen gegnerischen Schlag
		 * @param gegnerID Gegner, der den schaden anrichtet
		 * @param zielX x-Koordinate des Spielers
		 * @param zielY y-Koordinate des Spielers
		 */
		public void gegnerSchlag(int gegnerID, int zielX, int zielY){
			player[getPlayerID(zielX,zielY)].schadenBekommen(gegner[gegnerID].getSchaden());
		}
		
		/**
		 * Angriff des Spielers auf einen Gegner
		 * @param playerID Spieler der angreift
		 * @param zielX x-Koordinate 
		 * @param zielY y-Koordinate
		 */
		public void playerSchlag(int playerID, int zielX, int zielY){
			gegner[getGegnerID(zielX,zielY)].schadenBekommen(player[playerID].getSchaden());
		}
		
		/**
		 * gibt Nummer der aktuellen Spielfigur zurueck
		 * @param x x-Koordinate des Spielers
		 * @param y y-Koordinate des Spielers
		 * @return "Nummer" der Spielfigur
		 */
		public int getPlayerID(int x,int y){
			for (counter2=0;counter2<playerZahl; counter2++ ){
				if ((player[counter2].getX() == x)
					&(player[counter2].getY() == y)){
					returner = counter2;
				}
			}
			return returner;
		}
		/**
		 * gibt Gegnernummer zurueck
		 * @param x x-Koordinate des Gegners
		 * @param y y-Koordinate des Gegners
		 * @return "Nummer" des Gegners
		 */
		public int getGegnerID(int x,int y){
			for (counter3=0; counter3<gegnerZahl; counter3++ ){
				if ((gegner[counter3].getX() == x)
					&(gegner[counter3].getY() == y)){
					returner= counter3;
				}
			}
			return returner;
		}
		/**
		 * stellt Gegnerbild dar
		 * @param x x-Koordinate im Spielfeld auf die der Gegner gesetzt werden soll
		 * @param y y-Koordinate im Spielfeld auf die der Gegner gesetzt werden soll
		 * @param richtung Richtung in die der Gegner gerichtet ist
		 */
		public void displayGegner(int x, int y, int richtung){
			StdDraw.picture(PIC1+PIC2*x,PIC1+PIC2*y, MOBIMG,(-richtung)*NEUNZIG);
	}
}

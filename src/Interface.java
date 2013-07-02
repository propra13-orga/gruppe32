
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
	
	public static final double VIERTEL = 0.25;
	public static final double HALBES = 0.5;
	public static final double DREIVIERTEL = 0.75;
	public static final double EINEINHALB = 1.5;
	
	
	public static final int DREI = 3;
	public static final int VIER = 4;
	public static final int FUENF = 5;
	public static final int SECHS = 6;
	public static final int SIEBEN = 7;
	public static final int ACHT = 8;
	public static final int NEUN = 9;
	public static final int ZEHN = 10;
	public static final int ZWOELF = 12;
	public static final int DREIZEHN = 13;
	public static final int VIERZEHN = 14;
	public static final int FUENFZEHN = 15;
	public static final int ZWANZIG = 20;
	public static final int FUENFUNDZWANZIG = 25;
	public static final int DREISSIG = 30;
	public static final int ZWEIUNDDREISSIG = 32;
	public static final int SECHSUNDDREISSIG =36;
	public static final int VIERZIG = 40;
	public static final int ZWEIUNDVIERZIG = 42;
	public static final int DREIUNDVIERZIG = 43;
	public static final int ACHTUNDVIERZIG = 48;
	public static final int SECHZIG = 60;
	public static final int EINUNDSECHZIG = 61;
	public static final int ZWEIUNDSECHZIG = 62;
	public static final int SECHSUNDSECHZIG = 66;
	public static final int EINUNDSIEBZIG = 71;
	public static final int ZWEIUNDSIEBZIG = 72;
	public static final int SIEBENUNDSIEBZIG = 77;
	public static final int NEUNUNDSIEBZIG = 79;
	public static final int ACHZIG = 80;
	public static final int ZWEIUNDACHZIG = 82;
	public static final int DREIUNDACHZIG = 83;
	public static final int VIERUNDACHZIG = 84;
	public static final int SECHSUNDACHZIG = 86;
	public static final int ACHTUNDACHZIG = 88;
	public static final int NEUNUNDACHZIG = 89;
	public static final int NEUNZIG = 90;
	public static final int EINHUNDERT = 100;
	public static final int EINHUNDERTZEHN = 110;
	public static final int EINHUNDERTZWOELF = 112;
	public static final int EINHUNDERTDREISSIG = 130;
	public static final int EINHUNDERTFUENFZIG = 150;
	public static final int EINHUNDERTSECHZIG = 160;
	public static final int EINHUNDERTSIEBZIG = 170;
	public static final int ZWEIHUNDERT = 200;
	public static final int ZWEIHUNDERTZWANZIG = 220;
	public static final int ZWEIHUNDERTFUENFZIG = 250;
	public static final int ZWEIHUNDERTSECHZIG = 260;	
	public static final int DREIHUNDERT = 300;
	public static final int DREIHUNDERTFUENFZIG = 350;
	public static final int DREIHUNDERTSIEBZIG = 370;
	public static final int DREIHUNDERTNEUNZIG = 390;
	public static final int VIERHUNDERT = 400;
	public static final int VIERHUNDERTZEHN = 410;
	public static final int VIERHUNDERTDREISSIG = 430;
	public static final int VIERHUNDERTFUENFZIG = 450;
	public static final int VIERHUNDERTSIEBZIG = 470;
	public static final int VIERHUNDERTACHZIG = 480;
	public static final int VIERHUNDERTNEUNZIG = 490;
	public static final int FUENFHUNDERT = 500;
	public static final int FUENFHUNDERTZEHN = 510;
	public static final int FUENFHUNDERTDREISSIG = 530;
	public static final int FUENFHUNDERTVIERZIG = 540;
	public static final int FUENFHUNDERTFUENFZIG = 550;
	public static final int FUENFHUNDERTSECHZIG = 560;
	public static final int FUENFHUNDERTSIEBZIG = 570;
	public static final int SECHSHUNDERT = 600;
	public static final int SECHSHUNDERTZEHN = 610;
	public static final int ACHTHUNDERTZEHN = 810;
	public static final int ACHTHUNDERTZWANZIG = 820;
	public static final int NEUNHUNDERT = 900;
	public static final int NEUNHUNDERTZWANZIG = 920;
	public static final int VIEL = 1000000000;
	
	/**
	 * Spieler- und Gegneranzahl
	 */
	private int playerZahl;
	private static int gegnerZahl=0;
	
	/**
	 * Objekte vom Typ Spieler, Gegner und Boss
	 */
	private Spieler[] player = new Spieler[2];
	private Gegner[] gegner = new Gegner[20];
	private Boss3 boss3;
	
	
	
	/**
	 * Level und Raum
	 */
	public static int level;
	public static int raum;
	
	
	private int checkStartZiel;
	
	
	private int[] gegnerAttack = new int[3];
	private int[] playerAttack = new int[3];
	
	private static int aktiveCheckpoint=0;
	private static int[] checkpointArray = new int[4];
	
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
		starten.setBounds(ZWEIHUNDERTSECHZIG,0,EINHUNDERTSECHZIG,VIERZIG); 
		//damit was passiert, wenn man Buttons drueckt
		starten.addActionListener(StdDraw.frame); 
		starten.setFocusable(false);
		//wird der Oberflaeche hinzugefuegt
		StdDraw.frame.add(starten); 
		
		// Button "Beenden"
		//folgendes analog zu starten-Button (mit geaenderten Koordinaten)
		ende = new JButton("Beenden");
		ende.setBounds(VIERHUNDERTFUENFZIG,0,EINHUNDERTSECHZIG,VIERZIG);
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
			if (Spielfeld.initSpielfeld() == false){
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
		if(spielGestartet == true){
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
				if (toCheckpoint==true){
					gegnerZahl=0;
					levelDarstellen();
					player[0].moveTo(checkpointArray[2], checkpointArray[DREI]);
				}				
				
			StdDraw.show();
		}
	}
	/**
	 * ruft fuer jeden Gegner gegnerAktion auf
	 */
	public void alleGegnerBewegen(){
		for (counter=0;counter<gegnerZahl;counter++){
			if (spielGestartet==true){
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
			if (player[ getPlayerID(gegnerAttack[1],gegnerAttack[2]) ].schadenBekommen( gegner[id].getSchaden() ) ==true){
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
			if (player[0].schadenBekommen(boss3.getSchaden())==true){
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
		for (spalte=0;spalte<ZWANZIG;spalte++) {
			for(reihe=0;reihe<DREIZEHN;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BODEN
						/*
						 * 13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
						 * 13: X steht in level.txt fuer die Stelle neben dem Ziel
						 * 14: Y steht in level.txt fuer die Stelle neben dem Checkpoint
						 */
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==DREIZEHN) 
						|(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==VIERZEHN)){
																					
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, BODENIMG); 
				}
				/* Mauer*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MAUER){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, MAUERIMG);
				}
				/* Versteckter Gang*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==VERSTECKTERGANG){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, VERSTECKTERGANGIMG);
				}
				/* Startpunkt*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)== START){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, STARTIMG);
				}
				/*Zielpunkt*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==ZIEL){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, ZIELIMG);
				}
				/*Falle*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FALLE){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, FALLEIMG);
				}
				/*Mob*/
				else if (Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MOB){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, MOBIMG);
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

					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, SIEGIMG);
				}
				/*Checkpoint*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==CHECKPOINT){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, CHECKPOINTIMG);
				}
				/*blaue Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEBLAU){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, FARBEBLAUIMG);
				}
				/*gelbe Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEGELB){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, FARBEGELBIMG);
				}
				/*rote Spielfigur*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==FARBEROT){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, FARBEROTIMG);
				}
				/* Storyteller*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==STORYTELLER){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, STORYTELLERIMG);
				}
				/*Muenze*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MUENZEN){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, MUENZENIMG);
				}
				/* Shop erster Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP1){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, SHOP1IMG);
				}
				/* Shop zweiter Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP2){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, SHOP2IMG);
				}
				/* Shop dritter Teil*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SHOP3){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, SHOP3IMG);
				}
				/* HP-Trank*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==HPTRANK){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, HPTRANKIMG);
				}
				/* Manatrank*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MANATRANK){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, MANATRANKIMG);
				}
				/*HP-Trankshop*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==HPTRANKSHOP){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, HPTRANKIMG);
				}
				/* Mana-Trankshop*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==MANATRANKSHOP){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, MANATRANKIMG);
				}
				/*Boss 1*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS1){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, BOSS1IMG);
					gegner[gegnerZahl] = new Gegner(ZWANZIG, spalte, reihe, LINKS, 0, VIER, gegnerZahl,BOSS1);
					gegnerZahl++;
				}
				/*Boss 2*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS2){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, BOSS2IMG);
					gegner[gegnerZahl] = new Gegner(FUENFUNDZWANZIG, spalte, reihe, RECHTS, 0, VIER, gegnerZahl,BOSS2);
					gegnerZahl++;
				}
				/* Boss 3*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==BOSS3){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, BOSS3IMG);
					boss3 = new Boss3(spalte,reihe);
				}
				/*Schluessel*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==SCHLUESSEL){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, SCHLUESSELIMG);
				}
				/* Tor*/
				else if(Spielfeld.wertLesenBeiXY(level,raum,spalte,reihe)==TOR){
					StdDraw.picture(ZWANZIG+VIERZIG*spalte,ZWANZIG+VIERZIG*reihe, TORIMG);
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
			StdDraw.picture(VIERHUNDERT,DREIHUNDERT, GAMEOVERIMG);
			spielGestartet=false;			
		}
		
		
		
		/**
		 * 
		 * blendet 'Gewonnen' ein
		 * Spiel kann von neuem gestartet werden
		 * 
		 */
		public static void sieg(){
			StdDraw.picture(VIERHUNDERT,DREIHUNDERT, GEWONNENIMG);
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
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSECHZIG,
						"Früher war dies ein friedliches Plätzchen, aber dann kamen die Trolle und legten Fallen aus... ");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTVIERZIG, "Und das nur, um ihr Essen besser würzen zu können!");
									
			}
			//Storyteller vor dem Checkpoint (Level 1, Raum 2)
			else if ((level==0)&(raum==1)){ 
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSIEBZIG, 
						"Da bist du ja schon! Pass auf, dort unten steht die beste Erfindung, " +
						"seit es die fiesen Trolle hier runter geschafft haben.");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTFUENFZIG, 
						"Diese rote Flagge da ist ein CHECKPOINT! Wenn du sie berührst und im weiteren Verlauf deines " +
						"Abenteuers stirbst,");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTDREISSIG,
						"wirst du hier wiederbelebt werden. Und, habe ich zu viel versprochen? Die Idee ist ja wohl genial!");
				
			}
			//Storyteller für 1. Quest "Versteckter Gang" (Level 1, Raum 3)
			else if ((level==0)&(raum==2)){ 
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSECHZIG, 
						"Auch wenn es alle dementieren: In manchen Ausnahmesituationen hilft es,");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTVIERZIG, 
						"auch mal mit dem Kopf durch die Wand zu gehen!");
			}
			//Storyteller vor dem Checkpoint (Level 2, Raum 1)
			else if ((level==1)&(raum==0)){ 
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSECHZIG, 
						"Das hier ist der einzige Shop hier unten. Decke dich gut ein, denn du wirst " +
						"nicht so schnell wieder die Möglichkeit finden,");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTVIERZIG, 
						"deine Gesundheit und dein Mana zu regenerieren! Jeder Trank kostet genau eine Münze!");

			}
			//Storyteller für 2. Quest "Schlüssel und Tor" (Level 2, Raum 2)
			else if ((level==1)&(raum==1)){ 
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSIEBZIG, 
						"Ja ich weiß, da ist ein verschlossenes Tor... Mich stört es da ja auch! ");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTFUENFZIG, 
						"Die Trolle haben es errichtet, wer sonst! Aber sie haben auch die Schlüssel dafür...");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTDREISSIG, 
						"Man braucht 2 Schlüssel, um das Tor zu öffen, denn es ist ein doppelt gesichertes Tor!");
				
			}
			//Storyteller im Endraum (Level 3, Raum 3)
			else if ((level==2)&(raum==2)){ 
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTSIEBZIG, 
						"Fast hast du es geschafft!!! Besiege den Endgegner und berühre die Flagge ");
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTFUENFZIG, 
						"und du kannst beruhigt nach Hause zurückkehren und dich als Sieger feiern lassen.");		
				StdDraw.text(VIERHUNDERT, FUENFHUNDERTDREISSIG, 
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
			StdDraw.picture(ZWANZIG+VIERZIG*x,ZWANZIG+VIERZIG*y, MOBIMG,((-richtung)*NEUNZIG));
	}
}

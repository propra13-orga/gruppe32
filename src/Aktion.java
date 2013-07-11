import java.applet.AudioClip;



/**
 *
 * Hauptspiellogik bzw. was tun wenn was passiert
 * 
 */
public class Aktion{

/**
 *  Level und Raum initialisieren
 */
private int aktuellesLevel = 0;
private int aktuellerRaum =0;
private int newFigurX;
private int newFigurY;

static boolean reachedCheckpoint;
static int checkpointMerkeLevel;
static int checkpointMerkeRaum;
static boolean storyteller;
private boolean player;
private int[] returnArray = new int[5];

private int figurX;
private int figurY;
private FigurDisplay display = new FigurDisplay();

private static final String WEISSIMG = "Images\\weiss.jpg";

private static final AudioClip MUENZESOUND = Sound.loadSound("src/Sounds/gold.wav");
private static final AudioClip TORSOUND = Sound.loadSound("src/Sounds/tor.wav");
private static final AudioClip BOMBESOUND = Sound.loadSound("src/Sounds/bombe.wav");
private static final AudioClip ANGRIFFSOUND = Sound.loadSound("src/Sounds/angriff.wav");
private static final AudioClip CHECKPOINTSOUND = Sound.loadSound("src/Sounds/checkpoint.wav");

/**
 * 
 * @param ifPlayer 
 * @param newId 
 */
public Aktion(boolean ifPlayer, int newId){
	player = ifPlayer;
	
}

/**
 * neue Koordinaten der Spielfigur abhaengig von der jeweiligen Richtung
 * @param richtung Richtung in die die Figur zeigt 
 */
	private void setNewFigurXY(int richtung){
		if (richtung == Interface.RECHTS){ 
			newFigurX=figurX+1;
			newFigurY=figurY;
		}	   
		else if (richtung == Interface.UNTEN){ 
			newFigurX=figurX;
			newFigurY=figurY-1;
		}
		else if (richtung == Interface.LINKS){ 
			newFigurX=figurX-1;
			newFigurY=figurY;
		}
		else if (richtung == Interface.OBEN){ 
			newFigurX=figurX;
			newFigurY=figurY+1;
		}
	}

	/**
	 * Methode bewegt Figur anhand von Koordinaten
	 * @param richtung Richtung in die die Figur sich bewegt
	 * @param figurX2 X-Koordinate der Figur
	 * @param figurY2 Y-Koordinate der Figur
	 * @param farbe aktuelle Farbe, abhaengig von aktueller Ruestung
	 * @param schild vorhandener Schildzauber (Boolean)
	 * @param type Art der Figur
	 * @return Return 
	 */
		public int[] figurBewegen(int richtung, int figurX2, int figurY2, int farbe, boolean schild,int type){
		figurX=figurX2;
		figurY=figurY2;
		aktuellesLevel = Interface.getLevel();
		aktuellerRaum = Interface.getRaum();
		setNewFigurXY(richtung);
		
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BODEN)
				/*
				 * 13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
				 * 13: X steht in level.txt fuer die Stelle neben dem Ziel
				 * 14: Y steht in level.txt fuer die Stelle neben dem Checkpoint*/
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BEIZIEL) 
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BEICHECKPOINT)){ 
			if (player){
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else {
				display.gegnerBewegen(figurX,figurY,newFigurX,newFigurY,richtung,type);
				figurX=newFigurX;
				figurY=newFigurY;
			}
			returnArray[0]=Interface.BODEN;
			
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.VERSTECKTERGANG){
			if (player){
				returnArray[0]=Interface.VERSTECKTERGANG;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.VERSTECKTERGANG);
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.START)
				&((aktuellerRaum!=0)|(aktuellesLevel!=0))){
			if (player){
				returnArray[0]=Interface.START;
				StdDraw.picture(400, 550,WEISSIMG);
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.ZIEL){
			
			if ( player){	
				returnArray[0]=Interface.ZIEL;
				StdDraw.picture(400,550,WEISSIMG);
				TORSOUND.play();
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MOB){
			
			if (player){
				returnArray[0]=Interface.MOB;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
						
		}	else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FALLE){
			
			if (player){
				returnArray[0]=Interface.FALLE;
				BOMBESOUND.play();
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
						
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.SIEG){
			if ( player){
				returnArray[0]=Interface.SIEG;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.CHECKPOINT){
			if (player){
				CHECKPOINTSOUND.play();
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);
				figurX=newFigurX;
				figurY=newFigurY;
				returnArray[0]=Interface.CHECKPOINT;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
			
			
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.STORYTELLER){
			if (player){
				Interface.storyteller();
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MUENZEN){
			MUENZESOUND.play();
			if (player){
				
				returnArray[0]=Interface.MUENZEN;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
				
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
			
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.SCHLUESSEL){
			if (player){
				returnArray[0]=Interface.SCHLUESSEL;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.TOR){
			if (Spieler.aktuelleSchluessel==2 & player){
					returnArray[0]=Interface.TOR;
					Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
					display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
					figurX=newFigurX;
					figurY=newFigurY;
					TORSOUND.play();
					}
				else{
					returnArray[0]=Interface.MAUER;	
				}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.HPTRANKSHOP){
			if (player){	
				returnArray[0]=Interface.HPTRANKSHOP;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MANATRANKSHOP){
			if (player){	
				returnArray[0]=Interface.MANATRANKSHOP;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEGELB){
			if (player){	
				returnArray[0]=Interface.FARBEGELB;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEROT){
			if (player){	
				returnArray[0]=Interface.FARBEROT;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEBLAU){
			if (player){	
				returnArray[0]=Interface.FARBEBLAU;
			}
			else{
				returnArray[0]=Interface.MAUER;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.HPTRANK){
			if (player){	
				returnArray[0]=Interface.HPTRANK;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MANATRANK){
			if (player){	
				returnArray[0]=Interface.MANATRANK;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FIGUR){
			if (player){
				returnArray[0]=Interface.MAUER;
				

			}
			else {
				returnArray[0]=Interface.FIGUR;
				returnArray[Interface.ARRAYDREI]=newFigurX;
				returnArray[Interface.ARRAYVIER]=newFigurY;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS3){
			if (player){
				returnArray[0]=Interface.BOSS3;
			}
			else {
				returnArray[0]=Interface.MAUER;
			}
		}
		else{
			returnArray[0]=Interface.MAUER;
			

		}
		
		returnArray[1]=figurX;
		returnArray[2]=figurY;
		return returnArray;


	}

	
	/**
	 * 
	 * @param richtung Richtung in die der Spieler angreift
	 * @return Return    
	 */
	public int[] playerAttack(int richtung){
		setNewFigurXY(richtung);
		returnArray[0]=0;
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MOB)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS1)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS2)){
			returnArray[0]=Interface.MOB;
			returnArray[1]=newFigurX;
			returnArray[2]=newFigurY;
			ANGRIFFSOUND.play();
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS3){
			returnArray[0]=Interface.BOSS3;
			ANGRIFFSOUND.play();
		}
		return returnArray;
	}
	
/**
 * zeigt Figur an
 * @param x x-Koordinate der Figur
 * @param y y- Koordinate der Figur
 * @param farbe aktuelle Farbe, abhaengig von aktueller Ruestung
 * @param schild vorhandener Schildzauber (Boolean)
 */
	
public void displayFigur(int x, int y, int farbe, boolean schild){
	display.displayPlayer(x, y, farbe, schild);
}

/**
 * Bewegt Figur/ Spieler
 * @param vonX urspruengliche x-Koordinate
 * @param vonY urspruengliche y-Koordinate
 * @param nachX neue x-Koordinate
 * @param nachY neue y-Koordinate
 * @param farbe aktuelle Farbe, abhaengig von aktueller Ruestung
 * @param schild vorhandener Schildzauber (Boolean)
 */

public void playerNachXY(int vonX, int vonY, int nachX, int nachY, int farbe, boolean schild ){
	display.figurBewegen(vonX, vonY, nachX, nachY, farbe, schild );
}

/**
 *  zeigt den Gegner an
 * @param x x-Koordinate des Gegners
 * @param y y-Koordinate des Gegners
 * @param richtung Richtung in die sich die Figur bewegt
 * @param type Typ der Figur
 */

public void displayGegner(int x, int y, int richtung, int type){
	display.displayGegner(x,y,richtung,type);
}
	
	
	





}


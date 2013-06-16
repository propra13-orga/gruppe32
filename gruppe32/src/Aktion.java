

/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * 
 */
public class Aktion{

private int aktuellesLevel = 0;
private int aktuellerRaum =0;
private int newFigurX;
private int newFigurY;

static boolean reachedCheckpoint;
static int checkpointMerkeLevel;
static int checkpointMerkeRaum;
static boolean storyteller;
private boolean player;
private int[] returnArray = new int[3];

private int figurX;
private int figurY;
private FigurBewegung move = new FigurBewegung();

private static final String WEISSIMG = "Images\\weiss.jpg";

public Aktion(boolean ifPlayer, int newId){
	player = ifPlayer;
	
}


/**
 * Methode bewegt Figur anhand von Koordinaten
 * 
 */
	public int[] figurBewegen(int richtung, int figurX2, int figurY2, int farbe, boolean schild){
		figurX=figurX2;
		figurY=figurY2;
		aktuellesLevel = Interface.getLevel();
		aktuellerRaum = Interface.getRaum();
		
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
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==13) //13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==14)){ //13: X steht in level.txt fuer die Stelle neben dem Ziel
			if (player==true){	//14: Y steht in level.txt fuer die Stelle neben dem Checkpoint
				move.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else {
				move.gegnerBewegen(figurX,figurY,newFigurX,newFigurY,richtung);
				figurX=newFigurX;
				figurY=newFigurY;
			}
			returnArray[0]=Interface.BODEN;
			
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.START)
				&((aktuellerRaum!=0)|(aktuellesLevel!=0))){
			if (player==true){
				returnArray[0]=Interface.START;
				StdDraw.picture(400,560,WEISSIMG);
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.ZIEL){
			if ( player==true){	
				returnArray[0]=Interface.ZIEL;
				StdDraw.picture(400,560,WEISSIMG);
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FALLE)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MOB)){
			
			if (player==true){
				
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
						
		}	
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.SIEG){
			if ( player == true){
				aktuellesLevel=0;
				aktuellerRaum=0;
				Interface.sieg();
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.CHECKPOINT){
			if (player == true){
				move.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);
				figurX=newFigurX;
				figurY=newFigurY;
				returnArray[0]=Interface.CHECKPOINT;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
			
			
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.STORYTELLER){
			if (player == true){
				Interface.storyteller();
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MUENZEN){
			if (player == true){
				returnArray[0]=Interface.MUENZEN;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				move.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
			
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.HPTRANKSHOP){
			if (player == true){	
				returnArray[0]=Interface.HPTRANKSHOP;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MANATRANKSHOP){
			if (player == true){	
				returnArray[0]=Interface.MANATRANKSHOP;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEGELB){
			if (player == true){	
				returnArray[0]=Interface.FARBEGELB;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEROT){
			if (player == true){	
				returnArray[0]=Interface.FARBEROT;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FARBEBLAU){
			if (player == true){	
				returnArray[0]=Interface.FARBEBLAU;
			}
			else{
				returnArray[0]=Interface.MAUER;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.HPTRANK){
			if (player == true){	
				returnArray[0]=Interface.HPTRANK;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				move.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MANATRANK){
			if (player == true){	
				returnArray[0]=Interface.MANATRANK;
				Spielfeld.wertSetzenBeiXY(aktuellesLevel, aktuellerRaum, newFigurX, newFigurY, Interface.BODEN);
				move.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
				figurX=newFigurX;
				figurY=newFigurY;
			}
			else{
				returnArray[0]=Interface.MAUER;
				

			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FIGUR){
			if (player == true){
				returnArray[0]=Interface.MAUER;
				

			}
			else {
				//schadenmachzeug
			}
		}
		else{
			returnArray[0]=Interface.MAUER;
			

		}
		
		returnArray[1]=figurX;
		returnArray[2]=figurY;
		return returnArray;


	}


public void displayFigur(int x, int y, int farbe, boolean schild){
	move.displayPlayer(x, y, farbe, schild);
}
public void displayGegner(int x, int y, int richtung){
	move.displayGegner(x,y,richtung);
}
	
	
	





}


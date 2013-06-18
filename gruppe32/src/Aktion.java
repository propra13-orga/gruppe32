

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
private int[] returnArray = new int[5];

private int figurX;
private int figurY;
private FigurDisplay display = new FigurDisplay();

private static final String WEISSIMG = "Images\\weiss.jpg";

public Aktion(boolean ifPlayer, int newId){
	player = ifPlayer;
	
}


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
 * 
 */
	public int[] figurBewegen(int richtung, int figurX2, int figurY2, int farbe, boolean schild,int type){
		figurX=figurX2;
		figurY=figurY2;
		aktuellesLevel = Interface.getLevel();
		aktuellerRaum = Interface.getRaum();
		setNewFigurXY(richtung);
		
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==13) //13 und 14 sind Hilfselemente um an bestimmte Punkte zurueck zu kehren
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==14)){ //13: X steht in level.txt fuer die Stelle neben dem Ziel
			if (player==true){	//14: Y steht in level.txt fuer die Stelle neben dem Checkpoint
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
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MOB)){
			
			if (player==true){
				returnArray[0]=Interface.MOB;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
						
		}	else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.FALLE)){
			
			if (player==true){
				returnArray[0]=Interface.FALLE;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
						
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.SIEG){
			if ( player == true){
				returnArray[0]=Interface.SIEG;
			}
			else{
				returnArray[0]=Interface.MAUER;
				
				
			}
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.CHECKPOINT){
			if (player == true){
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
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
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
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
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
				display.figurBewegen(figurX,figurY,newFigurX,newFigurY, farbe, schild);	
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
				returnArray[0]=Interface.FIGUR;
				returnArray[3]=newFigurX;
				returnArray[4]=newFigurY;
			}
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS3){
			if (player == true){
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

	public int[] playerAttack(int richtung){
		setNewFigurXY(richtung);
		returnArray[0]=0;
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.MOB)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS1)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS2)){
			returnArray[0]=Interface.MOB;
			returnArray[1]=newFigurX;
			returnArray[2]=newFigurY;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,aktuellerRaum,newFigurX,newFigurY)==Interface.BOSS3){
			returnArray[0]=Interface.BOSS3;
		}
		return returnArray;
	}
	

public void displayFigur(int x, int y, int farbe, boolean schild){
	display.displayPlayer(x, y, farbe, schild);
}
public void playerNachXY(int vonX, int vonY, int nachX, int nachY, int farbe, boolean schild ){
	display.figurBewegen(vonX, vonY, nachX, nachY, farbe, schild );
}

public void displayGegner(int x, int y, int richtung, int type){
	display.displayGegner(x,y,richtung,type);
}
	
	
	





}


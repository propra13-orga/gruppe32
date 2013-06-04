import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * 
 */
public class Aktion{

private static int figurX;
private static int figurY;
private static int aktuellesLevel = 0;


private static final int RECHTS = 0;
private static final int UNTEN = 1;
private static final int LINKS = 2;
private static final int OBEN= 3;


int leben=3;
static boolean reachedCheckpoint;

/**
 * Methode bewegt Figur anhand von Koordinaten
 * 
 */
public void figurBewegen(int richtung){
	
		
	if (richtung == RECHTS){ 
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.FIGUR)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.START)&(aktuellesLevel>0)){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.ZIEL){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.FALLE)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.MOB)){
			if ((leben>0)&reachedCheckpoint==true){
				aktuellesLevel=2;
				Menu.levelDarstellen(2);
				Menu.figurReset(2, figurX, figurY);
				leben--;
			}
			else {
				reachedCheckpoint=false;
				Menu.figurReset(0,figurX,figurY);
			    Menu.levelDarstellen(0);
			    Menu.gameOver();
			}
		}	
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.SIEG){
			aktuellesLevel=0;
			Menu.sieg();
			//Menu.levelDarstellen(aktuellesLevel);
			//Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.CHECKPOINT){
			reachedCheckpoint=true;
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
			Spielfeld.wertSetzenBeiXY(2,9,13,Main.BODEN);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.STORYTELLER){
		    Spielfeld.storyteller();
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.FARBEGELB){
			Figur.setFarbe(Main.GELB);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.FARBEROT){
			Figur.setFarbe(Main.ROT);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==Main.FARBEBLAU){
			Figur.setFarbe(Main.BLAU);
		}
	}

			   
	else if (richtung == UNTEN){ 
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.FIGUR)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.START)&(aktuellesLevel>0)){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.ZIEL){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.FALLE)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.MOB)){
			if ((leben>0)&reachedCheckpoint==true){
				aktuellesLevel=2;
				Menu.levelDarstellen(2);
				Menu.figurReset(2, figurX, figurY);
				leben--;
			}
			else {
				reachedCheckpoint=false;
			    Menu.figurReset(0,figurX,figurY);
			    Menu.levelDarstellen(0);
			    Menu.gameOver();
			}
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.SIEG){
			aktuellesLevel=0;
			Menu.sieg();
			//Menu.levelDarstellen(aktuellesLevel);
			//Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.CHECKPOINT){
			reachedCheckpoint=true;
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
			Spielfeld.wertSetzenBeiXY(2,9,13,Main.BODEN);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.STORYTELLER){
			Spielfeld.storyteller();
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.FARBEGELB){
			Figur.setFarbe(Main.GELB);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.FARBEROT){
			Figur.setFarbe(Main.ROT);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==Main.FARBEBLAU){
			Figur.setFarbe(Main.BLAU);
		}
	}
	
	
	else if (richtung == LINKS){ //links
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.FIGUR)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX-1,figurY);
			figurX=figurX-1;
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.START)&(aktuellesLevel>0)){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.ZIEL){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.FALLE)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.MOB)){
			if ((leben>0)&reachedCheckpoint==true){
				aktuellesLevel=2;
				Menu.levelDarstellen(2);
				Menu.figurReset(2, figurX, figurY);
				leben--;
			}
			else {
				reachedCheckpoint=false;
			    Menu.figurReset(0,figurX,figurY);
			    Menu.levelDarstellen(0);
			    Menu.gameOver();
			}
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.SIEG){
			aktuellesLevel=0;
			Menu.sieg();
			//Menu.levelDarstellen(aktuellesLevel);
			//Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.CHECKPOINT){
			reachedCheckpoint=true;
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX-1,figurY);
			figurX=figurX-1;
			Spielfeld.wertSetzenBeiXY(2,9,13,Main.BODEN);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.STORYTELLER){
			Spielfeld.storyteller();
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.FARBEGELB){
			Figur.setFarbe(Main.GELB);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.FARBEROT){
			Figur.setFarbe(Main.ROT);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==Main.FARBEBLAU){
			Figur.setFarbe(Main.BLAU);
		}
		
	}
	
	
	else if (richtung == OBEN){ //oben
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.BODEN)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.FIGUR)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.START)&(aktuellesLevel>0)){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.ZIEL){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.FALLE)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.MOB)){
			if ((leben>0)&reachedCheckpoint==true){
			aktuellesLevel=2;
			Menu.levelDarstellen(2);
			Menu.figurReset(2, figurX, figurY);
			leben--;
		}
		else {
			reachedCheckpoint=false;
		    Menu.figurReset(0,figurX,figurY);
		    Menu.levelDarstellen(0);
		    Menu.gameOver();
		}
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.SIEG){
			//aktuellesLevel=0;
			Menu.sieg();
			//Menu.levelDarstellen(aktuellesLevel);
			//Menu.figurReset(aktuellesLevel, figurX, figurY);
		}	
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.CHECKPOINT){
			reachedCheckpoint=true;
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
			Spielfeld.wertSetzenBeiXY(2,9,13,Main.BODEN);
		}	
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.STORYTELLER){
			Spielfeld.storyteller();
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.FARBEGELB){
			Figur.setFarbe(Main.GELB);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.FARBEROT){
			Figur.setFarbe(Main.ROT);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==Main.FARBEBLAU){
			Figur.setFarbe(Main.BLAU);
		}
	}


}
	
	
	

/**
 * Methode setzt Figur
 * 
 */
public static void setFigurXY(int x, int y){
	figurX=x;
	figurY=y;		
}
/**
 * 
 * Methode setzt das aktuelle Level
 * 
 */
public static void setLevel(int level){
	aktuellesLevel = level;
}
public static int getFigurX(){
	return figurX;
}
public static int getFigurY(){
	return figurY;
}

}


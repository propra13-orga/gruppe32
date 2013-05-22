import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * 
 * ACHTUNG! PSEUDOVERSION! NICH FERTIG ! 
 * 
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * PROBLEM: Wie frage ich die KeyEvents im StdDraw-Fenster ab?
 * 			Aktion-Methode wird nicht aufgerufen!
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 */


public class Aktion{

static int figurX;
static int figurY;
static int aktuellesLevel = 0;




public void figurBewegen(int richtung){
	
	if (richtung == 0){ //rechts
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==0)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==6)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==7){
			Menu.gewonnen();
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==2)&(aktuellesLevel>0)){
			aktuellesLevel=aktuellesLevel-1;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==4)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
			// Game-Over-Text einblenden
			// Game-Over-Status auf true setzen, weitere Key-Atkionen unterbinden
			
		}
	}
	else if (richtung == 1){ //unten
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==0)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==6)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==3){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==7){
			Menu.gewonnen();
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==2)&(aktuellesLevel>0)){
			aktuellesLevel=aktuellesLevel-1;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==4)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
		}
	}
	else if (richtung == 2){ //links
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==0)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==6)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX-1,figurY);
			figurX=figurX-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==3){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==7){
			Menu.gewonnen();
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==2)&(aktuellesLevel>0)){
			aktuellesLevel=aktuellesLevel-1;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==4)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
		}
	}
	else if (richtung == 3){ //oben
		if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==0)
				|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==6)){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==3){
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==7){
			Menu.gewonnen();
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==2)&(aktuellesLevel>0)){
			aktuellesLevel=aktuellesLevel-1;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurZumZiel(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==4)
					|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
		}
	}
}

public static void setFigurXY(int x, int y){
	figurX=x;
	figurY=y;		
}



}


/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * ACHTUNG! PSEUDOVERSION! NICH FERTIG ! 
 */


public class Aktion{

static int figurX;
static int figurY;
int aktuellesLevel = 0;

public void figurBewegen(int richtung){
	
	if (richtung==0){ //rechts
		if (Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==0){
			Darstellung.figurBewegen(figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
		}

		else if (Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			Darstellung.figurBewegen(figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Darstellung.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Darstellung.levelDarstellen(aktuellesLevel);
		}
	}
	else if (richtung==1){ //unten
		if (Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY-1)==0){
			Darstellung.figurBewegen(figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
		}
		else if (Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY-1)==3){
			Darstellung.figurBewegen(figurX,figurY,figurX,figurY-1);
			aktuellesLevel++;
			Darstellung.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY-1)==4)|(Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY-1)==5)){
			Darstellung.levelDarstellen(aktuellesLevel);
		}
	}
	else if (richtung==2){ //links
		if (Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==0){
			Darstellung.figurBewegen(figurX,figurY,figurX+1,figurY);
			figurX=figurX-1;
		}
		else if (Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			Darstellung.figurBewegen(figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Darstellung.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Darstellung.levelDarstellen(aktuellesLevel);
		}
	}
	else if (richtung==3){ //oben
		if (Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY+1)==0){
			Darstellung.figurBewegen(figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
		}
		else if (Spielfeld.wertBeiXY(aktuellesLevel,figurX,figurY+1)==3){
			Darstellung.figurBewegen(figurX,figurY,figurX,figurY+1);
			aktuellesLevel++;
			Darstellung.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Darstellung.levelDarstellen(aktuellesLevel);
		}
	}
}

public static void setFigurXY(int x, int y){
	figurX=x;
	figurY=y;		
}

}


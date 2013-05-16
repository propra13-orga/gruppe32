import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * ACHTUNG! PSEUDOVERSION! NICH FERTIG ! 
 */


public class Aktion{

static int figurX;
static int figurY;
int aktuellesLevel = 0;


// so in der Art könnte man vielleicht die Bewegungen abfragen? ist allerdings noch fehlerhaft 
boolean up;
boolean down;
boolean left;
boolean right;


public void keyTyped(KeyEvent e) {
}

public void keyReleased(KeyEvent e){
}

public void actionPerformed(ActionEvent e) {
}

/*
public void KeyPressed(KeyEvent e){
	if (e.getKeyCode==KeyEvent.VK_UP){
		up=true;
	}
	if (e.getKeyCode==KeyEvent.VK_DOWN){
		down=true;
	}
	if (e.getKeyCode==KeyEvent.VK_LEFT){
		left=true;
	}
	if (e.getKeyCode==KeyEvent.VK_RIGHT){
		right=true;
	}
}
*/
// müssen dann wahrscheinlich irgendwann auch wieder auf false gesetzt werden...


public void figurBewegen(int richtung){
	
	if (right){ //rechts
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
	else if (down){ //unten
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
	else if (left){ //links
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
	else if (up){ //oben
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


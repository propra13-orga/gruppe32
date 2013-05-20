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
int aktuellesLevel = 0;


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


public void KeyPressed(KeyEvent e){
	if (e.getKeyCode()==KeyEvent.VK_UP){
		up=true;
		down=false;
		right=false;
		left=false;
		figurBewegen();
	}
	if (e.getKeyCode()==KeyEvent.VK_DOWN){
		up=false;
		down=true;
		right=false;
		left=false;
		figurBewegen();
	}
	if (e.getKeyCode()==KeyEvent.VK_LEFT){
		up=false;
		down=false;
		right=false;
		left=true;
		figurBewegen();
	}
	if (e.getKeyCode()==KeyEvent.VK_RIGHT){
		up=false;
		down=false;
		right=true;
		left=false;
		figurBewegen();
	}
}


public void figurBewegen(){
	
	if (right){ //rechts
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.levelDarstellen(aktuellesLevel);
			// Game-Over-Text einblenden
			// Game-Over-Status auf true setzen, weitere Key-Atkionen unterbinden
			
		}
	}
	else if (down){ //unten
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==3){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==5)){
			Menu.levelDarstellen(aktuellesLevel);
		}
	}
	else if (left){ //links
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.levelDarstellen(aktuellesLevel);
		}
	}
	else if (up){ //oben
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==3){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.levelDarstellen(aktuellesLevel);
		}
	}
}

public static void setFigurXY(int x, int y){
	figurX=x;
	figurY=y;		
}



}


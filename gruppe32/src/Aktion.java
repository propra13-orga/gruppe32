import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Klassenkommentar:
 * Hauptspiellogik bzw. was tun wenn was passiert
 * 
 * 
 */


public class Aktion{

static int figurX;
static int figurY;
int aktuellesLevel = 0;
boolean gameOver;
boolean sieg;


public void figurBewegen(int richtung){
	
		
	if (richtung == 0){ //rechts
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			figurX=figurX+1;
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==3){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
			gameOver=true;
		}
			
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==8){
			aktuellesLevel=0;
			sieg=true;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
			}		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==2){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
	}

			   
	else if (richtung == 1){ //unten
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			figurY=figurY-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==3){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY-1);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			//Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
			gameOver=true;
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==8){
			aktuellesLevel=0;
			sieg=true;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
			}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY-1)==2){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}

		}
	
	else if (richtung == 2){ //links
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX-1,figurY);
			figurX=figurX-1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==3){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX+1,figurY);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
			gameOver=true;
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==8){
			aktuellesLevel=0;
			sieg=true;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
			}
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX-1,figurY)==2){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}

		}
	
	else if (richtung == 3){ //oben
		if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==0){
			Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			figurY=figurY+1;
		}
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==3){
			//Menu.figurBewegen(aktuellesLevel,figurX,figurY,figurX,figurY+1);
			aktuellesLevel++;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}
		else if ((Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==4)|(Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX+1,figurY)==5)){
			Menu.figurReset(aktuellesLevel,figurX,figurY);
			gameOver=true;
		}

		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==8){
			aktuellesLevel=0;
			sieg=true;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
			}	
		
		else if (Spielfeld.wertLesenBeiXY(aktuellesLevel,figurX,figurY+1)==2){
			aktuellesLevel--;
			Menu.levelDarstellen(aktuellesLevel);
			Menu.figurReset(aktuellesLevel, figurX, figurY);
		}

		}
	
	
	if (gameOver){
		JFrame fenster = new JFrame("Game Over");
	    
		   fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fenster schlie�en 
		   JLabel label = new JLabel("Game Over!", JLabel.CENTER);
		   fenster.getContentPane().add(label);// dem fenster das label hinzuf�gen
		   fenster.setSize(300, 200);
		   fenster.setVisible(true);// fenster anzeigen
		   gameOver=false;
	}
	

	if (sieg){
		JFrame fenster = new JFrame("Spiel gewonnen!");
		fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fenster schlie�en 
		JLabel label = new JLabel("Herzlichen Gl�ckwunsch! Du hast gewonnen!", JLabel.CENTER);
		fenster.getContentPane().add(label);// dem fenster das label hinzuf�gen
		fenster.setSize(300, 200);
		fenster.setVisible(true);// fenster anzeigen
		sieg=false;
	}
	}
	
	
	


public static void setFigurXY(int x, int y){
	figurX=x;
	figurY=y;		
}



}


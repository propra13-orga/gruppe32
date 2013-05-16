import javax.swing.JLabel;

/**
 * 
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 * 
 */
public class Spielfeld {
/*hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass) */
static int[][][] spielfeld = new int [4][20][15];
int level;
int reihe;
int spalte;
int aktuellesLevel;



/**
 * ordnet dem Spielfeld-Array Werte für Mauern, Boden, Start, Ziel, Fallen und Spielfigur zu
 */
public Spielfeld(){
	for (spalte=0; spalte<20; spalte++) {
		for (reihe=0; reihe<15; reihe++) {
			for (level=0; level<4; level++) {
				if ((spalte==0)|(spalte==19)|(reihe==0)|(reihe==14)) {			
					spielfeld[level][spalte][reihe]=1;
					
				}
				else {
					spielfeld[level][spalte][reihe]=0;
				}
			}
		}
	}
	//startfelder(2) und zielfelder(3) setzen, erstmal fuer alle level das gleiche
	spielfeld[0][0][5]=spielfeld[1][0][5]=spielfeld[2][0][5]=spielfeld[3][0][5]=2;
	spielfeld[0][19][5]=spielfeld[1][19][5]=spielfeld[2][19][5]=spielfeld[3][19][5]=3;
	//testfallen&mobs
	spielfeld[0][1][6]=spielfeld[0][1][4]=spielfeld[0][2][6]=spielfeld[0][2][4]=4;
	spielfeld[0][18][6]=spielfeld[0][18][4]=spielfeld[0][17][6]=spielfeld[0][17][4]=5;
	//spielfigur(6) testweise an den Anfang setzten
	spielfeld[0][1][5]=6;

}


public static int wertBeiXY(int level,int x,int y)
{
	return spielfeld[level][x][y];
}




// JLabel gameOver; // Label fuer gameOver

// gameOver = new JLabel(); 
// gameOver.setVisible(false); 

// /**
//  * Methodenkommentar:
//  * Beendigung des Spieles (noch nicht ausgearbeitet)
//  * 
//  */
// public void endGame(){ 
//	gameOver.setVisible(true); 
//	gameOver.setText("GAME OVER"); 
//} 


}

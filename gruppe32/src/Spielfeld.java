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
 *
 */
public Spielfeld(){
	// Schleife über alle Level, Spalten und Reihen für Mauersteine
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
	spielfeld[0][0][5]=spielfeld[1][17][14]=spielfeld[2][10][14]=spielfeld[3][19][3]=2;
	spielfeld[0][17][0]=spielfeld[1][10][0]=spielfeld[2][0][3]=spielfeld[3][19][5]=3;
	//testfallen&mobs
	spielfeld[0][1][6]=spielfeld[0][1][4]=spielfeld[0][2][6]=spielfeld[0][2][4]=4;
	spielfeld[0][18][6]=spielfeld[0][18][4]=spielfeld[0][17][6]=spielfeld[0][17][4]=5;
	//spielfigur(6) testweise an den Anfang setzten
	spielfeld[0][1][5]=6;

}


/**
 * Spielfeldeigenschaft Wert des Feldes XY abfragen
 * @param level Level des Spiels
 * @param x X-Koordinate
 * @param y Y-Koordinate
 * 
 */
public static int wertLesenBeiXY(int level,int x,int y) {
	
	return spielfeld[level][x][y];
}


/**
 * 
 * @param level Level des Spiels
 * @param x X-Koordinate
 * @param y Y-Koordinate
 * @param wert Wert, der in das entsprechende Spielfeld gesetzt wird
 * 
 */
public static void wertSetzenBeiXY (int level, int x, int y, int wert) {
	
	spielfeld[level][x][y] = wert;
}

}

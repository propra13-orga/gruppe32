import javax.swing.JLabel;
//import java.StdOut;

/**
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 */
public class Spielfeld {
//hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass)
private static int[][][] spielfeld = new int [4][20][15];
private int level;
private int reihe;
private int spalte;

private static final int BODEN = 0;
private static final int MAUER = 1;
private static final int START = 2;
private static final int ZIEL = 3;
private static final int FALLE = 4;
private static final int MOB = 5;
private static final int FIGUR = 6;
private static final int SIEG = 7;
private static final int CHECKPOINT = 8;
private static final int STORYTELLER = 9;


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
					spielfeld[level][spalte][reihe]=MAUER;
				}
				else {
					spielfeld[level][spalte][reihe]=BODEN;
				}
			}
		}
	}
	
	//startfelder(2) und zielfelder(3) setzen, erstmal fuer alle level das gleiche
	spielfeld[0][0][5]=spielfeld[1][17][14]=spielfeld[2][10][14]=spielfeld[3][19][3]=START;
	spielfeld[0][17][0]=spielfeld[1][10][0]=spielfeld[2][0][3]=ZIEL;
	//testfallen&mobs(4/5)
	spielfeld[0][1][6]=spielfeld[0][1][4]=spielfeld[0][2][6]=spielfeld[0][2][4]=spielfeld[1][5][6]=spielfeld[1][9][3]=FALLE;
	spielfeld[2][1][9]=spielfeld[2][5][12]=spielfeld[2][9][6]=spielfeld[3][3][3]=spielfeld[3][3][4]=spielfeld[3][3][5]=spielfeld[3][14][4]=FALLE;
	spielfeld[0][18][6]=spielfeld[0][18][4]=spielfeld[0][17][6]=spielfeld[0][17][4]=spielfeld[1][10][2]=spielfeld[1][4][6]=MOB;
	spielfeld[2][15][4]=spielfeld[2][16][4]=spielfeld[2][13][9]=spielfeld[2][2][2]=spielfeld[3][9][5]=spielfeld[3][10][5]=spielfeld[3][15][3]=MOB;
	//spielfigur(6) testweise an den Anfang setzten
	spielfeld[0][1][5]=spielfeld[1][17][13]=spielfeld[2][10][13]=spielfeld[3][18][3]=FIGUR;
	spielfeld[3][14][5]=SIEG;
	
	//checkpoint
	spielfeld[2][9][13]=CHECKPOINT;

	//storyteller
	spielfeld[0][10][10]=spielfeld[2][11][13]=spielfeld[3][16][7]=STORYTELLER;
}


/**
 * Storyteller erzaehlt seine Geschichte
 * 
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * ACHTUNG: ARBEITSVERSION
 * Ausgabe noch nicht richtig, da Text im Spiel 
 * und nicht auf der Konsole ausgegeben werden soll
 * +
 * Fallunterscheidung funktioniert nicht
 * +
 * Methode steht in der falschen Klasse
 * ::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * 
 */
public static void storyteller(){
	
	if (spielfeld[0][10][10] == STORYTELLER){
		System.out.println("Hey du! Warte mal! Keine Angst, ich will dir nur helfen... \nDu bist nicht der erste Abenteurer hier auf dem Weg. Aber in dir sehe ich Potential diese Hoelle zu durchstehen... \nFrueher war dies ein friedliches Plaetzchen, aber dann kamen die Trolle und legten Fallen aus... und das nur, um ihr Essen besser wuerzen zu koennen! \nSiehst du sie dort unten...? Pass auf, komm ihnen nicht zu nahe!");
	}
	else if (spielfeld[2][11][13] == STORYTELLER){
		System.out.println("Da bist du ja schon! Pass auf, direkt neben mir steht die beste Erfindung, seitdem die fiesen Trolle es hier runter geschafft haben. Diese rote Flagge da ist ein CHECKPOINT! Wenn du sie beruehrst und im weiteren Verlauf deines Abenteuers stirbst, wirst du hier wiederbelebt werden. Und, habe ich zu viel versprochen? Die Idee ist ja wohl genial!");
	}
	else if (spielfeld[3][16][7] == STORYTELLER){
		System.out.println("Fast hast du es geschafft!!! Beruehre diese Flagge dort und du kannst beruhigt nach Hause zurueckkehren und dich als Sieger feiern lassen. \nAber lass dich nicht auf den letzten Metern von den Trollen erwischen! Mach's gut!");
	}		
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
 * Methode setzt den Wert bei den X- und Y-Koordinaten
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

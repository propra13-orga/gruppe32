/**
 * 
 * Klassenkommentar:
 * Erstellung eines Spielfeldes (Spiellogik) und
 * Darstellung dieses Spielfeldes (Grafik)
 * 
 */
public class Spielfeld {
/*hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass) */
int[][][] spielfeld = new int [4][20][15];
int level;
int reihe;
int spalte;
int aktuellesLevel;

/**
 * 
 * Methodenkommentar:
 * Spiellogik: Erstellung des 1. Levels
 * (muss in der main-class direkt am anfang ausgefuehrt werden)
 * 
 */
public void levelsErstellen() {
/*Allen Randfeldern in allen Leveln den Wert 1 ("hier is ne mauer") geben*/
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


/**
 * 
 * Methodenkommentar:
 * Darstellung der Levels (Grafik)
 * 
 */
public void levelDarstellen() {
	//stellt StdDraw auf eine besser handhabbare skala um
	StdDraw.setXscale(0.0,800);
	StdDraw.setYscale(0,600);
	for (spalte=0;spalte<20;spalte++) {
		for(reihe=0;reihe<15;reihe++) {
			// stellt an allen orten das dem wert entsprechende bild dar
			if (spielfeld[aktuellesLevel][spalte][reihe]==0){
				StdDraw.picture(20+40*spalte,20+40*reihe, "boden.jpg"); 
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==1){
				StdDraw.picture(20+40*spalte,20+40*reihe, "mauer.jpg");
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==2){
				StdDraw.picture(20+40*spalte,20+40*reihe, "start.jpg");
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==3){
				StdDraw.picture(20+40*spalte,20+40*reihe, "ziel.jpg");
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==4){
				StdDraw.picture(20+40*spalte,20+40*reihe, "falle.jpg");
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==5){
				StdDraw.picture(20+40*spalte,20+40*reihe, "mob.jpg");
			}
			else if (spielfeld[aktuellesLevel][spalte][reihe]==6){
				StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
			}
		}
	}
}


public int wertBeiKoordinaten(int n,int m)
{
	return spielfeld[level][n][m];
}
}

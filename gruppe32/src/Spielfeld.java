
public class Spielfeld {
/*hauptarray fürs spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spaß) */
int[][][] spielfeld = new int [4][20][15];
int level = 0;
int reihe;
int spalte;
/*muss in der main-class direkt am anfang ausgeführt werden*/
public void levelsErstellen() {
/*Allen Randfeldern in allen Leveln den Wert 1 ("hier is ne mauer") geben*/
	for (spalte=0; (spalte==0)||(spalte==19); spalte++)
	{
		for (reihe=0; reihe<=14; reihe++) {
			spielfeld[0][reihe][spalte]=1;
			spielfeld[1][reihe][spalte]=1;
			spielfeld[2][reihe][spalte]=1;
			spielfeld[3][reihe][spalte]=1;
		}
	}
	for (reihe=0; (reihe==0)||(reihe==14); spalte++)
	{
		for (spalte=0; spalte<=19; spalte++) {
			spielfeld[0][reihe][spalte]=1;
			spielfeld[1][reihe][spalte]=1;
			spielfeld[2][reihe][spalte]=1;
			spielfeld[3][reihe][spalte]=1;
		}
	}
}
}

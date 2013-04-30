
public class Spielfeld {
/*hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass) */
int[][][] spielfeld = new int [4][20][15];
int level = 0;
int reihe;
int spalte;
/*muss in der main-class direkt am anfang ausgefuehrt werden*/
public void levelsErstellen() {
/*Allen Randfeldern in allen Leveln den Wert 1 ("hier is ne mauer") geben*/
	for (spalte=0; (spalte==0)||(spalte==19); spalte++)
	{
		for (reihe=0; reihe<=14; reihe++) {
			spielfeld[0][spalte][reihe]=1;
			spielfeld[1][spalte][reihe]=1;
			spielfeld[2][spalte][reihe]=1;
			spielfeld[3][spalte][reihe]=1;
		}
	}
	for (reihe=0; (reihe==0)||(reihe==14); spalte++)
	{
		for (spalte=0; spalte<=19; spalte++) {
			spielfeld[0][spalte][reihe]=1;
			spielfeld[1][spalte][reihe]=1;
			spielfeld[2][spalte][reihe]=1;
			spielfeld[3][spalte][reihe]=1;
		}
	}
	//startfelder(2) und zielfelder(3) setzen, erstmal fuer alle level das gleiche
	spielfeld[0][0][5]=spielfeld[1][0][5]=spielfeld[2][0][5]=spielfeld[3][0][5]=2;
	spielfeld[0][19][5]=spielfeld[1][19][5]=spielfeld[2][19][5]=spielfeld[3][19][5]=3;
}
public int wertBeiKoordinaten(int n,int m)
{
	return spielfeld[level][n][m];
}
}

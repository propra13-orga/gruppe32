import java.io.*;


/**
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 */
public class Spielfeld {
//hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass)
private static int[][][][] spielfeld = new int [3][3][20][15];
private static int level;
private static int raum;
private static int reihe;
private  static int spalte;
private static int testChar;

private static final int BEIZIEL = 13;
private static final int BEICHECKPOINT = 14;

private static FileReader fr;
private static BufferedReader br;

/**
 * ordnet dem Spielfeld-Array Werte für Mauern, Boden, Start, Ziel, Fallen und Spielfigur zu
 *
 */
public static void initSpielfeld() {
	try{
	    
		fr = new FileReader("src\\level.txt");
		br = new BufferedReader(fr);
		for (level=0; level<3; level++) {
			br.skip(4);
			for (raum=0; raum<3; raum++) {
			br.skip(2);
			for (reihe=12; reihe>=0; reihe--) {
				br.skip(1);
					for (spalte=0; spalte<20; spalte++) {
						br.skip(1);
						testChar = br.read();
						if (testChar-48 == 1){ // 1
							spielfeld[level][raum][spalte][reihe]=Interface.MAUER;
						}
						else if (testChar-48 ==0){ // 0
							spielfeld[level][raum][spalte][reihe]=Interface.BODEN;	
						}
						else if (testChar-48 ==2){ // 2
							spielfeld[level][raum][spalte][reihe]=Interface.START;	
						}
						else if (testChar-48 ==3){  // 3
							spielfeld[level][raum][spalte][reihe]=Interface.ZIEL;
						}
						else if (testChar-48 == 5){ // 5
							spielfeld[level][raum][spalte][reihe]=Interface.MOB;
						}
						else if (testChar-48 == 4){ // 4
							spielfeld[level][raum][spalte][reihe]=Interface.FALLE;
						}
						else if (testChar-48 == 6){ // 6
							spielfeld[level][raum][spalte][reihe]=Interface.FIGUR;
						}
						else if (testChar-48 == 7){ // 7
							spielfeld[level][raum][spalte][reihe]=Interface.SIEG;
						}
						else if (testChar-48 == 8){ // 8
							spielfeld[level][raum][spalte][reihe]=Interface.CHECKPOINT;
						}
						else if (testChar-48 == 9){ // 9
							spielfeld[level][raum][spalte][reihe]=Interface.STORYTELLER;
						}
						else if (testChar == 36){ // $
							spielfeld[level][raum][spalte][reihe]=Interface.MUENZEN;
						}
						else if (testChar == 83){ // S
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP1; 
						}
						else if (testChar == 79){ // O
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP2; 
						}
						else if (testChar == 80){ // P
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP3; 
						}
						else if (testChar == 72){ // H
							spielfeld[level][raum][spalte][reihe]=Interface.HPTRANKSHOP; 
						}
						else if (testChar == 77){ // M
							spielfeld[level][raum][spalte][reihe]=Interface.MANATRANKSHOP; 
						}
						else if (testChar == 71){  // G
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEGELB;
						}
						else if (testChar == 82){ // R
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEROT;
						}
						else if (testChar == 66){ // B
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEBLAU;
						}
						else if (testChar == 88){ // X
							spielfeld[level][raum][spalte][reihe]=BEIZIEL;
						}
						else if (testChar == 89){ // Y
							spielfeld[level][raum][spalte][reihe]=BEICHECKPOINT;
						}
						else if (testChar == 43){ // +
							spielfeld[level][raum][spalte][reihe]=Interface.HPTRANK;
						}
						else if (testChar == 42){ // *
							spielfeld[level][raum][spalte][reihe]=Interface.MANATRANK;
						}
				}
			}
			}
		}
		}
		catch(FileNotFoundException e){
			spielfeld[0][0][1][2]=Interface.FARBEBLAU;
		}
		catch(IOException e){
			spielfeld[0][0][5][6]=Interface.FARBEROT;
		}
	}




/**
 * Spielfeldeigenschaft Wert des Feldes XY abfragen
 * @param level Level des Spiels
 * @param x X-Koordinate
 * @param y Y-Koordinate
 * 
 */
public static int wertLesenBeiXY(int level,int raum,int x,int y) {
	
	return spielfeld[level][raum][x][y];
}


/**
 * Methode setzt den Wert bei den X- und Y-Koordinaten
 * @param level Level des Spiels
 * @param x X-Koordinate
 * @param y Y-Koordinate
 * @param wert Wert, der in das entsprechende Spielfeld gesetzt wird
 * 
 */
public static void wertSetzenBeiXY (int level,int raum, int x, int y, int wert) {
	
	spielfeld[level][raum][x][y] = wert;
}



}

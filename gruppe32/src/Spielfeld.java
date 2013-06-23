import java.io.*;

import javax.swing.JFileChooser;


/**
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 */
public class Spielfeld {
//hauptarray fuers spielfeld sotiert nach [level][raum][spalte][reihe] (mehr dimensionen=mehr spass)
private static int[][][][] spielfeld = new int [3][3][20][15];
private static int level;
private static int raum;
private static int reihe;
private  static int spalte;
private static int testChar;
private static int[][] checkpoint = new int[6][4];
private static int counter;
private static int[][] startpunkt = new int[9][2];
private static int[] startpunktReturn = new int[2];
private static int[][] zielpunkt = new int[9][2];
private static int[] zielpunktReturn = new int[2];
private static int[] checkpointReturn = new int[4];

private static final int BEIZIEL = 13;
private static final int BEICHECKPOINT = 14;

private static FileReader fr;
private static BufferedReader br;
private static File file;
private static boolean fehlerGefunden;

private static Exception myException;

private static int exception;
private static final int FALSCHESZEICHEN = 0;
private static final int KEINLEERZEICHEN = 1;
private static final int KEINELEERZEILE = 2;
private static final int KEINZEILENUMBRUCH = 3;

/**
 * ordnet dem Spielfeld-Array Werte für Mauern, Boden, Start, Ziel, Fallen und Spielfigur zu
 *
 */
public static boolean initSpielfeld() {
	fehlerGefunden = false;
	counter=0;
	try{
	    
		JFileChooser chooser = new JFileChooser();
		int rueckgabe = chooser.showOpenDialog(null);
		if(rueckgabe == JFileChooser.APPROVE_OPTION){            
           file = chooser.getSelectedFile();
        }
		
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		for (level=0; level<3; level++) {
			if (br.read()!=13
					){ //^M (enter)
					exception = KEINELEERZEILE;
					throw myException;
				}
				br.read();
			if (br.read()!=13){ //^M (enter)
					exception = KEINELEERZEILE;
					throw myException;
				}
					br.read();
			for (raum=0; raum<3; raum++) {
				if (br.read()!=13){ //^M (enter)
						exception = KEINELEERZEILE;
						throw myException;
					}
					br.read();
				for (reihe=12; reihe>=0; reihe--) {
				if (br.read()!=13){ //^M (enter)
					exception = KEINZEILENUMBRUCH;
					throw myException;
				}
				br.read();
					for (spalte=0; spalte<20; spalte++) {
						if (br.read()!=32){ //space
							exception = KEINLEERZEICHEN;
							throw myException;
						}
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
							if (counter==0){
							setCheckpoint(level*2,level,raum,spalte,reihe);
							counter=counter-3;
							}
							counter++;
							setStartpunkt((level*3)+raum,spalte,reihe);
						}
						else if (testChar-48 == 7){ // 7
							spielfeld[level][raum][spalte][reihe]=Interface.SIEG;
						}
						else if (testChar-48 == 8){ // 8
							spielfeld[level][raum][spalte][reihe]=Interface.CHECKPOINT;
							setCheckpoint(level*2+1,level,raum,spalte,reihe);
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
							setZielpunkt((level*3)+raum,spalte,reihe);
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
						else if (testChar == 60){ // <
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS1;
						}
						else if (testChar == 61){ // =
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS2;
						}
						else if (testChar == 62){ // >
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS3;
						}
						else{
							
							exception = FALSCHESZEICHEN;
							throw myException;
						}
				}
			}
			}
		}
		}
		catch(FileNotFoundException e){
			StdDraw.text(400, 500, "FileNException");
		}
		catch(IOException e){
			StdDraw.text(400, 500, "IOException");
		}
		catch(Exception e){
			fehlerGefunden = true;
			if (exception == FALSCHESZEICHEN){
				StdDraw.text(400, 500, "Ungültiges Zeichen. "+(level+1)+"-"+(raum+1)+"::"+(spalte+1)+","+(reihe+1));
				StdDraw.text(400,450, "Für genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINLEERZEICHEN){
				StdDraw.text(400, 500, "Kein Leerzeichen vor "+(level+1)+"-"+(raum+1)+"::"+(spalte+1)+","+(reihe+1));
				StdDraw.text(400,450, "Für genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINZEILENUMBRUCH){
				StdDraw.text(400, 500, "Kein Zeilenumbruch vor "+(level+1)+"-"+(raum+1)+":: Reihe"+(reihe+1));
				StdDraw.text(400, 480, "oder zusätzliches Zeichen am vohrigen Reihenende");
				StdDraw.text(400,450, "Für genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINELEERZEILE){
				StdDraw.text(400, 500, "Fehlende Leerzeile vor "+(level+1)+"-"+(raum+1));
				StdDraw.text(400, 480, "oder zusätzliches Zeichen am vohrigen Reihenende");
				StdDraw.text(400,450, "Für genaue Level-Regeln levelReadme lesen");
			}

		}
		return fehlerGefunden;
	}

/**
 * setzt einen Checkpoint an die entsprechende Stelle
 * @param newCheckpoint
 * @param level
 * @param raum
 * @param x
 * @param y
 */
public static void setCheckpoint(int newCheckpoint, int level, int raum, int x, int y){
	checkpoint[newCheckpoint][0]=level;
	checkpoint[newCheckpoint][1]=raum;
	checkpoint[newCheckpoint][2]=x;
	checkpoint[newCheckpoint][3]=y;
}

/**
 * gibt den aktuellen Checkpoint zurueck
 * @param aktiveCheckpoint: zuletzt erreichter Checkpoint
 * @return 
 */
public static int[] getCheckpoint(int aktiveCheckpoint){
	checkpointReturn = checkpoint[aktiveCheckpoint];
	return checkpointReturn;
}
/**
 * setzt Startpunkt 
 * @param newStartpunkt
 * @param x
 * @param y
 */
public static void setStartpunkt(int newStartpunkt,int x,int y){
	startpunkt[newStartpunkt][0]=x;
	startpunkt[newStartpunkt][1]=y;
}

/**
 * gibt Startpunkt des aktuellen Levels zurueck
 * @param level
 * @param raum
 * @return
 */
public static int[] getStartpunkt(int level, int raum){
	startpunktReturn = startpunkt[level*3+raum];
	return startpunktReturn;
}

/**
 * setzt Zielpunkt
 * @param newzielpunkt
 * @param x
 * @param y
 */
public static void setZielpunkt(int newzielpunkt,int x,int y){
	zielpunkt[newzielpunkt][0]=x;
	zielpunkt[newzielpunkt][1]=y;
}
/**
 * gibt Zielpunkt des aktuellen Levels zurueck
 * @param level
 * @param raum
 * @return
 */
public static int[] getZielpunkt(int level, int raum){
	zielpunktReturn = zielpunkt[level*3+raum];
	return zielpunktReturn;
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

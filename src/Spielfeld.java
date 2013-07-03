
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;


/**
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 */
public class Spielfeld {
/**
 * hauptarray fuers spielfeld sotiert nach [level][raum][spalte][reihe] (mehr dimensionen=mehr spass)
 */
private static int[][][][] spielfeld = new int [3][3][20][15];
/**
 * Level, Raum des Spiels
 */
private static int level;
private static int raum;
/**
 * Reihe und Spalte des Spielfelds
 */
private static int reihe;
private  static int spalte;

private static int testChar;
private static int counter;
/**
 * Arrays f�r Checkpoint, Startpunkt und Zielpunkt
 */
private static int[][] checkpoint = new int[6][4];
private static int[] checkpointReturn = new int[4];
private static int[][] startpunkt = new int[9][2];
private static int[] startpunktReturn = new int[2];
private static int[][] zielpunkt = new int[9][2];
private static int[] zielpunktReturn = new int[2];

/**
 * Felder neben Ziel/Checkpoint als Konstanten
 */
private static final int BEIZIEL = 13;
private static final int BEICHECKPOINT = 14;

private static FileReader fr;
private static BufferedReader br;
private static File file;
private static boolean fehlerGefunden;

/**
 * Fehlertypen
 */
private static Exception myException;
private static int exception;
private static final int FALSCHESZEICHEN = 0;
private static final int KEINLEERZEICHEN = 1;
private static final int KEINELEERZEILE = 2;
private static final int KEINZEILENUMBRUCH = 3;

/**
 * File chooser zum Auswaehlen einer Spielfelddatei enthalten
 * Level Validierung: gibt Fehlermeldung zurueck, falls:
 *    falsches Zeichen vorhanden
 *    Leerzeile fehlt
 *    Leerzeichen fehlt
 *    Zeilenumbruch fehlt
 * ordnet dem Spielfeld-Array Werte fuer entsprechende Objekte (Mauer, Boden,...) zu
 * 
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
		for (level=0; level<Interface.DREI; level++) {
			//^M (enter)
			if (br.read()!=Interface.DREIZEHN){ 
					exception = KEINELEERZEILE;
					throw myException;
				}
				br.read();
				//^M (enter)
			if (br.read()!=Interface.DREIZEHN){ 
					exception = KEINELEERZEILE;
					throw myException;
				}
					br.read();
			for (raum=0; raum<Interface.DREI; raum++) {
				 //^M (enter)
				if (br.read()!=Interface.DREIZEHN){
						exception = KEINELEERZEILE;
						throw myException;
					}
					br.read();
				for (reihe=Interface.ZWOELF; reihe>=0; reihe--) {
					//^M (enter)
				if (br.read()!=Interface.DREIZEHN){ 
					exception = KEINZEILENUMBRUCH;
					throw myException;
				}
				br.read();
					for (spalte=0; spalte<Interface.ZWANZIG; spalte++) {
						//space
						if (br.read()!= Interface.ZWEIUNDDREISSIG){ 
							exception = KEINLEERZEICHEN;
							throw myException;
						}
						testChar = br.read();
						// 1
						if (testChar-Interface.ACHTUNDVIERZIG == 1){ 
							spielfeld[level][raum][spalte][reihe]=Interface.MAUER;
						}
						// V
						else if (testChar == Interface.SECHSUNDACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.VERSTECKTERGANG;	
						}
						// 0
						else if (testChar-Interface.ACHTUNDVIERZIG ==0){ 
							spielfeld[level][raum][spalte][reihe]=Interface.BODEN;	
						}
						// 2
						else if (testChar-Interface.ACHTUNDVIERZIG ==2){ 
							spielfeld[level][raum][spalte][reihe]=Interface.START;	
						}
						// 3
						else if (testChar-Interface.ACHTUNDVIERZIG ==Interface.DREI){  
							spielfeld[level][raum][spalte][reihe]=Interface.ZIEL;
						}
						// 5
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.FUENF){ 
							spielfeld[level][raum][spalte][reihe]=Interface.MOB;
						}
						// 4
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.VIER){ 
							spielfeld[level][raum][spalte][reihe]=Interface.FALLE;
						}
						// 6
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.SECHS){ 
							spielfeld[level][raum][spalte][reihe]=Interface.FIGUR;
							if (counter==0){
							setCheckpoint(level*2,level,raum,spalte,reihe);
							counter=counter-Interface.DREI;
							}
							counter++;
							setStartpunkt((level*Interface.DREI)+raum,spalte,reihe);
						}
						// 7
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.SIEBEN){ 
							spielfeld[level][raum][spalte][reihe]=Interface.SIEG;
						}
						// 8
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.ACHT){ 
							spielfeld[level][raum][spalte][reihe]=Interface.CHECKPOINT;
							setCheckpoint(level*2+1,level,raum,spalte,reihe);
						}
						// 9
						else if (testChar-Interface.ACHTUNDVIERZIG == Interface.NEUN){ 
							spielfeld[level][raum][spalte][reihe]=Interface.STORYTELLER;
						}
						// $
						else if (testChar == Interface.SECHSUNDDREISSIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.MUENZEN;
						}
						// S
						else if (testChar == Interface.DREIUNDACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP1; 
						}
						// O
						else if (testChar == Interface.NEUNUNDSIEBZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP2; 
						}
						// P
						else if (testChar == Interface.ACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.SHOP3; 
						}
						// H
						else if (testChar == Interface.ZWEIUNDSIEBZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.HPTRANKSHOP; 
						}
						// M
						else if (testChar == Interface.SIEBENUNDSIEBZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.MANATRANKSHOP; 
						}
						// G
						else if (testChar == Interface.EINUNDSIEBZIG){  
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEGELB;
						}
						 // R
						else if (testChar == Interface.ZWEIUNDACHZIG){
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEROT;
						}
						// B
						else if (testChar == Interface.SECHSUNDSECHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.FARBEBLAU;
						}
						// X
						else if (testChar == Interface.ACHTUNDACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=BEIZIEL;
							setZielpunkt((level*Interface.DREI)+raum,spalte,reihe);
						}
						// Y
						else if (testChar == Interface.NEUNUNDACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=BEICHECKPOINT;
						}
						// +
						else if (testChar == Interface.DREIUNDVIERZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.HPTRANK;
						}
						// *
						else if (testChar == Interface.ZWEIUNDVIERZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.MANATRANK;
						}
						// <
						else if (testChar == Interface.SECHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS1;
						}
						// =
						else if (testChar == Interface.EINUNDSECHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS2;
						}
						// >
						else if (testChar == Interface.ZWEIUNDSECHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.BOSS3;
						}
						// p
						else if (testChar == Interface.EINHUNDERTZWOELF){ 
							spielfeld[level][raum][spalte][reihe]=Interface.SCHLUESSEL;
						}
						// T
						else if (testChar == Interface.VIERUNDACHZIG){ 
							spielfeld[level][raum][spalte][reihe]=Interface.TOR;
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
			StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT, "FileNException");
		}
		catch(IOException e){
			StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT, "IOException");
		}
		catch(Exception e){
			fehlerGefunden = true;
			if (exception == FALSCHESZEICHEN){
				StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT, 
						"Ung�ltiges Zeichen. "+(level+1)+"-"+(raum+1)+"::"+(spalte+1)+","+(reihe+1));
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTFUENFZIG, "F�r genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINLEERZEICHEN){
				StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT,
						"Kein Leerzeichen vor "+(level+1)+"-"+(raum+1)+"::"+(spalte+1)+","+(reihe+1));
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTFUENFZIG, "F�r genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINZEILENUMBRUCH){
				StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT, 
						"Kein Zeilenumbruch vor "+(level+1)+"-"+(raum+1)+":: Reihe"+(reihe+1));
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTACHZIG,
						"oder zus�tzliches Zeichen am vohrigen Reihenende");
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTFUENFZIG, "F�r genaue Level-Regeln levelReadme lesen");
			}
			else if(exception == KEINELEERZEILE){
				StdDraw.text(Interface.VIERHUNDERT,Interface.FUENFHUNDERT, "Fehlende Leerzeile vor "+(level+1)+"-"+(raum+1));
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTACHZIG, 
						"oder zus�tzliches Zeichen am vohrigen Reihenende");
				StdDraw.text(Interface.VIERHUNDERT,Interface.VIERHUNDERTFUENFZIG, "F�r genaue Level-Regeln levelReadme lesen");
			}

		}
		return fehlerGefunden;
	}

/**
 * setzt einen Checkpoint an die entsprechende Stelle
 * @param newCheckpoint Nummer des neuen Checkpoints
 * @param level Level in dem der Checkpoint gesetzt wird
 * @param raum Raum in dem der Checkpoint gesetzt wird
 * @param x x-Koordinate der Position des Checkpoints
 * @param y y-Koordinate der Position des Checkpoints
 */
public static void setCheckpoint(int newCheckpoint, int level, int raum, int x, int y){
	checkpoint[newCheckpoint][0]=level;
	checkpoint[newCheckpoint][1]=raum;
	checkpoint[newCheckpoint][2]=x;
	checkpoint[newCheckpoint][Interface.DREI]=y;
}

/**
 * gibt den aktuellen Checkpoint zurueck
 * @param aktiveCheckpoint zuletzt erreichter Checkpoint
 * @return aktueller Checkpoint
 */
public static int[] getCheckpoint(int aktiveCheckpoint){
	checkpointReturn = checkpoint[aktiveCheckpoint];
	return checkpointReturn;
}
/**
 * setzt Startpunkt 
 * @param newStartpunkt "Nummer" des Startpunkts
 * @param x x-Koordinate des Startpunkts
 * @param y y-Koordinate des Startpunkts
 */
public static void setStartpunkt(int newStartpunkt,int x,int y){
	startpunkt[newStartpunkt][0]=x;
	startpunkt[newStartpunkt][1]=y;
}

/**
 * gibt Startpunkt des aktuellen Levels zurueck
 * @param level aktuelles Level
 * @param raum aktueller Raum 
 * @return Startpunkt
 */
public static int[] getStartpunkt(int level, int raum){
	startpunktReturn = startpunkt[level*Interface.DREI+raum];
	return startpunktReturn;
}

/**
 * setzt Zielpunkt
 * @param newzielpunkt "Nummer" des Zielpunkts
 * @param x x-Koordinate des Zielpunkts
 * @param y y-Koordinate des Zielpunkts
 */
public static void setZielpunkt(int newzielpunkt,int x,int y){
	zielpunkt[newzielpunkt][0]=x;
	zielpunkt[newzielpunkt][1]=y;
}
/**
 * gibt Zielpunkt des aktuellen Levels zurueck
 * @param level aktuelles Level
 * @param raum Aktueller Raum
 * @return Zielpunkt
 */
public static int[] getZielpunkt(int level, int raum){
	zielpunktReturn = zielpunkt[level*Interface.DREI+raum];
	return zielpunktReturn;
}

/**
 * Spielfeldeigenschaft Wert des Feldes XY abfragen
 * @param level Level des Spiels
 * @param x X-Koordinate
 * @param y Y-Koordinate
 * @param raum Raum des Spiels
 * @return RETURN
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
 * @param raum Raum des Spiels
 * 
 */
public static void wertSetzenBeiXY (int level,int raum, int x, int y, int wert) {
	
	spielfeld[level][raum][x][y] = wert;
}



}

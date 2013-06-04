import javax.swing.JLabel;
import java.io.*;
//import java.StdOut;

/**
 * Klassenkommentar:
 * Generierung des Spielfelds auf logischer Ebene
 * 
 */
public class Spielfeld {
//hauptarray fuers spielfeld sotiert nach [level][spalte][reihe] (mehr dimensionen=mehr spass)
private static int[][][][] spielfeld = new int [3][3][20][15];
private int level;
private int raum;
private int reihe;
private int spalte;
private int testChar;

private FileReader fr;
private BufferedReader br;

/**
 * ordnet dem Spielfeld-Array Werte für Mauern, Boden, Start, Ziel, Fallen und Spielfigur zu
 *
 */
public Spielfeld() {
	try{
	    
		fr = new FileReader("src/level.txt");
		br = new BufferedReader(fr);
		for (level=0; level<3; level++) {
			br.skip(4);
			for (raum=0; raum<3; raum++) {
			br.skip(2);
			for (reihe=14; reihe>=0; reihe--) {
				br.skip(1);
					for (spalte=0; spalte<20; spalte++) {
						br.skip(1);
						testChar = br.read();
						if (testChar-48 == 1){
							spielfeld[level][raum][spalte][reihe]=Main.MAUER;
						}
						else if (testChar-48 ==0){
							spielfeld[level][raum][spalte][reihe]=Main.BODEN;	
						}
						else if (testChar-48 ==2){
							spielfeld[level][raum][spalte][reihe]=Main.START;	
						}
						else if (testChar-48 ==3){
							spielfeld[level][raum][spalte][reihe]=Main.ZIEL;
						}
						else if (testChar-48 == 5){
							spielfeld[level][raum][spalte][reihe]=Main.MOB;
						}
						else if (testChar-48 == 4){
							spielfeld[level][raum][spalte][reihe]=Main.FALLE;
						}
						else if (testChar-48 == 6){
							spielfeld[level][raum][spalte][reihe]=Main.FIGUR;
						}
						else if (testChar-48 == 7){
							spielfeld[level][raum][spalte][reihe]=Main.SIEG;
						}
						else if (testChar-48 == 8){
							spielfeld[level][raum][spalte][reihe]=Main.CHECKPOINT;
						}
						else if (testChar-48 == 9){
							spielfeld[level][raum][spalte][reihe]=Main.STORYTELLER;
						}
						else if (testChar == 71){
							spielfeld[level][raum][spalte][reihe]=Main.FARBEGELB;
						}
						else if (testChar == 82){
							spielfeld[level][raum][spalte][reihe]=Main.FARBEROT;
						}
						else if (testChar == 66){
							spielfeld[level][raum][spalte][reihe]=Main.FARBEBLAU;
						}
						else if (testChar == 88){
							spielfeld[level][raum][spalte][reihe]=13;
						}
						
				}
			}
			}
		}
		}
		catch(FileNotFoundException e){
			spielfeld[0][0][1][2]=Main.FARBEBLAU;
		}
		catch(IOException e){
			spielfeld[0][0][5][6]=Main.FARBEROT;
		}
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
	
	if (spielfeld[0][0][10][10] == Main.STORYTELLER){
		System.out.println("Hey du! Warte mal! Keine Angst, ich will dir nur helfen... \nDu bist nicht der erste Abenteurer hier auf dem Weg. Aber in dir sehe ich Potential diese Hoelle zu durchstehen... \nFrueher war dies ein friedliches Plaetzchen, aber dann kamen die Trolle und legten Fallen aus... und das nur, um ihr Essen besser wuerzen zu koennen! \nSiehst du sie dort unten...? Pass auf, komm ihnen nicht zu nahe!");
	}
	else if (spielfeld[0][2][11][13] == Main.STORYTELLER){
		System.out.println("Da bist du ja schon! Pass auf, direkt neben mir steht die beste Erfindung, seitdem die fiesen Trolle es hier runter geschafft haben. Diese rote Flagge da ist ein CHECKPOINT! Wenn du sie beruehrst und im weiteren Verlauf deines Abenteuers stirbst, wirst du hier wiederbelebt werden. Und, habe ich zu viel versprochen? Die Idee ist ja wohl genial!");
	}
	else if (spielfeld[0][3][16][7] == Main.STORYTELLER){
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

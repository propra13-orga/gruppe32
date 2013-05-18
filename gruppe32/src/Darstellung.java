
/**
*
*Klassenkommentar:
*Umsetzung der in Spielfeld generierten Logik auf grafischer Ebene 
*
*/
public class Darstellung{
	static int spalte;
	static int reihe;

	/**
	 * Methodenkommentar:
	 * hinterlegt jedem Feld des Arrays die passende Graphik
	 *
	 */
	public static void levelDarstellen(int level) {
		//stellt StdDraw auf eine besser handhabbare skala um
		StdDraw.setXscale(0.0,800);
		StdDraw.setYscale(0,600);
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				// stellt an allen orten das dem wert entsprechende bild dar
				if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==0){
					StdDraw.picture(20+40*spalte,20+40*reihe, "boden.jpg"); 
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==1){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mauer.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==2){
					StdDraw.picture(20+40*spalte,20+40*reihe, "start.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==3){
					StdDraw.picture(20+40*spalte,20+40*reihe, "ziel.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==4){
					StdDraw.picture(20+40*spalte,20+40*reihe, "falle.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==5){
					StdDraw.picture(20+40*spalte,20+40*reihe, "mob.jpg");
				}
				else if (Spielfeld.wertLesenBeiXY(level,spalte,reihe)==6){
					StdDraw.picture(20+40*spalte,20+40*reihe, "spielfigur.jpg");
					Aktion.setFigurXY(spalte, reihe);
				}
			}
		}
	}
	
	
	/**
	 * Methodenkommentar:
	 * Stellt die figur an den neuen koordinaten dar, und ueberschreibt sie am ausgangspunkt
	 * 
	 */
	public static void figurBewegen(int level, int vonX, int vonY, int nachX, int nachY ){
		
		Spielfeld.wertSetzenBeiXY(level, vonX, vonY, 0);
		StdDraw.picture(20+40*vonX,20+40*vonY, "boden.jpg");
		
		Spielfeld.wertSetzenBeiXY(level, nachX, nachY, 6);
		StdDraw.picture(20+40*nachX,20+40*nachY+1, "figur.jpg");
		
	}
	
}
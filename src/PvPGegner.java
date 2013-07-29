/**
 * Klasse zur speicherung und verarbeitung der Gegnerwerte im PvP
 * 
 */
public class PvPGegner{
	
	
	private static double schaden;
	private static double aktuelleHP=10;
	private static double ruestung;
	private static int aktuelleFarbe;
	private static int x;
	private static int y;
	private static boolean schild;
	
	/**
	 * gibt bin aktuellen schaden aus
	 * @return
	 */
	public static double getSchaden(){
		return schaden;
	}
	
	/**
	 * gibt den aktuellen x-wert aus
	 * @return
	 */
	public static int getX(){
		return x;
	}
	
	/**
	 * gibt den aktuellen Y wert aus
	 * @return
	 */
	public static int getY(){
		return y;
	}
	
	/**
	 * gibt aus ob schild aktiv ist
	 * @return
	 */
	public static boolean getSchild(){
		return schild;
	}
	
	/**
	 * gibt die aktuelle farbe aus
	 * @return
	 */
	public static int getFarbe(){
		return aktuelleFarbe;
	}
	
	/**
	 * gibt die aktuellen HP aus
	 * @return
	 */
	public static double getHP(){
		return aktuelleHP;
	}
	
	/**
	 * setzt den x und y wert auf newX und newY
	 * @param newX neuer x wert
	 * @param newY neuer Y wert
	 */
	public static void setXY(int newX,int newY){
		x=newX;
		y=newY;
		Spielfeld.setPvPWertBeiXY(newX,newY,Interface.BEIZIEL);
	}
	
	/**
	 * setzt die aktuellen hp auf newHP
	 * @param newHP neuer HP wert
	 */
	public static void setHP(double newHP){
		aktuelleHP=newHP;
	}
	
	/**
	 * setzt den aktuellen schaden auf newSchaden
	 * @param newSchaden neuer schadenswert
	 */
	public static void setSchaden(double newSchaden){
		schaden=newSchaden;
	}
	
	/**
	 * setzt das schild auf aktiv/nicht aktiv
	 * @param newSchild aktiv-boolean
	 */
	public static void setSchild(boolean newSchild){
		schild=newSchild;
		PvPDisplay.gegnerDarstellen(x, y);
	}
	
	/**
	 * setzt die farbe auf newFarbe
	 * @param newFarbe neue Farbe
	 */
	public static void setFarbe(int newFarbe){
		aktuelleFarbe=newFarbe;
	}
	
	/**
	 * setzt die ruestung auf newRuestung
	 * @param newRuestung neuer ruestungswert
	 */
	public static void setRuestung(double newRuestung){
		ruestung=newRuestung;
	}
	
	/**
	 * lässt den gegneer schaden bekommen
	 * @param incSchaden schadenszahl
	 */
	public static void schadenBekommen(double incSchaden){
		if(schild==false){
			aktuelleHP =  Math.round((aktuelleHP-(incSchaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			
			}
		else{
			schild=false;
		}
		PvPDisplay.gegnerDarstellen(x, y);
	}
	
	/**
	 * bewegt den spieler nach newX,newY
	 * @param newX neuer x wert
	 * @param newY neuer y wert
	 */
	public static void moveTo(int newX,int newY){
		Spielfeld.setPvPWertBeiXY(x,y,Interface.BODEN);
		Spielfeld.setPvPWertBeiXY(newX,newY,Interface.BEIZIEL);
		PvPDisplay.figurBewegen(x, y, newX, newY, false);
		x=newX;
		y=newY;
		
	}
	
}
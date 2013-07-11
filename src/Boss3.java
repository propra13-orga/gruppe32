
/**
 * 
 * Objekt vom Typ Boss3 (Endgegner) 
 *
 */
public class Boss3{
	
	/**
	 * Werte fuer HP, Schaden und Ruestung
	 */
	private static final int DEFAULTHP=40;
	private static final int DEFAULTSCHADEN=2;
	private static final int RUESTUNG= 0;

	private double hp;
	private int x;
	private int y;
	
	
	private StatDisplay stats = new StatDisplay();
	
	
	/**
	 * Erstellt Objekt vom Typ Boss3
	 * @param newX x-Koordinate des Bosses
	 * @param newY y-Koordinate des Bosses
	 */
	public Boss3(int newX, int newY){
		x=newX;
		y=newY;
		hp=DEFAULTHP;
		stats.displayGegnerHP(hp, DEFAULTHP, x, y);

		
	}
	
	/**
	 * reduziert Lebenspunkte des Bosses
	 * lässt Gegner sterben, wenn keine Lebenspunkte mehr vorhanden sind
	 * @param schaden Hoehe des Schadens den man anrichten kann
	 */
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((Interface.EINHUNDERT-RUESTUNG)/Interface.EINHUNDERT)))
				*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		stats.displayGegnerHP(hp, DEFAULTHP, x, y);
		if (hp<=0){
			sterben();
		}
	}
	
	/**
	 * blendet Bild 'Gewonnen' ein
	 * Spieler erhaelt 500 Erfahrungspunkte
	 * Aufwertung Fertigkeitenbaum
	 */
	public void sterben(){
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.SIEG);
		StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.SIEGIMG);
		
		// Spieler.erfahrungspunkteSammeln(500);
		if (Spieler.aktuelleErfahrungspunkte > 800){
			//Fertigkeitenbaum
		}
	}
	
	/**
	 * 
	 * @return gibt urspruenglichen Schaden zurueck
	 */
	
	public double getSchaden(){
		return DEFAULTSCHADEN;
	}
	
	
	
	
}
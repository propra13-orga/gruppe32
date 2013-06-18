import java.lang.Math;

public class Boss3{
	
	private static final int DEFAULTHP=40;
	private static final int DEFAULTSCHADEN=2;
	private static final int RUESTUNG= 0;
	
	private double hp;
	private int x;
	private int y;
	
	
	private StatDisplay stats = new StatDisplay();
	
	
	public Boss3(int newX, int newY){
		x=newX;
		y=newY;
		hp=DEFAULTHP;
		stats.displayGegnerHP(hp, DEFAULTHP, x, y);

		
	}
	
	/**
	 * reduziert hp des Bosses
	 * ruft Methode sterben() auf, wenn kein hp mehr vorhanden ist
	 * @param schaden
	 */
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((100-RUESTUNG)/100)))*100.0)/100.0;
		stats.displayGegnerHP(hp, DEFAULTHP, x, y);
		if (hp<=0){
			sterben();
		}
	}
	
	/**
	 * blendet Bild 'Gewonnen' ein
	 */
	public void sterben(){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.SIEG);
			StdDraw.picture(20+40*x,20+40*y, Interface.SIEGIMG);
		
	}
	
	public double getSchaden(){
		return DEFAULTSCHADEN;
	}
	
	
	
	
}
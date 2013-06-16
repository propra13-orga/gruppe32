import java.lang.Math;


public class Gegner{

	private double defaultHP;
	private double hp;
	private int ruestung;
	private int schaden = 1;
	private int x;
	private int y;
	private int richtung;
	private int id;
	private Aktion aktion;
	
	
	public Gegner(int startDefaultHP, int startX, int startY, int startRichtung, int startRuestung, int startSchaden, int newID){
		
		defaultHP= startDefaultHP;
		hp = defaultHP;
		x = startX;
		y= startY;
		schaden = startSchaden;
		ruestung = startRuestung;
		richtung = startRichtung;
		id = newID;
		aktion = new Aktion(false, id);
		
	}
	
	public void bewegen(){
		int[] bewegungsReturn = aktion.figurBewegen(richtung,x,y,0,false);
		
		if((bewegungsReturn[0]==Interface.MAUER)){
			if (richtung == Interface.OBEN){
				richtung = Interface.UNTEN;
				aktion.displayGegner(x,y,richtung);
			}
			else if (richtung == Interface.LINKS){
				richtung = Interface.RECHTS;
				aktion.displayGegner(x,y,richtung);
			}
			else if (richtung == Interface.UNTEN){
				richtung = Interface.OBEN;
				aktion.displayGegner(x,y,richtung);
			}
			else if (richtung == Interface.RECHTS){
				richtung = Interface.LINKS;
				aktion.displayGegner(x,y,richtung);
			}
		}
		
		x=bewegungsReturn[1];
		y=bewegungsReturn[2];
	}
	
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((100-ruestung)/100)))*100.0)/100.0;
	}
	
	public void setXY(int newX, int newY){
		x= newX;
		y= newY;
	}
	
	public int getRichtung(){
		return richtung;
	}
	public double getHP(){
		return hp;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public double getSchaden(){
		return schaden;
	}
	
	
}
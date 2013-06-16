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
	private int[] attackReturn = new int[3];
	private boolean lebendig;
	private double loot;
	
	private StatDisplay stats = new StatDisplay();
	
	
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
		lebendig = true;
		
		
	}
	
	public int[] bewegen(){
		attackReturn[0]=0;
		if (lebendig==true){	
			int[] aktionReturn = aktion.figurBewegen(richtung,x,y,0,false);
			
			x=aktionReturn[1];
			y=aktionReturn[2];
			if((aktionReturn[0]==Interface.MAUER)){
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
			else if(aktionReturn[0]==Interface.FIGUR){
				attackReturn[0]=1;
				attackReturn[1]=aktionReturn[3];
				attackReturn[2]=aktionReturn[4];
			
			}
				stats.displayGegnerHP(hp, defaultHP, x, y);
		}
		
		return attackReturn;
	}
	
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((100-ruestung)/100)))*100.0)/100.0;
		stats.displayGegnerHP(hp, defaultHP, x, y);
		if (hp<=0){
			sterben();
		}
	}
	public void sterben(){
		lebendig=false;
		loot=Math.random();
		if (loot<0.33){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.HPTRANK);
			StdDraw.picture(20+40*x,20+40*y, Interface.HPTRANKIMG);
		}
		else if (loot<0.66){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MANATRANK);
			StdDraw.picture(20+40*x,20+40*y, Interface.MANATRANKIMG);
		}
		else{
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MUENZEN);
			StdDraw.picture(20+40*x,20+40*y, Interface.MUENZENIMG);
		}
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
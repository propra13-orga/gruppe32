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
	private int type;
	private double rndHelp;
	
	private StatDisplay stats = new StatDisplay();
	
	
	/**
	 * setzt Eigenschaften der Gegner
	 * @param startDefaultHP
	 * @param startX
	 * @param startY
	 * @param startRichtung
	 * @param startRuestung
	 * @param startSchaden
	 * @param newID
	 * @param newType
	 */
	public Gegner(int startDefaultHP, int startX, int startY, int startRichtung, int startRuestung, int startSchaden, int newID, int newType){
		
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
		stats.displayGegnerHP(hp, defaultHP, x, y);
		type=newType;
	}
	
	/** bewegt Gegner abhaengig von Richtung des Players bzw. zufaellig (Boss2)
	 * 
	 * @return
	 */
	public int[] bewegen(){
		attackReturn[0]=0;
		if (lebendig==true){	
			if(type==Interface.BOSS2){
				randomRichtung();
			}
			int[] aktionReturn = aktion.figurBewegen(richtung,x,y,0,false,type);
			
			x=aktionReturn[1];
			y=aktionReturn[2];
			if((aktionReturn[0]==Interface.MAUER)){
				if (richtung == Interface.OBEN){
					richtung = Interface.UNTEN;
					aktion.displayGegner(x,y,richtung,type);
				}
				else if (richtung == Interface.LINKS){
					richtung = Interface.RECHTS;
					aktion.displayGegner(x,y,richtung,type);
				}
				else if (richtung == Interface.UNTEN){
					richtung = Interface.OBEN;
					aktion.displayGegner(x,y,richtung,type);
				}
				else if (richtung == Interface.RECHTS){
					richtung = Interface.LINKS;
					aktion.displayGegner(x,y,richtung,type);
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
	
	/**
	 * setzt hp der Gegner herunter, abhaengig von der aktuellen Ruestung des Players
	 * falls hp <=0 ist wird Methode sterben aufgerufen
	 * @param schaden
	 */
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((100-ruestung)/100)))*100.0)/100.0;
		stats.displayGegnerHP(hp, defaultHP, x, y);
		if (hp<=0){
			sterben();
		}
	}
	/**
	 * Boolean lebendig wird auf false gesetzt
	 * erstellt Zufallszahl aus dem Intervall [0,1]
	 * anstelle des Gegners erscheint (abhaengig von der Zufallszahl) ein Manatrank, HPTrank oder eine Muenze
	 */
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
	
	/**
	 * gibt Richtung zurueck
	 * @return
	 */
	public int getRichtung(){
		return richtung;
	}
	
	/**
	 * gibt HP zurueck
	 * @return
	 */
	public double getHP(){
		return hp;
	}
	
	/**
	 * gibt x-Koordinate zurueck
	 * @return
	 */
	public int getX(){
		return x;
	}
	/**
	 * gibt y-Koordinate zurueck
	 * @return
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * gibt Schaden zurueck
	 * @return
	 */
	public double getSchaden(){
		return schaden;
	}
	
	/**
	 * erzeugt Zufallszahl im Intervall [0,1]
	 * abhaengig von dieser wird eine 'zufaellige' Richtung zugewiesen
	 */
	public void randomRichtung(){
		rndHelp=Math.random();
		if (rndHelp<0.25){
			richtung = Interface.LINKS;
		}
		else if (rndHelp<0.50){
			richtung = Interface.RECHTS;
		}
		else if (rndHelp<0.75){
			richtung = Interface.OBEN;
		}
		else{
			richtung = Interface.UNTEN;
		}
	}
	
	
}
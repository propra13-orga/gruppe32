
/**
 * 
 * erstellt Objekt vom Typ Gegner
 *
 */
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
	 * @param startX x-Koordinate der Startposition
	 * @param startY y-Koordinate der Startposition
	 * @param startRichtung Richtung, in die der Gegner ausgerichtet ist
	 * @param startRuestung Ruestung die der Gegner zu Beginn hat
	 * @param startSchaden Schaden, den der Gegner von Beginn an hat
	 * @param newID Neue ID 
	 * @param newType Neuer Typ
	 */
	public Gegner(int startDefaultHP, int startX, int startY, int startRichtung, int startRuestung,
			int startSchaden, int newID, int newType){
		
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
	 * @return Return
	 */
	public int[] bewegen(){
		attackReturn[0]=0;
		if (lebendig){
			if(type==Interface.BOSS2){
				randomRichtung();
			}
			int[] aktionReturn = aktion.figurBewegen(richtung,x,y,0,false,type);
			
			x=aktionReturn[1];
			y=aktionReturn[2];
			if(aktionReturn[0]==Interface.MAUER){
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
				attackReturn[1]=aktionReturn[Interface.DREI];
				attackReturn[2]=aktionReturn[Interface.VIER];
			
			}
				stats.displayGegnerHP(hp, defaultHP, x, y);
		}
		
		return attackReturn;
	}
	
	/**
	 * setzt Lebenspunkte der Gegner herunter, abhaengig von der aktuellen Ruestung des Spielers
	 * falls Lebenspunkte aufgebraucht sind, wird Methode sterben aufgerufen
	 * @param schaden Schaden den der Gegner erleidet
	 */
	public void schadenBekommen(double schaden){
		hp = Math.round((hp-(schaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
				*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		stats.displayGegnerHP(hp, defaultHP, x, y);
		if (hp<=0){
			sterben();
		}
	}
	/**
	 * Gegner stirbt, anstelle des Gegners erscheint ein Manatrank, HPTrank oder eine Muenze
	 *  
	 */
	public void sterben(){
		lebendig=false;
		loot=Math.random();
		if ((Interface.level==1)&(Interface.raum==0)&(loot<Interface.ZUFALL3)){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.SCHLUESSEL);
			StdDraw.picture(Interface.ZWANZIG+Interface.VIERZIG*x,Interface.ZWANZIG+Interface.VIERZIG*y, Interface.SCHLUESSELIMG);
		}
		else{
			if (loot<Interface.ZUFALL1){
				Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.HPTRANK);
				StdDraw.picture(Interface.ZWANZIG+Interface.VIERZIG*x,Interface.ZWANZIG+Interface.VIERZIG*y, Interface.HPTRANKIMG);
			}
			else if (loot<Interface.ZUFALL2){
				Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MANATRANK);
				StdDraw.picture(Interface.ZWANZIG+Interface.VIERZIG*x,Interface.ZWANZIG+Interface.VIERZIG*y, Interface.MANATRANKIMG);
			}
			else{
				Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MUENZEN);
				StdDraw.picture(Interface.ZWANZIG+Interface.VIERZIG*x,Interface.ZWANZIG+Interface.VIERZIG*y, Interface.MUENZENIMG);
			}
		}
	}
	
	/** 
	 * setzt Position 
	 * @param newX aktuelle x-Koordinate
	 * @param newY aktuelle y-Koordinate
	 */
	public void setXY(int newX, int newY){
		x= newX;
		y= newY;
	}
	
	/**
	 * gibt Richtung vom Gegner zurueck
	 * @return Richtung vom Gegner
	 */
	public int getRichtung(){
		return richtung;
	}
	
	/**
	 * gibt Lebenspunkte des Gegners zurueck
	 * @return Lebenspunkte des Gegners(HP)
	 */
	public double getHP(){
		return hp;
	}
	
	/**
	 * gibt x-Koordinate zurueck
	 * @return x-Koordinate
	 */
	public int getX(){
		return x;
	}
	/**
	 * gibt y-Koordinate zurueck
	 * @return y-Koordinate
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * gibt Schaden zurueck
	 * @return Schaden
	 */
	public double getSchaden(){
		return schaden;
	}
	
	/**
	 *
	 * Dem Gegner wird Bewegungsrichtung zugewiesen
	 * 
	 */
	public void randomRichtung(){
		rndHelp=Math.random();
		if (rndHelp<Interface.VIERTEL){
			richtung = Interface.LINKS;
		}
		else if (rndHelp<Interface.HALBES){
			richtung = Interface.RECHTS;
		}
		else if (rndHelp<Interface.DREIVIERTEL){
			richtung = Interface.OBEN;
		}
		else{
			richtung = Interface.UNTEN;
		}
	}
	
	
}



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
		aktion = new Aktion(id);
		
	}
	
	public void gegnerBewegen(){
		int[] bewegungsReturn = aktion.figurBewegen(richtung);
		
		if(bewegungsReturn[0]==Main.FIGUR){
			//muss bei Interface rein
			public void gegnerSchlag(int gegnerID, int zielX, int zielY){
				player[getPlayerID(zielX,zielY)].schadenBekommen(gegner[gegnerID].getSchaden);
			}
			public void playerSchlag(int playerID, int zielX, int zielY){
				gegner[getGegnerID(zielX,zielY)].schadenBekommen(player[playerID].getSchaden);
			}
			
			public int getPlayerID(int x,int y){
				for (counter=0; counter++; counter<spielerZahl){
					if ((player[counter].getX == x)
						|(player[counter].getY == y)){
						return counter;
					}
				}
			}
			public int getGegnerID(int x,int y){
				for (counter=0; counter++; counter<gegnerZahl){
					if ((gegner[counter].getX == x)
						|(gegner[counter].getY == y)){
						return counter;
					}
				}
			}
			public void gegnerDarstelen(int id, int x, int y, int richtung)
			
			
		}
		else{
			if (richtung == Main.OBEN){
				richtung = Main.UNTEN;
			}
			else if (richtung == Main.LINKS){
				richtung = Main.RECHTS;
			}
			else if (richtung == Main.UNTEN){
				richtung = Main.OBEN;
			}
			else if (richtung == Main.RECHTS){
				richtung = Main.LINKS;
			}
			
		}
		
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
	
	
}
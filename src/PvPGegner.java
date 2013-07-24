public class PvPGegner{
	
	
	private static double schaden;
	private static double aktuelleHP;
	private static double ruestung;
	private static int aktuelleFarbe;
	private static int x;
	private static int y;
	private static boolean schild;
	
	public static double getSchaden(){
		return schaden;
	}
	public static int getX(){
		return x;
	}
	public static int getY(){
		return y;
	}
	public static boolean getSchild(){
		return schild;
	}
	public static int getFarbe(){
		return aktuelleFarbe;
	}
	public static double getHP(){
		return aktuelleHP;
	}
	public static void setXY(int newX,int newY){
		x=newX;
		y=newY;
	}
	public static void setSchaden(double newSchaden){
		schaden=newSchaden;
	}
	public static void setSchild(boolean newSchild){
		schild=newSchild;
	}
	public static void setFarbe(int newFarbe){
		aktuelleFarbe=newFarbe;
	}
	public static void setRuestung(double newRuestung){
		ruestung=newRuestung;
	}
	
	public static void schadenBekommen(double incSchaden){
		if(schild==false){
			aktuelleHP = Math.round((aktuelleHP-(incSchaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			
			}
		else{
			schild=false;
		}
		PvPDisplay.gegnerDarstellen(x, y);
	}
	public static void moveTo(int newX,int newY){
		Spielfeld.setPvPWertBeiXY(x,y,Interface.BODEN);
		Spielfeld.setPvPWertBeiXY(newX,newY,Interface.FIGUR);
		PvPDisplay.figurBewegen(x, y, newX, newY, false);
		x=newX;
		y=newY;
		
	}
	
}
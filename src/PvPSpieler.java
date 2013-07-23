	
public class PvPSpieler{
	

	private static int leben;
	private static double manaFaktor;
	private static double schaden;
	private static double aktuellesMana;
	private static double aktuelleHP;
	private static double ruestung;
	private static int aktuelleFarbe;
	private static int x;
	private static int y;
	private static int schildAufladung;
	private static boolean schild;
	
	public static void bewegen(int richtung){
		
	}
	public static void schadenBekommen(int schaden){
		
	}
	public static void schadenHeilen(int heilung){
		
	}
	public static void manaVerbrauchen(int verbrauch){
		
	}
	public static void manaReg(int reg){
		
	}
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
public void setXY(int newX,int newY){
	x=newX;
	y=newY;
}
	
public void setFarbe(int farbe){
		
		if (farbe == Spieler.GELB){
			if (aktuelleFarbe == Spieler.BLAU){
				manaFaktor = Math.round(manaFaktor*Interface.EINEINHALB);
				ruestung = ruestung+Interface.DREISSIG;
			}
			else if (aktuelleFarbe == Spieler.ROT){
				schaden = schaden/Interface.EINEINHALB;
				ruestung = ruestung+Interface.PIC2;
			}
			aktuelleFarbe=Spieler.GELB;
		}
		else if (farbe == Spieler.BLAU){
			if (aktuelleFarbe == Spieler.GELB){
				ruestung = ruestung-Interface.DREISSIG;
				manaFaktor = Math.round((manaFaktor/Interface.EINEINHALB)
						*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			}
			else if (aktuelleFarbe == Spieler.ROT){
				schaden = schaden/Interface.EINEINHALB;
				manaFaktor = Math.round((manaFaktor/Interface.EINEINHALB)*(double)Interface.EINHUNDERT)/
						(double)Interface.EINHUNDERT;
				ruestung = ruestung+Interface.ZEHN;
			}
			aktuelleFarbe=Spieler.BLAU;
		}
		else if (farbe == Spieler.ROT){
			if (aktuelleFarbe == Spieler.BLAU){
				manaFaktor = Math.round(manaFaktor*Interface.EINEINHALB);
				schaden = schaden*Interface.EINEINHALB;
				ruestung = ruestung-Interface.ZEHN;
			}
			else if (aktuelleFarbe == Spieler.GELB){
				ruestung = ruestung-Interface.PIC2;
				schaden = schaden*Interface.EINEINHALB;
			}
			aktuelleFarbe=Spieler.ROT;
		}
	}
public void schildZauber(){
	if (schildAufladung <2&(aktuellesMana>=1)){
		manaVerbrauchen(1);
		schildAufladung = schildAufladung+1;
		schild = true ;
		
	}
}
	
}
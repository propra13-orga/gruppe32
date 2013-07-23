	
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
	private static boolean server;
	public static void bewegen(int richtung){
		
	}
	public static void schadenBekommen(double incSchaden){
		if(schild==false){
			aktuelleHP = Math.round((aktuelleHP-(incSchaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			if(aktuelleHP<=0){
				leben--;
				respawn();
			}
			}
		else{
			schild=false;
		}	
	}
	public static void schadenHeilen(int heilung){
		if ((aktuelleHP+heilung)<=10){
			aktuelleHP = Math.round((aktuelleHP+heilung)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuelleHP = 10;
		}
	}
	public static void manaVerbrauchen(int verbrauch){
		if ((aktuellesMana-(verbrauch*manaFaktor))>=0){
			aktuellesMana = Math.round((aktuellesMana-(verbrauch*manaFaktor))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = 0;
		}
	}
	public static void manaReg(int reg){
		if ((aktuellesMana+reg)<=10){
			aktuellesMana = Math.round((aktuellesMana+reg)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = 10;
		}
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
	public static double getHP(){
		return aktuelleHP;
	}
	public static double getMana(){
		return aktuellesMana;
	}
	public static double getRuestung(){
		return ruestung;
	}
	public static double getManafaktor(){
		return manaFaktor;
	}
	public static boolean getSchild(){
		return schild;
	}
	public static int getFarbe(){
		return aktuelleFarbe;
	}
	public static int getLeben(){
		return leben;
	}
	public static void setXY(int newX,int newY){
		x=newX;
		y=newY;
	}
		
	public static void setFarbe(int farbe){
			
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
	public static void schildZauber(){
		if (schild==false&(aktuellesMana>=1)){
			manaVerbrauchen(1);
			schild = true ;
			
		}
	}
	public static void respawn(){
	
			if(Spielfeld.getPvPWertBeiXY(1, 1)==Interface.BODEN){
				PvPDisplay.figurBewegen(x, y, 1, 1, true);
				Spielfeld.setPvPWertBeiXY(1,1,Interface.FIGUR);	
			}
			else{
				PvPDisplay.figurBewegen(x, y, 19, 14, true);
				Spielfeld.setPvPWertBeiXY(19,14,Interface.FIGUR);
		}		
		Spielfeld.setPvPWertBeiXY(x,y,Interface.BODEN);
	}
	
}
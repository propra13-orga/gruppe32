	
public class PvPSpieler{
	

	private static int leben;
	private static double manaFaktor = 1;
	private static double schaden;
	private static double aktuellesMana=10;
	private static double aktuelleHP=10;
	private static double ruestung = 20;
	private static int aktuelleFarbe = Interface.GELB;
	private static int x;
	private static int y;
	private static boolean schild;
	public static void bewegen(int richtung){
		
	}
	public static void schadenBekommen(double incSchaden){
		if(schild==false){
			aktuelleHP = Math.round((aktuelleHP-(incSchaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			if(aktuelleHP<=0){
				leben--;
				if (leben<1){
					PvPMain.loose();
				}
				else{
					respawn();
				}
			}
			}
		else{
			schild=false;
		}	
		PvPDisplay.displayPlayerStats();
	}
	public static void schadenHeilen(int heilung){
		if ((aktuelleHP+heilung)<=10){
			aktuelleHP = Math.round((aktuelleHP+heilung)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuelleHP = 10;
		}
		PvPDisplay.displayPlayerStats();
	}
	public static void manaVerbrauchen(int verbrauch){
		if ((aktuellesMana-(verbrauch*manaFaktor))>=0){
			aktuellesMana = Math.round((aktuellesMana-(verbrauch*manaFaktor))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = 0;
		}
		PvPDisplay.displayPlayerStats();
	}
	public static void manaReg(int reg){
		if ((aktuellesMana+reg)<=10){
			aktuellesMana = Math.round((aktuellesMana+reg)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = 10;
		}
		PvPDisplay.displayPlayerStats();
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
	public static int getSchildInt(){
		 if(schild){
			 return 1;
		 }
		 else{
			 return 0;
		 }
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
	public static void setLeben(int newLeben){
		leben=newLeben;
	}
	public static void setSchaden(double newSchaden){
		schaden=newSchaden;
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
			PvPDisplay.displayPlayerStats();
			PvPDisplay.spielerDarstellen(x, y);
		}
	public static void schildZauber(){
		if (schild==false&(aktuellesMana>=1)){
			manaVerbrauchen(1);
			schild = true ;
			PvPDisplay.spielerDarstellen(x, y);
		}
	}
	public static void respawn(){
		aktuelleHP=10;
		aktuellesMana=10;
			if(x>9){
				PvPDisplay.figurBewegen(x, y, 1, 1, true);
				Spielfeld.setPvPWertBeiXY(1,1,Interface.FIGUR);	
				x=1;
				y=1;
			}
			else{
				PvPDisplay.figurBewegen(x, y, 18, 11, true);
				Spielfeld.setPvPWertBeiXY(18,11,Interface.FIGUR);
				x=18;
				y=11;
		}		
		Spielfeld.setPvPWertBeiXY(x,y,Interface.BODEN);
		PvPDisplay.displayPlayerStats();
		PvPMain.transfer();
	}
	
}
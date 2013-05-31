public class Figur{
	
	public static final double MAXMANA = 10.0;
	public static final double MAXHP = 10.0;
	private static final double DEFAULTMANA = 5.0;
	private static final double DEFAULTHP = 5.0;
	private static final int GELB = 0;
	private static final int BLAU = 1;
	private static final int ROT = 2;
	private static final int DEFAULTFARBE = GELB;
	private static final double DEFAULTSCHADEN = 1;
	private static final double DEFAULTMANAFAKTOR=1;
	
	private static double manaFaktor;
	private static double schaden;
	private static double aktuellesMana;
	private static double aktuelleHP;
	private static double ruestung;
	private static int aktuelleFarbe;
	
	//public static int x;
	//public static int y;
	
	/*public static void setXY(int newX, int newY){
		x = newX;
		y = newY;
	}*/
	
	/*
	 * Methodenkommentar
	 * reduziert die aktuellenHP/mana um einen gegeben schadenswert
	 * 
	 */
	
	public static void schadenBekommen(double schaden){
		aktuelleHP = aktuelleHP-(schaden*((100-ruestung)/100));
		Menu.displayPlayerHP(aktuelleHP);
		if (aktuelleHP<=0){
			Menu.gameOver();
		}
	}
	public static void manaVerbrauchen(double verbrauch){
		if ((aktuellesMana-verbrauch)>=0){
			aktuellesMana = aktuellesMana-verbrauch;
		}
		else{
			aktuellesMana = 0;
		}
		Menu.displayPlayerMana(aktuellesMana);
	}
	/*
	 * Methodenkommentar
	 * erhöht die aktuellenHP/Mana um einen gegebenen wert
	 * 
	 */
	
	public static void heilen(double heilung){
		if ((aktuelleHP+heilung)<=MAXHP){
			aktuelleHP = aktuelleHP+heilung;
		}
		else{
			aktuelleHP = MAXHP;
		}
		Menu.displayPlayerHP(aktuelleHP);
	}
	public static void manaReg(double reg){
		if ((aktuellesMana+reg)<=MAXMANA){
			aktuellesMana = aktuellesMana+reg;
		}
		else{
			aktuellesMana = MAXMANA;
		}
		Menu.displayPlayerMana(aktuellesMana);
	}
	
	
	/*
	 * Methodenkommentar:
	 * setz alle werte auf die defaultwerte
	 * 
	 */
	
	public static void resetPlayerStats(){
		aktuelleHP=DEFAULTHP;
		aktuellesMana=DEFAULTMANA;
		aktuelleFarbe=DEFAULTFARBE;
		schaden=DEFAULTSCHADEN;
		manaFaktor=DEFAULTMANAFAKTOR;
	}
	
	/*
	 * Methodenkommentar:
	 * gibt die momentanen hp/mana aus
	 * 
	 */
	public static double getHP(){
		return aktuelleHP;
	}
	public static double getMana(){
		return aktuellesMana;
	}
	
	
	/*
	 * 
	 * Methodenkommentar:
	 *  
	 * 
	 */
	
	public static void setFarbe(int farbe){
		
		if (farbe == GELB){
			if (aktuelleFarbe == BLAU){
				manaFaktor = manaFaktor*1.5;
				ruestung = ruestung+30;
			}
			else if (aktuelleFarbe == ROT){
				schaden = schaden/1.5;
				ruestung = ruestung+40;
			}
			aktuelleFarbe=GELB;
		}
		else if (farbe == BLAU){
			if (aktuelleFarbe == GELB){
				ruestung = ruestung-30;
				manaFaktor = manaFaktor/1.5;
			}
			else if (aktuelleFarbe == ROT){
				schaden = schaden/1.5;
				manaFaktor = manaFaktor/1.5;
			}
			aktuelleFarbe=BLAU;
		}
		else if (farbe == ROT){
			if (aktuelleFarbe == BLAU){
				manaFaktor = manaFaktor*1.5;
				schaden = schaden*1.5;
			}
			else if (aktuelleFarbe == GELB){
				ruestung = ruestung-40;
				schaden = schaden*1.5;
			}
			aktuelleFarbe=ROT;
		}
		//Menu.dispalyPlayer;
	}
}
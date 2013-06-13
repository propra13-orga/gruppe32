import java.lang.Math;

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
	private static final int DEFAULTLEBEN=3;
	private static final int DEFAULTRUESTUNG = 20;
	private static final int DEFAULTMUENZEN = 0;
	private static final int DEFAULTSCHILDAUFLADUNG = 0;
	private static final int MAXSCHILD = 2;
	
	private static int leben;
	private static double manaFaktor;
	private static double schaden;
	private static double aktuellesMana;
	private static double aktuelleHP;
	private static double ruestung;
	private static int aktuelleMuenzen;
	private static int aktuelleFarbe;
	private static int schildAufladung;
	private static boolean schild;
	
	//public static int x;
	//public static int y;
	
	/*public static void setXY(int newX, int newY){
		x = newX;
		y = newY;
	}*/
	
	/**
	 * Methodenkommentar
	 * reduziert die aktuellenHP/mana um einen gegeben schadenswert
	 * 
	 */
	public static void schadenBekommen(double schaden){
		if (schildAufladung>0){
			schildAufladung--;
			if (schildAufladung<=0){
				schild=false;
				Menu.displayPlayer(aktuelleFarbe,Aktion.getFigurX(),Aktion.getFigurY());
			}
		}
		else {
			aktuelleHP = Math.round((aktuelleHP-(schaden*((100-ruestung)/100)))*100.0)/100.0;
			Menu.displayPlayerHP(aktuelleHP);
			if (aktuelleHP<=0){
				leben--;
				Aktion.zumCheckpoint();
				if (leben<=0){
					Menu.gameOver();
				}
				//Aktion.zumCheckpoint();
				//aktuelleHP=DEFAULTHP;
				//Menu.displayPlayerHP(aktuelleHP);
				//Menu.playerToCheckpoint();
			}
		Menu.displayPlayerStats();
		}
	}
	public static void manaVerbrauchen(double verbrauch){
		if ((aktuellesMana-(verbrauch*manaFaktor))>=0){
			aktuellesMana = Math.round((aktuellesMana-(verbrauch*manaFaktor))*100.0)/100.0;
		}
		else{
			aktuellesMana = 0;
		}
		Menu.displayPlayerMana(aktuellesMana);
	}
	
	
	/**
	 * Methodenkommentar:
	 * erhoeht die aktuellenHP/Mana um einen gegebenen wert
	 * 
	 */
	public static void heilen(double heilung){
		if ((aktuelleHP+heilung)<=MAXHP){
			aktuelleHP = Math.round((aktuelleHP+heilung)*100.0)/100.0;
		}
		else{
			aktuelleHP = MAXHP;
		}
		Menu.displayPlayerHP(aktuelleHP);
	}
	public static void manaReg(double reg){
		if ((aktuellesMana+reg)<=MAXMANA){
			aktuellesMana = Math.round((aktuellesMana+reg)*100.0)/100.0;
		}
		else{
			aktuellesMana = MAXMANA;
		}
		Menu.displayPlayerMana(aktuellesMana);
	}
	
	
	
	
	/**
	 * Methodenkommentar:
	 * Shop: Items erhoehen die aktuellenHP/Mana um einen gegebenen Wert
	 * 
	 */
	public static void shopHP(double heilung){
		if (((aktuelleHP+heilung)<=MAXHP)&(aktuelleMuenzen>0)){
			aktuelleHP = Math.round((aktuelleHP+heilung)*100.0)/100.0;
		}
		Menu.displayPlayerHP(aktuelleHP);
	}
	public static void shopMana(double reg){
		if (((aktuellesMana+reg)<=MAXMANA)&(aktuelleMuenzen>0)){
			aktuellesMana = Math.round((aktuellesMana+reg)*100.0)/100.0;
		}
		Menu.displayPlayerMana(aktuellesMana);
	}
	
	
	
	
	
	/**
	 * Muenzen einsammeln
	 * 
	 */
	public static void muenzenSammeln(int muenzen){
		aktuelleMuenzen = aktuelleMuenzen+muenzen;
		Menu.displayPlayerStats();
	}
	
	
	/**
	 * Muenzen verlieren
	 * 
	 */
	public static void muenzenVerlieren(int muenzen){
		if (aktuelleMuenzen > 0){
			aktuelleMuenzen = aktuelleMuenzen-muenzen;
			Menu.displayPlayerStats();
		}
	}
	
	

	
	/**
	 * Methodenkommentar:
	 * setz alle werte auf die defaultwerte
	 * 
	 */
	
	public static void resetPlayerStats(){
		aktuelleHP=DEFAULTHP;
		aktuellesMana=DEFAULTMANA;
		aktuelleMuenzen=DEFAULTMUENZEN;
		aktuelleFarbe=DEFAULTFARBE;
		schaden=DEFAULTSCHADEN;
		manaFaktor=DEFAULTMANAFAKTOR;
		leben = DEFAULTLEBEN;
		ruestung = DEFAULTRUESTUNG;
		schild = false;
		schildAufladung = DEFAULTSCHILDAUFLADUNG;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen hp aus
	 * 
	 */
	public static double getHP(){
		return aktuelleHP;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen mana aus
	 * 
	 */
	public static double getMana(){
		return aktuellesMana;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Anzahl an Muenzen aus
	 * 
	 */
	public static int getMuenzen(){
		return aktuelleMuenzen;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Farbe zurueck
	 * 
	 */
	public static int getFarbe(){
		return aktuelleFarbe;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Ruestungswert zurueck
	 * 
	 */
	public static double getRuestung(){
		return ruestung;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Manafaktor zurueck
	 * 
	 */
	public static double getManaFaktor(){
		return manaFaktor;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Schadensfaktor zurueck
	 * 
	 */
	public static double getSchaden(){
		return schaden;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen Lebensanzahl zurueck
	 * 
	 */
	public static int getLeben(){
		return leben;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Schildaufladung zurueck
	 * 
	 */
	public static int getSchild(){
		return schildAufladung;
	}
	
	/**
	 * Methodenkommentar:
	 * Booelan, ob Schild genutzt wird
	 * 
	 */
	public static boolean schildBool(){
		return schild;
	}
	
	/**
	 * Methodenkommentar:
	 * Booelan, ob Storytellerausgabe angezeigt wird
	 * 
	 */
	//public static boolean storytellerBool(){
	//	return false;
	//}
	
	
	
	/**
	 * 
	 * Methodenkommentar:
	 * stellt Mana, Schaden und Ruestung auf den entsprechenden Faktor der Farbe um 
	 *  
	 * 
	 */
	
	public static void setFarbe(int farbe){
		
		if (farbe == GELB){
			if (aktuelleFarbe == BLAU){
				manaFaktor = Math.round(manaFaktor*1.5);
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
				manaFaktor = Math.round((manaFaktor/1.5)*100.0)/100.0;
			}
			else if (aktuelleFarbe == ROT){
				schaden = schaden/1.5;
				manaFaktor = Math.round((manaFaktor/1.5)*100.0)/100.0;
				ruestung = ruestung+10;
			}
			aktuelleFarbe=BLAU;
		}
		else if (farbe == ROT){
			if (aktuelleFarbe == BLAU){
				manaFaktor = Math.round(manaFaktor*1.5);
				schaden = schaden*1.5;
				ruestung = ruestung-10;
			}
			else if (aktuelleFarbe == GELB){
				ruestung = ruestung-40;
				schaden = schaden*1.5;
			}
			aktuelleFarbe=ROT;
		}
		Menu.displayPlayer(aktuelleFarbe,Aktion.getFigurX(),Aktion.getFigurY());
		Menu.displayPlayerStats();
	}
	public static void resetHP(){
		aktuelleHP = DEFAULTHP;
	}
	public static void schildZauber(){
		if ((schildAufladung <MAXSCHILD)&(aktuellesMana>=1)){
			manaVerbrauchen(1);
			schildAufladung = schildAufladung+1;
			schild = true ;
			Menu.displayPlayer(aktuelleFarbe,Aktion.getFigurX(),Aktion.getFigurY());
			Menu.displayPlayerStats();
		}
	}
}
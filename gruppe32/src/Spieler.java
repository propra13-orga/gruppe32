import java.lang.Math;

public class Spieler{
	
	public static final double MAXMANA = 10.0;
	public static final double MAXHP = 10.0;
	private static final double DEFAULTMANA = 10.0;
	private static final double DEFAULTHP = 10.0;
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
	
	private int leben;
	private double manaFaktor;
	private double schaden;
	private double aktuellesMana;
	private double aktuelleHP;
	private double ruestung;
	private int aktuelleMuenzen;
	private int aktuelleFarbe;
	private int schildAufladung;
	private boolean schild;
	private int x;
	private int y;
	private Aktion aktion;
	private int[] checkArray = new int[3];
	private int[] attackReturn = new int[3];
	
	private boolean gestorben;
		
	private StatDisplay stats = new StatDisplay();
	
	private int id;
	private int bewegenReturn;
	
	public Spieler(int newId){
		id = newId;
		aktion = new Aktion(true, id);
		resetPlayerStats();
		gestorben = false;
		
	}
	
	//public static int x;
	//public static int y;
	
	/*public static void setXY(int newX, int newY){
		x = newX;
		y = newY;
	}*/
	
	public int bewegen(int richtung){
		checkArray = aktion.figurBewegen(richtung, x, y, aktuelleFarbe,schild);
		bewegenReturn = 0;
		if (checkArray[0]==Interface.CHECKPOINT){
			Interface.nextCheckpoint();
		}
		else if (checkArray[0]==Interface.MUENZEN){
			aktuelleMuenzen++;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
		}
		else if (checkArray[0]==Interface.MANATRANK){
			manaReg(1);
		
		}
		else if (checkArray[0]==Interface.HPTRANK){
			heilen(1);
		
		}
		else if (checkArray[0]==Interface.MANATRANKSHOP){
			if (aktuelleMuenzen>0){
				aktuelleMuenzen--;
				manaReg(1);
			}
			
		}
		else if (checkArray[0]==Interface.HPTRANKSHOP){
			if (aktuelleMuenzen>0){
				aktuelleMuenzen--;
				heilen(1);
			}
		}
		else if (checkArray[0]==Interface.FARBEGELB){
			setFarbe(Interface.GELB);
		}
		else if (checkArray[0]==Interface.FARBEROT){
			setFarbe(Interface.ROT);
		}
		else if (checkArray[0]==Interface.FARBEBLAU){
			setFarbe(Interface.BLAU);
		}
		else if (checkArray[0]==Interface.START){
			bewegenReturn=Interface.START;
		}
		else if (checkArray[0]==Interface.ZIEL){
			bewegenReturn=Interface.ZIEL;
		}else if (checkArray[0]==Interface.SIEG){
			bewegenReturn=Interface.SIEG;
			Interface.sieg();
		}
		else if (checkArray[0]==Interface.FALLE){
			if (schadenBekommen(5)==true){
				Interface.toCheckpoint=true;
			}
		}
		else if (checkArray[0]==Interface.MOB){
			sterben();
		}
		else if (checkArray[0]==Interface.BOSS3){
			sterben();
		}
		x=checkArray[1];
		y=checkArray[2];
		return bewegenReturn;
	}
	
	public void moveTo(int newX, int newY){
		aktion.playerNachXY(x, y, newX, newY, aktuelleFarbe, schild );
		x = newX;
		y = newY;
	}
	
	/**
	 * Methodenkommentar
	 * reduziert die aktuellenHP/mana um einen gegeben schadenswert
	 * 
	 */
	public boolean schadenBekommen(double incSchaden){
		gestorben = false;
		if (schildAufladung>0){
			schildAufladung--;
			if (schildAufladung<=0){
				schild=false;
				aktion.displayFigur(x,y,aktuelleFarbe,schild);
			}
		}
		else {
			aktuelleHP = Math.round((aktuelleHP-(incSchaden*((100-ruestung)/100)))*100.0)/100.0;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
			if (aktuelleHP<=0){
				leben--;
				if (leben<=0){
					Interface.gameOver();
				}
				else{
					Interface.toCheckpoint();
					gestorben = true;
				}
				aktuelleHP=DEFAULTHP;
				
				
			}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
		
		}
	return gestorben;	
	}
	
	public void sterben(){
		schildAufladung=0;
		schild=false;
		if (schadenBekommen(1000000000)==true){
			Interface.toCheckpoint=true;
		}
	}
	public void manaVerbrauchen(double verbrauch){
		if ((aktuellesMana-(verbrauch*manaFaktor))>=0){
			aktuellesMana = Math.round((aktuellesMana-(verbrauch*manaFaktor))*100.0)/100.0;
		}
		else{
			aktuellesMana = 0;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	
	/**
	 * Methodenkommentar:
	 * erhoeht die aktuellenHP/Mana um einen gegebenen wert
	 * 
	 */
	public void heilen(double heilung){
		if ((aktuelleHP+heilung)<=MAXHP){
			aktuelleHP = Math.round((aktuelleHP+heilung)*100.0)/100.0;
		}
		else{
			aktuelleHP = MAXHP;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	public void manaReg(double reg){
		if ((aktuellesMana+reg)<=MAXMANA){
			aktuellesMana = Math.round((aktuellesMana+reg)*100.0)/100.0;
		}
		else{
			aktuellesMana = MAXMANA;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	
	
	
	/**
	 * Methodenkommentar:
	 * Shop: Items erhoehen die aktuellenHP/Mana um einen gegebenen Wert
	 * 
	 */
	public void shopHP(double heilung){
		if (((aktuelleHP+heilung)<=MAXHP)&(aktuelleMuenzen>0)){
			aktuelleHP = Math.round((aktuelleHP+heilung)*100.0)/100.0;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	public void shopMana(double reg){
		if (((aktuellesMana+reg)<=MAXMANA)&(aktuelleMuenzen>0)){
			aktuellesMana = Math.round((aktuellesMana+reg)*100.0)/100.0;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	
	
	
	
	/**
	 * Muenzen einsammeln
	 * 
	 */
	public void muenzenSammeln(int muenzen){
		aktuelleMuenzen = aktuelleMuenzen+muenzen;
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	
	/**
	 * Muenzen verlieren
	 * 
	 */
	public void muenzenVerlieren(int muenzen){
		if (aktuelleMuenzen > 0){
			aktuelleMuenzen = aktuelleMuenzen-muenzen;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
		}
	}
	
	

	
	/**
	 * Methodenkommentar:
	 * setz alle werte auf die defaultwerte
	 * 
	 */
	
	public void resetPlayerStats(){
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
	public double getHP(){
		return aktuelleHP;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen mana aus
	 * 
	 */
	public double getMana(){
		return aktuellesMana;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Anzahl an Muenzen aus
	 * 
	 */
	public int getMuenzen(){
		return aktuelleMuenzen;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Farbe zurueck
	 * 
	 */
	public int getFarbe(){
		return aktuelleFarbe;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Ruestungswert zurueck
	 * 
	 */
	public double getRuestung(){
		return ruestung;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Manafaktor zurueck
	 * 
	 */
	public double getManaFaktor(){
		return manaFaktor;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Schadensfaktor zurueck
	 * 
	 */
	public double getSchaden(){
		return schaden;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen Lebensanzahl zurueck
	 * 
	 */
	public int getLeben(){
		return leben;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Schildaufladung zurueck
	 * 
	 */
	public int getSchild(){
		return schildAufladung;
	}
	
	/**
	 * Methodenkommentar:
	 * Booelan, ob Schild genutzt wird
	 * 
	 */
	public boolean schildBool(){
		return schild;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
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
	
	public void setFarbe(int farbe){
		
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
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	public void setXY(int newX, int newY){
		x=newX;
		y=newY;
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
	}
	
	public void resetHP(){
		aktuelleHP = DEFAULTHP;
	}
	public void schildZauber(){
		if ((schildAufladung <MAXSCHILD)&(aktuellesMana>=1)){
			manaVerbrauchen(1);
			schildAufladung = schildAufladung+1;
			schild = true ;
			aktion.displayFigur(x,y,aktuelleFarbe,schild);
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
		}
	}
	public void display(){
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen);
	}
	
	public int[] playerAttack(int richtung){
		attackReturn[0]=0;
		checkArray= aktion.playerAttack(richtung);		
		if (checkArray[0]==Interface.MOB){
			attackReturn=checkArray;
		}
		if (checkArray[0]==Interface.BOSS3){
			attackReturn=checkArray;
		}
		
		return attackReturn;
	}
	
	
}
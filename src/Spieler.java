

/** 
 * erstellt Objekt vom Typ Spieler 
 * 
 * 
 *
 */
public class Spieler{
	
	public static final double MAXMANA = 10.0;
	public static final double MAXHP = 10.0;
	private static final double DEFAULTMANA = 10.0;
	private static final double DEFAULTHP = 10.0;
	private static final int GELB = 0;
	private static final int BLAU = 1;
	private static final int ROT = 2;
	private static final int DEFAULTFARBE = GELB;
	private static final double DEFAULTSCHADEN = 2;
	private static final double DEFAULTMANAFAKTOR=1;
	private static final int DEFAULTLEBEN=3;
	private static final int DEFAULTRUESTUNG = 20;
	private static final int DEFAULTMUENZEN = 0;
	private static final int DEFAULTSCHLUESSEL = 0;
	private static final int DEFAULTSCHILDAUFLADUNG = 0;
	private static final int MAXSCHILD = 2;
	
	private int leben;
	private double manaFaktor;
	private double schaden;
	private double aktuellesMana;
	private double aktuelleHP;
	private double ruestung;
	private int aktuelleMuenzen;
	static int aktuelleSchluessel;
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
	
	/**
	 * 
	 * @param richtung
	 * @return RETURN
	 */
	public int bewegen(int richtung){
		checkArray = aktion.figurBewegen(richtung, x, y, aktuelleFarbe,schild,0);
		bewegenReturn = 0;
		if (checkArray[0]==Interface.CHECKPOINT){
			Interface.nextCheckpoint();
		}
		else if (checkArray[0]==Interface.MUENZEN){
			//Sound.soundAbspielen();
			aktuelleMuenzen++;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
					aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
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
			if (schadenBekommen(Interface.FUENF)){
				Interface.toCheckpoint=true;
			}
		}
		else if (checkArray[0]==Interface.MOB){
			sterben();
		}
		else if (checkArray[0]==Interface.BOSS3){
			sterben();
		}
		else if (checkArray[0]==Interface.SCHLUESSEL){
			aktuelleSchluessel++;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
					aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
		}
		else if (checkArray[0]==Interface.TOR){
			aktuelleSchluessel = 0;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
					aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
				//Quests.torAuf();
				
		}
		
		x=checkArray[1];
		y=checkArray[2];
		return bewegenReturn;
	}
	
	/**
	 * Bewegt Spieler
	 * @param newX nach X-Koordinate
	 * @param newY nach Y-Koordinate 
	 */
	public void moveTo(int newX, int newY){
		aktion.playerNachXY(x, y, newX, newY, aktuelleFarbe, schild );
		x = newX;
		y = newY;
	}
	
	
	/**
	 * reduziert die aktuellen HP/mana um einen gegeben schadenswert
	 * @param incSchaden 
	 * @return Return
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
			aktuelleHP = Math.round((aktuelleHP-(incSchaden*((Interface.EINHUNDERT-ruestung)/Interface.EINHUNDERT)))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,aktuelleMuenzen,
					aktuelleSchluessel);
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
				aktuellesMana=DEFAULTMANA;
				
			}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
		
		}
	return gestorben;	
	}
	
	/**
	 * Spieler stirbt
	 */
	public void sterben(){
		schildAufladung=0;
		schild=false;
		if (schadenBekommen(Interface.VIEL)){
			Interface.toCheckpoint=true;
		}
	}
	
	/**
	 * reduziert Mana und zeigt neues Wert rechts neben dem Spielfeld an
	 * @param verbrauch 
	 */
	public void manaVerbrauchen(double verbrauch){
		if ((aktuellesMana-(verbrauch*manaFaktor))>=0){
			aktuellesMana = Math.round((aktuellesMana-(verbrauch*manaFaktor))
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = 0;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP,
				aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
	}
	
	
	/**
	 * Methodenkommentar:
	 * erhoeht die aktuellenHP/Mana um einen gegebenen wert
	 * @param heilung  
	 */
	public void heilen(double heilung){
		if ((aktuelleHP+heilung)<=MAXHP){
			aktuelleHP = Math.round((aktuelleHP+heilung)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuelleHP = MAXHP;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
	}
	/**
	 * 
	 * @param reg 
	 */
	public void manaReg(double reg){
		if ((aktuellesMana+reg)<=MAXMANA){
			aktuellesMana = Math.round((aktuellesMana+reg)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		else{
			aktuellesMana = MAXMANA;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
				aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
	}
	
	
	
	
	/**
	 * Methodenkommentar:
	 * Shop: Items erhoehen die aktuellenHP/Mana um einen gegebenen Wert
	 * @param heilung  
	 */
	public void shopHP(double heilung){
		if (((aktuelleHP+heilung)<=MAXHP)&(aktuelleMuenzen>0)){
			aktuelleHP = Math.round((aktuelleHP+heilung)
					*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
				aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
	}
	/**
	 * 
	 * @param reg  
	 */
	public void shopMana(double reg){
		if (((aktuellesMana+reg)<=MAXMANA)&(aktuelleMuenzen>0)){
			aktuellesMana = Math.round((aktuellesMana+reg)*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
		}
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
	}
	
	
	
	
	
	/**
	 * Muenzen einsammeln
	 * @param muenzen Muenzen
	 */
	public void muenzenSammeln(int muenzen){
		aktuelleMuenzen = aktuelleMuenzen+muenzen;
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, 
				aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
	}
	
	
	/**
	 * Muenzen verlieren
	 * @param muenzen Muenzen
	 */
	public void muenzenVerlieren(int muenzen){
		if (aktuelleMuenzen > 0){
			aktuelleMuenzen = aktuelleMuenzen-muenzen;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP,
					aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
		}
	}
	
	/**
	 * Schluessel einsammeln
	 * @param schluessel Schluessel
	 */
	public void schluesselSammeln(int schluessel){
		aktuelleSchluessel = aktuelleSchluessel+schluessel;
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
	}
	
	/**
	 * Schluessel verlieren
	 * @param schluessel Schluessel
	 */
	public void schluesselVerlieren(int schluessel){
		if (aktuelleSchluessel > 1){
			aktuelleSchluessel = aktuelleSchluessel-schluessel;
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP,
					aktuellesMana,aktuelleMuenzen,aktuelleSchluessel);
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
		aktuelleSchluessel=DEFAULTSCHLUESSEL;
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
	 * @return aktuelle Healthpacks
	 */
	public double getHP(){
		return aktuelleHP;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen mana aus
	 * @return Aktueller Manawert
	 */
	public double getMana(){
		return aktuellesMana;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Anzahl an Muenzen aus
	 * @return Aktuelle Muenzanzahl
	 */
	public int getMuenzen(){
		return aktuelleMuenzen;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Anzahl an Schluesseln aus
	 * @return Aktuelle Schluesselanzahl
	 */
	public int getSchluessel(){
		return aktuelleSchluessel;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Farbe zurueck
	 * @return Aktuelle Farbe
	 */
	public int getFarbe(){
		return aktuelleFarbe;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Ruestungswert zurueck
	 * @return Aktuelle Ruestung
	 */
	public double getRuestung(){
		return ruestung;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Manafaktor zurueck
	 * @return Aktueller Manafaktor
	 */
	public double getManaFaktor(){
		return manaFaktor;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt den momentanen Schadensfaktor zurueck
	 * @return Aktueller Schadenswert
	 */
	public double getSchaden(){
		return schaden;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentanen Lebensanzahl zurueck
	 * @return Aktuelle Leben
	 */
	public int getLeben(){
		return leben;
	}
	
	/**
	 * Methodenkommentar:
	 * gibt die momentane Schildaufladung zurueck
	 * @return Schildaufladung
	 */
	public int getSchild(){
		return schildAufladung;
	}
	
	/**
	 * Methodenkommentar:
	 * Booelan, ob Schild genutzt wird
	 * @return Schild ja oder nein
	 */
	public boolean schildBool(){
		return schild;
	}
	
	/**
	 * Gibt X-Koordinate zurück
	 * @return X-Koordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Gibt Y-Koordinate zurück
	 * @return Y-Koordinate
	 */
	public int getY(){
		return y;
	}
	

	
	/**
	 * 
	 * Methodenkommentar:
	 * stellt Mana, Schaden und Ruestung auf den entsprechenden Faktor der Farbe um 
	 *  @param farbe Farbe
	 * 
	 */
	
	public void setFarbe(int farbe){
		
		if (farbe == GELB){
			if (aktuelleFarbe == BLAU){
				manaFaktor = Math.round(manaFaktor*Interface.EINEINHALB);
				ruestung = ruestung+Interface.DREISSIG;
			}
			else if (aktuelleFarbe == ROT){
				schaden = schaden/Interface.EINEINHALB;
				ruestung = ruestung+Interface.VIERZIG;
			}
			aktuelleFarbe=GELB;
		}
		else if (farbe == BLAU){
			if (aktuelleFarbe == GELB){
				ruestung = ruestung-Interface.DREISSIG;
				manaFaktor = Math.round((manaFaktor/Interface.EINEINHALB)
						*(double)Interface.EINHUNDERT)/(double)Interface.EINHUNDERT;
			}
			else if (aktuelleFarbe == ROT){
				schaden = schaden/Interface.EINEINHALB;
				manaFaktor = Math.round((manaFaktor/Interface.EINEINHALB)*(double)Interface.EINHUNDERT)/
						(double)Interface.EINHUNDERT;
				ruestung = ruestung+Interface.ZEHN;
			}
			aktuelleFarbe=BLAU;
		}
		else if (farbe == ROT){
			if (aktuelleFarbe == BLAU){
				manaFaktor = Math.round(manaFaktor*Interface.EINEINHALB);
				schaden = schaden*Interface.EINEINHALB;
				ruestung = ruestung-Interface.ZEHN;
			}
			else if (aktuelleFarbe == GELB){
				ruestung = ruestung-Interface.VIERZIG;
				schaden = schaden*Interface.EINEINHALB;
			}
			aktuelleFarbe=ROT;
		}
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
	}
	
	/**
	 * 
	 * @param newX X-Koordinate
	 * @param newY Y-Koordinate
	 */
	public void setXY(int newX, int newY){
		x=newX;
		y=newY;
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
	}
	/**
	 * setzt HP auf Defaultwert zuruwck
	 */
	public void resetHP(){
		aktuelleHP = DEFAULTHP;
	}
	
	/**
	 * verbraucht Mana
	 * bildet andere Spielfigur ab (mit gruenem Kreis um die Figur)
	 */
	public void schildZauber(){
		if ((schildAufladung <MAXSCHILD)&(aktuellesMana>=1)){
			manaVerbrauchen(1);
			schildAufladung = schildAufladung+1;
			schild = true ;
			aktion.displayFigur(x,y,aktuelleFarbe,schild);
			stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
					aktuelleMuenzen,aktuelleSchluessel);
		}
	}
	/**
	 * zeigt Figur und alle Player Eigenschaften an
	 */
	public void display(){
		aktion.displayFigur(x,y,aktuelleFarbe,schild);
		stats.displayPlayerStats(leben, schaden, ruestung, manaFaktor,aktuelleHP, aktuellesMana,
				aktuelleMuenzen,aktuelleSchluessel);
	}
	
	/**
	 * 
	 * @param richtung Richtung in die angegriffen wird
	 * @return Return
	 */
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
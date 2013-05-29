public class Figur{
	
	public static final double MAXMANA = 10.0;
	public static final double MAXHP = 10.0;
	private static final double DEFAULTMANA = 5.0;
	private static final double DEFAULTHP = 5.0;
	
	private static double aktuellesMana;
	private static double aktuelleHP;
	
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
		aktuelleHP = aktuelleHP-schaden;
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
	 * setz aktuelleHP und aktuellesMana auf die defaultwerte
	 * 
	 */
	
	public static void resetManaHP(){
		aktuelleHP=DEFAULTHP;
		aktuellesMana=DEFAULTMANA;
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
}
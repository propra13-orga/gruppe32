public class StatDisplay{
	
	
	/*
	 * Counter
	 */
	private int counter;
	
	
	/**
	 * zeigt Eigenschaften des Players an
	 * @param leben Anzahl der Leben der Spielfigur 
	 * @param schaden Schadenshoehe, die die Spielfigur mit aktueller Ruestung ausrichtet
	 * @param ruestung Wert der aktuellen Ruestung
	 * @param manafaktor aktueller Manawert
	 * @param hp Wert der Lebenspunkte, die die aktuelle Ruestung vorgibt
	 * @param mana Manawert (Zauber), den die aktuelle Ruestung vorgibt
	 * @param muenzen bisher gesammelte Muenz-Anzahl
	 * @param schluessel bisher gesammelte Schluessel-Anzahl
	 */
	public void displayPlayerStats(int leben, double schaden, double ruestung, double manafaktor, 
			double hp, double mana, int muenzen, int schluessel){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(Interface.NEUNHUNDERTZWANZIG,Interface.DREIHUNDERT, Interface.EINHUNDERT, Interface.FUENFHUNDERT);
		StdDraw.setPenColor();
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.FUENFHUNDERTZEHN, "Leben:"+leben);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTNEUNZIG, "Schaden:"+schaden);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTSIEBZIG, "Ruestung:"+ruestung);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTFUENFZIG, "Manafaktor:"+manafaktor);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTDREISSIG,"Raum:" +
				" "+(Interface.getLevel()+1)+"-"+(Interface.getRaum()+1));
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTZEHN, "HP:"+hp);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.DREIHUNDERTNEUNZIG, "Mana:"+mana);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.DREIHUNDERTSIEBZIG, "Muenzen:"+muenzen);
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.DREIHUNDERTFUENFZIG, "Schluessel:"+schluessel);
		
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERTFUENFZIG, "Steuerung:");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERTZWANZIG, "Pfeiltasten");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERT, "zur Bewegung");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTSIEBZIG, "W: Angriff oben");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTFUENFZIG, "A: Angriff links");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTDREISSIG, "S: Angriff unten");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTZEHN, "D: Angriff rechts");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ACHZIG, "Leertaste: ");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.SECHZIG, "aktiviert Schild");
	
		displayPlayerHP(hp);
		displayPlayerMana(mana);
	}
	/**
	 * 
	 * zeigt aktuelle Lebenspunkte (Health Packs) oben links ueber dem Spielfeld an
	 * @param hp verbleibende Lebenspunkte
	 * 
	 */
	public void displayPlayerHP(double hp){	
		for (counter=1; counter<=Spieler.MAXHP; counter++){
			if ((counter>hp)&(hp>counter-1)){
				StdDraw.picture(-Interface.ZEHN+Interface.ZWANZIG*counter,Interface.SECHSHUNDERTZEHN,Interface.HALFHEARTIMG);
			}
			else if(counter<=hp){
				StdDraw.picture(-Interface.ZEHN+Interface.ZWANZIG*counter,Interface.SECHSHUNDERTZEHN,Interface.FULLHEARTIMG);
			}
			else{
				StdDraw.picture(-Interface.ZEHN+Interface.ZWANZIG*counter,Interface.SECHSHUNDERTZEHN,Interface.EMPTYHEARTIMG);
			}
			
		}
	}
	
	
	
	/**
	 * 
	 * zeigt aktuelle Mana oben rechts ueber dem Spielfeld an
	 * @param mana verbleibender Manawert (Zauber)
	 * 
	 */
	public void displayPlayerMana(double mana){	
		for (counter=1; counter<=Spieler.MAXMANA; counter++){
			if ((counter>mana)&(mana>counter-1)){
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.ZWANZIG*counter,
						Interface.SECHSHUNDERTZEHN,Interface.HALFMANAIMG);
			}
			else if(counter<=mana){
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.ZWANZIG*counter,
						Interface.SECHSHUNDERTZEHN,Interface.FULLMANAIMG);
			}
			else{
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.ZWANZIG*counter,
						Interface.SECHSHUNDERTZEHN,Interface.EMPTYMANAIMG);
			}
			
		}
	}
	
	/**
	 * zeigt Eigenschaften des Gegners an
	 * @param hp Lebenspunkte des Gegners
	 * @param defaulthp urspruengliche Lebenspunkte des Gegners
	 * @param x x-Koordinate des Gegners
	 * @param y y-Koordinate des Gegners
	 */
	public void displayGegnerHP(double hp,double defaulthp, int x, int y){
		if (hp>=0){
			StdDraw.show(0);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(Interface.ZWANZIG+Interface.VIERZIG*x,
					Interface.ZWANZIG+Interface.VIERZIG*y+Interface.ZWOELF, Interface.FUENFZEHN, 2);
			StdDraw.setPenColor(StdDraw.GREEN);
			double mod =  (hp/defaulthp)*Interface.FUENFZEHN;
			StdDraw.filledRectangle(Interface.ZWANZIG+Interface.VIERZIG*x,
					Interface.ZWANZIG+Interface.VIERZIG*y+Interface.ZWOELF, mod, 2);
			StdDraw.setPenColor();
			StdDraw.show(0);
		}
		
	}
}
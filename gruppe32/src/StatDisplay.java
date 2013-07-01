public class StatDisplay{
	
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
	public void displayPlayerStats(int leben, double schaden, double ruestung, double manafaktor, double hp, double mana, int muenzen, int schluessel){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(920, 300, 100, 500);
		StdDraw.setPenColor();
		StdDraw.textLeft(820, 510, "Leben:"+leben);
		StdDraw.textLeft(820, 490, "Schaden:"+schaden);
		StdDraw.textLeft(820, 470, "Ruestung:"+ruestung);
		StdDraw.textLeft(820, 450, "Manafaktor:"+manafaktor);
		StdDraw.textLeft(820, 430,"Raum: "+(Interface.getLevel()+1)+"-"+(Interface.getRaum()+1));
		StdDraw.textLeft(820, 410, "HP:"+hp);
		StdDraw.textLeft(820, 390, "Mana:"+mana);
		StdDraw.textLeft(820, 370, "Muenzen:"+muenzen);
		StdDraw.textLeft(820, 350, "Schluessel:"+schluessel);
		if (Aktion.reachedCheckpoint==true){
			StdDraw.textLeft(820, 330, "Checkpoint:"+(Aktion.checkpointMerkeLevel+1)+"-"+(Aktion.checkpointMerkeRaum+1));
		    StdDraw.picture(870,300,Interface.CHECKPOINTIMG);
		    }
		StdDraw.textLeft(820, 250, "Steuerung:");
		StdDraw.textLeft(820, 220, "Pfeiltasten");
		StdDraw.textLeft(820, 200, "zur Bewegung");
		StdDraw.textLeft(820, 170, "W: Angriff oben");
		StdDraw.textLeft(820, 150, "A: Angriff links");
		StdDraw.textLeft(820, 130, "S: Angriff unten");
		StdDraw.textLeft(820, 110, "D: Angriff rechts");
		StdDraw.textLeft(820, 80, "Leertaste: ");
		StdDraw.textLeft(820, 60, "aktiviert Schild");
	
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
				StdDraw.picture(-10+20*counter,610,Interface.HALFHEARTIMG);
			}
			else if(counter<=hp){
				StdDraw.picture(-10+20*counter,610,Interface.FULLHEARTIMG);
			}
			else{
				StdDraw.picture(-10+20*counter,610,Interface.EMPTYHEARTIMG);
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
				StdDraw.picture(810-20*counter,610,Interface.HALFMANAIMG);
			}
			else if(counter<=mana){
				StdDraw.picture(810-20*counter,610,Interface.FULLMANAIMG);
			}
			else{
				StdDraw.picture(810-20*counter,610,Interface.EMPTYMANAIMG);
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
			StdDraw.filledRectangle(20+40*x, 20+40*y+12, 15, 2);
			StdDraw.setPenColor(StdDraw.GREEN);
			double mod =  (hp/defaulthp)*15;
			StdDraw.filledRectangle(20+40*x, 20+40*y+12, mod, 2);
			StdDraw.setPenColor();
			StdDraw.show(0);
		}
		
	}
}
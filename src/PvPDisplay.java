public class PvPDisplay{
	
	private static int counter;
	private static int spalte;
	private static int reihe;
	
	
	public static void figurBewegen(int vonX,int vonY,int nachX,int nachY, boolean spieler){
		StdDraw.picture(Interface.PIC1+Interface.PIC2*vonX,Interface.PIC1+Interface.PIC2*vonY, Interface.BODENIMG);
		if (spieler){
			spielerDarstellen(nachX,nachY);
		}
		else{
			gegnerDarstellen(nachX,nachY);
		}
	}
	public static void spielerDarstellen(int x, int y){
		if (PvPSpieler.getFarbe() == Interface.GELB){
			if  ((!PvPSpieler.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURGELB);
			}
			else if ((PvPSpieler.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURGELBSCHILD);
			}
			
		}
		if (PvPSpieler.getFarbe() == Interface.ROT){
			if  ((!PvPSpieler.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURROT);
			}
			else if ((PvPSpieler.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURROTSCHILD);
			}
			
		}
		if (PvPSpieler.getFarbe() == Interface.BLAU){
			if  ((!PvPSpieler.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURBLAU);
			}
			else if ((PvPSpieler.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURBLAUSCHILD);
			}
			
		}
	}
	public static void gegnerDarstellen(int x, int y){
		if (PvPGegner.getFarbe() == Interface.GELB){
			if  ((!PvPGegner.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURGELBSPEZIAL);
			}
			else if ((PvPGegner.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURGELBSCHILDSPEZIAL);
			}
			
		}
		if (PvPGegner.getFarbe() == Interface.ROT){
			if  ((!PvPGegner.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURROTSPEZIAL);
			}
			else if ((PvPGegner.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURROTSCHILDSPEZIAL);
			}
			
		}
		if (PvPGegner.getFarbe() == Interface.BLAU){
			if  ((!PvPGegner.getSchild())){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURBLAUSPEZIAL);
			}
			else if ((PvPGegner.getSchild() == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURBLAUSCHILDSPEZIAL);
			}
			
		}
		if (PvPGegner.getHP()>=0){
			StdDraw.show(0);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(Interface.PIC1+Interface.PIC2*x,
					Interface.PIC1+Interface.PIC2*y+Interface.ZWOELF, Interface.FUENFZEHN, 2);
			StdDraw.setPenColor(StdDraw.GREEN);
			double mod =  (PvPGegner.getHP()/10)*Interface.FUENFZEHN;
			StdDraw.filledRectangle(Interface.PIC1+Interface.PIC2*x,
					Interface.PIC1+Interface.PIC2*y+Interface.ZWOELF, mod, 2);
			StdDraw.setPenColor();
			StdDraw.show();
		}
	}
	
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
	 * @param erfahrungspunkte gesammelte Erfahrungspunkte des Spielers
	 */
	public static void displayPlayerStats(){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(Interface.NEUNHUNDERTZWANZIG,Interface.DREIHUNDERT, Interface.EINHUNDERT, Interface.BREITETEXT8);
		StdDraw.setPenColor();
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.FUENFHUNDERTZEHN, "Leben:"+PvPSpieler.getLeben());
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTNEUNZIG, "Schaden:"+PvPSpieler.getSchaden());
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTSIEBZIG, "Ruestung:"+PvPSpieler.getRuestung());
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.BREITETEXT6, "Manafaktor:"+PvPSpieler.getManafaktor());
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.VIERHUNDERTZEHN, "HP:"+PvPSpieler.getHP());
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.DREIHUNDERTNEUNZIG, "Mana:"+PvPSpieler.getMana());
		
		
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERTFUENFZIG, "Steuerung:");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERTZWANZIG, "Pfeiltasten");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ZWEIHUNDERT, "zur Bewegung");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTSIEBZIG, "W: Angriff oben");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTFUENFZIG, "A: Angriff links");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTDREISSIG, "S: Angriff unten");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.EINHUNDERTZEHN, "D: Angriff rechts");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.ACHZIG, "Leertaste: ");
		StdDraw.textLeft(Interface.ACHTHUNDERTZWANZIG, Interface.SECHZIG, "aktiviert Schild");
	
		displayPlayerHP(PvPSpieler.getHP());
		displayPlayerMana(PvPSpieler.getMana());
	}
	/**
	 * 
	 * zeigt aktuelle Lebenspunkte (Health Packs) oben links ueber dem Spielfeld an
	 * @param hp verbleibende Lebenspunkte
	 * 
	 */
	public static void displayPlayerHP(double hp){	
		for (counter=1; counter<=Spieler.MAXHP; counter++){
			if ((counter>hp)&(hp>counter-1)){
				StdDraw.picture(-Interface.ZEHN+Interface.PIC1*counter,Interface.SECHSHUNDERTZEHN,Interface.HALFHEARTIMG);
			}
			else if(counter<=hp){
				StdDraw.picture(-Interface.ZEHN+Interface.PIC1*counter,Interface.SECHSHUNDERTZEHN,Interface.FULLHEARTIMG);
			}
			else{
				StdDraw.picture(-Interface.ZEHN+Interface.PIC1*counter,Interface.SECHSHUNDERTZEHN,Interface.EMPTYHEARTIMG);
			}
			
		}
	}
	
	
	
	/**
	 * 
	 * zeigt aktuelle Mana oben rechts ueber dem Spielfeld an
	 * @param mana verbleibender Manawert (Zauber)
	 * 
	 */
	public static void displayPlayerMana(double mana){	
		for (counter=1; counter<=Spieler.MAXMANA; counter++){
			if ((counter>mana)&(mana>counter-1)){
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.PIC1*counter,
						Interface.SECHSHUNDERTZEHN,Interface.HALFMANAIMG);
			}
			else if(counter<=mana){
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.PIC1*counter,
						Interface.SECHSHUNDERTZEHN,Interface.FULLMANAIMG);
			}
			else{
				StdDraw.picture(Interface.ACHTHUNDERTZEHN-Interface.PIC1*counter,
						Interface.SECHSHUNDERTZEHN,Interface.EMPTYMANAIMG);
			}
			
		}
	}
	public static void spielfeldDarstellen(){
		//StdDraw.show(0);
		StdDraw.clear();
		StdDraw.setXscale(0.0,900);
		StdDraw.setYscale(0,600);
		StdDraw.show(0);
		for (spalte=0;spalte<Interface.SPALTEN;spalte++) {
			for(reihe=0;reihe<Interface.REIHEN;reihe++) {
				if(Spielfeld.getPvPWertBeiXY(spalte,reihe)==Interface.MAUER){
					StdDraw.picture(Interface.PIC1+Interface.PIC2*spalte,Interface.PIC1+Interface.PIC2*reihe, Interface.MAUERIMG);
				}
				else if(Spielfeld.getPvPWertBeiXY(spalte,reihe)==Interface.FARBEROT){
					StdDraw.picture(Interface.PIC1+Interface.PIC2*spalte,Interface.PIC1+Interface.PIC2*reihe, Interface.FARBEROTIMG);
				}
				else if(Spielfeld.getPvPWertBeiXY(spalte,reihe)==Interface.FARBEGELB){
					StdDraw.picture(Interface.PIC1+Interface.PIC2*spalte,Interface.PIC1+Interface.PIC2*reihe, Interface.FARBEGELBIMG);
				}
				else if(Spielfeld.getPvPWertBeiXY(spalte,reihe)==Interface.FARBEBLAU){
					StdDraw.picture(Interface.PIC1+Interface.PIC2*spalte,Interface.PIC1+Interface.PIC2*reihe, Interface.FARBEBLAUIMG);
				}
				else{
					StdDraw.picture(Interface.PIC1+Interface.PIC2*spalte,Interface.PIC1+Interface.PIC2*reihe, Interface.BODENIMG);
				}
				
			}
		}
		spielerDarstellen(PvPSpieler.getX(),PvPSpieler.getY());
		gegnerDarstellen(PvPGegner.getX(),PvPGegner.getY());
		StdDraw.show();
	}
	
}
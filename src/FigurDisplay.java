
/**
 * 
 * Stellt Figuren mit ihren aktuellen Eigenschaften dar
 *
 */

public class FigurDisplay{
	
	/**
	 * stellt an der vorherigen Position der Spielfigur Boden dar
	 * setzt neue Position der Figur und stellt sie dar
	 * @param vonX urspr�ngliche X-Koordinate 
	 * @param vonY urspr�ngliche Y-Koordinate 
	 * @param nachX neue X-Koordinate
	 * @param nachY neue Y-Koordinate
	 * @param farbe aktuelle Farbe, abhaengig von aktueller Ruestung
	 * @param schild vorhandener Schildzauber (Boolean)
	 */
	public void figurBewegen(int vonX, int vonY, int nachX, int nachY, int farbe, boolean schild){
		
		StdDraw.picture(Interface.PIC1+Interface.PIC2*vonX,Interface.PIC1+Interface.PIC2*vonY, Interface.BODENIMG);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		displayPlayer(nachX,nachY,farbe, schild);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), nachX, nachY, Interface.FIGUR);
	}
	
	/**
	 * stellt an der vorherigen Position des Gegners Boden dar
	 * @param vonX urspr�ngliche X-Koordinate 
	 * @param vonY urspr�ngliche Y-Koordinate 
	 * @param nachX neue X-Koordinate
	 * @param nachY neue Y-Koordinate
	 * @param richtung Richtung in die die Figur sich bewegt
	 * @param type Gegnerart
	 */
	public void gegnerBewegen(int vonX, int vonY, int nachX, int nachY, int richtung, int type){
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		StdDraw.picture(Interface.PIC1+Interface.PIC2*vonX,Interface.PIC1+Interface.PIC2*vonY, Interface.BODENIMG);
		displayGegner(nachX,nachY,richtung,type);
		
		
	}
	
	/**
	 * stellt SPielfigur je nach aktueller Ruestung dar
	 * @param x X-Koordinate der Spielfigur
	 * @param y Y-Koodrinate der Spielfigur
	 * @param farbe Farbe abhaengig von Ruestung
	 * @param schild vorhandener Schildzauber (Boolean)
	 */
	public void displayPlayer(int x, int y,int farbe, boolean schild){
		if (farbe == Interface.GELB){
			if  ((!schild) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURGELB);
			}
			else if  ((!schild) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURGELBSPEZIAL);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURGELBSCHILD);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURGELBSCHILDSPEZIAL);
			}
		}
		else if (farbe == Interface.BLAU){
			if  ((!schild) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURBLAU);
			}
			else if  ((!schild) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURBLAUSPEZIAL);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURBLAUSCHILD);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURBLAUSCHILDSPEZIAL);
			}
		}
		else if (farbe== Interface.ROT){
			if  ((!schild) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURROT);
			}
			else if  ((!schild) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, Interface.FIGURROTSPEZIAL);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == false)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURROTSCHILD);
			}
			else if ((schild == true) & (Spieler.spezialAngriff == true)){
				StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
						Interface.FIGURROTSCHILDSPEZIAL);
			}
		}
		
	}
	/**
	 * setzt an entsprechender Stelle Werte f�r Mob/Boss1/Boss2
	 * stellt die zugehoerigen Bilder dar
	 * @param x x-Koordinate des Gegners
	 * @param y y-Koordinate des Gegners
	 * @param richtung Richtung in die die Figur sich bewegt
	 * @param type Gegnerart
	 */
	public void displayGegner(int x, int y, int richtung, int type){
		if (type==Interface.MOB){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MOB);
			StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y,
					Interface.MOBIMG, richtung*Interface.NEUNZIG);
		}
		else if (type==Interface.BOSS1){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.BOSS1);
			StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y, 
					Interface.BOSS1IMG, richtung*Interface.NEUNZIG);
		}
		else if (type==Interface.BOSS2){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.BOSS2);
			StdDraw.picture(Interface.PIC1+Interface.PIC2*x,Interface.PIC1+Interface.PIC2*y,
					Interface.BOSS2IMG, richtung*Interface.NEUNZIG);
		}
		
	}
}
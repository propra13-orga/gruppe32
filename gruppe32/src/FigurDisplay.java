public class FigurDisplay{
	
	/**
	 * stellt an der vorherigen Position der Spielfigur Boden dar
	 * setzt neue Position der Figur und stellt sie dar
	 * @param vonX
	 * @param vonY
	 * @param nachX
	 * @param nachY
	 * @param farbe
	 * @param schild
	 */
	public void figurBewegen(int vonX, int vonY, int nachX, int nachY, int farbe, boolean schild ){
		
		StdDraw.picture(20+40*vonX,20+40*vonY, Interface.BODENIMG);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		displayPlayer(nachX,nachY,farbe, schild);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), nachX, nachY, Interface.FIGUR);
	}
	
	/**
	 * stellt an der vorherigen Position des Gegners Boden dar
	 * @param vonX
	 * @param vonY
	 * @param nachX
	 * @param nachY
	 * @param richtung
	 * @param type
	 */
	public void gegnerBewegen(int vonX, int vonY, int nachX, int nachY, int richtung, int type){
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		StdDraw.picture(20+40*vonX,20+40*vonY, Interface.BODENIMG);
		displayGegner(nachX,nachY,richtung,type);
		
		
	}
	
	/**
	 * stellt SPielfigur je nach aktueller Ruestung dar
	 * @param x
	 * @param y
	 * @param farbe
	 * @param schild: Boolean
	 */
	public void displayPlayer(int x, int y,int farbe, boolean schild){
		if (farbe == Interface.GELB){
			if (schild==false){
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURGELB);
			}
			else{
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURGELBSCHILD);
			}
		}
		else if (farbe == Interface.BLAU){
			if (schild==false){
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURBLAU);
			}
			else{
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURBLAUSCHILD);
			}
		}
		else if (farbe== Interface.ROT){
			if (schild==false){
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURROT);
			}
			else{
				StdDraw.picture(20+40*x,20+40*y, Interface.FIGURROTSCHILD);
			}
		}
		
	}
	/**
	 * setzt an entsprechender Stelle Werte f�r Mob/Boss1/Boss2
	 * stellt die zugehoerigen Bilder dar
	 * @param x
	 * @param y
	 * @param richtung
	 * @param type
	 */
	public void displayGegner(int x, int y, int richtung, int type){
		if (type==Interface.MOB){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.MOB);
			StdDraw.picture(20+40*x,20+40*y, Interface.MOBIMG, (richtung)*90);
		}
		else if (type==Interface.BOSS1){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.BOSS1);
			StdDraw.picture(20+40*x,20+40*y, Interface.BOSS1IMG, (richtung)*90);
		}
		else if (type==Interface.BOSS2){
			Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), x, y, Interface.BOSS2);
			StdDraw.picture(20+40*x,20+40*y, Interface.BOSS2IMG, (richtung)*90);
		}
		
	}
}
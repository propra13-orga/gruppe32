public class FigurDisplay{
	
	
	public void figurBewegen(int vonX, int vonY, int nachX, int nachY, int farbe, boolean schild ){
		
		StdDraw.picture(20+40*vonX,20+40*vonY, Interface.BODENIMG);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		displayPlayer(nachX,nachY,farbe, schild);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), nachX, nachY, Interface.FIGUR);
	}
	public void gegnerBewegen(int vonX, int vonY, int nachX, int nachY, int richtung){
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), vonX, vonY, Interface.BODEN);
		StdDraw.picture(20+40*vonX,20+40*vonY, Interface.BODENIMG);
		displayGegner(nachX,nachY,richtung);
		Spielfeld.wertSetzenBeiXY(Interface.getLevel(), Interface.getRaum(), nachX, nachY, Interface.MOB);
		
	}
	
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
	public void displayGegner(int x, int y, int richtung){
		StdDraw.picture(20+40*x,20+40*y, Interface.MOBIMG, (richtung)*90);
	}
}
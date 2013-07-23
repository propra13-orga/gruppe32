public class PvPDisplay{
	
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
	}
	
}
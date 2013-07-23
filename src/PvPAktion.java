public class PvPAktion{
	
	public static int newFigurX;
	public static int newFigurY;
	
	public void figurBewegen(int richtung, int figurX, int figurY){
		if (richtung == Interface.RECHTS){ 
			newFigurX=figurX+1;
			newFigurY=figurY;
		}	   
		else if (richtung == Interface.UNTEN){ 
			newFigurX=figurX;
			newFigurY=figurY-1;
		}
		else if (richtung == Interface.LINKS){ 
			newFigurX=figurX-1;
			newFigurY=figurY;
		}
		else if (richtung == Interface.OBEN){ 
			newFigurX=figurX;
			newFigurY=figurY+1;
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.BODEN){
			PvPSpieler.setXY(newFigurX,newFigurY);
			Spielfeld.setPvPWertBeiXY(newFigurX,newFigurY,Interface.FIGUR);
			Spielfeld.setPvPWertBeiXY(figurX,figurY,Interface.BODEN);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.BEIZIEL){
			PvPSpieler.schadenBekommen(PvPGegner.getSchaden());
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEBLAU){
			PvPSpieler.setFarbe(Spieler.BLAU);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEROT){
			PvPSpieler.setFarbe(Spieler.ROT);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEGELB){
			PvPSpieler.setFarbe(Spieler.GELB);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.MANATRANK){
			PvPSpieler.manaReg(1);
			PvPSpieler.setXY(newFigurX,newFigurY);
			Spielfeld.setPvPWertBeiXY(newFigurX,newFigurY,Interface.FIGUR);
			Spielfeld.setPvPWertBeiXY(figurX,figurY,Interface.BODEN);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.HPTRANK){
			PvPSpieler.schadenHeilen(1);
			PvPSpieler.setXY(newFigurX,newFigurY);
			Spielfeld.setPvPWertBeiXY(newFigurX,newFigurY,Interface.FIGUR);
			Spielfeld.setPvPWertBeiXY(figurX,figurY,Interface.BODEN);
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.MAUER){
			
		}
	}
	
	public void figurAttack(int richtung, int figurX, int figurY){
		if (richtung == Interface.RECHTS){ 
			newFigurX=figurX+1;
			newFigurY=figurY;
		}	   
		else if (richtung == Interface.UNTEN){ 
			newFigurX=figurX;
			newFigurY=figurY-1;
		}
		else if (richtung == Interface.LINKS){ 
			newFigurX=figurX-1;
			newFigurY=figurY;
		}
		else if (richtung == Interface.OBEN){ 
			newFigurX=figurX;
			newFigurY=figurY+1;
		}
		if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.BEIZIEL){
			PvPGegner.schadenBekommen(PvPSpieler.getSchaden());
		}
		
	}
	

	
	
	
	
}
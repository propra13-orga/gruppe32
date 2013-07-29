/**
 * 
 * klasse für die verarbeitung der tasteneingabe
 *
 */
public class PvPAktion{
	
	public static int newFigurX;
	public static int newFigurY;
	
	/**
	 * leitet die bewegung des spieler von figurX,figurY in eine bestimmte Richtung
	 * @param richtung richtung als int
	 * @param figurX ausgangs X-Koordinate
	 * @param figurY ausgangs Y-Koordinate
	 */
	public static void figurBewegen(int richtung, int figurX, int figurY){
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
			PvPDisplay.figurBewegen(figurX, figurY, newFigurX, newFigurY, true);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.BEIZIEL){
			PvPSpieler.schadenBekommen(PvPGegner.getSchaden());
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEBLAU){
			PvPSpieler.setFarbe(Spieler.BLAU);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEROT){
			PvPSpieler.setFarbe(Spieler.ROT);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.FARBEGELB){
			PvPSpieler.setFarbe(Spieler.GELB);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.MANATRANK){
			PvPSpieler.manaReg(1);
			PvPSpieler.setXY(newFigurX,newFigurY);
			Spielfeld.setPvPWertBeiXY(newFigurX,newFigurY,Interface.FIGUR);
			Spielfeld.setPvPWertBeiXY(figurX,figurY,Interface.BODEN);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.HPTRANK){
			PvPSpieler.schadenHeilen(1);
			PvPSpieler.setXY(newFigurX,newFigurY);
			Spielfeld.setPvPWertBeiXY(newFigurX,newFigurY,Interface.FIGUR);
			Spielfeld.setPvPWertBeiXY(figurX,figurY,Interface.BODEN);
		}
		else if (Spielfeld.getPvPWertBeiXY(newFigurX,newFigurY)==Interface.MAUER){
			
		}
	}
	
	/**
	 * leitet eine von figurX,figurY in eine bestimmt richtung ein
	 * @param richtung schadens-ausrichtung
	 * @param figurX ausgangs X-Koordinate
	 * @param figurY ausgangs Y-Koordinate
	 */
	public static void figurAttack(int richtung, int figurX, int figurY){
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
			PvPMain.damageTransfer=PvPMain.damageTransfer+PvPSpieler.getSchaden();
		}
		
	}
	

	
	
	
	
}
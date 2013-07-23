public class PvPMain{
	public static double[] transferArray = new double[6];
	public static double[] recieveArray = new double[6];
	public static boolean aktiv;
	
	public PvPMain(boolean server, int leben, double startSchaden, int startMana, int startFarbe){
		
		PvPSpieler.setLeben(leben);
		PvPSpieler.setSchaden(startSchaden);
		PvPGegner.setSchaden(startSchaden);
		PvPSpieler.setFarbe(startFarbe);
		PvPGegner.setFarbe(startFarbe);
		Spielfeld.initSpielfeldPvP();
		if (server){
			PvPSpieler.setXY(1, 1);
			PvPGegner.setXY(19, 14);
			aktiv=true;
		}
		else{
			PvPGegner.setXY(1, 1);
			PvPSpieler.setXY(19, 14);
		}
		PvPDisplay.spielfeldDarstellen();	
	}
	
	public static void aktion(String taste){
		if(aktiv){
			if (taste=="w"){
				PvPAktion.figurAttack(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="a"){
				PvPAktion.figurAttack(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());			
			}
			if (taste=="s"){
				PvPAktion.figurAttack(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="d"){
				PvPAktion.figurAttack(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="links"){
				PvPAktion.figurBewegen(Interface.LINKS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="rechts"){
				PvPAktion.figurBewegen(Interface.RECHTS,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="oben"){
				PvPAktion.figurBewegen(Interface.OBEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="unten"){
				PvPAktion.figurBewegen(Interface.UNTEN,PvPSpieler.getX(),PvPSpieler.getY());
			}
			if (taste=="leer"){
				PvPSpieler.schildZauber();
			}

		}
		aktiv=false;
	}
	
	public void updateTransferArray(){
		transferArray[0]=PvPSpieler.getX();
		transferArray[1]=PvPSpieler.getY();
		transferArray[2]=PvPSpieler.getSchaden();
		transferArray[3]=PvPSpieler.getRuestung();
		transferArray[4]=PvPSpieler.getFarbe();
		transferArray[5]=PvPSpieler.getSchildInt();
	}
	public void recieveAuswerten(){
		int newX = (int)recieveArray[0];
		int newY = (int)recieveArray[1];
		PvPGegner.setXY(newX, newY);
		PvPGegner.setSchaden(recieveArray[2]);
		PvPGegner.setRuestung(recieveArray[3]);
		int newFarbe = (int)recieveArray[4];
		PvPGegner.setFarbe(newFarbe);
		if(recieveArray[5]==1){
			PvPGegner.setSchild(true);
		}
		else{
			PvPGegner.setSchild(false);
		}
		PvPSpieler.schadenBekommen(recieveArray[6]);
		aktiv=true;
	}
}
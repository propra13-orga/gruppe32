public class StatDisplay{
	
	private int counter;
	
	
	
	public void displayPlayerStats(int leben, double schaden, double ruestung, double manafaktor, double hp, double mana, int muenzen){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(920, 300, 100, 500);
		StdDraw.setPenColor();
		StdDraw.textLeft(820, 550, "Leben:"+leben);
		StdDraw.textLeft(820, 530, "Schaden:"+schaden);
		StdDraw.textLeft(820, 510, "Ruestung:"+ruestung);
		StdDraw.textLeft(820, 490, "Manafaktor:"+manafaktor);
		StdDraw.textLeft(820, 470,"Raum: "+(Interface.getLevel()+1)+"-"+(Interface.getRaum()+1));
		StdDraw.textLeft(820, 450, "HP:"+hp);
		StdDraw.textLeft(820, 430, "Mana:"+mana);
		StdDraw.textLeft(820, 410, "Muenzen:"+muenzen);
		if (Aktion.reachedCheckpoint==true){
			StdDraw.textLeft(820, 390, "Checkpoint:"+(Aktion.checkpointMerkeLevel+1)+"-"+(Aktion.checkpointMerkeRaum+1));
		    StdDraw.picture(870,360,Interface.CHECKPOINTIMG);
		    }
		displayPlayerHP(hp);
		displayPlayerMana(mana);
	}
	/**
	 * 
	 * zeigt aktuelle HP oben links ueber dem Spielfeld an
	 * @param hp
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
	 * @param mana
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
}
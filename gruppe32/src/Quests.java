
/**
 * Klasse Quests erstellt Aufgaben im Spiel
 * 1. Quest "Versteckter Gang":  Mauerst�ck als versteckter Durchgang (Storyteller als Hinweisgeber)
 * 2. Quest "Schl�ssel und Tor": Sammeln von zwei Schl�sseln, sodass Tor aufgeht (Storyteller als Leitfigur)
 *
 */
public class Quests {
	
	public static boolean torAuf;
	
	
	/**
	 * (2. Quest: "Schl�ssel und Tor")
	 * Methode l�sst Tor durch Schluessel aufgehen
	 */
	public static void torAuf(){
		torAuf = true;
	}
}

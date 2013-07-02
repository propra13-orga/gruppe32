
/**
 * Klasse Quests erstellt Aufgaben im Spiel
 * 1. Quest "Versteckter Gang":  Mauerstück als versteckter Durchgang (Storyteller als Hinweisgeber)
 * 2. Quest "Schlüssel und Tor": Sammeln von zwei Schlüsseln, sodass Tor aufgeht (Storyteller als Leitfigur)
 *
 */
public class Quests {
	
	public static boolean torAuf;
	
	
	/**
	 * (2. Quest: "Schlüssel und Tor")
	 * Methode lässt Tor durch Schluessel aufgehen
	 */
	public static void torAuf(){
		torAuf = true;
	}
}

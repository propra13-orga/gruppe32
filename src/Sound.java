import java.applet.*;
import java.net.*;
import java.util.*;



/**
 * Klasse Sound spielt Sounds im Spiel ab
 * (verwendete Quelle: "Spiele-Programmierung in Java", Version 1.2 (Autor nicht genannt))
 */
public class Sound{
	Hashtable<String, AudioClip> sounds;
	
	public Sound(){
		sounds = new Hashtable<String, AudioClip>();
	}
	
	public void loadSound(String name, String path){
		if(sounds.containsKey(name)){
			return;
		}
		
		URL sound_url = getClass().getClassLoader().getResource(path);
		sounds.put(name, (AudioClip)Applet.newAudioClip(sound_url));
	}
	
	public void playSound(String name){
		AudioClip audio = sounds.get(name);
		audio.play();
	}
}
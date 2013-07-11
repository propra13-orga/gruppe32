import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.io.File;


  
public class Sound{
      
    public static AudioClip loadSound(String string) {
		File f = new File(string);
		try {
			AudioClip sound = Applet.newAudioClip(f.toURI().toURL());
			return sound;
		} 
		catch (MalformedURLException e) {
			System.out.println(e);
			return null;
		}
	}
}
    
 
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;


/**
 * Klasse Sound spielt Sounds im Spiel ab
 *
 */

/**
 * This enum encapsulates all the sound effects of a game, so as to separate the sound playing
 * codes from the game codes.
 * 1. Define all your sound effect names and the associated wave file.
 * 2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
 */
public enum Sound{
   MUENZESOUND("muenze.wav"),   // muenze
   TORSOUND("tor.wav");         // tor
   
   
   // Each sound effect has its own clip, loaded with its own sound file.
   private Clip clip;
   
   // Constructor to construct each element of the enum with its own sound file.
   Sound(String soundFileName) {
      try {
         // Use URL (instead of File) to read from disk and JAR.
         URL url = this.getClass().getClassLoader().getResource("muenze.wav");
         // Set up an audio input stream piped from the sound file.
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
         // Get a clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
}
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameAudio {

    Map<String, Clip> clips = new HashMap<>();


    public GameAudio() {
        loadAudioClip("/audio/bell.wav");
        loadAudioClip("/audio/pops.wav");
        loadAudioClip("/audio/rolling-dice.wav");
    }

    public void loadAudioClip(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(this.getClass().getResource(soundName)));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clips.put(soundName, clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playAudioClip(String soundName) {
        try {
            Clip c = clips.get(soundName);
            c.setFramePosition(0);
            c.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

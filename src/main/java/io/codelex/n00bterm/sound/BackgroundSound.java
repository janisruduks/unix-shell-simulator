package io.codelex.n00bterm.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class BackgroundSound {

    public void playSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("musicfiles/bg-music.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}

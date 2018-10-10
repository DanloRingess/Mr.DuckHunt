package org.academiadecodigo.codecadets.sound;

import javax.sound.sampled.*;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;


//Ignore this class It exist so we know how it may work, MC_s will *maybe* teach us to make it work
public class Sound
        implements AudioClip {
    Clip clip;

    public Sound(String paramString) {

        URL localURL = Sound.class.getResource("/" + paramString);

        try {

            if (localURL == null) {
                File localFile = new File(paramString);
                localURL = localFile.toURI().toURL();
            }

            AudioInputStream localAudioInputStream = AudioSystem.getAudioInputStream(localURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(localAudioInputStream);

        } catch (UnsupportedAudioFileException localUnsupportedAudioFileException) {

            localUnsupportedAudioFileException.printStackTrace();
        } catch (IOException localIOException) {

            localIOException.printStackTrace();
        } catch (LineUnavailableException localLineUnavailableException) {

            localLineUnavailableException.printStackTrace();
        }
    }

    public void play() {

        this.clip.stop();
        this.clip.flush();
        this.clip.setFramePosition(0);
        this.clip.start();
    }

    public void loop() {
        this.clip.loop(-1);
    }

    public void stop() {
        this.clip.stop();
    }
}

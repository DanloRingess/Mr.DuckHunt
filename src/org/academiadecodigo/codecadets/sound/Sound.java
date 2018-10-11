package org.academiadecodigo.codecadets.sound;

import org.academiadecodigo.codecadets.Configs.SoundConfigs;
import org.academiadecodigo.codecadets.enums.SoundTypes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    public void playSound(SoundTypes sndType){
        switch (sndType){
            case BGMUSIC:
                startMusicLoop(SoundConfigs.BGMUSIC_URI, true);
                break;
            case DUCKHIT:
                startMusicLoop(SoundConfigs.DUCKHIT, false);
                break;
            case DUCKHIT2:
                startMusicLoop(SoundConfigs.DUCKHIT2, false);
            case SGRELOADING:
                startMusicLoop(SoundConfigs.SGRELOADING, false);
                break;
            case SGEMPTY:
                startMusicLoop(SoundConfigs.SGEMPTY, false);
                break;
            case SGSHOOT:
                startMusicLoop(SoundConfigs.SGSHOOT, false);
                break;
            default:
                System.out.println("No such Sound: " + sndType.toString());
        }
    }

    private void startMusicLoop(String soundURI, boolean loop) {
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try {
            File file = new File(soundURI);
            soundURL = file.toURI().toURL();
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            if (loop){
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
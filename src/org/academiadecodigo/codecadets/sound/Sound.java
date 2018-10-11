package org.academiadecodigo.codecadets.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.academiadecodigo.codecadets.Configs.SoundConfigs;
import org.academiadecodigo.codecadets.enums.SoundTypes;

import javax.print.DocFlavor;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URI;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


// Change this class to your liking, this is just a base example

public class Sound {

    public void playSound(SoundTypes sndType){
        switch (sndType){
            case BGMUSIC:
                startMusicLoop(SoundConfigs.BGMUSIC_URI, true);
                break;
            case DUCKHIT:
                startMusicLoop(SoundConfigs.DUCKHIT, false);
                break;
            case SGRELOADING:
                startMusicLoop(SoundConfigs.SGRELOADING, false);
                break;
            case SGEMPTY:
                startMusicLoop(SoundConfigs.SGEMPTY, false);
                break;
            default:
                System.out.println("No such Sound: "+sndType.toString());
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
package org.academiadecodigo.codecadets.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.academiadecodigo.codecadets.Configs.SoundConfigs;
import org.academiadecodigo.codecadets.enums.SoundTypes;
import java.net.URI;

import java.io.File;
import java.net.URISyntaxException;


// Change this class to your liking, this is just a base example

public class Sound {

    public void playSound(SoundTypes sndType){
        switch (sndType){
            case BGMUSIC:
                startMusicLoop(SoundConfigs.BGMUSIC_URI);
                break;
            default:
                System.out.println("No such Sound");
        }
    }

    public void startMusicLoop(String soundURI) {
        try {
            Media media = new Media(); //TODO FIX THIS
            MediaPlayer mPlayer = new MediaPlayer(media);
            mPlayer.play();
            mPlayer.setAutoPlay(true);
        } catch (URISyntaxException ex) {
            System.out.println("URI not valid.");
        }
    }
}
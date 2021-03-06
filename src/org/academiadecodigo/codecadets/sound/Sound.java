package org.academiadecodigo.codecadets.sound;

import org.academiadecodigo.codecadets.Configs.SoundConfigs;
import org.academiadecodigo.codecadets.Main;
import org.academiadecodigo.codecadets.enums.SoundTypes;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private static Clip bgMusic;

    public void playSound(SoundTypes sndType){
        switch (sndType){
            case BGMUSIC:
                bgMusic = startMusicLoop(SoundConfigs.BGMUSIC_URI, true);
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
            case GAMENAME:
                startMusicLoop(SoundConfigs.GAMENAME, false);
                break;
            case PROPHIT:
                startMusicLoop(SoundConfigs.PROPHIT, false);
                break;
            default:
                System.out.println("No such Sound: " + sndType.toString());
        }
    }

    private Clip startMusicLoop(String soundURI, boolean loop) {
        AudioInputStream audioInputStream = null;
        URL soundURL;

        soundURI = soundURI.startsWith("/") ? soundURI : "/" + soundURI;

        try {
            soundURL = Main.class.getResource(soundURI);

            if (soundURL == null) {
                soundURI = soundURI.substring(1);
                File file = new File(soundURI);
                soundURL = file.toURI().toURL();
            }

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

            Frame[] frames = Frame.getFrames();

            for (Frame frame: frames) {
                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        clip.stop();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        clip.stop();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            }

            return clip;
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Clip getBgMusic() {
        return bgMusic;
    }
}
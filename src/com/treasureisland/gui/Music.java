package com.treasureisland.gui;

import com.treasureisland.utilities.ComponentsManager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Music {
//    public static URL song;
//    public static AudioClip songClip;


//    public Music(int songNumber){
//        song = Music.class.getResource("src/com/treasureisland/music/song"
//                +songNumber+".wav");
//        songClip = Applet.newAudioClip(song);
//        System.out.println("MUSIC CLASS: PLAYING SONG: "+songNumber);
//    }
public static void playMusic(String musicLocation) {
        try {
            File musicpath = new File(musicLocation);

            if(musicpath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
                Clip musicClip = AudioSystem.getClip();
                musicClip.open(audioInput);
                musicClip.start();
                System.out.println("playing music");
                musicClip.loop(musicClip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null, "Press || to pause music");
                long clipTimePosition = musicClip.getMicrosecondPosition();
                musicClip.stop();
                System.out.println("pausing music");

                JOptionPane.showMessageDialog(null, "Press || to resume music");
                musicClip.setMicrosecondPosition(clipTimePosition);
                musicClip.start();
                System.out.println("playing music");

            }
            else {
                System.out.println("Can't find music file");
            }
        }
        catch(Exception playMusicException) {
            playMusicException.printStackTrace();
        }
    }

//    String filepath = "src/com/treasureisland/music/song0.wav";
//
//    Music musicObject = new Music();
//
//        musicObject.playMusic(filepath);


}

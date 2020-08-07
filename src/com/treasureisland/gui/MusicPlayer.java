package com.treasureisland.gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayer {
    Clip clip;

    public void setFile(String soundFileName){

        try{
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e){
            System.out.println("MusicPlayer: setFile: Couldn't find song");

        }
    }

    public void play(){

        System.out.println("Music Player: Play");
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        System.out.println("Music Player: Loop");
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        System.out.println("Music Player: Stop");
        clip.stop();
        clip.close();
    }

}

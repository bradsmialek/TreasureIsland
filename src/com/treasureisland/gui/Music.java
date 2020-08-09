package com.treasureisland.gui;

import com.treasureisland.utilities.ComponentsManager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;


public class Music {
     public static void playMusic(String musicLocation){
         System.out.println("\nMUSIC CLASS: READING MUSIC FILE: " + musicLocation);
         try{
            File musicPath = new File(musicLocation);
//             System.out.println(musicPath);
            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

            }
            else{
                System.out.println("no file");
            }
         }
         catch(Exception exception){
             System.out.println("not here");
         }

     }

}

   // AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/com/treasureisland/music/song0.wav").getAbsoluteFile());


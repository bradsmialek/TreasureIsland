package com.treasureisland;

import com.treasureisland.components.*;
import com.treasureisland.gui.Board;
import com.treasureisland.gui.MusicPlayer;
import com.treasureisland.utilities.MyMethods;
import com.treasureisland.utilities.Storyline;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * No Ascii Panel, only JFrame
 */
public class Main {
    public static MusicPlayer mp = new MusicPlayer();
    public static JButton musicButton;

    public static String song0, musicOnOff;

    private static JFrame window;
    private static Board board;

    public static void main(String[] args) {
        System.out.println("MAIN CLASS: Initializing....");
        createMainWindow();
        createMusicButton();
        createBoard();
        StartGame();
    }

    private static void createMainWindow(){
        System.out.println("MAIN CLASS: CREATING WINDOW...");
        window = new JFrame("Treasure Island");
        window.setVisible(true);
        window.setResizable(false);
        window.setBounds(100, 10, Attributes.windowWidth, Attributes.windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createMusicButton(){
        musicButton = new JButton("Music");
        //window.add(musicButton, BorderLayout.NORTH);

        song0 = ".//Resource//song0.wav";
        System.out.println("Searching for song");

        musicOnOff = "off";
    }

    private static void createBoard(){
        System.out.println("MAIN CLASS: CREATING BOARD....");
        board = new Board();

//        JTextField tf = new JTextField();
//        tf.setBackground(Color.cyan);
//        JScrollPane pane = new JScrollPane(tf);
//        pane.setSize(Attributes.windowWidth - 20, Attributes.windowHeight - 700);
//
//        board.add(pane);
        window.add(board, BorderLayout.CENTER);
        board.requestFocusInWindow();
    }

    //Start Game
    public static void StartGame() {
        System.out.println("MAIN CLASS: STARTING GAME....");
        Attributes.currentIsland = new Island(Island.getIslandNumber()); //starts at island 0 .txt
        Attributes.currentMap = new Maps(Maps.getMapNumber());
        System.out.println("\nMAIN CLASS: CREATING STORYLINE");
        Storyline.createStoryline();
        //        Music.playMusic("/Users/bradsmialek/tlg/java/projects/TreasureIsland/src/com/treasureisland/music/song1.wav");

        Attributes.player = new Player(19, 18);
        Attributes.pirates = new ArrayList<Pirate>();
        Attributes.peopleInterests = new ArrayList<PeopleInterest>();
        Attributes.clues = new ArrayList<Clues>();
//        Attributes.friendlies = new ArrayList<Friend>();  maybe make friendlies move??
        MyMethods.initializeTiles();
    }
}


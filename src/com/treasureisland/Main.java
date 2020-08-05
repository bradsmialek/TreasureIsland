package com.treasureisland;

import com.treasureisland.components.Island;
import com.treasureisland.components.Player;
import com.treasureisland.gui.Board;
import com.treasureisland.gui.Music;
import com.treasureisland.utilities.MyMethods;

import javax.swing.*;

/**
 * No Ascii Panel, only JFranm
 */
public class Main {
    private static JFrame window;
    private static Board board;

    public static void main(String[] args) {
        System.out.println("MAIN CLASS: Initializing....");
        createMainWindow();
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

    private static void createBoard(){
        System.out.println("MAIN CLASS: CREATING BOARD....");
        board = new Board();
        window.add(board);
        board.requestFocusInWindow();
    }

    //Start Game
    public static void StartGame() {
        System.out.println("MAIN CLASS: STARTING GAME....");
        Attributes.currentIsland = new Island(Island.getIslandNumber()); //starts at island 0 .txt
        Attributes.player = new Player(19, 19);
//        Music.playMusic();
//        Attributes.pirates = new ArrayList<Pirate>();//        Attributes.friendlies = new ArrayList<Friend>();
        MyMethods.initializeTiles();
    }
}

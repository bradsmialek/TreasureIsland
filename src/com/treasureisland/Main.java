package com.treasureisland;

import com.treasureisland.gui.Board;

import javax.swing.*;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:12 PM
 * No Ascii Panel, only JFranm
 */
public class Main {
    private static JFrame window;
    private static Board board;

    public static void main(String[] args) {
        System.out.println("MAIN CLASS: STARTING GAME....");
        createMainWindow();
        createBoard();
    }

    private static void createMainWindow(){
        System.out.println("MAIN CLASS: CREATING WINDOW...");
        window = new JFrame("Treasure Island");
        window.setVisible(true);
        window.setResizable(false);
        window.setBounds(400, 200, Attributes.windowWidth, Attributes.windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void createBoard(){
        System.out.println("MAIN: CREATING BOARD....");
        board = new Board();
        window.add(board);
        board.requestFocusInWindow();
    }
}

package com.treasureisland;

import javax.swing.*;
import asciiPanel.AsciiPanel;

/**
 * Created by bradsmialek on Sat - 8/1/20 @ 6:30 PM
 */
public class MainApp extends JFrame {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;

    public MainApp(){
        super();
        terminal = new AsciiPanel();
        terminal.write("Treasure Island", 1, 1);
        add(terminal);
        pack();
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

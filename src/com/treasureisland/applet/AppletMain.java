package com.treasureisland.applet;

import asciiPanel.AsciiPanel;

import java.applet.Applet;

/**
 * Created by bradsmialek on Sat - 8/1/20 @ 7:16 PM
 */
public class AppletMain extends Applet {
    private static final long serialVersionUID = 2560255315130084198L;

    private AsciiPanel terminal;

    public AppletMain(){
        super();
        terminal = new AsciiPanel();
        terminal.write("Treasure Island", 1, 1);
        add(terminal);
    }

    public void init(){
        super.init();
        this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
    }

    public void repaint(){
        super.repaint();
        terminal.repaint();
    }
}

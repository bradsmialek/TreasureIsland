package com.treasureisland.gui;


import com.treasureisland.Attributes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:31 PM
 * GUI setup
 */
public class Board extends JPanel
implements KeyListener {
    public Board(){
        addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        repaint();
        revalidate();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, Attributes.windowWidth, Attributes.windowHeight);

    }

    @Override
    public void keyPressed(KeyEvent arg0) {}

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}

package com.treasureisland.gui;


import com.treasureisland.Attributes;
import com.treasureisland.components.Island;
import com.treasureisland.components.Player;
import com.treasureisland.utilities.Directions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:31 PM
 * GUI setup
 */
@SuppressWarnings(
        "serial"
)
public class Board extends JPanel
implements KeyListener {

    public Board(){
        addKeyListener(this);
        this.setFocusable(true);

        //initial
        Attributes.currentIsland = new Island(0);

        for (int i = 0; i < Attributes.currentIsland.getHeight(); i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {
                switch (Attributes.currentIsland.getTile(j,i)) {
                    case '@':
                        Attributes.player = new Player(j, i);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        repaint();
        revalidate();

        //BACKGROUND
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Attributes.windowWidth, Attributes.windowHeight);

        //ISLAND
        g.setColor(Color.WHITE);
        int x =15, y =20;
        for(int i = 0 ; i < Attributes.currentIsland.getHeight(); i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {
                g.drawString(""+Attributes.currentIsland.getTile(j,i), x, y);
                x+=10;
            }
            y+=15; x=15;
        }

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        System.out.println("MOVED");
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (Attributes.currentIsland.playerDoesMove(Directions.UP))
                    Attributes.player.move(Directions.UP);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (Attributes.currentIsland.playerDoesMove(Directions.LEFT))
                    Attributes.player.move(Directions.LEFT);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (Attributes.currentIsland.playerDoesMove(Directions.DOWN))
                    Attributes.player.move(Directions.DOWN);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (Attributes.currentIsland.playerDoesMove(Directions.RIGHT))
                    Attributes.player.move(Directions.RIGHT);
                break;
        }
        Attributes.currentIsland.posUpdate();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}

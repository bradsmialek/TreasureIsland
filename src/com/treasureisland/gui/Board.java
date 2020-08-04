package com.treasureisland.gui;


import com.treasureisland.Attributes;
import com.treasureisland.components.Island;
import com.treasureisland.components.Player;
import com.treasureisland.utilities.Tile;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.MyMethods;

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
        Attributes.player = new Player(10, 10);

        MyMethods.initializeTiles();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        repaint();
        revalidate();

        //BACKGROUND
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Attributes.windowWidth, Attributes.windowHeight);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, Attributes.windowWidth-720, Attributes.windowHeight-350, 5, 5);
        g.drawRoundRect(790, 5, Attributes.windowWidth-800, Attributes.windowHeight-350, 5, 5);
        g.drawRoundRect(5, Attributes.windowHeight-340, Attributes.windowWidth-15, Attributes.windowHeight-700, 5, 5);

        //ISLAND
        g.setColor(Color.WHITE);
        int x =15, y =20;
        for(int i = 0 ; i < Attributes.currentIsland.getHeight(); i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {
                g.drawString(""+Attributes.currentIsland.getTileChar(j,i), x, y);
                x+=10;
            }
            y+=15; x=15;
        }

        //STATS
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.drawString("Player", 800, 50);
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.drawString("HP: "+Attributes.player.getHealth()+"/"+Attributes.player.getMaxHealth(), 800, 100);

        g.drawString("Current Location: ", 800, 150);//+Attributes.player.getCurrentLocation()
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (Attributes.currentIsland.tileDoesMove(Attributes.player, Directions.UP))
                    Attributes.player.move(Directions.UP); // Move player if can move
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (Attributes.currentIsland.tileDoesMove(Attributes.player, Directions.LEFT))
                    Attributes.player.move(Directions.LEFT);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (Attributes.currentIsland.tileDoesMove(Attributes.player, Directions.DOWN))
                    Attributes.player.move(Directions.DOWN);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (Attributes.currentIsland.tileDoesMove(Attributes.player, Directions.RIGHT))
                    Attributes.player.move(Directions.RIGHT);
                break;
        }

        switch (Attributes.currentIsland.getTile(Attributes.player.getPosX(), Attributes.player.getPosY())) {
            case DOCK:
                Attributes.currentIsland = new Island(MyMethods.getRandomNumber(Attributes.islandCount));
                MyMethods.initializeTiles();
                break;
            case PIRATE:
                Attributes.player.damage(MyMethods.getRandomNumber(2));
                break;
            case RUM:
                Attributes.player.heal(MyMethods.getRandomNumber(3));
                break;
            default:
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}

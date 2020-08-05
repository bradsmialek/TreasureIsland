package com.treasureisland.gui;


import com.treasureisland.Attributes;
import com.treasureisland.Main;
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

    public Board() {
        addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        revalidate();

        //BACKGROUND
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Attributes.windowWidth, Attributes.windowHeight);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, Attributes.windowWidth - 720, Attributes.windowHeight - 350, 5, 5);
        g.drawRoundRect(790, 5, Attributes.windowWidth - 800, Attributes.windowHeight - 350, 5, 5);
        g.drawRoundRect(5, Attributes.windowHeight - 340, Attributes.windowWidth - 15, Attributes.windowHeight - 700, 5, 5);


        //ISLAND
        g.setColor(Color.WHITE);
        int x = 15, y = 20;
        for (int i = 0; i < Attributes.currentIsland.getHeight(); i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {
                g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                x += 10;
            }
            y += 15;
            x = 15;
        }

        //Legend of characters
        //^ ship
        //P pirate ... etc

        //STATS
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.drawString("Player: ", 800, 50); //TODO  ask user name and use it    +Attributes.player.getName()
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.drawString("HP: " + Attributes.player.getHealth() + "/" + Attributes.player.getMaxHealth(), 800, 100);

        g.drawString("Current Location: "+Island.getIslandName(Island.getIslandNumber()), 800, 150);

        g.drawString("Gold: ", 800, 170); //+Attributes.player.getGold()
        g.drawString("Keys: ", 800, 190); //+Attributes.player.getKeys()

        //Message
        g.drawString(MyMethods.getMessage(), 15, 680);
        g.drawString(MyMethods.getMessage2(), 15, 700);
        g.drawString(MyMethods.getMessage3(), 15, 720);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
//        if (Attributes.player.isLiving()) {

        try {
            switch (arg0.getKeyCode()) {
                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:
                    Attributes.player.setFacing(Directions.UP);
                    MyMethods.playerHandler(Directions.UP);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    Attributes.player.setFacing(Directions.LEFT);
                    MyMethods.playerHandler(Directions.LEFT);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    Attributes.player.setFacing(Directions.DOWN);
                    MyMethods.playerHandler(Directions.DOWN);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    Attributes.player.setFacing(Directions.RIGHT);
                    MyMethods.playerHandler(Directions.RIGHT);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_Y:
                    MyMethods.decisionTree(true);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_N:
                    MyMethods.decisionTree(false);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_2:
                    MyMethods.locationTree(2);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_3:
                    MyMethods.locationTree(3);
                    Attributes.currentIsland.posUpdate();
                    break;
            }
//            MyMethods.checkIsDead();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        } else {
//            Main.StartGame();
//        }
    }


    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

}

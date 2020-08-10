package com.treasureisland.gui;


import com.treasureisland.Attributes;
import com.treasureisland.Main;
import com.treasureisland.components.Island;
import com.treasureisland.components.Maps;
import com.treasureisland.components.PeopleInterest;
import com.treasureisland.components.Player;
import com.treasureisland.utilities.HeadsOrTails;
import com.treasureisland.utilities.Tile;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.MyMethods;
//import sun.jvm.hotspot.ui.treetable.AbstractTreeTableModel;


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
//        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Attributes.windowWidth, Attributes.windowHeight);
        g.setColor(Color.BLUE);
        g.drawRoundRect(5, 5, Attributes.windowWidth - 720, Attributes.windowHeight - 350, 5, 5);
        g.drawRoundRect(790, 5, Attributes.windowWidth - 800, Attributes.windowHeight - 700, 5, 5);
        g.drawRoundRect(790, 310, Attributes.windowWidth - 800, Attributes.windowHeight - 655, 5, 5);
        g.drawRoundRect(5, Attributes.windowHeight - 340, Attributes.windowWidth - 15, Attributes.windowHeight - 700, 5, 5);




        //MAP
        g.setColor(Color.lightGray);
        try {
            int a = 840, b = 340;
            for (int i = 0; i < Attributes.currentMap.getHeight(); i++) {
                for (int j = 0; j < Attributes.currentMap.getWidth(); j++) {

                    if (Attributes.currentMap.getTileChar(j, i) == '@') {
                        g.setColor(Color.RED);
                        g.drawString("" + Attributes.currentMap.getTileChar(j, i), a, b);
                        g.setColor(Color.lightGray);
                    }
                    else if (Attributes.currentMap.getTileChar(j, i) == '.') {
                            g.setColor(Color.darkGray);
                            g.drawString("" + Attributes.currentMap.getTileChar(j, i), a, b);
                            g.setColor(Color.orange);
                    } else if (Attributes.currentMap.getTileChar(j, i) == '#') {
                        g.setColor(Color.pink);
                        g.drawString("" + Attributes.currentMap.getTileChar(j, i), a, b);
                        g.setColor(Color.lightGray);
                    } else {
                        g.setColor(Color.lightGray);
                        g.drawString("" + Attributes.currentMap.getTileChar(j, i), a, b);
                    }
                    a += 8;
                }
                b += 13;
                a = 840;
            }
        } catch (Exception drawCurrentMapError) {
            System.out.println("Something went wrong while we were drawing the map");
        }

        //Island
        g.setColor(Color.orange);
        try {

            int x = 15, y = 20;
            for (int i = 0; i < Attributes.currentIsland.getHeight(); i++) {
                for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {

                    if (Attributes.currentIsland.getTileChar(j, i) == '@') {
                        g.setColor(Color.MAGENTA);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    } else if (Attributes.currentIsland.getTileChar(j, i) == '+') {
                        g.setColor(Color.lightGray);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    } else if (Attributes.currentIsland.getTileChar(j, i) == 'p') {
                        g.setColor(Color.red);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    }else if (Attributes.currentIsland.getTileChar(j, i) == 'f') {
                        g.setColor(Color.green);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    }else if (Attributes.currentIsland.getTileChar(j, i) == '.') {
                        g.setColor(Color.darkGray);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    } else if (Attributes.currentIsland.getTileChar(j, i) == '~') {
                        g.setColor(Color.blue);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    } else if (Attributes.currentIsland.getTileChar(j, i) == '#') {
                        g.setColor(Color.pink);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                        g.setColor(Color.orange);
                    }else {
                        g.setColor(Color.orange);
                        g.drawString("" + Attributes.currentIsland.getTileChar(j, i), x, y);
                    }

                    x += 10;
                }
                y += 15;
                x = 15;
            }
        } catch (Exception paintIslandError) {
            System.out.println("Something went wrong while we were painting the island");
        }

        //Legend of characters  TODO
        //^ ship
        //P pirate ... etc


        //STATS
        try {
            g.setFont(new Font("arial", Font.PLAIN, 20));
            g.setColor(Color.cyan);
            g.drawString("Player: ", 800, 50); //TODO  ask user name and use it    +Attributes.player.getName()
            g.setFont(new Font("arial", Font.PLAIN, 20));
            g.drawString("HP: " + Attributes.player.getHealth() + "/" + Attributes.player.getMaxHealth(), 800, 80);
            g.drawString("XP: " + Attributes.player.getXP() + "/" + Attributes.player.getNextLevel(), 800, 110);
            g.drawString("Gold: " + Attributes.player.getsGold(), 800, 140);
            g.drawString("Keys: " + Attributes.player.getsKeys(), 800, 170);

            g.drawString("Char Level: " + Attributes.player.getsLevel(), 800, 225);
            g.drawString("Current Location: " + Island.getIslandName(Island.getIslandNumber()), 800, 285);

            g.drawString("Special Items: ", 1200, 50);
            g.drawString("Keys: 0/3", 1200, 90); //+Attributes.player.getsSpecialKeys()  --------------TODO
            // 0/3
            g.drawString("Emerald: 0/1", 1200, 120); // +Attributes.player.getsEmerald() ---------------TODO
            // 0/1
            g.drawString("Maps: 0/4", 1200, 150); // +Attributes.player.getsEmerald() ---------------TODO
            // 0/4

        } catch (Exception drawStatsError) {
            System.out.println("Something went wrong while we were drawing Player stats");
        }

        //Message
        try {

            g.setColor(Color.lightGray);
            g.setFont(new Font("arial", Font.PLAIN, 35));
            g.drawString(MyMethods.getMessage(), 15, 700);
            g.drawString(MyMethods.getMessage2(), 15, 750);
            g.drawString(MyMethods.getMessage3(), 15, 800);
            g.drawString(MyMethods.getMessage4(), 15, 850);
            g.drawString(MyMethods.getMessage5(), 15, 900);
            g.drawString(MyMethods.getMessage6(), 15, 950);

        } catch (Exception drawMessageException) {
            System.out.println("Something went wrong while we were drawing your message board");
        }
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
//                    MyMethods.movePirates();
//                    Attributes.currentIsland.posPirateUpdate();
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    Attributes.player.setFacing(Directions.LEFT);
                    MyMethods.playerHandler(Directions.LEFT);
                    Attributes.currentIsland.posUpdate();
//                    MyMethods.movePirates();
//                    Attributes.currentIsland.posPirateUpdate();
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    Attributes.player.setFacing(Directions.DOWN);
                    MyMethods.playerHandler(Directions.DOWN);
                    Attributes.currentIsland.posUpdate();
//                    MyMethods.movePirates();
//                    Attributes.currentIsland.posPirateUpdate();
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    Attributes.player.setFacing(Directions.RIGHT);
                    MyMethods.playerHandler(Directions.RIGHT);
                    Attributes.currentIsland.posUpdate();
//                    MyMethods.movePirates();
//                    Attributes.currentIsland.posPirateUpdate();
                    break;
                case KeyEvent.VK_Y:
                    Attributes.routeCommand(true);
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_N:
                    Attributes.routeCommand(false);
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
                case KeyEvent.VK_H:
                    MyMethods.coinTossTree("Heads");
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_T:
                    MyMethods.coinTossTree("Tails");
                    Attributes.currentIsland.posUpdate();
                    break;
                case KeyEvent.VK_ESCAPE:
                    if (Main.musicOnOff.equals("off")) {
                        Main.mp.setFile(Main.song0);
                        Main.mp.play();
                        Main.mp.loop();
                        Main.musicOnOff = "on";
                        Main.musicButton.setText("Music On");
                    }
                    else if (Main.musicOnOff.equals("on")) {
                        Main.mp.stop();
                        Main.musicOnOff = "off";
                        Main.musicButton.setText("Music Off");
                    }
            }
//            MyMethods.checkIsDead();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Player input error");
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

package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.Island;
import com.treasureisland.components.Player;



import java.sql.Ref;
import java.util.Random;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 5:10 AM
 */
public class MyMethods {

    private static String message = " ";
    private static String message2 = " ";
    private static String message3 = " ";

    public static void initializeTiles(){
        System.out.println(Attributes.currentIsland.toString());
        for (int i = 0; i < Attributes.currentIsland.getHeight()-1; i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth()-1; j++) {
//                System.out.println(i);
//                System.out.println(j);
                switch (Attributes.currentIsland.getTile(j,i)) {
                    case PLAYER:
                        Attributes.player.setPos(j, i);
                        break;
//                    case PIRATE:
//                        Attributes.pirates.add(new Pirate("Pirate", x, y, 10, 2, 2));
                    default:
                        break;
                }
            }
        }
    }

    //TODO test me
    public static int getRandomNumber(int n) {
        Random rand = new Random();
//        if ()
        return rand.nextInt(n) +1;
    }

    public static void playerHandler(Directions dir) {
        Tile tile = null;

        switch(dir) {
            case UP:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX(), Attributes.player.getPosY()-1);
                break;
            case LEFT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX()-1, Attributes.player.getPosY());
                break;
            case DOWN:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX(), Attributes.player.getPosY()+1);
                break;
            case RIGHT:
                tile = Attributes.currentIsland.getTile(Attributes.player.getPosX()+1, Attributes.player.getPosY());
                break;
        }

        //Handles the player movement
        switch(tile){
            case NOTHING:
                Attributes.player.move(dir);
                // every time player moves previous displayed message will dissapear
                message = " ";
                message2 = " ";
                message3 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
                message2 = " ";
                message3 = " ";
                break;
            case DOCK:
                Attributes.player.move(dir);
                Attributes.currentIsland = new Island(MyMethods.getRandomNumber(Attributes.islandCount));
                message = "You went somewhere??";
                message2 = " ";
                message3 = " ";
                MyMethods.initializeTiles();
                break; //Randomly change floor
            case RUM:
                message = "You found Rum! Do you want to drink it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.RUM_UP;
                break;
            case GOLD:
                break;
            case TREASURE:
                break; //Ask to open chest
            case KEY:
                break; //Adds a key
            case DOOR:
                break; //Ask to open door
            case PIRATE:
                Attributes.player.damage(MyMethods.getRandomNumber(2));
                message = "You fought a pirate and took damage!";
                message2 = " ";
                message3 = " ";
                break; //Handles encounters with pirates
            case FRIENDLY:
                message = RandomMessage.randomMessageGenerator();
                break; //Handles encounters with pirates
            case MAP:
                message = "Where would you like to go?";
                message2 = "Island Two     Island Three";
                message3 = "    [2]             [3]    ";
                decided = Decision.LOCATION;

            default:
                System.out.println("???");
                break; //If something glitches out
        }

    }

    private enum Decision {
        NONE,
        RUM_UP,
        LOCATION;
    }

    private static Decision decided = Decision.NONE;
    //private static //something location = //whatever

    //DECISION TREE
    public static void decisionTree(boolean yn) {
        System.out.println(yn);
        if (decided == Decision.NONE) {
            return;
        }
        else if(decided == Decision.RUM_UP && yn) {
            Attributes.player.heal(MyMethods.getRandomNumber(5)+3);
            message = "You drank Rum and it gave you health.";
            message2 = "";
            message3 = "";
            Attributes.player.move();//replace tile to .
        }
        else if(decided == Decision.RUM_UP) {
            message = "I'm too drunk already!";
            message2 = "";
            message3 = "";

        }

        decided = Decision.NONE;
    }

    //LOCATION TREE
    public static void locationTree(int islandNumber) {
        System.out.println(islandNumber);
        if (decided == Decision.NONE) {
            return;
        }
        else if (islandNumber == 2) {
            Attributes.currentIsland = new Island(2);
        }
        else if (islandNumber == 3) {
            Attributes.currentIsland = new Island(3);
        }
        else if (decided == Decision.LOCATION) {
            message = "I'm fine exploring here.";
        }
        decided = Decision.NONE;

    }


    public static String getMessage() {return message;}

    public static String getMessage2() {return message2;}

    public static String getMessage3() {return message3;}

    public static void checkIsDead() {
        if(Attributes.player.getHealth()<=0) {
            System.out.println("You Died!");
            Attributes.player.setDead();
        }
    }

}



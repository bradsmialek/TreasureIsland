package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.*;
//import sun.security.pkcs11.wrapper.Functions;


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
        for (int i = 0; i < Attributes.currentIsland.getHeight()-1; i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth()-1; j++) {
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

    public static void playerHandler(Directions dir) throws Exception {
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
                Attributes.currentIsland = new Island(1);
                Attributes.currentMap = new Maps(1);
                message = "You have returned to your Ship!"; // 89 char
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
                Attributes.player.move(dir);
                Attributes.player.addsGold(MyMethods.getRandomNumber(3)+2);
                message = "You picked up gold!";
                message2 = " ";
                message3 = " ";
                break;
            case TREASURE:
                message = "You found a chest.  You need a key to open it!";
                message2 = " ";
                message3 = " ";
                break; //Ask to open chest
            case KEY:
                Attributes.player.move(dir);
                Attributes.player.addsKey();
                message = "You picked up a normal key! Must be something nearby to unlock?";
                message2 = " ";
                message3 = " ";
                break; //Adds a key
            case DOOR:
                message = "This door is locked. You need a key!";
                message2 = " ";
                message3 = " ";
                break; //Ask to open door
            case PIRATE:
                Attributes.player.damage(MyMethods.getRandomNumber(2));
                message = "You fought a pirate and took damage!";
                //drops items  -----------------------------------------------------------TODO
                //option to fight and kill deal damage------------------------------------TODO
                message2 = " ";
                message3 = " ";
                break; //Handles encounters with pirates
            case FRIENDLY:
                message = RandomMessage.randomMessageGenerator();
                // drops random items with random generator
                break;
            case MAP:
                message = "Where would you like to sail to?";
                message2 = "Rum Runners Is. [2]    Port Royal [3]     Isle Cruces [4]";
                message3 = "Isla De Muerta [5]    Treasure Island [6]";
//                message4 = "";
                locationDecided = LocationDecision.LOCATION;
                break;
            case VENDOR:
                message = "What would you like to Buy?";
                message2 = "list of stuff";
                //Attributes.vendorItems.getAll();
                message3 = Attributes.vendorItems.getAll();
                // deduct from coins depending on item cost
                //itemDecided = itemDecision.ITEMS;  or something like this
                break;
            case POI:
                PeopleInterest.poiTree(Entity.getPosX(), Entity.getPosY(), Island.getIslandName(Island.getIslandNumber()));

                message = "should tell story";
                message2 = " ";
                message3 = " ";
                break;
            default:
                System.out.println("???");
                break; //If something glitches out
        }
    }


    private enum LocationDecision {
        LOCATION,
        NOWHERE;
    }

    private enum Decision {
        NONE,
        RUM_UP,
    }
    private static LocationDecision locationDecided = LocationDecision.NOWHERE;

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
        if (locationDecided == LocationDecision.NOWHERE) {
            return;
        }
        else if ( islandNumber == 2) {
            Attributes.currentIsland = new Island(2);
            Attributes.currentMap = new Maps(2);

        }
        else if (islandNumber == 3) {
            //check for special key and map ------------------------------------------TODO
            // no key no go message
            Attributes.currentIsland = new Island(3);
            Attributes.currentMap = new Maps(3);
        }
        else {
            message = "I'm fine exploring here.";
        }
        locationDecided = LocationDecision.NOWHERE;
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



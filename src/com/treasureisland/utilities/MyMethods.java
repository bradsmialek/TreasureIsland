package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.*;


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

        Attributes.pirates.clear();

        System.out.println(Attributes.currentIsland.toString());

        for (int y = 0; y < Attributes.currentIsland.getHeight()-1; y++) {
            for (int x = 0; x < Attributes.currentIsland.getWidth()-1; x++) {
                switch (Attributes.currentIsland.getTile(x,y)) {
                    case PLAYER:
                        Attributes.player.setPos(x, y);
                        break;
                    case PIRATE:
                        Attributes.pirates.add(new Pirate( x, y, 10));
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
                message = "You have returned to your Ship!";
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

                message = "You fought a pirate and took damage!";
                message2 = " ";
                message3 = " ";
                break; //Handles encounters with pirates
            case FRIENDLY:
                message = RandomMessage.randomMessageGenerator();
                break; //Handles encounters with pirates
            case MAP:
                message = "Where would you like to sail to?";
                message2 = "Island Two     Island Three";
                message3 = "    [2]             [3]    ";
                locationDecided = LocationDecision.LOCATION;
                break;
            case VENDOR:
                message = "What would you like to Buy?";
                message2 = "list of stuff";
                Attributes.vendorItems.getAll();
                message3 = " ";


                // deduct from coins depending on item cost
                //itemDecided = itemDecision.ITEMS;  or something like this
                break;
            case POI:
//                PeopleInterest.poiTree(Entity.getPosX(), Entity.getPosY(), Island.getIslandName(Island.getIslandNumber()));

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
        }
        else if (islandNumber == 3) {
            Attributes.currentIsland = new Island(3);
        }
        else {
            message = "I'm fine exploring here.";
        }
        locationDecided = LocationDecision.NOWHERE;
    }

    public static void movePirates() {
        for(int i = 0; i<Attributes.pirates.size(); i++) {
            Attributes.pirates.get(i).moveRandom();
        }
    }

    public static void pirateEncounter(Directions direction) {
        int pirateX=0, pirateY=0;

        switch(direction) {
            case UP:
                pirateX = Attributes.player.getPosX(); pirateY = Attributes.player.getPosY()-1; break;
            case LEFT:
                pirateX = Attributes.player.getPosX()-1; pirateY = Attributes.player.getPosY(); break;
            case DOWN:
                pirateX = Attributes.player.getPosX(); pirateY = Attributes.player.getPosY()+1; break;
            case RIGHT:
                pirateX = Attributes.player.getPosX()+1; pirateY = Attributes.player.getPosY(); break;
        }

        for(int i = 0; i<Attributes.pirates.size(); i++) {
            if(Attributes.pirates.get(i).getPosX() == pirateX && Attributes.pirates.get(i).getPosY() == pirateY) {
                Attributes.player.damage(MyMethods.getRandomNumber(2));
                message = "You attacked the Pirate and left him with "+Attributes.pirates.get(i).getHealth()+" HP!";
                message2 = "The Pirate attacked you!";
            }
        }
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



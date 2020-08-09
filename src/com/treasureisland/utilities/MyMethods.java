package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.*;
//import sun.security.pkcs11.wrapper.Functions;


import java.sql.Ref;
import java.util.*;
import java.util.Random;


/**
 * Created by bradsmialek on Mon - 8/3/20 @ 5:10 AM
 */
public class MyMethods {

    private static String message = " ";
    private static String message2 = " ";
    private static String message3 = " ";
    private static String message4 = " ";
    private static String message5 = " ";
    private static String message6 = " ";

    public static void initializeTiles(){
        for (int i = 0; i < Attributes.currentIsland.getHeight()-1; i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth()-1; j++) {
                switch (Attributes.currentIsland.getTile(j,i)) {
                    case PLAYER:
                        Attributes.player.setPos(j, i);
                        break;
                    case PIRATE:
                        Attributes.pirates.add(new Pirate("Pirate", j, i, 5)); // TODO make strength and or defense
                        break;
                    case POI:
                        Attributes.peopleInterests.add(new PeopleInterest("POI", j, i, "tells story"));
                        break;
//                    case FRIENDLY:
//                        Attributes.friendlys.add(new Friendly("Friendly", x, y));  //  maybe??
//                        break;
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
                tile = Attributes.currentIsland.getTile(Entity.getPosX(), Entity.getPosY()-1);
                break;
            case LEFT:
                tile = Attributes.currentIsland.getTile(Entity.getPosX()-1, Entity.getPosY());
                break;
            case DOWN:
                tile = Attributes.currentIsland.getTile(Entity.getPosX(), Entity.getPosY()+1);
                break;
            case RIGHT:
                tile = Attributes.currentIsland.getTile(Entity.getPosX()+1, Entity.getPosY());
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
                message4 = " ";
                message5 = " ";
                message6 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
                message2 = " ";
                message3 = " ";
                break;
            case DOCK:
                message = "Do you want to return to your Ship?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.RETURN_TO_SHIP;
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
                message = "This door is locked. Do you want to use a key and open it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.OPEN_DOOR;
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
                message2 = " ";
                message3 = "Rum Runner Island [2]    Port Royal [3]    Isle Cruces [4]";
                message4 = "Isla De Muerta [5]    Treasure Island [6]";
                message5 = " ";
                message6 = " ";
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
                ArrayList<String> m = PeopleInterest.poiTree(dir, Island.getIslandName(Island.getIslandNumber()));
                message = m.get(0);
                message2 = m.get(1);
                message3 = m.get(2);
                message4 = m.get(3);
                message5 = m.get(4);
                message6 = m.get(5);
                break;
            case COINTOSS:
                message = "Would you like to play CoinToss for 5 Gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decided = Decision.COIN_TOSS;
                break;
            case CLUE:
                Attributes.player.move(dir);
                message = "You found a clue?";
                message2 = " ";
                message3 = " ";
//                decided = Decision.COIN_TOSS;
                break;
            default:
                System.out.println("Where are you???");
                break;
        }
    }


    private enum LocationDecision {
        LOCATION,
        NOWHERE;
    }

    private enum Decision {
        NONE,
        RUM_UP,
        COIN_TOSS,
        RETURN_TO_SHIP,
        OPEN_DOOR;
    }

    private enum CoinTossDecision {
        NONE,
        SIDEOFCOIN;
    }
    private static LocationDecision locationDecided = LocationDecision.NOWHERE;

    private static CoinTossDecision tossDecision = CoinTossDecision.NONE;

    private static Decision decided = Decision.NONE;


    //DECISION TREE
    public static void decisionTree(boolean yn) {
        System.out.println(yn);
        if (decided == Decision.NONE) {
            return;
        }
        else if(decided == Decision.RETURN_TO_SHIP && yn) {
            Attributes.currentIsland = new Island(1);
            Attributes.currentMap = new Maps(1);
            message = "You have returned to your Ship!"; // 89 char
            message2 = " ";
            message3 = " ";
            MyMethods.initializeTiles();
        }
        else if (decided == Decision.RETURN_TO_SHIP) {
            message = "Arhg... Fine, stay here.";
            message2 = " ";
            message3 = " ";
        }
        else if(decided == Decision.RUM_UP && yn) {
            Attributes.player.heal(MyMethods.getRandomNumber(5)+3);
            Attributes.player.addsXP(2);
            message = "Down the hatchet...";
            message2 = "+ HP";
            message3 = "+2 XP";
            Attributes.player.move();//replace tile to .
        }
        else if(decided == Decision.RUM_UP) {
            message = "I'm too drunk already!";
            message2 = "";
            message3 = "";
        }
        else if(decided == Decision.COIN_TOSS && yn) {
            if (Attributes.player.getsGold() >= 5) {
                message = "Heads or Tails?";
                message2 = "    [H]        [T]";
                tossDecision = CoinTossDecision.SIDEOFCOIN;
            }
            else {
                message = "You don't have enough Gold...";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decided == Decision.COIN_TOSS) {
            message = "'I'd rather not lose me money...'";
            message2 = " ";
        }
        else if(decided == Decision.OPEN_DOOR && yn) {
            if (Attributes.player.getsKeys() >= 1) {
                Attributes.player.takesKey();
                Attributes.player.addsXP(2);
                message = "You opened the door!";
                message2 = " On with ye discovery...";
                message3 = " "; //Open chest
                Attributes.player.move();
            }
            else{
                message = "You don't have any keys!";
                message2 = " ";
            }

        }
        else if(decided == Decision.OPEN_DOOR) {
                message = "You might be better off not knowing what's behind this door!";
                message2 = " ";
                message3 = " ";
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
            MyMethods.initializeTiles();
        }
        else if (islandNumber == 3) {
            //check for special key and map ------------------------------------------TODO
            // no key no go message
            Attributes.currentIsland = new Island(3);
            Attributes.currentMap = new Maps(3);
            MyMethods.initializeTiles();
        }
        else {
            message = "Argh... fine, stay here.";
        }
        locationDecided = LocationDecision.NOWHERE;
    }

    public static void coinTossTree(String chooseCoinSide) {
        HeadsOrTails.coinToss();
        System.out.println(chooseCoinSide);
        if (tossDecision == CoinTossDecision.NONE) {
            return;
        }
        else if (chooseCoinSide.equals("Heads")) {
            System.out.println("You chose heads");
            message = "You chose Heads...";
            if (HeadsOrTails.coinSide.equals("Heads")) {
                Attributes.player.addsGold(5);
                Attributes.player.addsXP(2);
                message2 = "Coin landed on Heads...";
                message3 = "You Win!";
                message4 = "+5 Gold";
                message5 = "+2 XP";
            }
            else {
                message = "Coin landed on Tails...";
                message2 = "You Lose!";
                message4 = "-5 Gold";
                Attributes.player.takesGold(5);
            }
        }
        else if (chooseCoinSide.equals("Tails")) {
            System.out.println("You chose Tails");
            message = "You chose Tails";
            if (HeadsOrTails.coinSide.equals("Tails")) {
                Attributes.player.addsGold(5);
                Attributes.player.addsXP(2);
                message2 = "Coin landed on Tails...";
                message3 = "You Win!";
                message4 = "+5 Gold";
                message5 = "+2 XP";
            }
            else {
                message = "Coin landed on Heads...";
                message2 = "You Lose!";
                message4 = "-5 Gold";
                Attributes.player.takesGold(5);
            }
        }
        else {
            message = "Argh... I hate this game.";
        }
        tossDecision = CoinTossDecision.NONE;
    }

    // Returns messages
    public static String getMessage() {return message;}

    public static String getMessage2() {return message2;}

    public static String getMessage3() {return message3;}

    public static String getMessage4() {return message4;}

    public static String getMessage5() {return message5;}

    public static String getMessage6() {return message6;}


    public static void checkIsDead() {
        if(Attributes.player.getHealth()<=0) {
            System.out.println("You Died!");
            Attributes.player.setDead();
        }
    }

}



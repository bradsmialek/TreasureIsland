package com.treasureisland;

import com.treasureisland.components.*;
import com.treasureisland.utilities.BlackJackGame;
import com.treasureisland.utilities.MyMethods;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:21 PM
 */
public class Attributes {
    public static final int windowWidth = 1500;
    public static final int windowHeight = 1000;

    public static final int islandCount = 3;
    public static final int mapCount = 3;

    public static Island currentIsland;
    public static Maps currentMap;
    public static Player player;
    public static Vendor vendorItems = Vendor.getInstance();
    public static SubGames currentSubGame = SubGames.NONE;

    public static ArrayList<Pirate> pirates;
    public static ArrayList<PeopleInterest> peopleInterests;
    public static ArrayList<Clues> clues;


    public static Island getCurrentIsland() {
        return currentIsland;
    }

    public static Maps getCurrentMap() {
        return currentMap;
    }

    public static void routeCommand(boolean tf) {
        switch(currentSubGame) {
            case BLACKJACK:
                BlackJackGame.decisionRouting(tf);
                break;
            case NONE:
                MyMethods.decisionTree(tf);
                break;
            default:
                throw new Error("Something went wrong you have not registered a router for this type of subgame");
        }
    }

}

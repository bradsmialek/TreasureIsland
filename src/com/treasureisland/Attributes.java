package com.treasureisland;

import com.treasureisland.components.Island;
import com.treasureisland.components.Pirate;
import com.treasureisland.components.Player;
import com.treasureisland.components.Vendor;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:21 PM
 */
public class Attributes {
    public static final int windowWidth = 1500;
    public static final int windowHeight = 1000;

    public static final int islandCount = 3;

    public static Island currentIsland;
    public static Player player;
    public static Vendor vendorItems = Vendor.getInstance();
    public static ArrayList<Pirate> pirates;

    public static Island getCurrentIsland() {
        return currentIsland;
    }

}

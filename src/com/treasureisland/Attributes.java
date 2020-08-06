package com.treasureisland;

import com.treasureisland.components.Island;
import com.treasureisland.components.Maps;
import com.treasureisland.components.Player;
import com.treasureisland.components.Vendor;

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

    public static Island getCurrentIsland() {
        return currentIsland;
    }

    public static Maps getCurrentMap() {
        return currentMap;
    }


}

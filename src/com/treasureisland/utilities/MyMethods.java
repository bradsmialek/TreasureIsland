package com.treasureisland.utilities;

import com.treasureisland.Attributes;
import com.treasureisland.components.Player;

import java.util.Random;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 5:10 AM
 */
public class MyMethods {

    public static void initializeTiles(){
        for (int i = 0; i < Attributes.currentIsland.getHeight(); i++) {
            for (int j = 0; j < Attributes.currentIsland.getWidth(); j++) {
                switch (Attributes.currentIsland.getTile(j,i)) {
                    case '@':
                        Attributes.player.setPos(j, i);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static int getRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n) + 1;
    }
}

package com.treasureisland.utilities;

public class HeadsOrTails {
    public static String coinSide;
    public static void coinToss() {

        if (Math.random() < 0.5) {
            System.out.println("Landed on Heads");
            coinSide = "Heads";
        }
        else {
            System.out.println("Landed on Tails");
            coinSide = "Tails";
        }
    }
}

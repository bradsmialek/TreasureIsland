package com.treasureisland.utilities;

public class HeadsOrTails {
    public static String coinSide;
    public static void coinToss() {

        if (Math.random() < 0.5) {
            System.out.println("Heads");
            coinSide = "Heads";
        }
        else {
            System.out.println("Tails");
            coinSide = "Tails";
        }
    }
}

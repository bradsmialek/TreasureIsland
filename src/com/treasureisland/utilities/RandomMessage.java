package com.treasureisland.utilities;

import java.util.Random;

public class RandomMessage {
    @Override
    public String toString() {
        return "RandomMessage{}";
    }

    public static String randomMessageGenerator(){
        String [] messageArr = {"'Ahoy ye matey!'", "'Bloody pirates...'", "'Off with ye!'", "'Yo-ho and a bottle of rum!'", "'Have ye seen me eye?'" };
        Random randomMessage = new Random();

        int selectedMessage = randomMessage.nextInt(messageArr.length);
        String message = messageArr[selectedMessage];

        System.out.println("Random Message selected: " + message);
        return message;
    }
}

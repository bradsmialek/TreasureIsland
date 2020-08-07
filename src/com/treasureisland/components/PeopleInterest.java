package com.treasureisland.components;

import com.treasureisland.Attributes;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Tue - 8/4/20 @ 12:24 PM
 * POI Logic
 */
public class PeopleInterest extends Entity {

    private static int tileX;
    private static int tileY;
    public static ArrayList<String> messages;

    private String name;

    public PeopleInterest(String name, int posX, int posY, String story) {
        super(posX, posY, story);
        System.out.println("PEOPLEINTERST CLASS: JUST FINISHED CALL TO SUPER[ENTITY]");
        this.name=name;

    }


    public static void poiTree(int x, int y, String island){

        messages = new ArrayList<>();

        if(island == "Black Pearl"){
            System.out.println("\nNow Talking to POI at ("+x+","+y+") from "+island);

            if (x == 57 && y == 9){
                System.out.println("true");
                //go get message from this person
                messages.add("Ask master brewer for the Sunshine Rum sample.");
                messages.add("Ask master brewer for the Sunshine Rum sample.");
                messages.add("Ask master brewer for the Sunshine Rum sample.");
                messages.add("Ask master brewer for the Sunshine Rum sample.");
                messages.add("Ask master brewer for the Sunshine Rum sample.");
                messages.add("Ask master brewer for the Sunshine Rum sample.");
//                System.out.println(messages.get(0));
            }
//            if (x == 57 && y == 9){
//                System.out.println("true");
//                //go get message from this person
//            }
//            if (x == 57 && y == 9){
//                System.out.println("true");
//                //go get message from this person
//            }
//            if (x == 57 && y == 9){
//                System.out.println("true");
//                //go get message from this person
//            }

        }
        if(island == "Rum Runner Island"){
            System.out.println("\nNow Talking to POI at ("+x+","+y+") from "+island);
        }

        if(island == "Port Royal"){
            System.out.println("\nNow Talking to POI at ("+x+","+y+") from "+island);
        }


    }

    public String getName(){
        return name;
    }
}

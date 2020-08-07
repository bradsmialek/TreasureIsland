package com.treasureisland.components;

/**
 * Created by bradsmialek on Tue - 8/4/20 @ 12:24 PM
 * POI Logic
 */
public class PeopleInterest extends Entity {

    private static int tileX;
    private static int tileY;

    private String name;

    public PeopleInterest(String name, int posX, int posY, String story) {
        super(posX, posY, story);
        System.out.println("PEOPLEINTERST CLASS: JUST FINISHED CALL TO SUPER[ENTITY]");
        this.name=name;

    }


    public static void poiTree(int x, int y, String island){
//        get current island
//                get posx  get pos y of ?   and character
//                if same
//                display correct story

        //to left x decremaent, y same       20 , 13    (19,13 / 21,13) or  (20,12 / 20,14)
         // up x same , y decrament


        if(island == "Black Pearl"){
            System.out.println("black pearl");
            System.out.println(x);
            System.out.println(y);


//            if (){
//
//            }
        }
        if(island == "Rum Runner Island"){
            System.out.println("Rum Runner Island");
            System.out.println(x);
            System.out.println(y);
        }
        if(island == "Port Royal"){
            System.out.println("Port Royal");
            System.out.println(x);
            System.out.println(y);
        }


    }

    public String getName(){
        return name;
    }
}

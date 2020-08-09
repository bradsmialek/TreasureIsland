package com.treasureisland.components;

/**
 * Created by bradsmialek on Thu - 8/6/20 @ 9:46 PM
 */
public class Pirate extends Entity{
    private String name;

    //Create a pirate
    public Pirate(String name, int posX, int posY, int health) { //endurance and or strenght later
        super(posX, posY, health);
        this.name=name;
        System.out.println("PIRATE CLASS: CREATING PIRATE AT "+posX+ " "+posY);
    }



    public String getName() {
        return name;
    }
}


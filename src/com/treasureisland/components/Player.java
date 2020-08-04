package com.treasureisland.components;

import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:21 AM
 */
public class Player extends Entity {

    public Player(int posX, int posY) {
        super(posX, posY);
        this.health = 20;
        this.maxHealth = 20;
        System.out.println("PLAYER CLASS: CREATING PLAYER");
    }

    @Override
    public void move(Directions dir){
        super.move(dir);
        System.out.println("PLAYER CLASS: POSITION IS "+posX+" "+posY);
    }
}

package com.treasureisland.components;

import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:21 AM
 */
public class Player extends Entity {

    private Directions facing;
    private boolean alive;

    public Player(int posX, int posY) {
        super(posX, posY,20);
        this.alive = true;

        System.out.println("PLAYER CLASS: CREATING PLAYER");
    }

    @Override
    public void move(Directions dir){
        super.move(dir);
        System.out.println("PLAYER CLASS: POSITION IS "+posX+" "+posY);
    }

    public void move() {
        this.move(facing);
    }

    public void setFacing(Directions dir) {
        this.facing = dir;
    }

    public boolean isLiving() {
        return alive;
    }

    public void setDead() {
        this.alive = false;
    }

}

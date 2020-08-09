package com.treasureisland.components;

import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:21 AM
 */
public class Player extends Entity {



    private Directions facing;
    private int keys;
    private int gold;
    private boolean alive;

    public Player(int posX, int posY) {
        super(posX, posY,20, 0, 1);
        System.out.println("PLAYER CLASS: JUST FINISHED CALL TO SUPER[ENTITY]");
        this.gold = 0;
        this.keys = 0;

    }

    @Override
    public void move(Directions dir){
        super.move(dir);
        System.out.println("\nPLAYER CLASS: POSITION IS NOW "+posX+" "+posY);
    }

    public void move() {
        this.move(facing);
    }

    public void setFacing(Directions dir) {
        this.facing = dir;
    }

    public Directions getFacing() {
        return facing;
    }

    public int getsKeys() {
        return keys;
    }

    public void addsKey() {
        keys++;
    }

    public void takesKey() {
        if(keys>0)
            keys--;
    }

    public int getsGold() {
        return gold;
    }

    /**Adds gold to the player
     * @param amount - The amount of gold to add*/
    public void addsGold(int amount) {
        gold+=amount;
    }

    public void takesGold(int amount) {
        gold-=amount;
    }

    public void addsXP(int amount){
        xp+= amount;
    }

    public boolean isLiving() {
        return alive;
    }

    public void setDead() {
        this.alive = false;
    }

}

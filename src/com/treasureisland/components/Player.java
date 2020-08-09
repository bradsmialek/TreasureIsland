package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:21 AM
 */
public class Player extends Entity {

    private Directions facing;
    private int keys;
    private int gold;
    private boolean alive;

//    public Player(int posX, int posY) {
//
//        super(posX, posY,20);
//
//        System.out.println("PLAYER CLASS: CREATING PLAYER AT "+posX+ " "+posY);
//        this.gold = 0;
//        this.keys = 0;
//
//    }

    public Player(int posX, int posY) {
        super(posX, posY, 20);
        this.gold=0;
//        this.equippedWeapon = Weapon.hand;
//        this.equippedArmor = Armor.normal;
        this.alive=true;
        System.out.println("PLAYER CLASS: CREATING PLAYER AT "+posX+ " "+posY);
    }

    @Override
    public void move(Directions dir){
        super.move(dir);
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

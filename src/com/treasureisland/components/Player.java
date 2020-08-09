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


    public Player(int x, int y) {
        super(x, y, 20);
        this.gold=0;
//        this.equippedWeapon = Weapon.hand;
//        this.equippedArmor = Armor.normal;
        this.alive=true;
        System.out.println("PLAYER CLASS: CREATING PLAYER AT "+x+ " "+y);
    }

    @Override
    public void move(Directions dir){
        super.move(dir);
        System.out.println("\nPLAYER CLASS: POSITION IS NOW "+x+" "+y);
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

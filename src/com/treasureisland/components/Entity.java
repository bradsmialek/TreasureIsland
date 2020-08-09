package com.treasureisland.components;


import com.treasureisland.utilities.Directions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:49 AM
 */
public class Entity {

    protected static int x;
    protected static int y;
    protected int health;
    protected int xp;
    protected int level;
    protected int nextLevel = 100;
    protected int maxHealth;


    //Character and Pirate
    protected Entity(int x, int y, int health) {

        this.setPos(x, y);
        this.health=health;
        this.maxHealth=health;
    }

    //SETTERS

    // CHARACTER
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    // GETTERS
    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }


    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getXP() {
        return xp;
    }

    public void damage(int dmg){
        this.health -= dmg;
    }

    public void heal(int amount){
        this.health+=amount;
        if (health>maxHealth)health=maxHealth;
    }

    public int getsLevel() {
        return level;
    }

    public int getNextLevel(){
        return nextLevel;
    }

    public void gainXP(int amount) {
        this.xp+=amount;
        setLevel(this.xp);
    }

    public void setLevel(int xp){

        if(xp>=500) {
            this.level = 6;
        }
        else if(xp>=400) {
            this.level = 5;
        }
        else if(xp>=300) {
            this.level = 4;
        }
        else if(xp>=200) {
            this.level = 3;
        }
        else if(xp>=100) {
            this.level = 2;
        }
        else if(xp>=0) {
            this.level = 1;
        }
        setNextLevel(this.level);
    }

    public void setNextLevel(int level) {
        System.out.println("here at set next level");
        if(level == 6) {
            this.nextLevel = 600;
        }
        else if(level == 5) {
            this.nextLevel = 500;
        }
        else if(level == 4) {
            this.nextLevel = 400;
        }
        else if(level == 3) {
            this.nextLevel = 300;
        }
        else if(level == 2) {
            this.nextLevel = 200;
        }
        else if(level == 1) {
            this.nextLevel = 100;
        }
    }

    protected void move(Directions dir) {
        switch (dir) {
            case UP:
                this.y--;
                break;
            case LEFT:
                this.x--;
                break;
            case DOWN:
                this.y++;
                break;
            case RIGHT:
                this.x++;
                break;
        }
    }
}

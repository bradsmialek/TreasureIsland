package com.treasureisland.components;


import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:49 AM
 */
public class Entity {

    protected static int posX;
    protected static int posY;
    protected static int posXinterest;
    protected static int posYinterest;
    protected static int posXpirate;
    protected static int posYpirate;
    protected int health;
    protected int pirateHealth;
    protected int xp;
    protected int level;
    protected int nextLevel = 100;
    protected int maxHealth;


    // OBJECT Constructors

    //Character
    protected Entity(int posX, int posY, int health, int xp, int level) {
        System.out.println("\n[Setting Character @ x: "+posX+", "+"y: "+posY+"]");
        this.setPos(posX, posY);
        this.health=health;
        this.maxHealth=health;
        this.xp = xp;
        this.level = level;
    }

    //character
    protected Entity(int posX, int posY) {
        System.out.println("setting somethings x,y");
        this.setPos(posX, posY);
    }

    //People of interest
    protected Entity(int posX, int posY, String story) {
        System.out.println("\n[Setting POI @ x: "+posX+", y: "+posY+"]");
        this.setInterestsPos(posX, posY);
    }

    //Pirate
    protected Entity(int posX, int posY, int health) {
        System.out.println("\n[Setting PIRATE @ x: "+posX+", y: "+posY+"]");
        this.setPiratePos(posX, posY);
        this.pirateHealth=health;
    }

    //SETTERS

    // CHARACTER
    public void setPos(int posX, int posY){
        System.out.println("[Done Setting Character @ x: "+posX+", "+"y: "+posY);
        this.posX = posX;
        this.posY = posY;
    }

    //PEOPLE OF INTEREST
    public void setInterestsPos(int x, int y){
        System.out.println("[Done Setting POI @ x: "+x+", y: "+y+"]");
        this.posXinterest = x;
        this.posYinterest = y;
    }

    //PIRATES
    public void setPiratePos(int x, int y){
        System.out.println("[Done Setting PIRATE @ x: "+x+", y: "+y+"]");
        this.posXpirate = x;
        this.posYpirate = y;
    }

    // GETTERS
    public static int getPosX() {
        return posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static int getPosXinterest() {
        return posXinterest;
    }

    public static int getPosYinterest() {
        return posYinterest;
    }

    public static int getPosXpirate() {
        return posXpirate;
    }

    public static int getPosYpirate() {
        return posYpirate;
    }

    public int getPirateHealth() {
        return pirateHealth;
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
                this.posY--;
                break;
            case LEFT:
                this.posX--;
                break;
            case DOWN:
                this.posY++;
                break;
            case RIGHT:
                this.posX++;
                break;
        }
    }
}

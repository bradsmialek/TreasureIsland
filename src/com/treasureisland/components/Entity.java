package com.treasureisland.components;


import com.treasureisland.utilities.Directions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:49 AM
 */
public class Entity {

    protected static int posX;
    protected static int posY;
    protected static int posXClue;
    protected static int posYClue;
    private static int posXinterest;
    private static int posYinterest;
    protected static int posXpirate;
    protected static int posYpirate;

    protected int health;
    protected int pirateHealth;
    protected int xp;
    protected int level;
    protected int nextLevel = 100;
    protected int maxHealth;


    public static List<Integer> myCoords = new ArrayList<>();
    // OBJECT Constructors

    //Character and Pirate
    protected Entity(int posX, int posY, int health) {

        this.setPos(posX, posY);
//        this.setPiratePos(posX, posY);
        this.health=health;
        this.maxHealth=health;

    }

    //People of interest
    protected Entity(int posX, int posY, String type) {

        this.setInterestsPos(posX, posY);
        addtoArray(posX, posY);
    }

    //Clue
    protected Entity(int posX, int posY, char c) {

        this.setCluePos(posX, posY);
    }
//
    public static void addtoArray(int x, int y){
        myCoords.add(x);
        myCoords.add(y);
    }
//
    public static List<Integer> getMyCoords() {
        return myCoords;
    }

    //Pirate
//    protected Entity(int posX, int posY, int health) {
//        System.out.println("\n[Setting PIRATE @ x: "+posX+", y: "+posY+"]");
//        this.setPiratePos(posX, posY);
//        this.health = health;
//        this.pirateHealth=health;
////        this.setPos(posX,posY);
//    }



    //SETTERS

    // CHARACTER
    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    //PEOPLE OF INTEREST
    public void setInterestsPos(int x, int y){

        posXinterest = x;
        posYinterest = y;
    }

    //Clue
    public void setCluePos(int x, int y){
        posXClue = x;
        posYClue = y;
    }
    //PIRATES
    public void setPiratePos(int x, int y){

        this.posXpirate = x;
        this.posYpirate = y;
    }

    // GETTERS
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosXinterest() {
        return posXinterest;
    }

    public int getPosYinterest() {
        return posYinterest;
    }

//    public static int getPosXpirate() {
//        return posXpirate;
//    }
//
//    public static int getPosYpirate() {
//        return posYpirate;
//    }

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

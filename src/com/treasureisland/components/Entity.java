package com.treasureisland.components;


import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:49 AM
 */
public class Entity {

    protected int posX;
    protected int posY;
    protected int health;
    protected int maxHealth;

    //PLAYER OBJECT
    protected Entity(int posX, int posY) {
        this.setPos(posX, posY);
    }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    // GETTERS
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void damage(int dmg){
        this.health -= dmg;
    }

    public void heal(int amount){
        this.health+=amount;
        if (health>maxHealth)health=maxHealth;
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

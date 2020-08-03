package com.treasureisland.components;


import com.treasureisland.utilities.Directions;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 12:49 AM
 */
public class Player {

    private int posX;
    private int posY;

    //PLAYER OBJECT
    public Player(int posX, int posY) {

        System.out.println("PLAYER CLASS: CREATING PLAYER");
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

    public void move(Directions dir) {
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
        System.out.println("PLAYER CLASS: POSITION IS "+posX+" "+posY);
    }
}

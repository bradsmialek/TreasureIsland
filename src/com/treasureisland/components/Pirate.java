package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.MyMethods;
import com.treasureisland.utilities.Tile;

import java.sql.Ref;
//import sun.security.pkcs11.wrapper.Functions;

/**
 * Created by bradsmialek on Thu - 8/6/20 @ 9:46 PM
 */
public class Pirate extends Entity{

    private String name;

    //Create a pirate
//    public Pirate(int posX, int posY, int health) { //endurance and or strenght later
//        super(posX, posY, health);
//
//    }

    public Pirate(String name, int posX, int posY, int health) {
        super(posX, posY, health);
        this.name=name;
        System.out.println("PIRATE CLASS: CREATING PIRATE AT "+posX+ " "+posY);
    }

    // Randomly moves pirate
    public void randomMove() {
        switch(MyMethods.getRandomNumber(4)) {
            case 1:
                System.out.println("case 1");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1));
                if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1) == Tile.NOTHING)
                    super.move(Directions.UP);
                else if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1) == Tile.PLAYER)
                    MyMethods.fightPirate(Directions.UP);
                break;
            case 2:
                System.out.println("case 2");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1));
                if(Attributes.currentIsland.getTile(this.getPosX()-1, this.getPosY()) == Tile.NOTHING)
                    super.move(Directions.LEFT);
                else if(Attributes.currentIsland.getTile(this.getPosX()-1, this.getPosY()) == Tile.PLAYER)
                    MyMethods.fightPirate(Directions.LEFT);
                break;
            case 3:
                System.out.println("case 3");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1));
                if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()+1) == Tile.NOTHING)
                    super.move(Directions.DOWN);
                else if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()+1) == Tile.PLAYER)
                    MyMethods.fightPirate(Directions.DOWN);
                break;
            case 4:
                System.out.println("case 4");
                System.out.println(this);
                System.out.println(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1));
                if(Attributes.currentIsland.getTile(this.getPosX()+1, this.getPosY()) == Tile.NOTHING)
                    super.move(Directions.RIGHT);
                else if(Attributes.currentIsland.getTile(this.getPosX()+1, this.getPosY()) == Tile.PLAYER)
                    MyMethods.fightPirate(Directions.RIGHT);
                break;

        }
    }
    public String getName() {return name;}


}


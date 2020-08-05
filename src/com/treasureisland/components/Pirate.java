package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.MyMethods;
import com.treasureisland.utilities.Tile;

public class Pirate extends Entity{
    private String name;

    public Pirate(int posX, int posY, int health) {
        super(posX, posY, health);
        this.name = name;
        System.out.println("[Pirate]: Creating a Pirate");
    }

    public void moveRandom() {
        switch(MyMethods.getRandomNumber(4)) {
            case 1:
                if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1) == Tile.NOTHING)
                    super.move(Directions.UP);
                else if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()-1) == Tile.PLAYER)
                    MyMethods.pirateEncounter(Directions.UP);
                break;
            case 2:
                if(Attributes.currentIsland.getTile(this.getPosX()-1, this.getPosY()) == Tile.NOTHING)
                    super.move(Directions.LEFT);
                else if(Attributes.currentIsland.getTile(this.getPosX()-1, this.getPosY()) == Tile.PLAYER)
                    MyMethods.pirateEncounter(Directions.LEFT);
                break;
            case 3:
                if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()+1) == Tile.NOTHING)
                    super.move(Directions.DOWN);
                else if(Attributes.currentIsland.getTile(this.getPosX(), this.getPosY()+1) == Tile.PLAYER)
                    MyMethods.pirateEncounter(Directions.DOWN);
                break;
            case 4:
                if(Attributes.currentIsland.getTile(this.getPosX()+1, this.getPosY()) == Tile.NOTHING)
                    super.move(Directions.RIGHT);
                else if(Attributes.currentIsland.getTile(this.getPosX()+1, this.getPosY()) == Tile.PLAYER)
                    MyMethods.pirateEncounter(Directions.RIGHT);
                break;
        }
    }

    public String getName() {return name;}
}

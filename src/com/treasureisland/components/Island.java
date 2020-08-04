package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Action;
import com.treasureisland.utilities.Tile;
import com.treasureisland.utilities.ComponentsManager;
import com.treasureisland.utilities.Directions;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:56 PM
 * Islands
 */
public class Island {

    private ArrayList<ArrayList<Tile>> tiles;

    public Island(int islandNumber) {
        System.out.println("ISLAND CLASS: CREATING ISLAND "+islandNumber);

        tiles = new ArrayList<ArrayList<Tile>>();

        ArrayList<String> strs = ComponentsManager.readIslandFile("src/com/treasureisland/islands/island"
                +islandNumber+".txt");

        for(int i =0; i < strs.size()-1; i++){
            char[] charray = strs.get(i).toCharArray();
            tiles.add(new ArrayList<Tile>());
            for (int j = 0; j < charray.length; j++){
                switch (charray[j]){
                    case '.':
                        tiles.get(i).add(Tile.NOTHING);
                        break;
                    case '#':
                        tiles.get(i).add(Tile.WALL);
                        break;
                    case '@':
                        tiles.get(i).add(Tile.PLAYER);
                        break;
                    case '^':
                        tiles.get(i).add(Tile.DOCK);
                        break;
                    case 'P':
                        tiles.get(i).add(Tile.PIRATE);
                        break;
                    case 'F':
                        tiles.get(i).add(Tile.FRIENDLY);
                        break;
                    case 'r':
                        tiles.get(i).add(Tile.RUM);
                        break;
                }
            }
        }



    }

    public int getHeight() {
        return tiles.size();
    }

    public int getWidth() {
        return tiles.get(0).size();
    }

    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    public char getTileChar(int x, int y) {
        return tiles.get(y).get(x).symbol();
    }

    public boolean tileDoesMove(Entity tile, Directions dir) {
        switch (dir) {
            case UP:
                if (tiles.get(tile.getPosY()-1).get(tile.getPosX()) != Tile.WALL)
                    return  true;
                break;
            case LEFT:
                if (tiles.get(tile.getPosY()).get(tile.getPosX()-1) != Tile.WALL)
                    return  true;
                break;
            case DOWN:
                if (tiles.get(tile.getPosY()+1).get(tile.getPosX()) != Tile.WALL)
                    return  true;
                break;
            case RIGHT:
                if (tiles.get(tile.getPosY()).get(tile.getPosX()+1) != Tile.WALL)
                    return  true;
                break;
        }
        return false;
    }

    public void posUpdate(){
        //DELETES
        for(int i = 0 ; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (tiles.get(i).get(j) == Tile.PLAYER)
                    tiles.get(i).set(j, Tile.NOTHING);
            }
        }
        //PLAYER
        tiles.get(Attributes.player.getPosY()).set(Attributes.player.getPosX(), Tile.PLAYER);
    }

    public static void getRandomFloor(){

    }

}

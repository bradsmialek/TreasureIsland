package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Actions;
import com.treasureisland.utilities.ComponentsManager;
import com.treasureisland.utilities.Directions;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sun - 8/2/20 @ 8:56 PM
 * Islands
 */
public class Island {

    private ArrayList<char[]> tiles;

    public Island(int islandNumber) {
        System.out.println("ISLAND CLASS: CREATING ISLAND "+islandNumber);

        tiles = new ArrayList<char[]>();

        ArrayList<String> strs = ComponentsManager.readIslandFile("src/com/treasureisland/islands/island"
                +islandNumber+".txt");

        for(int i =0; i < strs.size()-1; i++){
            tiles.add(strs.get(i).toCharArray());
        }



    }

    public int getHeight() {
        return tiles.size();
    }

    public int getWidth() {
        return tiles.get(0).length;
    }

    public char getTile(int x, int y) {
        return tiles.get(y)[x];
    }

    public Actions tileDoesMove(MovingTile tile, Directions dir) {
        switch (dir) {
            case UP:
                if (tiles.get(tile.getPosY()-1)[tile.getPosX()]=='.')
                    return Actions.CAN_MOVE;
                else if (tiles.get(tile.getPosY()-1)[tile.getPosX()]=='^')
                    return Actions.CHANGE_ISLAND;
                else if (tiles.get(tile.getPosY()-1)[tile.getPosX()]=='P')
                    return Actions.TRAPPED;
                break;
            case LEFT:
                if (tiles.get(tile.getPosY())[tile.getPosX()-1]=='.')
                    return Actions.CAN_MOVE;
                else if (tiles.get(tile.getPosY())[tile.getPosX()-1]=='^')
                    return Actions.CHANGE_ISLAND;
                else if (tiles.get(tile.getPosY())[tile.getPosX()-1]=='P')
                    return Actions.TRAPPED;
                break;
            case DOWN:
                if (tiles.get(tile.getPosY()+1)[tile.getPosX()]=='.')
                    return Actions.CAN_MOVE;
                else if (tiles.get(tile.getPosY()+1)[tile.getPosX()]=='^')
                    return Actions.CHANGE_ISLAND;
                else if (tiles.get(tile.getPosY()+1)[tile.getPosX()]=='P')
                    return Actions.TRAPPED;
                break;
            case RIGHT:
                if (tiles.get(tile.getPosY())[tile.getPosX()+1]=='.')
                    return Actions.CAN_MOVE;
                else if (tiles.get(tile.getPosY())[tile.getPosX()+1]=='^')
                    return Actions.CHANGE_ISLAND;
                else if (tiles.get(tile.getPosY())[tile.getPosX()+1]=='P')
                    return Actions.TRAPPED;
                break;
        }
        return Actions.NOTHING;
    }

    public void posUpdate(){
        //DELETES
        for(int i = 0 ; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (tiles.get(i)[j] == '@')
                    tiles.get(i)[j] = '.';
            }
        }
        //PLAYER
        tiles.get(Attributes.player.getPosY())[Attributes.player.getPosX()] = '@';
    }

    public static void getRandomFloor(){

    }

}

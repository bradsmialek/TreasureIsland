package com.treasureisland.components;

import com.treasureisland.Attributes;
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

    public boolean playerDoesMove(Directions dir) {
        switch (dir) {
            case UP:
                return tiles.get(Attributes.player.getPosY()-1)[Attributes.player.getPosX()]!='#';
            case LEFT:
                return tiles.get(Attributes.player.getPosY())[Attributes.player.getPosX()-1]!='#';
            case DOWN:
                return tiles.get(Attributes.player.getPosY()+1)[Attributes.player.getPosX()]!='#';
            case RIGHT:
                return tiles.get(Attributes.player.getPosY())[Attributes.player.getPosX()+1]!='#';
            default:
                return false;
        }

    }

    public void posUpdate(){

        for(int i = 0 ; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (tiles.get(i)[j] == '@')
                    tiles.get(i)[j] = '.';
            }
        }
        tiles.get(Attributes.player.getPosY())[Attributes.player.getPosX()] = '@';
    }
}

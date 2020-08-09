package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Tile;
import com.treasureisland.utilities.ComponentsManager;

import java.util.ArrayList;

/**
 * Islands
 */
public class Island {

    private ArrayList<ArrayList<Tile>> tiles;

    private static int islandNumber = 0;
    private static String islandName = "Rum Runner Island";


    public Island(int islandNumber) {
        Island.setIslandNumber(islandNumber);
        System.out.println("\nISLAND CLASS: CREATING ISLAND "+islandNumber);

        tiles = new ArrayList<ArrayList<Tile>>();

        ArrayList<String> strs = ComponentsManager.readIslandFile("src/com/treasureisland/islands/island"
                +islandNumber+".txt");

        for(int i = 0; i < strs.size()-1 ; i++) {
            char[] charray = strs.get(i).toCharArray();
            tiles.add(new ArrayList<Tile>());
            for(int j = 0 ; j < charray.length ; j++) {
                switch(charray[j]) {
                    case '.':
                        tiles.get(i).add(Tile.NOTHING); break;
                    case '#':
                        tiles.get(i).add(Tile.WALL); break;
                    case '@':
                        tiles.get(i).add(Tile.PLAYER); break;
                    case '^':
                        tiles.get(i).add(Tile.DOCK); break;
                    case 'r':
                        tiles.get(i).add(Tile.RUM); break;
                    case 'G':
                        tiles.get(i).add(Tile.GOLD); break;
                    case 'm':
                        tiles.get(i).add(Tile.TREASURE); break;
                    case '!':
                        tiles.get(i).add(Tile.KEY); break;
                    case '/':
                        tiles.get(i).add(Tile.DOOR); break;
                    case 'p':
                        tiles.get(i).add(Tile.PIRATE); break;
                    case 'f':
                        tiles.get(i).add(Tile.FRIENDLY); break;
                    case 'A':
                        tiles.get(i).add(Tile.A); break;
                    case 'B':
                        tiles.get(i).add(Tile.B); break;
                    case 'C':
                        tiles.get(i).add(Tile.COINTOSS); break;
                    case 'D':
                        tiles.get(i).add(Tile.D); break;
                    case 'E':
                        tiles.get(i).add(Tile.E); break;
                    case 'H':
                        tiles.get(i).add(Tile.H); break;
                    case 'I':
                        tiles.get(i).add(Tile.I); break;
                    case 'J':
                        tiles.get(i).add(Tile.J); break;
                    case 'K':
                        tiles.get(i).add(Tile.K); break;
                    case 'L':
                        tiles.get(i).add(Tile.L); break;
                    case 'M':
                        tiles.get(i).add(Tile.M); break;
                    case 'N':
                        tiles.get(i).add(Tile.N); break;
                    case 'O':
                        tiles.get(i).add(Tile.O); break;
                    case 'Q':
                        tiles.get(i).add(Tile.Q); break;
                    case 'R':
                        tiles.get(i).add(Tile.R); break;
                    case 'S':
                        tiles.get(i).add(Tile.S); break;
                    case 'T':
                        tiles.get(i).add(Tile.T); break;
                    case 'U':
                        tiles.get(i).add(Tile.U); break;
                    case 'V':
                        tiles.get(i).add(Tile.VENDOR); break;
                    case 'W':
                        tiles.get(i).add(Tile.W); break;
                    case 'x':
                        tiles.get(i).add(Tile.x); break;
                    case 'Y':
                        tiles.get(i).add(Tile.Y); break;
                    case 'Z':
                        tiles.get(i).add(Tile.Z); break;
                    case '+':
                        tiles.get(i).add(Tile.PLUS); break;
                    case '*':
                        tiles.get(i).add(Tile.MAP); break;
                    case 'X':
                        tiles.get(i).add(Tile.X); break;
                    case '~':
                        tiles.get(i).add(Tile.TILDE); break;
                    case ' ':
                        tiles.get(i).add(Tile.SPACE); break;
                    case '?':
                        tiles.get(i).add(Tile.POI); break;
                    case 'P':
                        tiles.get(i).add(Tile.P); break;
                    case 'F':
                        tiles.get(i).add(Tile.F); break;

                }
            }
        }
//        if(islandNumber == 0) firstFloor = true;//-------------------------------------------------------------------------------TODO
//        else firstFloor = false;
    }


    //Gets the size of the floor on the y coordinate
    public int getHeight() {
        return tiles.size();
    }

    //Gets the size of the floor on the x coordinate
    public int getWidth() {
        return tiles.get(0).size();
    }

    //Returns one tile of the floor
    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }

    //Returns one tile of the floor
    public char getTileChar(int x, int y) {
        return tiles.get(y).get(x).symbol();
    }


    public void posUpdate(){
        //DELETES
        for(int i=0;i<this.getHeight();i++) {
            for(int j=0;j<this.getWidth();j++) {
                if(tiles.get(i).get(j) == Tile.PLAYER)
                    tiles.get(i).set(j, Tile.NOTHING);
            }
        }
        //Sets new pos
        tiles.get(Attributes.player.getPosY()).set(Attributes.player.getPosX(), Tile.PLAYER);
    }

    public static int getIslandNumber() {
        return islandNumber;
    }

    public static void setIslandNumber(int islandNumber) {
        Island.islandNumber = islandNumber;
    }

    public static String getIslandName(int islandNumber){
        if (islandNumber == 0) {
            islandName = "Introduction";
        }
        else if (islandNumber == 1){
            islandName = "Black Pearl";
        }
        else if(islandNumber == 2) {
            islandName = "Rum Runner Island";
        }
        else if(islandNumber == 3) {
            islandName = "Port Royal";
        }
        return islandName;
    }
}

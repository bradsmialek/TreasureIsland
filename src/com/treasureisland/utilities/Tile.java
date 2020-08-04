package com.treasureisland.utilities;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:33 AM
 */
public enum Tile {
    NOTHING ('.'),
    WALL('#'),
    PLAYER('@'),
    DOCK('^'),
    PIRATE('P'),
    FRIENDLY('F'),
    RUM('r');

    private char symbol;

    Tile(char symbol){
        this.symbol=symbol;
    }

    public char symbol(){
        return symbol;
    }

}

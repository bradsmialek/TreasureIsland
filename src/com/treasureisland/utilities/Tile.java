package com.treasureisland.utilities;

/**
 * Created by bradsmialek on Mon - 8/3/20 @ 4:33 AM
 */
public enum Tile {
    NOTHING ('.'),
    WALL('#'),
    PLAYER('@'),
    DOCK('^'),
    PIRATE('p'),
    FRIENDLY('f'),
    RUM('r'),
    GOLD('g'),
    TREASURE('m'),
    KEY('!'),
    DOOR('/'),
    PLUS('+'),
    MAP('*'),
    TILDE('~'),
    SPACE(' '),
    POI('?'),
    CLUE('`'),
    COINTOSS('C'),
    VENDOR('V'),
    A('A'),
    B('B'),
   //C used for cointoss
    D('D'),
    E('E'),
    F('F'),
    G('G'),
    H('H'),
    I('I'),
    J('J'),
    K('K'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    P('P'),
    Q('Q'),
    R('R'),
    S('S'),
    T('T'),
    U('U'),
    //V is for Vendor
    W('W'),
    X('X'),
    Y('Y'),
    Z('Z');


    private char symbol;

    Tile(char symbol){
        this.symbol=symbol;
    }

    public char symbol(){
        return symbol;
    }

}

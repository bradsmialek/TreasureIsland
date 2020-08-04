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
    RUM('r'),
    GOLD('G'),
    TREASURE('m'),
    KEY('!'),
    DOOR('/'),
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    H('H'),
    I('I'),
    J('J'),
    K('K'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    Q('Q'),
    R('R'),
    S('S'),
    T('T'),
    U('U'),
    V('V'),
    W('W'),
    x('x'),
    Y('Y'),
    Z('Z'),
    PLUS('+'),
    MAP('*'),
    X('x'),
    TILDE('~'),
    SPACE(' ');

    private char symbol;

    Tile(char symbol){
        this.symbol=symbol;
    }

    public char symbol(){
        return symbol;
    }

}

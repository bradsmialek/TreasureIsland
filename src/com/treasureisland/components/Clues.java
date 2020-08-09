package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.Storyline;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Sat - 8/8/20 @ 7:16 PM
 */
public class Clues extends Entity{

    public Clues(int posX, int posY) {
        super(posX, posY, 'c');
        System.out.println("CLUES CLASS: CREATING CLUE AT "+posX+ " "+posY);

    }

    public static ArrayList<String> clueTree(Directions direction, String island) {

        int clueX=0, clueY=0;

        switch(direction) {
            case UP:
                clueX = Attributes.player.getPosX(); clueY = Attributes.player.getPosY()-1; break;
            case LEFT:
                clueX = Attributes.player.getPosX()-1; clueY = Attributes.player.getPosY(); break;
            case DOWN:
                clueX = Attributes.player.getPosX(); clueY = Attributes.player.getPosY()+1; break;
            case RIGHT:
                clueX = Attributes.player.getPosX()+1; clueY = Attributes.player.getPosY(); break;
        }
        int sum = clueX+clueY;
        System.out.println("CLUE is at "+clueX+ " "+ clueY);
        System.out.println(sum);

        ArrayList<String> messages = new ArrayList<>();


        if(island.equals("Black Pearl")){
            messages = Storyline.getbPearlClues();
        }
        else if(island.equals("Rum Runner Island")){   //TODO   get positions where clues are created and put them in here as the case.  Look in console for sum
            switch(sum) {
                case 66:
                    messages = Storyline.getRum1Clues();
                    break;
                case 34:
                    messages = Storyline.getRum2messages();
                    break;
                case 25:
                    messages = Storyline.getRum3messages();
                    break;
                case 29:
                    messages = Storyline.getRum4messages();
                    break;

            }
        }

        return messages;
    }

}

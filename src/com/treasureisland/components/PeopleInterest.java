package com.treasureisland.components;

import com.treasureisland.Attributes;
import com.treasureisland.utilities.Directions;
import com.treasureisland.utilities.Storyline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bradsmialek on Tue - 8/4/20 @ 12:24 PM
 * POI Logic
 */
public class PeopleInterest extends Entity {


    private String name;

    public PeopleInterest(String name, int posX, int posY, String story) {
        super(posX, posY, story);
        System.out.println("PEOPLEINTEREST CLASS: JUST FINISHED CALL TO SUPER[ENTITY]");
        this.name=name;

    }

     public static ArrayList<String> poiTree(Directions direction, String island) {

         int poiX=0, poiY=0;

         switch(direction) {
             case UP:
                 poiX = Attributes.player.getPosX(); poiY = Attributes.player.getPosY()-1; break;
             case LEFT:
                 poiX = Attributes.player.getPosX()-1; poiY = Attributes.player.getPosY(); break;
             case DOWN:
                 poiX = Attributes.player.getPosX(); poiY = Attributes.player.getPosY()+1; break;
             case RIGHT:
                 poiX = Attributes.player.getPosX()+1; poiY = Attributes.player.getPosY(); break;
         }
         int sum = poiX+poiY;
         System.out.println("POI is at "+poiX+ " "+ posY);
         System.out.println(sum);

        ArrayList<String> messages = new ArrayList<>();


        if(island.equals("Black Pearl")){
                messages = Storyline.getbPearlMessages();
        }
        else if(island.equals("Rum Runner Island")){
            switch(sum) {
                case 31:
                    messages = Storyline.getRum1messages();
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

    public String getName(){
        return name;
    }
}

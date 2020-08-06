package com.treasureisland.components;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vendor {

    private static final Vendor item = new Vendor();

    public Vendor(){

    }

    public static Vendor getInstance(){ return item;}

    private List<Items> vendorItems = new ArrayList(Arrays.asList(
            new Items("Banana", 1),
            new Items("Rum", 2)
    ));



    public String getAll(){
        for(Items item : vendorItems){
            System.out.println(item.toString());
            return item.toString();
        }
        return item.toString();
    }


    public int size() {
        return vendorItems.size();
    }



    public Items findByName(String name) {
        Items result = null;
        for (Items item : vendorItems) {
            if (item.getItemName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

}

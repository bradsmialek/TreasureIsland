package com.treasureisland.components;

public class Items {
    public String itemName;
    public Integer healthValue;
    public Integer cost;

    private static final Items item = new Items();

    private Items(){

    }

    public static Items getInstance(){ return item;}

    public Items(String itemName, Integer cost){
        setItemName(itemName);
        setCost(cost);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(Integer healthValue) {
        this.healthValue = healthValue;
    }

    public Integer getCost(){
        return cost;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }

    @Override
    public String toString() {
        return " Item = " + itemName + ", cost = " + cost + " gold " +
                "";
    }


}

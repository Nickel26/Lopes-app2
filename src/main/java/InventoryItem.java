/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
public class InventoryItem extends InventoryList{
    String itemValue;
    String itemSerialNum;
    String itemName;

    public InventoryItem(String value, String serialNum, String name){
        this.itemName = name;
        this.itemValue = value;
        this.itemSerialNum = serialNum;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemSerialNum(){
        return itemSerialNum;
    }

    public String getItemValue(){
        return itemValue;
    }

    public void setItemName(String nameTemp){
        this.itemName = nameTemp;
    }

    public void setItemSerialNum(String serialNumTemp){
        this.itemSerialNum = serialNumTemp;
    }

    public void setItemValue(String valueTemp){
        this.itemValue = valueTemp;
    }
}

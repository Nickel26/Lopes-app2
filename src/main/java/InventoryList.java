/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import java.util.ArrayList;

public class InventoryList {
    ArrayList<InventoryItem> inventoryList = new ArrayList<>();

    String addItem(String name, String serialNum, String value){
        //check if name has at least 2 characters and is less than 256 characters
        //check that value is greater than or equal to 0
        //check that serial number is in correct format
        //if all cases pass then create new inventoryItem object and set value
        //add item to list
        //if a case does not pass send a specific value to the send error function to return error message
        return null;
    }

    String itemError(int num){
        //check num with cases and return specific error message
        return null;
    }

    String editItem(int i, String name, String serialNum, String value){
        //check if edited values still fit requirements
        //if values pass cases change stored values
        //if case does not pass send error value and return error message
        return null;
    }

    void removeItem(int i){
        //remove item at index i
    }

    void clearList(){
        //clear entire list
    }

    protected void  saveList(){

    }

    protected void  loadList(){

    }


}

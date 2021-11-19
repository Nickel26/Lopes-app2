/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import java.util.ArrayList;

public class InventoryList {
    ArrayList<InventoryItem> itemList = new ArrayList<>();

    String addItem(String name, String serialNum, String value){
        String error = null;

        //check if name has at least 2 characters and is less than 256 characters
        if((name.length() >= 2) || (name.length() <= 265)){

            //check if item with same serial number exists
            for(int i = 0; i < this.itemList.size(); i++){
                if(serialNum.compareTo(this.itemList.get(i).itemSerialNum) == 0){
                    error = itemError(2);
                    return error;
                }
            }
        }

        else{
            error = itemError(1);
            return error;
        }

        //check that value is greater than or equal to 0
        for(int i = 0; i < value.length(); i++){
            if(Character.isLetter(value.charAt(i)) || value.charAt(i) == '-'){
                error = itemError(3);
                return error;
            }
        }

        //check that serial number is in correct format
        if((serialNum.length() != 13) || (!Character.isLetter(serialNum.charAt(0)))){
            error = itemError(4);
            return error;
        }
        for(int i = 1; i < 13; i++){
            if(i == 1 || i == 5 || i == 9){
                if(serialNum.charAt(i) != 45) {
                    error = itemError(4);
                    return error;
                }
            }
            else if(!Character.isLetter(serialNum.charAt(i)) && !Character.isDigit(serialNum.charAt(i))){
                error = itemError(4);
                return error;
            }
        }

        //if all cases pass then create new inventoryItem object and set value
        InventoryItem item = new InventoryItem(value, serialNum, name);

        //add item to list
        this.itemList.add(item);

        //if a case does not pass send a specific value to the send error function to return error message
        return null;
    }

    String itemError(int num){
        //check num with cases and return specific error message
        String error = null;
        if(num == 1){
            error = "String must be more than 2 characters and less than 256 characters";
        }
        else if(num == 2){
            error = "An item with this Serial Number already exists";
        }
        else if(num == 3) {
            error = "The value must be a number greater than 0, or equal to 0";
        }
        else if(num ==4){
            error = "Serial number must be in A-XXX-XXX-XXX format, A has to be a letter";
        }
        return error;
    }

    String editItem(int i, String name, String serialNum, String value){
        //check if edited values still fit requirements
        String error = null;
        if(itemList.get(i).itemName.compareTo(name) != 0){
            if(name.length() < 2 || name.length() > 256){
                error = itemError(1);
                return error;
            }
        }

        if(itemList.get(i).itemSerialNum.compareTo(serialNum) != 0){
            if(serialNum.length() != 13 || !Character.isLetter(serialNum.charAt(0))){
                error = itemError(4);
                return error;
            }
            for(int j = 0; j < itemList.size(); j++){
                if(serialNum.compareTo(itemList.get(j).itemSerialNum) == 0){
                    error = itemError(2);
                    return error;
                }
            }

            for(int j = 1; j < 13; j++){
                if(j == 1 || j == 5 || j == 9){
                    if(serialNum.charAt(j) != 45) {
                        error = itemError(4);
                        return error;
                    }
                }
                else if(!Character.isLetter(serialNum.charAt(j)) && !Character.isDigit(serialNum.charAt(j))){
                    error = itemError(4);
                    return error;
                }
            }
        }

        if(itemList.get(i).itemValue.compareTo(value) != 0){
            for(int j = 0; j < value.length(); j++){
                if(Character.isLetter(value.charAt(j)) || value.charAt(j) == '-'){
                    error = itemError(3);
                    return error;
                }
            }
        }
        //if values pass cases change stored values
        itemList.get(i).setItemName(name);
        itemList.get(i).setItemSerialNum(serialNum);
        itemList.get(i).setItemValue(value);

        //if case does not pass send error value and return error message
        return null;
    }

    void removeItem(int i){
        //remove item at index i
        this.itemList.remove(i);
    }

    void clearList(){
        //clear entire list
        this.itemList.clear();
    }

    protected void  saveList(){

    }

    protected void  loadList(){

    }


}

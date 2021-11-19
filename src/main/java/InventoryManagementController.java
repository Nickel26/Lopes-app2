/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryManagementController implements Initializable {

        @FXML
        private Button AddItemButton;

        @FXML
        private TextFlow AddItemErrorBox;

        @FXML
        private TextField AddNameText;

        @FXML
        private TextField AddSerialNumText;

        @FXML
        private TextField AddValueText;

        @FXML
        private Button ClearInventoryButton;

        @FXML
        private Button DeleteItemButton;

        @FXML
        private Button EditItemButton;

        @FXML
        private TextFlow EditItemErrorBox;

        @FXML
        private TextField EditNameText;

        @FXML
        private TextField EditSerialNumText;

        @FXML
        private TextField EditValueText;

        @FXML
        private TableView<InventoryItem> Table;

        @FXML
        private Button LoadInventoryButton;

        @FXML
        private CheckBox NameCheckbox;

        @FXML
        private TableColumn<InventoryItem, String> NameColumn;

        @FXML
        private Button NameSearchButton;

        @FXML
        private Button SaveInventoryButton;

        @FXML
        private TextField SearchTextBox;

        @FXML
        private CheckBox SerialNumCheckbox;

        @FXML
        private TableColumn<InventoryItem, String> SerialNumColumn;

        @FXML
        private Button SerialSearchButton;

        @FXML
        private CheckBox ValueCheckbox;

        @FXML
        private TableColumn<InventoryItem, String> ValueColumn;

        private final InventoryList invList = new InventoryList();
        public ObservableList<InventoryItem> List = FXCollections.observableArrayList();

        @FXML
        void addItem(ActionEvent event) {
                AddItemErrorBox.getChildren().clear();
                String error = null;
                String name, value, serialNum;

                // take inputs and pass to addItem method within Inventory List
                error = invList.addItem(AddNameText.getText(), AddSerialNumText.getText(), AddValueText.getText());

                //if string has error then error is display wtihin textfield and input is not added
                if(error != null){
                        Text errorText = new Text(error);
                        AddItemErrorBox.getChildren().add(errorText);
                }

                //if returned string is null then no error and item is added to list
                else{
                        AddNameText.clear();
                        AddSerialNumText.clear();
                        AddValueText.clear();
                        List.add(invList.itemList.get(invList.itemList.size() - 1));
                }
        }

        @FXML
        void clearInventory(ActionEvent event) {
            //runs clearList method
                invList.clearList();
                List.clear();
        }

        @FXML
        void deleteItem(ActionEvent event) {
                ObservableList<InventoryItem> selectedItem;
                selectedItem = Table.getSelectionModel().getSelectedItems();

                //takes item values and searches for its index
                int i = 0;
                for(InventoryItem inventoryItem: selectedItem){
                        i = List.indexOf(inventoryItem);
                        List.remove(inventoryItem);
                }

                //passes index to removeItem method within InventoryList class
                invList.removeItem(i);
        }

        @FXML
        void editItem(ActionEvent event) {
                EditItemErrorBox.getChildren().clear();
                String error = null;

                //stores selected item
                ObservableList<InventoryItem> selectedItem;
                selectedItem = Table.getSelectionModel().getSelectedItems();

                //find index of selected item
                int i = 0;
                for(InventoryItem inventoryItem: selectedItem){
                        i = List.indexOf(inventoryItem);
                }

                //store selected items values
                InventoryItem temp = new InventoryItem(List.get(i).itemValue, List.get(i).itemSerialNum, List.get(i).itemName);

                if(!EditNameText.getText().isEmpty()){
                        temp.itemName = EditNameText.getText();
                }

                if(!EditValueText.getText().isEmpty()){
                        temp.itemValue = EditValueText.getText();
                }

                if(!EditSerialNumText.getText().isEmpty()){
                        temp.itemSerialNum = EditSerialNumText.getText();
                }


                //passes new values to edit Item method
                error = invList.editItem(i, temp.itemName, temp.itemSerialNum, temp.itemValue);

                //if string has error then display error in textfield and item is not edited
                if(error != null){
                        Text errorText = new Text(error);
                        EditItemErrorBox.getChildren().add(errorText);
                }

                //if returned string is null item can be edited
                else {
                        List.set(i, temp);
                        EditNameText.clear();
                        EditSerialNumText.clear();
                        EditValueText.clear();
                }
        }

        @FXML
        void loadInventory(ActionEvent event) {
            //prompt user to select file
            //pass file to loadList method
            //displays loaded list
        }

        @FXML
        void saveInventory(ActionEvent event) {
            //prompt user for file name and directory
            //passes input to saveList method
        }

        @FXML
        void searchByName(ActionEvent event) {
                ObservableList<InventoryItem> searchItem = FXCollections.observableArrayList();
                String key;

            //take input from SearchTextBox
                key = SearchTextBox.getText();

                //finds index that input matches with
                for(int i = 0; i < invList.itemList.size(); i++){
                        if(key.compareTo(invList.itemList.get(i).getItemName()) == 0){
                                searchItem.add(invList.itemList.get(i));

                                //displays item at index
                                Table.setItems(searchItem);
                        }
                }
        }

        @FXML
        void searchBySerialNum(ActionEvent event) {
                ObservableList<InventoryItem> searchItem = FXCollections.observableArrayList();
                String key;

                //take input from SearchTextBox
                key = SearchTextBox.getText();

                //finds index that input matches with
                for(int i = 0; i < invList.itemList.size(); i++){
                        if(key.compareTo(invList.itemList.get(i).getItemSerialNum()) == 0){
                                searchItem.add(invList.itemList.get(i));

                                //displays item at index
                                Table.setItems(searchItem);
                        }
                }
        }

        @FXML
        void sortByNameCheckbox(ActionEvent event) {
            //Sorts list by name alphabetically
        }

        @FXML
        void sortBySerialNumCheckbox(ActionEvent event) {
            //Sorts list by serial number alphanumerical
        }

        @FXML
        void sortByValueCheckbox(ActionEvent event) {
            //sorts by value from least to greatest
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //Initializes columns of display table with values of TodoItem object
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            SerialNumColumn.setCellValueFactory(new PropertyValueFactory<>("itemSerialNum"));
            ValueColumn.setCellValueFactory(new PropertyValueFactory<>("itemValue"));

            //allows table to access observables to display
            Table.setItems(List);

        }

    }

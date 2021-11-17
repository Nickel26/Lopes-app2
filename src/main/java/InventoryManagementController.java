/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

    public class InventoryManagementController {

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
        private TableView<InventoryItem> InventoryList;

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

        private final InventoryList inventoryList = new InventoryList();
        public ObservableList<InventoryItem> List = FXCollections.observableArrayList();

        @FXML
        void addItem(ActionEvent event) {
            //take inputs from textboxes
            //pass inputs to addItem method within Inventory List
            //if returned string is null then no error and item is added to list
            //if string has error then error is display wtihin textfield and input is not added
        }

        @FXML
        void clearInventory(ActionEvent event) {
            //runs clearList method
        }

        @FXML
        void deleteItem(ActionEvent event) {
            //takes item values and searches for its index
            //passes index to removeItem method within InventoryList class
        }

        @FXML
        void editItem(ActionEvent event) {
            //passes new values to edit Item method
            //if returned string is null item can be edited
            //if string has error then display error in textfield and item is not edited
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
            //take input from SearchTextBox
            //finds index that input matches with
            //displays item at index
        }

        @FXML
        void searchBySerialNum(ActionEvent event) {
            //take input from SearchTextBox
            //finds index that input matches with
            //displays item at index
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

    }

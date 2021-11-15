/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TableView<?> InventoryList;

    @FXML
    private Button LoadInventoryButton;

    @FXML
    private TableColumn<?, ?> NameColumn;

    @FXML
    private Button SaveInventoryButton;

    @FXML
    private TableColumn<?, ?> SerialNumColumn;

    @FXML
    private TableColumn<?, ?> ValueColumn;

    @FXML
    void addItem(ActionEvent event) {

    }

    @FXML
    void clearInventory(ActionEvent event) {

    }

    @FXML
    void deleteItem(ActionEvent event) {

    }

    @FXML
    void editItem(ActionEvent event) {

    }

    @FXML
    void loadInventory(ActionEvent event) {

    }

    @FXML
    void saveInventory(ActionEvent event) {

    }

}

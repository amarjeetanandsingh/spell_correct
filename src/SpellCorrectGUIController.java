/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




public class SpellCorrectGUIController implements Initializable {

    @FXML
    private Button btnCorrect; // Value injected by FXMLLoader
    
    @FXML 
    private TextField txtInput;

    @FXML
    private ComboBox comboEditDistance;

    @FXML
    private TableView table;

    @FXML
    private TableColumn clmSrNo;
    
    @FXML
    private TableColumn clmWord;

    @FXML
    private TableColumn clmDistance;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert btnCorrect != null : "fx:id=\"btnCorrect\" was not injected: check your FXML file 'simple.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'simple.fxml'.";

        // doing combo box related stuff.
        comboEditDistance.getItems().clear();
		comboEditDistance.getItems().addAll("1", "2", "3", "4", "5");
		comboEditDistance.getSelectionModel().select(2);
  
	}

    public Button getBtnCorrect() {
    	return btnCorrect;
    }

    public TextField getTxtInput() {
    	return txtInput;
    }
    public ComboBox getComboEditDistance(){
        return comboEditDistance;
    }    
    public TableView getTable(){
        return table;
    }
    public TableColumn getSrNo(){
        return clmSrNo;
    }
    public TableColumn getWord(){
        return clmWord;
    }
    public TableColumn getDistance(){
        return clmDistance;
    }
}

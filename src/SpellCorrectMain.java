import java.util.*;
import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.Desktop;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.*;
import javafx.scene.Group;

public class SpellCorrectMain  extends Application {

	VBox page;
	FXMLLoader fxmlLoader;
	private Button btnCorrect;
	private TextField txtInput;
	private ComboBox comboEditDistance;
	
	private TableView table;
	private TableColumn clmSrNo;
	private TableColumn clmWord;
	private TableColumn clmDistance;

	private SpellCorrectGUIController spellCorrectGUIController;
	ObservableList<Word> data = FXCollections.observableArrayList();



	public static void main(String[] args) {
		Application.launch(SpellCorrectMain.class, (java.lang.String[])null);
	}

	public void start(Stage primaryStage){
		try {
			fxmlLoader = new FXMLLoader(SpellCorrectMain.class.getResource("spell_correct.fxml"));
			// fxmlLoader.setLocation(SpellCorrectMain.class.getResource("spell_correct.fxml"));
            page = (VBox)fxmlLoader.load();
			spellCorrectGUIController = (SpellCorrectGUIController)fxmlLoader.getController();

            
            // get control instances.
	        btnCorrect 		= spellCorrectGUIController.getBtnCorrect();
	        txtInput		= spellCorrectGUIController.getTxtInput();        
	        table 			= spellCorrectGUIController.getTable();
	        clmSrNo			= spellCorrectGUIController.getSrNo();
	        clmWord			= spellCorrectGUIController.getWord();
	        clmDistance 	= spellCorrectGUIController.getDistance();
	        comboEditDistance = spellCorrectGUIController.getComboEditDistance();


	        // modifying table column
	        clmSrNo.setCellValueFactory(new PropertyValueFactory<Word, String>("srNo"));
	        clmWord.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
	        clmDistance.setCellValueFactory(new PropertyValueFactory<Word, String>("editDistance"));

	        // add event listener
			btnCorrect.setOnAction( new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(final ActionEvent e) {
	            	correctWord(txtInput.getText());
	            }
	        });              


			// display GUI.
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("File compressor");
	        primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(SpellCorrectMain .class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public void correctWord(String inputWord){
		if(inputWord == null || inputWord.trim().equals("")){
			txtInput.requestFocus();
			data.clear();
			return;
		}
		Spell_Correct spell_correct = new Spell_Correct();
		spell_correct.setEditDistance(Integer.parseInt(comboEditDistance.getValue().toString()));
		ArrayList<Word> wordList = spell_correct.correct(inputWord);
		int count = 1;
		data.clear();
		for (Word word : wordList) {
			word.setSrNo(count++ +"");
			data.add(word);
		}
		table.setItems(data);
	}
}
package in.amarjeet;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import in.amarjeet.spellcorrect.SpellCorrector;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpellCorrectMain extends Application {

	VBox page;
	FXMLLoader fxmlLoader;
	private Button btnCorrect;
	private TextField txtInput;
	private ComboBox<?> comboEditDistance;

	private TableView<Word> table;
	private TableColumn<Word, String> clmSrNo;
	private TableColumn<Word, String> clmWord;
	private TableColumn<Word, String> clmDistance;

	private SpellCorrectController spellCorrectController;

	ObservableList<Word> data = FXCollections.observableArrayList();

	public static void main(String[] args) throws Exception {
		Application.launch(SpellCorrectMain.class, (java.lang.String[]) null);
	}

	public void start(Stage primaryStage) {
		try {
			fxmlLoader = new FXMLLoader(SpellCorrectMain.class.getResource("SpellCorrectApp.fxml"));
			page = (VBox) fxmlLoader.load();
			spellCorrectController = (SpellCorrectController) fxmlLoader.getController();

			// get control instances.
			btnCorrect = spellCorrectController.getBtnCorrect();
			txtInput = spellCorrectController.getTxtInput();
			table = spellCorrectController.getTable();
			clmSrNo = spellCorrectController.getSrNo();
			clmWord = spellCorrectController.getWord();
			clmDistance = spellCorrectController.getDistance();
			comboEditDistance = spellCorrectController.getComboEditDistance();

			// modifying table column
			clmSrNo.setCellValueFactory(new PropertyValueFactory<Word, String>("srNo"));
			clmWord.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
			clmDistance.setCellValueFactory(new PropertyValueFactory<Word, String>("editDistance"));

			// add event listener
			btnCorrect.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(final ActionEvent e) {
					correctWord(txtInput.getText());
				}
			});

			txtInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.ENTER) {
						correctWord(txtInput.getText());
					}
				}
			});
			// display GUI.
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Spelling Correct");
			primaryStage.show();
			txtInput.requestFocus();
		} catch (Exception ex) {
			Logger.getLogger(SpellCorrectMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void correctWord(String inputWord) {
		if (inputWord == null || inputWord.trim().equals("")) {
			txtInput.requestFocus();
			data.clear();
			return;
		}
		long startTime = System.currentTimeMillis();
		 SpellCorrector spellCorrector = new SpellCorrector();
		spellCorrector.setEditLimit(Integer.parseInt(comboEditDistance.getValue().toString()));
		LinkedHashMap<String, Integer> wordList = null;
		try {
			wordList = spellCorrector.correct(inputWord);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		Logger.getLogger(SpellCorrectMain.class.getName()).log(Level.INFO,
				"Suggested " + spellCorrector.getSuggestedWordListLimit() + " words in "
						+ (System.currentTimeMillis() - startTime) + " ms");
		int count = 1;
		data.clear();
		for (String wordStr : wordList.keySet()) {
			Word word = new Word((count++) + "", wordStr, wordList.get(wordStr) + "");
			data.add(word);
		}
		table.setItems(data);
	}
}

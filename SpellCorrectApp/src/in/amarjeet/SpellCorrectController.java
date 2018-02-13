package in.amarjeet;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class SpellCorrectController implements Initializable {
	@FXML
    private Button btnCorrect; // Value injected by FXMLLoader
    
    @FXML 
    private TextField txtInput;

    @FXML
    private ComboBox<String> comboEditDistance;

    @FXML
    private TableView<Word> table;

    @FXML
    private TableColumn<Word, String> clmSrNo;
    
    @FXML
    private TableColumn<Word, String> clmWord;

    @FXML
    private TableColumn<Word, String> clmDistance;

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
    public ComboBox<String> getComboEditDistance(){
        return comboEditDistance;
    }    
    public TableView<Word> getTable(){
        return table;
    }
    public TableColumn<Word, String> getSrNo(){
        return clmSrNo;
    }
    public TableColumn<Word, String> getWord(){
        return clmWord;
    }

	public TableColumn<Word, String> getDistance(){
        return clmDistance;
    }
}

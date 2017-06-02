import javafx.beans.property.SimpleStringProperty;

public class Word {
	
	private SimpleStringProperty 	srNo;
	private SimpleStringProperty 	word;
	private SimpleStringProperty	editDistance;

	public Word(String srNo, String word, String editDistance){
		this.srNo			= new SimpleStringProperty(srNo);
		this.word 			= new SimpleStringProperty(word);
		this.editDistance	= new SimpleStringProperty(editDistance);
	}

	public String getSrNo(){
		return srNo.get();
	}
	public void setSrNo(String srNo){
		this.srNo.set(srNo);
	}
	public String getWord(){
		return word.get();
	}
	public void setWord(String word){
		this.word.set(word) ;
	}
	public String getEditDistance(){
		return editDistance.get();
	}
	public void setEditDistance(String editDistance){
		this.editDistance.set(editDistance);
	}
}
package in.amarjeet.spellcorrect.pojo;

public class PQElement implements Comparable<PQElement> {

	private String word = "";
	private int editDistance = 0;
	private String frequency = "";

	public PQElement(String word, int editDistance, String frequency) {
		this.word = word;
		this.editDistance = editDistance;
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getDistance() {
		return editDistance;
	}

	public void setDistance(int editDistance) {
		this.editDistance = editDistance;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public int compareTo(PQElement element) {
		if (this.getDistance() > element.getDistance()) {
			return 1;
		} else if (this.getDistance() < element.getDistance()) {
			return -1;
		} else if (this.getFrequency().length() < element.getFrequency().length()) {
			return 1;
		} else if (this.getFrequency().length() > element.getFrequency().length()) {
			return -1;
		}
		return element.getFrequency().compareTo(this.getFrequency());
	}
}

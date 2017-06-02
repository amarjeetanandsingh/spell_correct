import java.io.*;
import java.util.*;
import java.sql.*;

class Spell_Correct {

	private int EDIT_LIMIT = 3;
	private int SUGGESTED_WORD_LIST_LIMIT = 10;
	private final int EDIT_LIMIT = 3;
	private final int SUGGESTED_WORD_LIST_LIMIT = 10;
	private static final String DICTIONARY_FILE_PATH = "word_list_freq.txt";
	private String inputString ="";
	private PriorityQueue<PQElement> suggestedWords = new PriorityQueue<PQElement>(10);
	private static TSTNode root = null;
	private long timeToSearch = 0;
	
	static{
		root = createTST(null); 		
	}

	// set time in micro second.
	public double getTimeToSearch(){
		return timeToSearch/1000.0;
	}

	public void setEditDistance(int edit_limit){
		this.EDIT_LIMIT = edit_limit;
	}

	public ArrayList<Word> correct(String str) throws IllegalArgumentException{

	static{
		root = createTST(null); 		
	}
	
	public double getTimeToSearch(){
		return timeToSearch/1000.0;
	}
	public List<String> correct(String str) throws IllegalArgumentException{
		if(str.equals("")){
			throw new IllegalArgumentException("Input string is blank.");
		}
		inputString = str;
		ArrayList<Word> suggestedWordList = new ArrayList<Word>();
		List<String> suggestedWordList = new ArrayList<String>();
		long startTime = System.nanoTime();
		traverse(root, "");
		timeToSearch = System.nanoTime()-startTime;

		for (int i=0; suggestedWords.isEmpty()== false; i++) {
			PQElement element = suggestedWords.poll();
			suggestedWordList.add(new Word(1+"", element.getWord(), element.getDistance()+""));
		for (int i=0; suggestedWords.isEmpty()== false && i<SUGGESTED_WORD_LIST_LIMIT; i++) {
			PQElement element = suggestedWords.poll();
			suggestedWordList.add(element.getWord());
		}		
		return suggestedWordList;
	}

	private void traverse (TSTNode root, String str){

		if(root == null) return ;	

		int dis = getLevensthienDistance(inputString, str+root.getData());
		// skip traversing the nodes below which distance is grater than EDIT_LIMIT.
		if ((str.length() < inputString.length()) &&
		 			(getLevensthienDistance(str, inputString.substring(0,str.length()+1)) >EDIT_LIMIT)) {
			return ;
		} else if (str.length() > inputString.length()+EDIT_LIMIT) {
			return ;
		}else if (Math.abs(str.length() - inputString.length()) <= EDIT_LIMIT &&
				 dis  > EDIT_LIMIT) {
			return ;
		}

		// recursively traverse through the nodes for words
		traverse(root.getLeft(), str);
		if(root.getIsEnd() == true){
			if(dis<= EDIT_LIMIT){
				suggestedWords.add(new PQElement(str+root.getData(), dis, root.getFrequency()));
			}
		}
		traverse(root.getEqual(), str+root.getData());
		traverse(root.getRight(), str);
	} 

	private static TSTNode createTST(TSTNode root) {
		long startTime = System.nanoTime();
		File file;
		FileReader fr;
		BufferedReader br;

		try{
			file = new File(DICTIONARY_FILE_PATH);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			String words[] = null;
			while ((line = br.readLine())!= null) {
				words = line.split("\t");
				// word[0] = actual word.
				// word[1] = frequency of the word.
				root = TSTNode.insert(root, words[0], 0, words[1]);
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		long stopTime = System.nanoTime();
		System.out.println("Time to create tree : "+((stopTime-startTime)/1000.0)+" us");
		return root;		
	}

	// Levenshtein distance	
	private int getLevensthienDistance(String a, String b) {
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
}


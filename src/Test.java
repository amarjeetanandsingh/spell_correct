import java.util.*;
import java.io.*;

class Test{
	public static void main(String[] args){
		Spell_Correct spell_correct =  new Spell_Correct();
		List<String> list;
		long startTime = 0;
		long stopTime =0;
		long totalTime =0;

		File fileToRead;
		FileReader fr;
		BufferedReader br;

		try{
			fileToRead = new File("word_list.txt");
			fr = new FileReader(fileToRead);
			br = new BufferedReader(fr);
			String line = "";
			int counter = 1;
			while ((line=br.readLine()) != null) {
				startTime = System.currentTimeMillis();
				list = spell_correct.correct(line);				
				totalTime += (System.currentTimeMillis()-startTime);
				list.clear();
				System.out.print("\r"+ counter++ + " of 36900");
			}// wh 
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Total Time taken is : "+totalTime +" ms");
		System.out.println("Total Time taken is : "+((totalTime)/1000.0) +" s");
		System.out.println("Total Time taken is : "+((totalTime)/60000.0) +" m");
	}
}
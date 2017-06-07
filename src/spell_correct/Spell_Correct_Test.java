
/*
*	A test code to demonstrate the use of SpellCorrect jar file.
*	
*	@author : Amarjeet Anand
*/

package spell_correct;

import java.util.Scanner;
import java.util.LinkedHashMap;

class Test{
	public static void main(String[] args) throws Exception{
		Spell_Correct spell_correct =  new Spell_Correct();
		long startTime 	= 0;
		long stopTime 	= 0;
		long totalTime 	= 0;
		
		Scanner sc = new Scanner(System.in);
		String inputWord = sc.next();

		// you can also set edit limit before fetching results as
		// setEditLimit(int );
		// or
		// you can set suggested word list limite to be returned from the program as
		// setSuggestedWordListLimit(int );


		// get the output as List of Word class defined.
		LinkedHashMap<String, Integer> suggestedWordMap = spell_correct.correct(inputWord);
		
		System.out.println("Word\t\tDistance");
		System.out.println("****            ********");
		for (String word : suggestedWordMap.keySet()) {
			System.out.println(word +"\t\t"+suggestedWordMap.get(word));
		}
	}
}

package in.amarjeet.spellcorrect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import in.amarjeet.spellcorrect.pojo.Node;
import in.amarjeet.spellcorrect.pojo.TST;

public class WordTree {

	private static Logger log = Logger.getLogger(WordTree.class.getName());

	public static Node createTree(TST tst) {
		long startTime = System.currentTimeMillis();

		try {
			InputStream inputStream = getWordListFile();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			String token[] = null;
			while ((line = br.readLine()) != null) {
				token = line.split("\t");
				// token[0] = actual word.
				// token[1] = frequency of the word.
				tst.insert(token[0], token[1]);
			}

			inputStream.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Tree creadted in : " + ((System.currentTimeMillis() - startTime)) + " ms");
		return tst.getRoot();
	}

	private static InputStream getWordListFile() throws URISyntaxException {
		return WordTree.class.getClassLoader().getResourceAsStream("resources/word_freq_en.txt");
	}
}

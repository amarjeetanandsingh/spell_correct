# Spell_Correct
Java code to suggest correct English words against incorrectly spelled word.


<h2>Overview</h2>

It implements <a href="https://en.wikipedia.org/wiki/Ternary_search_tree">Ternary Search Tree </a><em>(<b>TST</b>)</em> data structure and <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance</a>(<b>LD</b>) algorithm to suggest a list of 10 related english words sorted by <b>Edit Distance</b> <em>(asc)</em> <i>(default-max : <b>3</b>)</i> followed by <b>frequency</b><em>(desc)</em> of entered word in english language.

<h2>Algorithm</h2>
<ul>
<li>Create a Priority Queue with a comparator.</li>
<li>Create a TST and insert all english <a href="http://norvig.com/google-books-common-words.txt">words</a> <em>(from <a href="http://norvig.com/mayzner.html">Norvig's post</a>)</em> along with their frequencies.</li>		
<li>Start traversing the TST and for every word encountered in TST, calculate its Levenshtein Distance<b>(LD)</b> from input_word</li>
<li>If LD <= 3 then put it in a Priority Queue.</li>
<li>At Last extract 10 words from the Priority Queue and display.</li>
</ul>

<h2>Performance </h2>
<ul>
<li>Initially it takes about <b>450</b><em> ms</em> to create the Ternary Search Tree for 97565 words.</li> 
<li>It suggests correct words with an average of <b>40-50</b> <em>ms</em> and <b>80</b> <em>ms</em> at worst.</li>
<li>The algorithm is proportional to the length of wrong word. But it hardly crosses 80 ms.</li>
<li>Tested on Pentium processor.</li>
</ul>

<h2>How to use</h2>
Download and run <a href="https://github.com/amarjeetanandsingh/spell_correct/raw/master/SpellCorrectApp/dist/SpellCorrectApp.jar">jar file</a>. If it doesn't run with double click, use following command.

```java
	java -jar SpellCorrectApp.jar
```

<h2>API Details</h2>
Download and add <a href = "https://github.com/amarjeetanandsingh/spell_correct/blob/master/spellcorrect/dist/spellcorrect.jar">jar file</a> to your classpath. You can use the following methods of <b>SpellCorrector</b> class to get the list of suggested words.
<h5>1</h5>

```java
	public void setEditLimit(int)
```
You can set up to what edit limit you want to see the result. Min value is 0, default is 3.

<h5>2</h5>

```java
	public void setSuggestedWordListLimit(int)
```
You can set how many suggested words you want in output.


<h5>3</h5>

```java
	public LinkedHashMap<String, Integer> correct(String) throws IllegalArgumentException
```
The method to correct a wrong word. It throws an `IllegalArgumentException` for blank or null String argument. It returns a `LinkedHashMap<String, Integer>` object where key(String) is the suggested correct word and its value is its edit distance from the wrong word. Also, the elements in map are arranged according to edit distance(asc) and then by the frequency of that word in english language(desc).

<h2>Sample Uses</h2>

```java

try{
  
    SpellCorrector spellCorrector = new SpellCorrector();
    spellCorrector.setEditLimit(3); //[optional]
    spell_correct.setSuggestedWordListLimit(10); //[optional]
    LinkedHashMap<String, Integer> wordList = wordList = spellCorrector.correct("happyness");
		
    System.out.println("Word\t\tDistance");
    for (String word : suggestedWordMap.keySet()) {
    	System.out.println(word +"\t\t"+suggestedWordMap.get(word));
    }
}catch (IllegalArgumentException e){
	e.printStackTrace();
}

```

<h2>Minimum Requirment</h2>
<ul>
<li>Java 1.8+ and JavaFX 2.0+</li>
</ul>

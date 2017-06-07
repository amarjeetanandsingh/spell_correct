# Spell_Correct
<p>
This is a program written in java to suggest a correct spelling against a wrongly spelled english word. 
</p>
<hr/>

<h2>Overview</h2>
<p>
It uses <a href="https://en.wikipedia.org/wiki/Ternary_search_tree">Ternary Search Tree</a><em>(TST)</em> data structure and <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein Distance</b> algorithm to suggest a <b>List</b> of 10 correct english words sorted by <b>Edit Distance</b> <em>(asc)</em><i>(default-max : <b>3</b>)</i> first and then by <b>frequency</b><em>(desc)</em> of that word in english language.
</p>
<hr/>

<h2>Algorithm</h2>
<p>
	<ul>
		<li>Create a Priority Queue with a comparator.</li>
		<li>Create a TST and insert all english <a href="http://norvig.com/google-books-common-words.txt">words</a> <em>(from <a href="http://norvig.com/mayzner.html">Norvig's post</a>)</em> along with their frequencies.</li>		
		<li>Start traversing the TST and for every word encountered in TST, calculate its Levenshtein Distance<b>LD</b> from input_word</li>
		<li>If LD <= 3 then put it in a Priority Queue.</li>	
		<li>At Last extract 10 words from the Priority Queue and display.</li>
	</ul>
</p>
<hr/>

<h2>Performance </h2>
<ul>
  <li>Initially it takes about <b>450</b><em>ms</em> to create the Ternary Search Tree for 97565 words.</li> 
  <li>It suggests correct words with an average of <b>40-50</b> <em>ms</em> and <b>80</b> <em>ms</em> at worst. on Pentium processor.</li>
  <li>The algorith is proportional to the length of wrong word. But it hardly crosses 80 ms</li>
</ul>
<hr/>

<h2>How to use</h2>
<h4>GUI Version</h4>
<p>
	<ul>
		<li>Download `dist` folder and open it in terminal/command prompt.</li>
		<li></li>
	</ul>
</p>
<h4>CLI Version</h4>
<p>
	<ul>
		<li>Download root folder and open it in terminal/command prompt.</li>
		<li>Type ```java java -cp lib/ spell_correct.Test ``` and press `enter`.</li>
		<li>Enter the english word you want to get the suggestion of.</li>
	</ul>
</p>
<hr/>


<h2>API Details</h2>
<p>

</p>
<hr/>

<h2>Minimum Requirment</h2>
<ul>Java 1.5 or above.</ul>
<hr/>

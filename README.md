# Spell_Correct
An english word spelling correction program

This is a program written java to suggest a correct spelling against a wrongly spelled word. 

It uses <b>Ternary Search Tree</b> data structure and <b>Levenshtein Distance</b> algorithm to return a <b>List</b> of 10 words sorted using <b>Edit Distance</b> <i>(max : <b>3</b>)</i> first and then by <b>frequency </b> of that word in english language.
<h2>Performance </h2>
<ul>
  <li>For the 36900 words listed <a href="">here</a>, it successfully suggests correct words with an average of 7.8 ms per wrong word.</li>
  <li>The algorith is proportional to the length of wrong word. But it hardly crosses 80 ms for long words like "knowledge..."</li>
  <li>Firstly it takes about <<b>450 ms</b> to create the Ternary Search Tree for the first time.  
</ul>

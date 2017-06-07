/*
	Node class for Ternary Search Tree.

	@author :	Amarjeet Anand
	@since	: 	4/6/2015
*/

package spell_correct;

class Node{
	private char data=' ';
	private boolean isEnd = false;	// end of a word.
	private Node left=null, equal=null, right=null;
	private String frequency = null;

	public Node (char data){
		this.data = data;
	}
	public void setData (char data){
		this.data = data;
	}
	public char getData(){
		return this.data;
	}
	public void setIsEnd (boolean isEnd){
		this.isEnd = isEnd;
	}
	public boolean getIsEnd() {
		return this.isEnd;
	}	
	public void setLeft (Node left){
		this.left = left;
	}
	public Node getLeft(){
		return this.left;
	}
	public Node setEqual (Node equal){
		return (this.equal = equal);
	}
	public Node getEqual(){
		return this.equal;
	}	
	public void setRight (Node right){
		this.right = right;
	}
	public Node getRight (){
		return this.right;
	}
	public void setFrequency(String frequency){
		this.frequency = frequency;
	}
	public String getFrequency(){
		return this.frequency;
	}
}
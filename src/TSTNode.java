class TSTNode {
	char data=' ';
	boolean isEnd = false;	// end of a word.
	TSTNode left=null, equal=null, right=null;
	String frequency = "";

	TSTNode (){}
	
	TSTNode (char data){
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
	public void setLeft (TSTNode left){
		this.left = left;
	}
	public TSTNode getLeft(){
		return this.left;
	}
	public TSTNode setEqual (TSTNode equal){
		return (this.equal = equal);
	}
	public TSTNode getEqual (){
		return this.equal;
	}	
	public void setRight (TSTNode right){
		this.right = right;
	}
	public TSTNode getRight (){
		return this.right;
	}
	public void setFrequency(String frequency){
		this.frequency = frequency;
	}
	public String getFrequency(){
		return this.frequency;
	}

	public static TSTNode insert (TSTNode root, String word, int pos, String frequency){
		if(root == null){			
			root = new TSTNode(word.charAt(pos));
		}
		
		// SANFOUNDRY.
		if(word.charAt(pos) <root.getData()){
			root.setLeft(insert(root.getLeft(), word, pos, frequency));
		}else if (word.charAt(pos) > root.getData()) {
			root.setRight(insert(root.getRight(), word, pos, frequency));
		}else {
			if(pos+1 < word.length()){
				root.setEqual(insert(root.getEqual(), word, pos+1, frequency));
			}else {
				root.setIsEnd(true);
				root.setFrequency(frequency);
			}
		}
		return  root;
	}

	public static boolean search(TSTNode root, String word, int pos){
	
		while (root != null ) {
			if(word.charAt(pos) < root.getData()){
				root = root.getLeft();
			}else if (word.charAt(pos) > root.getData()){
				root = root.getRight();
			}else {
				if(root.getIsEnd()==true && pos== word.length()-1){
					return true;
				}
				pos++;
				root = root.getEqual();
			}
		}
		return false;
	}	// search()
}
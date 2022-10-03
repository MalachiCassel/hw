
public class Node {
	private String word;
	public Node left;
	public Node right;
	
	public Node(String word){
		this.word=word;
		left=null;
		right=null;
	}
	public String getWord() {
		return word;
	}
}

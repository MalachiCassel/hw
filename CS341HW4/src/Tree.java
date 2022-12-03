import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public Node root;

	public Tree() {
		this.root = null;

	}

	public void addnode(String word) {
		Node temp = new Node(word);
		if (root == null) {
			root = temp;
		} else {
			insertWordNode(root, temp);
		}
	}

	private void insertWordNode(Node myroot, Node temp) {
		while (true) {
			if (temp.getWord().compareTo(myroot.getWord()) == 0)
				return;

			if (temp.getWord().compareTo(myroot.getWord()) <= -1) {
				if (myroot.left != null) {
					myroot = myroot.left;
				} else {
					myroot.left = temp;
					break;
				}
			} else {
				if (myroot.right != null) {
					myroot = myroot.right;
				} else {
					myroot.right = temp;
					break;
				}
			}
		}

	}

	public void deleteKey(String word) {
		root = deleteRec(root, word);
	}

	Node deleteRec(Node root, String word) { 
		assert (true);
		if (root == null)
			return root;
		if (word.compareTo(root.getWord()) < 0)
			root.left = deleteRec(root.left, word);
		else if (word.compareTo(root.getWord()) > 0)
			root.right = deleteRec(root.right, word);
		else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			String x = root.getWord();
			x = minValue(root.right);
			root.right = deleteRec(root.right, root.getWord());
		}
		assert (root==null):"this is the root being deleted";
		return root;
		
	}

	String minValue(Node root) {
		String minv = root.getWord();
		while (root.left != null) {
			minv = root.left.getWord();
			root = root.left;
		}
		return minv;
	}

	public void insert(String word) {
		root = insertRec(root, word);
	}

	Node insertRec(Node root, String word) {
		if (root == null) {
			root = new Node(word);
			return root;
		}

		if (word.compareTo(root.getWord()) < 0) {
			root.left = insertRec(root.left, word);
		} else if (word.compareTo(root.getWord()) > 0) {
			root.right = insertRec(root.right, word);
		}

		return root;
	}

	public void inorder() {
		inorderRec(root);
	}

	public void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.getWord() + " ");
			inorderRec(root.right);
		}
	}

	public boolean spellcheck(Node node,String word) {
		if(null == node) {
            return false;
        }
        if(node.getWord() == word) {
            return true;
        } 
        else if(node.getWord().compareTo(word)>0) {
            return spellcheck(node.left,word);
        }
        else {
            return spellcheck(node.right,word);
    }
}
}

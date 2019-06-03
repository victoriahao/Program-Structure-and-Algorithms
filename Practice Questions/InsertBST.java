import javax.swing.tree.TreeNode;

//Practice Questions (1)
//Question 3

//Insert into a Binary Search Tree
//Topics - Tree

//Binary search tree characteristics: the left side node is smaller than the parent node,
//and the right side node is bigger than the parent node. (This also means that left side 
//node will always smaller than the right side node.)

public class InsertBST{
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
		
	public TreeNode insertIntoBST(TreeNode root, int val) {
		
		if(root == null) {
			System.out.print("null" + val);			
			root = new TreeNode(val);
		} else if(val < root.val) {
			System.out.print("left" + root.val);
			root.left = insertIntoBST(root.left, val);
		}
		else {
			System.out.print("right" + root.val);
			root.right = insertIntoBST(root.right, val);
		}
		System.out.println("");
		return root;
	}

	public static void main(String[] args) {
				
		InsertBST bst = new InsertBST();
		TreeNode root = null;
		root = bst.insertIntoBST(root, 5);
		root = bst.insertIntoBST(root, 2);
		root = bst.insertIntoBST(root, 1);
		root = bst.insertIntoBST(root, 3);
		root = bst.insertIntoBST(root, 4);
		root = bst.insertIntoBST(root, 7);
		
	}


}

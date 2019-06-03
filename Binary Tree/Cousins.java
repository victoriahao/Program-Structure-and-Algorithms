//Find if two trees are Cousins

public class Cousins{
	static class BinTree{
		Nodes root;
		
		boolean isSiblings(Nodes node, Nodes a, Nodes b) {
			if(node == null) {
				return false;
			}
			return ((node.left == a && node.right == b) || (node.left == b && node.right == a) ||
					isSiblings(node.left, a, b) || isSiblings(node.right, a, b));
		}
		
		int level(Nodes node, Nodes levelOfNode, int level) {
			if(node == null) {
				return 0;
			}
			if(node == levelOfNode) {
				return level;
			}
			
			int left = level(node.left, levelOfNode, level + 1);
			
			if(left != 0) {
				return left;
			}
			return level(node.right, levelOfNode, level + 1);
			
		}
		
		boolean isCousins(Nodes node, Nodes a, Nodes b) {
			return ((level(node, a, 1) == level(node, b, 1)) && (!isSiblings(node, a, b)));
		}
		
		public static void main(String[] args) {
			
			BinTree binTree = new BinTree();
			binTree.root = new Nodes(1);
			binTree.root.left = new Nodes(2);
			binTree.root.right = new Nodes(3);
			binTree.root.left.left = new Nodes(4);
			binTree.root.left.right = new Nodes(5);
			binTree.root.right.left = new Nodes(6);
			binTree.root.right.right = new Nodes(7);
			binTree.root.left.right.right = new Nodes(8);
			binTree.root.right.left.right = new Nodes(9);
			
			Nodes Node1, Node2;
			Node1 = binTree.root.left.left;
			Node2 = binTree.root.right.right;
			if(binTree.isCousins(binTree.root, Node1, Node2)) {
				System.out.println("Yes, they are cousins!");
			}
			else {
				System.out.println("No, they are not cousins.");
			}

		}
	}
}



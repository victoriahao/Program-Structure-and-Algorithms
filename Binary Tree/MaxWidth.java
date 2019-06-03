//Max width of a tree

public class MaxWidth {
	
	Nodes root;
	
	int getMaximumW(Nodes node) {
		int maximumW = 0;
		int width;
		int h = height(node);
		int i;
		
		for(i = 1; i <= h; i++) {
			width = getW(node, i);
			if(width > maximumW) {
				maximumW = width;
			}
		}
		return maximumW;
	}
	
	int getW(Nodes node, int level) {
		if(node == null) {
			return 0;
		}
		if(level == 1) {
			return 1;
		}
		else if(level > 1) {
			return getW(node.left, level - 1) + getW(node.right, level - 1);
		}
		return 0;
	}
	
	//compute the height of the tree
	int height(Nodes node) {
		if(node == null) {
			return 0;
		}
		else {
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);
			
			return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
		}
	}

	public static void main(String[] args) {
		MaxWidth maxWidth = new MaxWidth();
		
		/*My binary tree is:
		  
		        11
		      /    \
		     33     35
		    /  \   /  \
		   42  48 50   55
		  /     \       \
		 96     99      100

		*/
		maxWidth.root = new Nodes(11);
		maxWidth.root.left = new Nodes(33);
		maxWidth.root.right = new Nodes(35);
		maxWidth.root.left.left = new Nodes(42);
		maxWidth.root.left.right = new Nodes(48);
		maxWidth.root.right.left = new Nodes(50);
		maxWidth.root.right.right = new Nodes(55);
		maxWidth.root.left.left.left = new Nodes(96);
		maxWidth.root.left.right.right = new Nodes(99);
		maxWidth.root.right.right.right = new Nodes(100);
		
		System.out.println("Max width of a tree is: " + maxWidth.getMaximumW(maxWidth.root));

	}

}

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

//Print Top View of a tree.
//Example:
/*        7
 *      /   \
 *     6     5
 *    / \   / \
 *   4   3 2   1
 */
//Output should be: 4, 6, 7, 5, 1

public class BinTreeTopView {
	
	Nodes root;
	
	public BinTreeTopView() {
		root = null;
	}
	
	private void topView(Nodes root) {
		class queueObject{
			Nodes node;
			int h;
			
			queueObject(Nodes node, int h){
				this.node = node;
				this.h= h;
			}
		}
		
		Queue<queueObject> queue = new LinkedList<queueObject>();
		Map<Integer, Nodes> mapTopView = new TreeMap<Integer, Nodes>();
		
		if(root == null) {
			return;
		}
		else {
			queue.add(new queueObject(root, 0));
		}
		
		while(!queue.isEmpty()) {
			queueObject NodeTemp = queue.poll();
			if(!mapTopView.containsKey(NodeTemp.h)) {
				mapTopView.put(NodeTemp.h, NodeTemp.node);
			}
			if(NodeTemp.node.left != null) {
				queue.add(new queueObject(NodeTemp.node.left, NodeTemp.h - 1));
			}
			if(NodeTemp.node.right != null) {
				queue.add(new queueObject(NodeTemp.node.right, NodeTemp.h + 1));
			}
		}
		for(Entry<Integer, Nodes> entry : mapTopView.entrySet()) {
			System.out.print(entry.getValue().data);
		}
	}

	public static void main(String[] args) {
		/*create the binary tree below:
		 *        7
		 *      /   \
		 *     6     5
		 *      \   /  \
		 *       4  3   2
		 *               \
		 *                1
		 * 
		 * The results should print out: 6, 7, 5, 2, 1
		 */
		
		BinTreeTopView binTreeTopView = new BinTreeTopView();
		binTreeTopView.root = new Nodes(7);
		binTreeTopView.root.left = new Nodes(6);
		binTreeTopView.root.right = new Nodes(5);
		binTreeTopView.root.left.right = new Nodes(4);
		binTreeTopView.root.right.left = new Nodes(3);
		binTreeTopView.root.right.right = new Nodes(2);
		binTreeTopView.root.right.right.right = new Nodes(1);
		System.out.println("Print top view of a tree:");
		binTreeTopView.topView(binTreeTopView.root);

	}

}

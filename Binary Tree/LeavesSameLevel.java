//Find if all leaves are at same level.

class Leaves{
	int leaveslevel = 0;
}

public class LeavesSameLevel {
	
	//numbers of left is equal to numbers of right
	Nodes root;
	Leaves leaves = new Leaves();
	
	boolean checkIfSameLevel(Nodes node, int level, Leaves leavesLevel) {
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null) {
			if(leavesLevel.leaveslevel == 0) {
				leavesLevel.leaveslevel = level;
				return true;
			}
			return (level == leavesLevel.leaveslevel);
		}
		return checkIfSameLevel(node.left, level + 1, leavesLevel)
				&& checkIfSameLevel(node.right, level + 1, leavesLevel);
	}
	
	boolean check(Nodes node) {
		int level = 0;
		return checkIfSameLevel(node, level, leaves);
	}
	
	public static void main(String[] args) {
		LeavesSameLevel leavesSameLevel = new LeavesSameLevel();
		leavesSameLevel.root = new Nodes(23);
		leavesSameLevel.root.left = new Nodes(10);
		leavesSameLevel.root.left.left = new Nodes(7);
		leavesSameLevel.root.left.right = new Nodes(18);
		leavesSameLevel.root.left.left.left = new Nodes(4);
		leavesSameLevel.root.left.right.left = new Nodes(5);
		if(leavesSameLevel.check(leavesSameLevel.root)) {
			System.out.println("All leaves are at same level.");
		}
		else {
			System.out.println("Leaves are not at the same level.");
		}

	}

}

//Dynamic Programming Assignment
//Question 1: Solve Min cost to traverse an matrix from 0,0 to n,n 

//First assume that we can only go right and down through this matrix
public class MinCostToTraverseMatrix {
	
	static int MinCostTraverse(int[][] M){
		int[][] solution = new int[M.length][M.length];
		
		solution[0][0] = M[0][0];
		
		int i;
		//First, fill out the first row (do a for loop)
		for(i=1; i<M.length; i++) {
			solution[0][i] = M[0][i] + solution[0][i-1];
		}
		
		//Then, fill out the first column (do a for loop)
		for(i=1; i<M.length; i++) {
			solution[i][0] = M[i][0] + solution[i-1][0];
		}
		
		int j;
		//Find minimum cost
		for(i=1; i<M.length; i++) {
			for(j = 1; j<M.length; j++) {
				solution[i][j] = M[i][j] + Math.min(solution[i-1][j], solution[i][j-1]);
				//solution[i-1][j] is when i>0; solution[i][j-1] is when j>0
			}
		}
		return solution[M.length-1][M.length-1];
		
	}

	public static void main(String[] args) {
		int[][] M = {{1,2,3,4},
				     {5,6,7,8},
				     {4,3,2,1},
				     {8,7,6,5}};
		
		//Minimum cost to traverse this matrix is 1+2+6+3+2+1+5 -> 20
		
		System.out.println("Minimum cost is: " + MinCostTraverse(M));
	}

}

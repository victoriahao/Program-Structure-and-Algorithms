/*
3. Given a m x n matrix, if an element is 0, set its entire row and column to 0.
Input : [[1,1,1],[1,0,1],[1,1,1]] Output : [[1,0,1], [0,0,0],[1,0,1]]
*/

public class MatrixElement {
	public static void setMatrixRowColumn(int matrix[][]) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int m = matrix.length, n = matrix[0].length;
		boolean row = false, column = false;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
					if(i == 0) {
						row = true;
					}
					if(j == 0) {
						column = true;
					}
				}
			}
		}
		for(int i = 1; i < m; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for(int j = 1; j < n; j++) {
			if(matrix[0][j] == 0) {
				for(int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		if(row) {
			for(int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		if(column) {
			for(int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1, 1, 1},
				          {1, 0, 1},
				          {1, 1, 1}};
		setMatrixRowColumn(matrix);
		System.out.println("");
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}
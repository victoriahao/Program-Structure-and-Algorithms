/*
2. Peak Index in a mountain array
Given an array, return any i (index) such that A[0] < A[1] < ... A[i - 1] < A[i] > A[i + 1] > ... > A[A.length - 1]
Ex: Input : [0,2,1,0]
Output : 1 
*/

public class PeakIndex {
	
	public static int peakIndexMountainArr(int[] A) {
		int left = 0, right = A.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(A[mid] > A[mid - 1]) {
				left = mid;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int A[] = {0,2,1,0};
		System.out.println(peakIndexMountainArr(A));
	}

}

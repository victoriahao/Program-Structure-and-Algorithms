//Question 1.: Given Sorted array find index of first occurance of a specific integer. 
//             If the integer is not found return -1

public class FirstOccuranceIndex {
	
	static int findFirstOccurance(int arr[], int n, int k) {
		int count = 0;
		boolean isK = false;
		for(int i=0; i<n; i++) {
			if(arr[i] == k) {
				isK = true;
			}
			else if(arr[i] < k) {
				count++;
			}
		}
		if(isK == false) {
			return -1;
		}
		else {
			return count;
		}
	}

	public static void main(String[] args) {
		int k = 80, arr[] = {10, 40, 60, 80, 80};
		//int k = 50, arr[] = {10, 40, 60, 80, 80};  //since 50 is not in the array, return -1.
		int n = arr.length;
		System.out.println(findFirstOccurance(arr, n, k));

	}

}

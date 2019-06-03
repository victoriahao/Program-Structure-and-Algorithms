//Question: Write code for Pancake sort

public class PancakeSort {
	
	//reverse arr[0...k].
	static void flip(int[] arr, int k) {
		int temp, start = 0;
		while (start < k) {
			temp = arr[start];
			arr[start] = arr[k];
			arr[k] = temp;
			start++;
			k--;
		}
	}
	
	//return maximum index in arr[0...j-1].
	static int findMaximum(int[] arr, int j) {
		int nk, k;
		for(nk = 0, k = 0; k < j; k++) {
			if(arr[k] > arr[nk]) {
				nk = k;
			}
		}
		return nk;
	}
	
	static int pancakeSort(int[] arr, int j) {
		
		//1.everytime reduce current array size by one.
		for(int current_size = j; current_size > 1; current_size--) {
			
			//2.find maximum index.
			int nk = findMaximum(arr, current_size);
			
			
			//3.place maximum at the end of current array if it is not already at the end.
			if(nk != current_size-1) {
				
				//move maximum number to the beginning of the array.
				flip(arr, nk);
				
				//reverse array.
				flip(arr, current_size-1);
			}
		}
		return 0;
	}
	
	//print out array
	static void printArray(int[] arr, int array_size) {
		for(int k = 0; k < array_size; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println("");
	}
	
	//test
	public static void main(String[] args) {
		int[] arr = {6,5,3,1,8,7,2,4};
		int j = arr.length;
		
		pancakeSort(arr, j);
		
		printArray(arr, j);
	}
}

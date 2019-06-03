//Practice Question (1)
//Question 5

//Topics-Array, Sort, Two pointers

public class MoveZeroes {
	
	static void moveZeroesToEndArray(int arr[], int n) {
		int count = 0;  //Count of non-zero numbers
		for(int i=0; i<n; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < n) {
			arr[count++] = 0;
		}
	}

	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 3, 12};
		int n = arr.length;
		moveZeroesToEndArray(arr, n);
		System.out.println("After moving all zeroes to the end of the array: ");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}

/*
1. Squares of a sorted array
Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, 
also in sorted non-decreasing order.
Ex:  Input: [-4,-1,0,3,10]
Output :[0,1,9,16,100]
*/

import java.util.Arrays;

public class SquaredArray {
	
	public static void SquaredSort(int arr[]) {
		int n = arr.length;
		
		//convert each number to its square
		for(int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}
		
		//sort array
		Arrays.sort(arr);
	}
	
	//test above function
	public static void main(String[] args) {
		int arr[] = {-4,-1,0,3,10};
		int n = arr.length;
		
		System.out.println("Array before sorting: ");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
		
		SquaredSort(arr);
		System.out.println("");
		System.out.println("Array after sorting:¡@");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}

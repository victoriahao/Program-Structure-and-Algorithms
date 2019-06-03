import java.io.*;
import java.util.*;
import java.lang.Math;

//Question 2: In Unsorted array find pair of values whose sum is closest to a value X.

public class PairValuesClosest {
	
	int arr[] =  new int[]{27, 50, 10, 90, 60, 58};
	
	static void SumClosest(int array[], int n, int X) {
		
		Arrays.sort(array);
		
		int result_left = 0, result_right = 0;
		
		int left = 0, right = n - 1, difference = Integer.MAX_VALUE;
		
		while(right > 1) {
			if(Math.abs(array[left] + array[right] - X) < difference) {
				result_left = left;
				result_right = right;
				difference = Math.abs(array[left] + array[right] - X);
			}
			
			if(array[left] + array[right] > X) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.println("Pair values are:  " + array[result_left] + " , " + array[result_right]);
	}
	
	public static void main(String[] args) {
		int array[] =  {27, 50, 10, 90, 60, 58}, X = 90;  
		//the result should print put 27 and 60 since 27+60=87 is closest to 90.
        int n = array.length; 
        SumClosest(array, n, X); 
		
	}

}

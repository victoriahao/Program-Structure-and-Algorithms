import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Question 3: In Unsorted array find pair of values whose sum is equal to rest elements. 
public class PairValuesEqual {
	
	int arr[] = new int[]{3, 5, 10, 12, 8, 6};
	
	static boolean findPair(int arr[], int n) {
		
		Arrays.sort(arr);

		int sum=0;
		for(int i=0; i<n; i++) {
			sum=sum+arr[i];
		}
		if(sum%2 != 0) {
			return false;
		}
		sum=sum/2;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			int value = sum - arr[i];
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
			}
			
			if(set.contains(value)) {
				System.out.println("Pair of values are  " + arr[i] + " , " + value);
				return true;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 5, 10, 12, 8, 6};  
		//results should print out 10 and 12, since the rest 3+5+8+6=22.
		int n = arr.length; 
	    if(findPair(arr, n) == false) {
	    	System.out.println("Can't find the pairs!");
	    }
	}
}

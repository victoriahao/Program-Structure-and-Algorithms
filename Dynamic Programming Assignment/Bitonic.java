//Dynamic Programming Assignment
//Question 2: Print Max Bitonic in an array

public class Bitonic {
	
	//Swap the numbers
	static void Swap(int[] arr, int start, int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
	}
	
	//Reverse the array: In order to do longest decreasing subsequence(lds), we start from the back
	static void Reverse(int[] arr) {
		int temp = 0;
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			Swap(arr, start, end);
			start++;
			end--;
		}
	}
	
	static int[] LISArray(int[] arr) {
		int[] lis = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			lis[i] = 1;  //Initially, set lis[1,1,1,1,1,1,1,1]
		}
		int[] path = new int[arr.length];
		int count = 0;  //The first number in path[] is 0
		for(int i=0; i<arr.length; i++) {
			path[i] = count;  //Initially, set path[0,1,2,3,4,5,6,7]
			count++;  //Adding the number
		}
		int max=0;  //The initial max is zero
		
		//This is the longest increasing subsequence part
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {  //j needs to be smaller than i
				if(arr[j] < arr[i] && lis[i] < lis[j]+1) {  //Compare arr[] and also compare lis[]
					lis[i] = lis[j]+1;
					path[i] = j;
					
					if(max < lis[i]) {
						max=lis[i];
					}
				}
			}
		}
		return lis;
	}
	
	//For lis, we start from the beginning; for lds, we start from the back
	static int MaxBitonic(int[] arr) {
		int[] lis = LISArray(arr);
		
		Reverse(arr);
		int[] lds = LISArray(arr);
		
		Reverse(lds);
		
		Reverse(arr);
		int max=0;
		
		for(int i=0; i<arr.length; i++) {
			int sum = lis[i] + lds[i]-1;  //After we calculate both lis and lds, 
			                              //we then add each pair of lis and lds together
			                              //to find the largest number
			if(sum>max) {  //Whenever we find the largest number,
				           //that largest number will become max
				max=sum;
			}
		}
		return max;
		
	}
	
	//Testing methods
	public static void main(String[] args) {
		int test = MaxBitonic(new int[] {5,8,4,6,2,7,9,1});
		//Either two cases: 5->8->4->2->1 or 5->6->7->9->1 are both five numbers
		System.out.println(test);

	}

}

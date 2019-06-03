//Dynamic Programming Assignment
//Question 3: Print Longest Increasing Sub Sequence

public class LIS {
	
	static int LongestIncreasingSubSequence(int[] arr) {
		int[] lis = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			lis[i] = 1;  //Initially, set lis[1,1,1,1,1,1,1,1]
		}
		int[] path = new int[arr.length];
		int count = 0;  //The first number in path[] is 0
		for(int i=0; i<arr.length; i++) {
			path[i] = count;
			count++;  //Adding the number in path[] by 1, so the path[] is path[0,1,2,3,4,5,6,7]
		}
		int max=0;
		
		//This is the longest increasing subsequence part
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {  //j needs to be smaller than i
				if(arr[j] < arr[i] && lis[i] < lis[j]+1) {  //Compare both arr[] and lis[]
					lis[i] = lis[j]+1;
					path[i] = j;
					
					if(max < lis[i]) {
						max=lis[i];
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int test = LongestIncreasingSubSequence(new int[] {5,8,4,6,2,7,9,1});
		/*
		*Through LIS(longest increasing subsequence), we get lis[] result is lis[1,2,1,2,1,3,4,1],
		*since 4 is the largest number, and the location 4 corresponds to 9 in arr[5,8,4,6,2,7,9,1],
		*so 9 is the largest number in our result.
		*We also know that the longest increasing number is 5->6->7->9 or 4->6->7->9
		*We can see that there are 4 numbers maximum
		*/
		System.out.println(test);

	}

}

//Practice Questions (1)
//Question 2

//Maximum Subarray
//Topics - Array, Dynamic Programming

//This question is also called a Kadane Algorithm problem
public class MaxSubarraySum {
	
	static int MaxSubarray(int[] arr) {
		
		//Initialize max, sum, start, end
		int max=0;
		int sum=0;
		int start=0;
		int end=0;
		
		for(int i=0; i<arr.length; i++) {
			sum=sum+arr[i];
			if(sum>max) {
				max=sum;
				end=i;  //As long as the number is positive, keep update the end
			}
			if(sum<0) {
				sum=0;
				start=i+1;  //Whenever the number is negative, then start from the next one
			}
		}
		return max;  //Find maximum
	}

	public static void main(String[] args) {
		int test = MaxSubarray(new int[] {3,-2,-2,4,-2,-1,5,-7,2,1});
		//Below subarray: 4,-2,-1,5 has the maximum sum 6
		System.out.println(test);

	}

}

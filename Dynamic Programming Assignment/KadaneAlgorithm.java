//Dynamic Programming Assignment
//Question 4: Kadane algorithm find start and end

//Kadane algorithm is like a maximum sum subarray problem
public class KadaneAlgorithm { 
  
    static void Kadane(int[] arr, int size) {
    	
        int so_far_max = Integer.MIN_VALUE; 
        int max_end_here = 0;
        int start = 0;
        int end = 0;
        int s = 0; 
  
        for (int i = 0; i < size; i++) {
        	
            max_end_here = max_end_here + arr[i]; 
  
            if (so_far_max < max_end_here) {
            	
            	so_far_max = max_end_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_end_here < 0) {
            	
                max_end_here = 0; 
                s = i + 1; 
            }
            
        } 
        System.out.println("Maximum subarray sum is: " + so_far_max); 
        System.out.println("Start index is: " + start);
        System.out.println("End index is: " + end); 
    } 
  
    //Testing method
    public static void main(String[] args) {
    	
        int[] arr = {3,-2,-2,4,-2,-1,5,-7,2,1}; 
        int n = arr.length; 
        Kadane(arr, n);
        
    }
    
}

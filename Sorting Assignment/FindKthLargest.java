import java.util.Arrays;

//Question: Write a function to find Kth largest in an integer array
//First: sort the array
public class FindKthLargest{

    public static int findKthLargestInArray(Integer[] arr, int k){
        Arrays.sort(arr);
        int index = arr.length - k;
        return arr[index];
    }

    public static void main(String[] args) {
		Integer[] arr = new Integer[]{6,5,3,1,8,7,2,4};
		//int[] arr = {0,1,1,2,3,2,2,5,6,6,3,6};
		int k = 1;
        System.out.print(findKthLargestInArray(arr, k));
    }

}

//Pratice Question (1)
//Question 10

//Topics - String

public class LongestSubstringWithoutRepeat {
	
	static final int numOfChars = 256;
	
	static int lengthOfLongestSubstring(String s){
		int n = s.length();
		int currLength = 1; //Length of current substring
		int maxLength = 1;  //result
		int prevIndex;  //Previous index
		int i;
		int visited[] = new int[numOfChars];
		
		for(i=0; i<numOfChars; i++) {
			visited[i] = -1;
		}
		
		visited[s.charAt(0)] = 0;
		
		for(i=1; i<n; i++) {
			prevIndex = visited[s.charAt(i)];
			
			if(prevIndex == -1 || i - currLength > prevIndex) {
				currLength++;
			}
			else {
				if(currLength > maxLength) {
					maxLength = currLength;
				}
				currLength = i - prevIndex;
			}
			
			visited[s.charAt(i)] = i;
		}
		
		if(currLength > maxLength) {
			maxLength = currLength;
		}
		return maxLength;
		
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println("Input: " + s);
		int length = lengthOfLongestSubstring(s);
		System.out.println("The length of the longest substring "
				+ "without repeating characters is: " + length);

	}

}

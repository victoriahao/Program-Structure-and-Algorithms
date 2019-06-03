//Practice Question (1)
//Question 7

//Topics - Math

public class RomanToInteger {
	
	//Below function returns value of Roman symbol
	int value(char c) {
		if(c == 'I') {
			return 1;
		}
		if(c == 'V') {
			return 5;
		}
		if(c == 'X') {
			return 10;
		}
		if(c == 'L') {
			return 50;
		}
		if(c == 'C') {
			return 100;
		}
		if(c == 'D') {
			return 500;
		}
		if(c == 'M') {
			return 1000;
		}
		return -1;
	}
	
	//Below function aims to find decimal value of a given Roman numeral
	int romanToDecimalValue(String s) {
		int result = 0;  //Initialize result
		
		for(int i=0; i<s.length(); i++) {
			int s1 = value(s.charAt(i));
			
			if(i+1 < s.length()) {
				int s2 = value(s.charAt(i+1));
				
				if(s1 >= s2) {  //If previous number is greater than or equal to its next number,
					            //add numbers together.
					result = result + s1;
				}
				else {
					result = result + s2 - s1;  //Otherwise, subtract numbers.
					i++;
				}
			}
			else {
				result = result + s1;
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RomanToInteger ro = new RomanToInteger();
		String s = "MCMXCIV";
		System.out.println("An integer form of a roman numeral is: " + ro.romanToDecimalValue(s));

	}

}

import java.util.Stack;

//Practice Question (1)
//Question 6

//Topics - Stack

//I used Stack's push() and pop() functions to write this code
public class ValidParentheses {
	
	public static boolean isValidParen(String str){
		str = str.trim();
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		if(str.isEmpty()) {
			return true;  //An empty string is also valid
		}
		boolean isValidParen = true;
		for(char c : arr) {
			if(c == '{') {
				stack.push('}');
			}else if(c == '[') {
				stack.push(']');
			}else if(c == '(') {
				stack.push(')');
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek() != c) {
					isValidParen = false;
					break;
				}
				else {
					stack.pop();  //This function is what closing brackets will do
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return isValidParen;
	}
		

	public static void main(String[] args) {
		char arr[] = {'(','[',')',']'};
		boolean result = isValidParen("([)]");
		String str = "([)]";
		System.out.println(result);
		if(isValidParen(str)) {
			System.out.println("Parentheses is valid.");
		}
		else {
			System.out.println("It is not a valid parentheses.");
		}

	}

}

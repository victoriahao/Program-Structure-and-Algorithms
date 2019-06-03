import java.util.Stack;

//Practice Question (1)
//Question 8

//Topics - Design

public class MinStack {
	
	Stack<Integer> stack;
	Integer minElement;
	
	MinStack(){
		stack = new Stack<Integer>();
	}
	
	void getMinimum() {
		if(stack.isEmpty()) {
			System.out.println("Empty stack");
		}
		else {
			System.out.println("Minimum element in stack is: " + minElement);
		}
	}
	
	void top() {
		if(stack.isEmpty()) {
			System.out.println("Empty stack");
			return;
		}
		
		Integer t = stack.peek();  //Get the top element
		
		System.out.print("Top element is: ");
		
		if(t < minElement) {
			System.out.println(minElement);
		}
		else {
			System.out.println(t);
		}
	}
	
	void pop() {  //Removes the element on top of the stack
		if(stack.isEmpty()) {
			System.out.println("Empty stack");
			return;
		}
		
		System.out.print("Top element removed: ");
		Integer t = stack.pop();
		
		if(t < minElement) {
			System.out.println(minElement);
			minElement = 2 * minElement - t;
		}
		else {
			System.out.println(t);
		}
	}
	
	void push(Integer x) { //Push element x onto stack
		if(stack.isEmpty()) {
			minElement = x;
			stack.push(x);
			System.out.println("The inserted number is: " + x);
			return;
		}
		
		if(x < minElement) {
			stack.push(2 * x - minElement);
			minElement = x;
		}
		else {
			stack.push(x);
		}
		System.out.println("The inserted number is: " + x);
	}

	public static void main(String[] args) {
		MinStack minstack = new MinStack();
		minstack.push(-2);
		minstack.push(0);
		minstack.push(-3);
		minstack.getMinimum();
		minstack.pop();
		minstack.top();
		minstack.getMinimum();

	}

}

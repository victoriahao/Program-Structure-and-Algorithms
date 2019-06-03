//Practice Questions (1)
//Question 4

//Topics - Linked List

public class OddEvenLinkedlist {
	
	ListNode head;
	
	class ListNode{
		int value;
		ListNode next;
		ListNode(int x){
			value = x;
			next = null;
		}
	}
	
	void groupEvenAndOdd() {
		
		ListNode evenhead = null;
		ListNode evenlast = null;
		ListNode oddhead = null;
		ListNode oddlast = null;
		ListNode currNode = head;
		
		while(currNode != null) {
			
			int element = currNode.value;
			
			if(element % 2 == 0) {
				if(evenhead == null) {
					evenhead = currNode;
		            evenlast = evenhead;
				}
				else {
					evenlast.next = currNode;
					evenlast = evenlast.next;
				}
			}
			else {
				if(oddhead == null) {
					oddhead = currNode;
					oddlast = oddhead;
				}
				else {
					oddlast.next = currNode;
					oddlast = oddlast.next;
				}
			}
			currNode = currNode.next;
		}
		
		if(oddhead == null || evenhead == null) {
			return;
		}
		
		oddlast.next = evenhead;
		evenlast.next = null;
		head = oddhead;
		
	}

	void push(int newData) {
		
        ListNode newNode = new ListNode(newData); 
        
		newNode.next = head; 

        head = newNode; 
    }
	
	void printTheList() {
		
        ListNode temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.value+" "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 

	public static void main(String[] args) {
		
		OddEvenLinkedlist oddeven = new OddEvenLinkedlist();
		
		oddeven.push(5); 
		oddeven.push(4); 
		oddeven.push(3); 
		oddeven.push(2); 
		oddeven.push(1);
		
        System.out.println("Before grouping odd and even nodes: "); 
        oddeven.printTheList(); 
  
        oddeven.groupEvenAndOdd(); 
  
        System.out.println("After grouping odd and even nodes: "); 
        oddeven.printTheList(); 

	}

}

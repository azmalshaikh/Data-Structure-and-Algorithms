package linkedList;

public class Linkedl {
	
	Node head ;
	
	public void add(int data) {
		Node toAdd = new Node (data);
		if(isEmpty()) {
			head = toAdd ;
			return ;
		}
		Node temp = head ;
		while(temp.next != null) {
			temp = temp.next ;
		}
		temp.next = toAdd ;
	}
	
	void print () {
		Node temp = head ;
		while(temp !=null) {
			System.out.print(temp.data + " ");
			temp = temp.next ;
		}
	}
	
	void get(int index) {
		Node temp = head ;
		for (int i=0 ; i<index ; i++) {
			temp = temp.next;
			if(temp == null) {
				System.out.println("Index Should be in the range.");
				return;
			}
		}
		System.out.println(temp.data);
	}
	
	void set (int index , int value) {
		Node temp = head ;
		for(int i=0 ; i<index ; i++) {
			temp = temp.next ;
			if(temp == null) {
				System.out.println("Index Should be in the range.");
				return;
			}
		}
		temp.data = value ;
	}
	
	void remove (int index) {
		Node temp = head , prev = null;
//		CASE 1: 
//	    If index is 0, then head node itself is to be deleted 
		if(index ==0 && temp!=null) {
			head = temp.next ;
			return;
		}
//		CASE 2 :
//		If index is between 0 to size of list
		int counter = 0 ;
		while(temp != null) {
			if(counter == index) {
				prev.next = temp.next;
				break ;
			} else {
				prev = temp ;
				temp = temp.next ;
				counter ++ ;
			}
		}
//		CASE 3 : 
//		If index is greator than size of list
		if(temp == null) {
			System.out.println("Element Not Found");
		}
	}
	
	public void contains (int value) {
		Node temp = head ;
		while(temp != null) {
			if(temp.data == value) {
				 System.out.println("true");
				 break ;
			}
			temp = temp.next ;
		}
	}
	
	void clear() {
		head = null ;
		System.out.println("List is cleared");
	}
	
	void size() {
		Node temp = head ;
		int n = 0 ;
		while(temp != null) {
			n++ ;
			temp = temp.next ;
		}
		System.out.println(n);
	}
	
	public boolean isEmpty() {
		return head == null ;
	}
	
	static class Node{
		int data ;
		Node next ;
		public Node (int data) {
			this.data = data ;
			next = null ;
		}
	}
	
}

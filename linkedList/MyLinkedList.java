package linkedList;

//import linkedList.Linkedl.Node;

public class MyLinkedList <E> {
	
	Node<E> head ;
	
	public void add(E data) {
		Node<E> toAdd = new Node<E> (data) ;
		
		if (isEmpty()) {
			head = toAdd ;
			return ;
		}
		Node<E> temp = head ;
		while(temp.next != null) {
			temp = temp.next ;
		}
		
		temp.next = toAdd ;
	}
	
	public void print ( ) {
		Node <E> temp = head ;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next ;
		}
	}
	
	public void get(int index) {
		Node<E> temp = head ;
		for (int i=0 ; i<index ; i++) {
			temp = temp.next;
			if(temp == null) {
				System.out.println("Index Should be in the range.");
				return;
			}
		}
//		System.out.println(temp.data);
	}
	
	public void set (int index , E value) {
		Node <E> temp = head ;
		for(int i=0 ; i<index ; i++) {
			temp = temp.next ;
			if(temp == null) {
				System.out.println("Index Should be in the range.");
				return;
			}
		}
		temp.data = value ;
	}
	
	public void remove (int index) {
		Node <E> temp = head , prev = null;
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
	
	public void contains (E value) {
		Node <E> temp = head ;
		while(temp != null) {
			if(temp.data == value) {
				 System.out.println("true");
				 break ;
			}
			temp = temp.next ;
		}
	}
	
	public boolean isEmpty ( ) {
		return head == null ;
	}
	
	public E removeLast() throws Exception {
		Node<E> temp = head ;
		if(temp == null) {
			throw new Exception("Cannot remove last element from empty linked list") ;
		}
		if(temp.next == null) {
			Node<E> toRemove = head;
			head = null ;
			return toRemove.data;
		}
		while(temp.next.next != null) {
			temp = temp.next ;
		}
		Node <E>toRemove = temp.next ;
		temp.next = null ;
		return toRemove.data ;
	}
	
	public E getLast() throws Exception {
		Node<E> temp = head ;
		if(temp == null) {
			throw new Exception("Cannot peek last element from empty linked list");
		}
		while (temp.next != null) {
			temp = temp.next ;
		}
		return temp.data ;
	}
	public void search(E value) {
		Node<E> temp = head ;
		while(temp!=null) {
			if(temp.data==value) {
				System.out.println("It contains "+ value);
			}
			temp = temp.next;
		}
	}
	public static class Node <E>{
		public E data ;
		public Node<E> next ;
		
		public Node (E data) {
			this.data = data ;
			next = null ;
		}
	}
}

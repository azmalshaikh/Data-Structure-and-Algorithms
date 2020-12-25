package vectorAndStacks;

import linkedList.MyLinkedList;

public class MyStack <E> {
	
	private MyLinkedList<E> ll = new MyLinkedList<>();
	
	void push(E e) {
		ll.add(e);
	}
	
	E pop() throws Exception {
		if(ll.isEmpty()) {
			throw new Exception("Popping from empty stack is not allowed");
		}
		
		return ll.removeLast() ;
	}
	
	E peek() throws Exception {
		if(ll.isEmpty()) {
			throw new Exception ("Peeking from empty stack is not allowed");
		}
		return ll.getLast();
	}
	
	void isEmpty() {
		if(ll.isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			System.out.println("Stack is not Empty");
		}
	}
	
	void search(E e) {
		ll.search(e);
	}
	
}

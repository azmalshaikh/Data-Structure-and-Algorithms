package linkedList;

import java.util.* ;
public class MainLinkedList {

	public static void main(String[] args) {
		
//		List <Integer> ll = new LinkedList<>() ;
//		List <Integer> al = new ArrayList<>() ;
//		ll.add(10);
//		ll.get(1);
//		getTimeDiff(al) ;
//		getTimeDiff(ll) ;
		
		Linkedl myll = new Linkedl (); 
		myll.add(45);
		myll.add(20);
		myll.add(10);
		myll.add(99);
		myll.add(2);
		myll.add(1);
		
		myll.clear();
		myll.add(4);
		myll.add(15);
		myll.add(42);
		myll.add(111);
		myll.add(89);
		
		myll.get(1);
		myll.get(2);
		myll.remove(3);
		myll.get(3);
	}

	static void getTimeDiff(List <Integer> list) {
//		
//		long start = System.currentTimeMillis() ;
//		
//		for (int i=0 ; i<100000 ; i++) {
//			list.add(0 , i) ;
//		}
//		
//		long end = System.currentTimeMillis() ;
//		
//		System.out.println(list.getClass().getName() + "-->"+(end - start));
		
//		MyLinkedList <String> myLL = new MyLinkedList <> () ;
//		
//		for (int i=0 ; i<10 ; i++) {
//			myLL.add("Azmal");
//		}
//		myLL.print();

	}
}

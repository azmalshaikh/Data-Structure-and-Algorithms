public static Node findUnion(Node head1, Node head2) {
	    TreeSet <Integer> s = new TreeSet<>();
	    
	    while(head1 != null) {
            s.add(head1.data);
            head1 = head1.next;
        }
        
        while(head2 != null) {
            s.add(head2.data);
            head2 = head2.next;
        }
        
        Node cur=null, head=null;
	    
	    for(int i: s) {
	        Node toAdd = new Node(i);
	        
	        if(head == null) {
	            head = toAdd;
	            cur = toAdd;
	        } else {
	            cur.next = toAdd;
	            cur = toAdd;
	        }
	    }
	    return head;
	}

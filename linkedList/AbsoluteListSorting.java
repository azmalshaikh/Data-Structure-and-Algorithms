Node sortedList(Node head) {

    if(head == null || head.next == null) return head;

    Node tail = head.next;
    Node cur = head;

    while(tail != null) {
	if(tail.data < 0) {
	    cur.next = tail.next;
	    tail.next = head;

	    head = tail;
	    tail = cur.next;
	} else {
	    cur = tail;
	    tail = tail.next;
    	}
    }

    return head;
}

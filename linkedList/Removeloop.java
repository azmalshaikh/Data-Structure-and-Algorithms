public static void removeLoop(Node head){
        
    if(head == null) return;

    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow) break;
    }

    fast = head;

    // If LinkedList is CircularLinkedList
    if(slow == fast && slow == head) {
        while(slow.next != fast) {
            slow = slow.next;
        }
    } else {
        while(slow.next != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }
    }

    slow.next = null;
}

class Clone {
    
    // data
    // next
    // arb
    
    Node copyList(Node head) {
        // Step 1
        Node temp = head, nextNode = head;
        
        while(temp != null) {
            nextNode = temp.next;
            
            Node toAdd = new Node(temp.data);
            temp.next = toAdd;
            toAdd.next = nextNode;
            
            temp = nextNode;
        }
        
        // Step 2 Random Pointers
        temp = head;
        while(temp != null) {
            if(temp.arb != null) temp.next.arb = temp.arb.next;
            temp = temp.next.next;
        }
        
        // Step 3 Remove Connection
        temp = head;
        Node dummy = new Node(-1), ptr = dummy;
        Node fast = head, slow = head;
        
        while(slow != null) {
            fast = slow.next.next;
            
            ptr.next = slow.next;
            ptr = ptr.next;
            
            slow.next = fast;
            
            slow = fast;
        }
        
        return dummy.next;
    }
}

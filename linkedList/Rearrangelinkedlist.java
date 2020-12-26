public static Node rearrange(Node head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        Node temp = head;
        
        while(temp.next.next != null) {
            temp = temp.next;
        }
        
        Node last = temp.next;
        temp.next = null;
        
        Node attach = rearrange(head.next);
        
        head.next = last;
        last.next = attach;
        
        return head;
    }

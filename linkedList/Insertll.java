Node sortedInsert(Node head, int key) {
        Node temp = head;
        Node toAdd = new Node(key);
        
        if(head == null) {
            head = toAdd;
        } else if(head.data > key) {
            toAdd.next = head;
            head = toAdd;
        } else {
            while(temp.next != null && temp.next.data < key) {
                temp = temp.next;
            }
            toAdd.next = temp.next;
            temp.next = toAdd;
        } 
        return head;
    }

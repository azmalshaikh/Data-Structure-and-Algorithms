public static Node sortedInsert(Node head,int data){
        Node temp = head;
        
        Node toAdd = new Node(data);
        
        if(head == null) {
            toAdd.next = toAdd;
            head = toAdd;
        } else if (head.data >= data) {
            while(temp.next != head) {
                temp = temp.next;
            }
            temp.next = toAdd;
            toAdd.next = head;
            head = toAdd;
        } else {
            while(temp.next.data < data && temp.next != head) {
                temp = temp.next;
            }
            toAdd.next = temp.next;
            temp.next = toAdd;
        }
        
        
        return head;
    }

public static Node sortedInsert(Node head, int x) {

        Node toAdd = new Node (x);
        
        Node current; 
  
        if (head == null) 
            head = toAdd;  
  
        else if (head.data >= toAdd.data) { 
            toAdd.next = head; 
            toAdd.next.prev = toAdd; 
            head = toAdd; 
        } else { 
            current = head; 
  
            while (current.next != null &&  
                current.next.data < toAdd.data)  
                current = current.next; 
  
            toAdd.next = current.next; 
  
            if (current.next != null)  
                toAdd.next.prev = toAdd;  
  
            current.next = toAdd;  
            toAdd.prev = current;  
              
        } 
        return head;
    }

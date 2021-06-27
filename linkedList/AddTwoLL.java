class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        
        Node head = null, prev=null, toAdd = null;
        
        first = reverse(first);
        second = reverse(second);
        
        int carry = 0;
        while(first != null || second != null) {
            int a = first != null ? first.data : 0;
            int b = second != null ? second.data : 0;
            
            int cur = a + b + carry;
            
            toAdd = new Node(cur%10);
            
            if(head == null) head = toAdd;
            else prev.next = toAdd;
            
            prev = toAdd;
            
            carry = cur / 10;
            
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        
        }
        
        if(carry != 0) {
            toAdd.next = new Node(carry);
        }
        
        return reverse(head);
    }
    
    static Node reverse(Node head) {
        Node prev=null, cur=head, next=null;
            
        while(cur != null) {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
        }
        return prev;
    } 
}

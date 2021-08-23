class Solution {
    
    public static Node reverse(Node head) {
        Node prev = null, cur = head, next = null;
        
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public static Node addOne(Node head) { 
        Node tail = reverse(head);
        int carry = 1;
        Node temp = tail, prev = null;
        while(temp != null && carry != 0) {
            temp.data += carry;
            
            if(temp.data >= 10) {
                temp.data = 0;
            } else {
                return reverse(tail);
            }
            prev = temp;
            temp = temp.next;
        }
        
        if(carry == 1) {
            prev.next = new Node(1);
        }
        return reverse(tail);
    }
    
}

class Solution {
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        
        Node zero=zeroD, one=oneD, two=twoD;
        
        Node cur = head;
        
        while(cur != null) {
            if(cur.data == 0) {
                zero.next = cur;
                zero = zero.next;
            } else if(cur.data == 1) {
                one.next = cur;
                one = one.next;
            } else {
                two.next = cur;
                two = two.next;
            }
            
            cur = cur.next;
        }
        
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        head = zeroD.next;
        
        return head;
    }
}

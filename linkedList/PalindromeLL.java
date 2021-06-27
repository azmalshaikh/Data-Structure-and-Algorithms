class Solution {
    
    boolean isPalindrome(Node head) {
        Node fast = head, slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        Node mid = reverse(slow.next);
        
        while(mid != null) {
            if(mid.data != head.data) return false;
            
            mid = mid.next;
            head = head.next;
        }
        
        return true;
    }   
    
    Node reverse(Node head) {
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

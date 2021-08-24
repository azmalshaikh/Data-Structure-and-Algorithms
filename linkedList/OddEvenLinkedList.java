class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode (-1);
        ListNode dummyEven = new ListNode (-1);
        ListNode tOdd = dummyOdd, tEven = dummyEven;
        
        int count = 1;
        while(head != null) {
            if(count % 2 == 0) { // Even
                tEven.next = head;
                tEven = tEven.next;
            } else { // Odd
                tOdd.next = head;
                tOdd = tOdd.next;
            }
            count++;
            head = head.next;
        }
        tOdd.next = null;
        tEven.next = null;
        
        tOdd.next = dummyEven.next;
        
        return dummyOdd.next;
    }
}

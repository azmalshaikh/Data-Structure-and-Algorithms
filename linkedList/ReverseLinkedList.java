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

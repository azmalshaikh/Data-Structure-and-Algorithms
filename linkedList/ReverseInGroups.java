public static Node reverse(Node head, int k) {
    Node cur = head, next = null, prev = null;
    int count = 0;

    while(count < k && cur != null) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next ;
        count++;
    }

    if(next != null) {
        head.next = reverse(next, k);
    }

    return prev;
}

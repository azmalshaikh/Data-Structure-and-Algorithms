public static void unfold(ListNode head) {
    if (head == null || head.next == null)
        return;

    ListNode h1 = head;
    ListNode h2 = head.next;

    ListNode c1 = h1;
    ListNode c2 = h2;

    while (c2 != null && c2.next != null) {
        ListNode f = c2.next; // Backup

        c1.next = f; // links
        c2.next = f.next;

        c1 = c1.next;
        c2 = c2.next;
    }

    // c1->next = nullptr;
    h2 = reverseList(h2);
    c1.next = h2;
}

public static ListNode midNode(ListNode node) {
    if (node == null || node.next == null)
        return node;

    ListNode slow = node, fast = node;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public static ListNode reverseList(ListNode node) {
    if (node == null || node.next == null)
        return node;

    ListNode prev = null;
    ListNode curr = node;
    while (curr != null) {
        ListNode forw = curr.next; // backup.

        curr.next = prev; // connection

        prev = curr; // move forw.
        curr = forw;
    }

    return prev;
}

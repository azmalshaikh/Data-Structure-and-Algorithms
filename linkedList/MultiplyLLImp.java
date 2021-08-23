public static ListNode multiply(ListNode l1, int n) {
    ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;
    int carry = 0;

    while(l1 != null || carry != 0) {
        int sum = carry + (l1 != null ? (l1.val * n) : 0) ;

        temp.next = new ListNode(sum%10);
        temp = temp.next;
        carry = sum/10;

        if(l1 != null) l1 = l1.next;
    }

    return dummy.next;
}

public static ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head, next = null;

    while(cur != null) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }

    return prev;
}

public static void addlinkedlist(ListNode cur1, ListNode cur2) {

    int carry = 0;

    while(cur1 != null || carry != 0) {
        int sum = carry + (cur1 != null ? cur1.val : 0) + (cur2.next != null ? cur2.next.val : 0);

        carry = sum/10;

        if(cur2.next != null) cur2.next.val = sum%10;
        else cur2.next = new ListNode(sum%10);

        if(cur1 != null) cur1 = cur1.next;
        cur2 = cur2.next;
    }
}

public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);

    ListNode dummy = new ListNode(-1);
    ListNode temp = l2;
    ListNode temp1 = dummy;

    while(temp != null) {
        ListNode prod = multiply(l1, temp.val);
        temp = temp.next;

        addlinkedlist(prod, temp1);
        temp1 = temp1.next;
    }

    return reverse(dummy.next);
}

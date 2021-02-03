public static Node findIntersection(Node head1, Node head2) {
    LinkedHashSet<Integer> s = new LinkedHashSet<>();

    while(head1 != null) {
        s.add(head1.data);
        head1 = head1.next;
    }

    LinkedHashSet<Integer> ans = new LinkedHashSet<>();

    while(head2 != null) {
        if(s.contains(head2.data)) {
            ans.add(head2.data);
        }
        head2 = head2.next;
    }

    Node head=null, cur=null;

    for(int i: ans) {
        Node toAdd = new Node(i);
        if(head == null) {
            head = toAdd;
            cur = head;
        } else {
            cur.next = toAdd;
            cur = toAdd;
        }
    }

    return head;
}

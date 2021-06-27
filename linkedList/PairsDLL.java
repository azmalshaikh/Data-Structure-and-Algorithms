static void findpairs(Node head, int x) {
    Node i = head;

    while(head.next != null) head = head.next;

    Node j = head;

    while(i != j || j.next != i) {
        if((i.data + j.data) == x) {
            System.out.println(i.data + " " + j.data);

            i = i.next;
            j = j.prev;
        } else {
            if((i.data + j.data) > x) {
                j = j.prev;
            } else {
                i = i.next;
            }
        }
    }
}

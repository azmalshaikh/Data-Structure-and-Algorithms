int intersectPoint(Node head1, Node head2) {
      int a = size(head1);
      int b = size(head2);

      int d = Math.abs(a-b);

      if(a > b) {
          return intersect(head1, head2, d); 
      }

      return intersect(head2, head1, d);
}

int intersect(Node head1, Node head2, int d) {
    for(int i=0; i<d; i++) {
        if(head1 == null) return -1;

        head1 = head1.next;
    }

    while(head1 != null && head2 != null) {
        if(head1.data == head2.data) return head1.data;

        head1 = head1.next;
        head2 = head2.next;
    }

    return -1;
}

int size(Node head) {
    if(head == null) return 0;

    return size(head.next) + 1;
}

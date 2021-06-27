void splitList(circular_LinkedList list) {
        
      Node head = list.head, slow = head, fast = head;

      while(fast.next != head && fast.next.next != head) {
          fast = fast.next.next;
          slow = slow.next;
      }

      if(fast.next.next == head) fast = fast.next;

      list.head1 = head;

      if(head.next != head) {
          list.head2 = slow.next;
      }

      fast.next = slow.next;
      slow.next = list.head1;
}

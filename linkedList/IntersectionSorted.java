class Sol {
    public static Node findIntersection(Node head1, Node head2) {
        Node ans = null, temp = null;
        
        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                
                if(ans == null) {
                    temp = ans = new Node(head1.data);
                } else {
                    temp.next = new Node(head1.data);
                    temp = temp.next;
                }
                
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.data > head2.data) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
        
        return ans;
    }
}

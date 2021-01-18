public Node removeDuplicates(Node head) {
    HashSet<Integer> set = new HashSet<>();

    Node temp = head, prev = null;
    Node point;

    while(temp != null) {
        if(set.contains(temp.data)) {
            point = temp.next;
            prev.next = null;
            prev.next = point;
            temp = temp.next;
        } else {
            set.add(temp.data);
            prev = temp;
            temp = temp.next;
        }
    }

    return head;
}

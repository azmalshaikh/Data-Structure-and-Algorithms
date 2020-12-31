public static Tree convert(Node head, Tree node) {
    Queue<Tree> q = new LinkedList<Tree>();

    if(head == null) {
        node = null;
        return null;
    }

    node = new Tree(head.data);
    q.add(node);
    head = head.next;

    while(head != null) {
        Tree cur = q.poll();

        Tree leftC = null, rightC = null;
        leftC = new Tree(head.data);
        q.add(leftC);
        head = head.next;

        if(head != null) {
            rightC = new Tree(head.data);
            q.add(rightC);
            head = head.next;
        }

        cur.left = leftC;
        cur.right = rightC;
    }

    return node;
}

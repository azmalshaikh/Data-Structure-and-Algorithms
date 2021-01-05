public static boolean detectLoop(Node head){
    Node fast = head;
    Node slow = head;

    boolean ans = false;

    while(fast != null && slow != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow) {
            ans = true;
            break;
        }
    }
    return ans;
}

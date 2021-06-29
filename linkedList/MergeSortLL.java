class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;
        
        Node middle = getMiddle(head);
        Node nextofmiddle = middle.next;
        
        middle.next = null;
        
        Node leftPart = mergeSort(head);
        Node rightPart = mergeSort(nextofmiddle);
        
        Node ans = merge(leftPart, rightPart);
        
        return ans;
    }
    
    static Node merge(Node left, Node right) {
        Node result = null;
        
        if(left == null) return right;
        if(right == null) return left;
        
        if(left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        
        return result;
    }
    
    static Node getMiddle(Node head) {
        if(head == null) return head;
        
        Node slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}

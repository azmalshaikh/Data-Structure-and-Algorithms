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
        Node result = new Node(1);
        Node temp = result;
        
        while(left != null && right != null) {
            if(left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            
            temp = temp.next;
        }
        
        while(left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        
        while(right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        
        return result.next;
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

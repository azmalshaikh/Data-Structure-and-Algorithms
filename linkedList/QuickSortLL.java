class GfG
{
    public static Node quickSort(Node node) {
        
        Node end = node;
        while(end.next != null) end = end.next;
        
        sort(node, end);
        
        return node;
    }
    
    static void sort(Node start, Node end) {
        if(start == null || start == end || start == end.next) return;
        
        Node pivot_prev = partition(start, end);
        sort(start, pivot_prev);
        
        if(pivot_prev != null && pivot_prev == start) {
            sort(pivot_prev.next, end);
        } else if(pivot_prev != null && pivot_prev.next != null) {
            sort(pivot_prev.next.next, end);
        }
    }
    
    static Node partition(Node start, Node end) {
        if(start == end || start == null || end == null) return start;
        
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
        
        while(start != end) {
            if(start.data < pivot) {
                pivot_prev = curr;
                
                // Swap
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                
                curr = curr.next;
            }
            start = start.next;
        }
        
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        
        return pivot_prev;
    }
    
    
}

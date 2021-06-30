class GfG
{
    public static Node partition(Node l, Node h) {
        int pivot = h.data;
        
        Node i = l.prev;
        
        for(Node j=l; j!=h; j=j.next) {
            if(pivot >= j.data) {
                i = (i == null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        
        i = (i == null) ? l : i.next;
        
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        
        return i;
    }
}

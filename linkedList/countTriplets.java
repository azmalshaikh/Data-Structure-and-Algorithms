 static int countTriplets(Node head, int x) {
    Node ptr, ptr1, ptr2;

    HashMap<Integer, Node> map = new HashMap<>();

    for(ptr=head; ptr != null; ptr = ptr.next) {
        map.put(ptr.data, ptr);
    }

    int ans = 0;

    for(ptr1=head; ptr1 != null; ptr1 = ptr1.next) {
        for(ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {

            int cur = ptr1.data + ptr2.data;

            if(map.containsKey(x-cur) && map.get(x-cur) != ptr1 && map.get(x-cur) != ptr2) {
                ans++;    
            }

        }
    }

    return ans/3;
}

class LRUCache {
    
    class Node {
        int key, data;
        Node prev, next;
        
        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    
    LRUCache(int cap) {
        head = new Node(0,0);
        map = new HashMap<>();
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = cap;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            
            return node.data;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        
        if(map.size() == size) {
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
    
    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node) {
        map.put(node.key, node);
        Node headnext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headnext;
        headnext.prev = node;
    }
}

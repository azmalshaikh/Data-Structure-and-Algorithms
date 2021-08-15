class MapSum {
    
    class Node {
        Node child[] = new Node[26];
        int count;
    }
    
    HashMap<String, Integer> map;
    Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        // MapSum mapsum = new MapSum();
        map = new HashMap<>();
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        int newval = val - map.getOrDefault(key, 0);
        map.put(key, val);
        
        for(int i=0; i<key.length(); i++) {
            int pos = key.charAt(i) - 'a';
            if(cur.child[pos] == null) cur.child[pos] = new Node();
            
            cur = cur.child[pos];
            cur.count += newval;
        }
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for(int i=0; i<prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if(cur.child[pos] == null) return 0;
            cur = cur.child[pos];
        }
        
        return cur.count;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

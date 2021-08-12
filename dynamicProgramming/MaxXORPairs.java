class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int i=0; i<nums.length; i++) {
            trie.insert(nums[i]);
        }
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            int find = Integer.MAX_VALUE ^ nums[i];
            int res = trie.search(find);
            ans = Math.max(ans, nums[i] ^ res);    
        }
        
        return ans;
    }
    
    static class Trie {
        
        class Node {
            Node left, right;
        }
        
        Node root;
        Trie() {
            root = new Node();
        }
        
        public void insert(int val) {
            Node cur = root;
            int bitIndex = 30;
            
            while(bitIndex >= 0) {
                int mask = 1<<bitIndex;
                int bit = (val&mask) > 0 ? 1 : 0;
                
                if(bit == 0) {
                    if(cur.left == null) {
                        cur.left = new Node();
                    }
                    cur = cur.left;
                } else {
                    if(cur.right == null) {
                        cur.right = new Node();
                    }
                    cur = cur.right;
                }
                bitIndex--;
            }
        }
        
        public int search(int find) {
            Node cur = root;
            
            int bitIndex = 30, ans = 0;
            
            while(bitIndex >= 0) {
                int mask = 1 << bitIndex;
                int bit = find & mask;
                
                if(bit == 0) {
                    if(cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur = cur.right;
                        ans |= mask;
                    }
                } else {
                    if(cur.right != null) {
                        cur = cur.right;
                        ans |= mask;
                    } else {
                        cur = cur.left;
                    }
                }
                bitIndex--;
            }
            
            return ans;
        }
    }
}

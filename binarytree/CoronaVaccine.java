class Solution{
    
    static int ans = 0;
    
    static int post(Node node) {
        boolean zero = false, two = false;
        if(node.left == null && node.right == null) return 0;
        
        if(node.left != null) {
            int get = post(node.left);
            if(get == 0) zero = true;
            if(get == 2) two = true;
        }
        
        if(node.right != null) {
            int get = post(node.right);
            if(get == 0) zero = true;
            if(get == 2) two = true;
        }
        
        if(zero) {
            ans++;
            return 2;
        }
        
        if(two) {
            return 1;
        }
        
        return 0;
    }
    
    public static int supplyVaccine(Node root){
        ans = 0;
        int result = post(root);
        if(result == 0) {
            return ans+1;
        }
        
        return ans;
    }
}

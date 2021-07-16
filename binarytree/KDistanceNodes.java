class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        list = new ArrayList<>();
        
        find(root, target);
        
        for(int i=0; i<list.size(); i++) {
            Kdistance(list.get(i), k-i, ans, i == 0 ? null : list.get(i-1));
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    
    static void Kdistance(Node root, int k, ArrayList<Integer> list, Node blocker) {
        if(root == null || k < 0 || root == blocker) return ;
        
        
        if(k == 0) {
            list.add(root.data);
            return;
        }
        
        Kdistance(root.left, k-1, list, blocker);
        Kdistance(root.right, k-1, list, blocker);
    }
    
    static ArrayList<Node> list;
    
    public static boolean find(Node node, int data){
        if(node == null) return false;
        
        if(node.data == data) {
            list.add(node);
            return true;
        }
        
        boolean filc = find(node.left, data);
        if(filc) {
            list.add(node);
            return true;
        }
    
        boolean firc = find(node.right, data);
        if(firc) {
            list.add(node);
            return true;
        }
    
        return false;
    }
};

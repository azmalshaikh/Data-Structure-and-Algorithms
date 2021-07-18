class Solution {
    
    static class BSTPair {
         boolean isbst;
         int min, max, size;
         Node root;
    }
      
    static BSTPair isBST(Node node) {
          
        if(node == null) {
            BSTPair mt = new BSTPair();
            mt.isbst = true;
            mt.max = Integer.MIN_VALUE;
            mt.min = Integer.MAX_VALUE;
            mt.root = null;
            mt.size = 0;
            return mt;
        }
          
        BSTPair lt = isBST(node.left);
        BSTPair rt = isBST(node.right);
          
        BSTPair mt = new BSTPair();
        mt.isbst = lt.isbst && rt.isbst && (node.data > lt.max && node.data < rt.min);
        mt.min = Math.min(node.data, Math.min(lt.min, rt.min));
        mt.max = Math.max(node.data, Math.max(lt.max, rt.max));
          
        if(mt.isbst) {
            mt.root = node;
            mt.size = 1 + lt.size + rt.size;
        } else if(lt.size > rt.size) {
            mt.root = lt.root;
            mt.size = lt.size;
        } else {
            mt.root = rt.root;
            mt.size = rt.size;
        }
          
        return mt;
    }

    static int largestBst(Node root) {
        
        // display(root);
        
        BSTPair p = isBST(root);
        return p.size;
    }
    
    static void display(Node root) {
        
        if(root == null) return;
        
        System.out.print(root.data + " => ");
        
        if(root.left != null) {
            System.out.print(root.left.data + " ");
        }
        
        if(root.right != null) {
            System.out.print(root.right.data);
        }
        System.out.println();
        
        display(root.left);
        display(root.right);
    }
}

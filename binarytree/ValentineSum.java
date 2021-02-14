static int sum;
    
static void add_subtree(Node node, int dist) {
    if( (node==null) || (dist<0) ) return;
    sum += node.data;
    add_subtree(node.left, dist-1);
    add_subtree(node.right, dist-1);
}

static int traverse(Node node, int target, int k){
    if(node==null) return -1;
    if(node.data==target) {
        add_subtree(node, k);
        // adding all nodes within range in the sub tree below
        return k-1;
    }

    int dist = traverse(node.left, target, k);
    if(dist>-1)
    // dist>-1 indicates target was found in left subtree
    {
        sum += node.data;
        add_subtree(node.right, dist-1);
        // adding values from right sub tree
        return dist-1;
    }

    dist = traverse(node.right, target, k);
    if(dist>-1)
    // dist>-1 indicates target was found in right subtree
    {
        sum += node.data;
        add_subtree(node.left, dist-1);
        // adding values from left sub tree
        return dist-1;
    }

    return -1;
}

static int sum_at_distK(Node root, int target, int k){
    sum = 0;
    traverse(root, target, k);
    return sum;
}

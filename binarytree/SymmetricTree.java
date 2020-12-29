public static boolean isSymmetric(Node root) {
    Node node1=root, node2=root;

    return isSymmetric(node1, node2);
}

static boolean isSymmetric(Node node1, Node node2) {
    if(node1 == null && node2 != null) return false;

    else if(node1 != null && node2 == null) return false;

    else if(node1 == null && node2 == null) return false;

    return ( (node1.data == node2.data) && (isSymmetric(node1.left, node2.right))
             && (isSymmetric(node1.right, node2.left))
            );    
}

class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        Node currentNode = new Node(node.val);
        
        map.put(node.val, currentNode);
        for (Node neighbour : node.neighbors) {
            if (map.containsKey(neighbour.val)) {
                currentNode.neighbors.add(map.get(neighbour.val));
            } else currentNode.neighbors.add(cloneGraph(neighbour));
        }
        
        return currentNode;
    }
}

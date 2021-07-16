public static boolean find(Node node, int data){
  if(node == null) return false;

  if(node.data == data) {
      list.add(node.data);
      return true;
  }

  boolean filc = find(node.left, data);
  if(filc) {
      list.add(node.data);
      return true;
  }

  boolean firc = find(node.right, data);
  if(firc) {
      list.add(node.data);
      return true;
  }

  return false;
}

public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    return list;
}

public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    return list;
}

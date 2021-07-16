public static boolean find(Node node, int data){
  if(node == null) return false;

  if(node.data == data) return true;

  if(node.left != null) {
      if(find(node.left, data)) return true;
  }

  if(node.right != null) {
      if(find(node.right, data)) return true;
  }

  return false;
}

public static ArrayList<Integer> nodeToRootPath(Node node, int data){

    if(node == null) {
        return new ArrayList<>();
    }

  ArrayList<Integer> list = new ArrayList<>();

  if(node.data == data) {
      list.add(node.data);
      return list;
  }

  ArrayList<Integer> l1 = new ArrayList<>();
  ArrayList<Integer> l2 = new ArrayList<>();

  if(node.left != null) {
      l1 = nodeToRootPath(node.left, data);
  } 

  if(node.right != null) {
      l2 = nodeToRootPath(node.right, data);
  }

  if(!l1.isEmpty()) list.addAll(l1);
  if(!l2.isEmpty()) list.addAll(l2);
  if(!list.isEmpty())list.add(node.data);

  return list;
}

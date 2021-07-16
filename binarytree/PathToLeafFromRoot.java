public static void pathToLeafFromRoot(Node root, String path, int S, int lo, int hi){
    
  if(root == null) return ;

  if(root.left == null && root.right == null) {
      S += root.data;
      if(S > lo && S < hi) {
          System.out.println(path + root.data);    
      }
      return;
  }

  path += root.data + " ";

  pathToLeafFromRoot(root.left,path, S + root.data, lo, hi);
  pathToLeafFromRoot(root.right,path, S + root.data, lo, hi);
}

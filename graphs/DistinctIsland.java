static void dfs(int arr[][], int i, int j, StringBuilder sb) {
    if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 0) return;

    arr[i][j] = 0;
    dfs(arr, i-1, j, sb.append("t"));
    dfs(arr, i+1, j, sb.append("d"));
    dfs(arr, i, j-1, sb.append("l"));
    dfs(arr, i, j+1, sb.append("r"));
}

public static int numDistinctIslands(int[][] arr) {

    HashSet<String> set = new HashSet();

  for(int i=0; i<arr.length; i++) {
      for(int j=0; j<arr[0].length; j++) {
          if(arr[i][j] == 1) {
              StringBuilder sb = new StringBuilder();
              sb.append("x");
              dfs(arr, i, j, sb);
              set.add(sb.toString());
          } 
      }
  }

  return set.size();
}

// Here vis array is not necessary bec we are marking every arr[cr][cc] = 0 so it will never visit again because of base case arr[cc][cc] == 0 return;
public static void connectedComp(int arr[][], boolean vis[][], int cr, int cc) {
  if(cr < 0 || cc < 0 || cr >= arr.length || cc >= arr[0].length || arr[cr][cc] == 0 || vis[cr][cc]) return;

  vis[cr][cc] = true;
  arr[cr][cc] = 0;
  connectedComp(arr, vis, cr-1, cc);
  connectedComp(arr, vis, cr+1, cc);
  connectedComp(arr, vis, cr, cc+1);
  connectedComp(arr, vis, cr, cc-1);
}

public static int numEnclaves(int[][] arr) {
  int m = arr.length;
  int n = arr[0].length;
  boolean vis[][] = new boolean [m][n];
  for(int j=0; j<n; j++) {
      if(arr[0][j] == 1) {
          connectedComp(arr, vis, 0, j);
      }    

      if(arr[m-1][j] == 1) {
          connectedComp(arr, vis, m-1, j);
      }
  }

  for(int i=0; i<m; i++) {
      if(arr[i][0] == 1) {
          connectedComp(arr, vis, i, 0);
      }    

      if(arr[i][n-1] == 1) {
          connectedComp(arr, vis, i, n-1);
      }
  }

  int ans = 0;

  for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
          if(arr[i][j] == 1) ans++;
      }
  }

  return ans;
}

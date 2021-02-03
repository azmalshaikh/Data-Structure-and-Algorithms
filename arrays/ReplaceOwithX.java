public static void main (String[] args) {
  Scanner sc = new Scanner(System.in);
  int t = sc.nextInt();
  while(t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char mat[][] = new char [n][m];

      for(int i=0; i<n; i++) {
          for(int j=0; j<m; j++) {
              mat[i][j] = sc.next().charAt(0);
          }
      }

      replaceSurrounded(mat, n, m);
      for(int i=0; i<n; i++) {
          for(int j=0; j<m; j++) {
              System.out.print(mat[i][j] + " ");
          }
      }

      System.out.println();
  }
}

static void floodFillUtil(char mat[][], int x, int y, char prevV, char newV, int M, int N) { 
      if (x < 0 || x >= M || 
          y < 0 || y >= N) 
          return; 

      if (mat[x][y] != prevV) 
          return; 

      mat[x][y] = newV; 

      floodFillUtil(mat, x + 1, y, prevV, newV, M, N); 
      floodFillUtil(mat, x - 1, y, prevV, newV, M, N); 
      floodFillUtil(mat, x, y + 1, prevV, newV, M, N); 
      floodFillUtil(mat, x, y - 1, prevV, newV, M, N); 
  } 

  static void replaceSurrounded(char mat[][], int M, int N) { 

      for (int i = 0; i < M; i++) 
          for (int j = 0; j < N; j++) 
              if (mat[i][j] == 'O') 
                  mat[i][j] = '-'; 

      for (int i = 0; i < M; i++)
          if (mat[i][0] == '-') 
              floodFillUtil(mat, i, 0,'-', 'O', M, N); 

      for (int i = 0; i < M; i++) 
          if (mat[i][N - 1] == '-') 
              floodFillUtil(mat, i, N - 1, '-', 'O', M, N); 

      for (int i = 0; i < N; i++) 
          if (mat[0][i] == '-') 
              floodFillUtil(mat, 0, i,'-', 'O', M, N); 

      for (int i = 0; i < N; i++)
          if (mat[M - 1][i] == '-') 
              floodFillUtil(mat, M - 1, i, '-', 'O', M, N); 

      for (int i = 0; i < M; i++) 
          for (int j = 0; j < N; j++) 
              if (mat[i][j] == '-') 
                  mat[i][j] = 'X'; 
  }

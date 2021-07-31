import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  private static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    int[][] ans = updateMatrix(arr);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }

  public static int[][] updateMatrix(int[][] matrix) {
    LinkedList<Pair> queue = new LinkedList<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = -1;
        } else {
          queue.addLast(new Pair(i, j));
        }
      }
    }
    int length = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      length++;
      for (int i = 0; i < size; i++) {
        Pair rem = queue.removeFirst();
        for (int[] dir : dirs) {
          int idash = rem.x + dir[0];
          int jdash = rem.y + dir[1];

          if (idash >= 0 && jdash >= 0 && idash < matrix.length && jdash < matrix[0].length) {
            if (matrix[idash][jdash] == -1) {
              matrix[idash][jdash] = length;
              queue.addLast(new Pair(idash, jdash));
            }
          }
        }
      }
    }
    return matrix;
  }
}
                                

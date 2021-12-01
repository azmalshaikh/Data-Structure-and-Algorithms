import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }
  
  public static int find(int parent[], int i) {
      if(parent[i] == i) return i;
      
      return parent[i]= find(parent, parent[i]);
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer>list = new ArrayList<>();
    
    int size = m*n;
    int parent[] = new int[size];
    int rank[] = new int[size];
    Arrays.fill(parent, -1);
    
    int dirs[][] = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    int count = 0;
    
    for(int pos[]:positions) {
        int temp = pos[0]*n + pos[1];
        
        if(parent[temp] != -1) {
            list.add(count);
            continue;
        }
        
        parent[temp] = temp;
        rank[temp] = 1;
        count++;
        for(int dir[]: dirs) {
            int nrow = pos[0] + dir[0], ncol = pos[1] + dir[1];
            int colno = nrow * n + ncol;
            
            if(nrow<0 || ncol<0 || nrow>=m || ncol>=n || parent[colno] == -1) continue;
            
            int px = find(parent, temp); 
            int py = find(parent, colno);
            
            if(px != py) { // Belong to diff sets
                if(rank[px] > rank[py]) {
                    parent[py] = px;
                } else if(rank[px] < rank[py]) {
                    parent[px] = py;
                } else {
                    parent[py] = px;
                    rank[px]++;
                }
                count--;
            }
            
        }
        list.add(count);
    }
    
    return list;
  }
}

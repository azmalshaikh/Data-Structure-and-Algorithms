import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge {
        int v, n;
        public Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }
    
    static void getConnectedComponents(ArrayList<Edge> graph[], int src, boolean vis[], ArrayList<Integer> temp) {
        vis[src] = true;
        temp.add(src);
        for(Edge edge: graph[src]) {
            if(!vis[edge.n]) {
                getConnectedComponents(graph, edge.n, vis, temp);
            }
        }
    }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayList<Edge> graph[] = new ArrayList[n];
      
      for(int v=0; v<n; v++) {
          graph[v] = new ArrayList<>();
      }
      
      for(int i=0; i<k; i++) {
          String line = br.readLine();
          String parts[] = line.split(" ");
          
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          
          graph[v1].add(new Edge(v1, v2));
          graph[v2].add(new Edge(v2, v1));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean vis[] = new boolean[n];
      
      for(int v=0; v<n; v++) {
          if(!vis[v]) {
              ArrayList<Integer> temp = new ArrayList<>();
              getConnectedComponents(graph, v, vis, temp);
              comps.add(temp);
          }
      }
      
      int ans = 0;
      
      for(int i=0; i<comps.size(); i++) {
          for(int j=i+1; j<comps.size(); j++) {
              ans += comps.get(i).size() * comps.get(j).size();
          }
      }
      
      System.out.println(ans);
   }

}

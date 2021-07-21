import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   static void connectedcomp(ArrayList<Edge> graph[], int src, ArrayList<Integer> temp, boolean vis[]) {
       
       vis[src] = true;
       temp.add(src);
       for(Edge edge: graph[src]) {
           if(!vis[edge.nbr]) connectedcomp(graph, edge.nbr, temp, vis);
       }
       
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean vis[] = new boolean[vtces];
      
      for(int i=0; i<vtces; i++) {
          if(!vis[i]) {
            ArrayList<Integer> temp = new ArrayList<>();  
            connectedcomp(graph, i, temp, vis);  
            comps.add(temp);
          }
      }
      // write your code here

      System.out.println(comps);
   }
}

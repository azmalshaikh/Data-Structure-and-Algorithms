import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   static int infection(ArrayList<Edge> graph[], int src, int t, boolean vis[]) {
       
       int time[] = new int [vis.length];
       vis[src] = true;
       Queue<Integer> q = new LinkedList<>();
       q.add(src);
       time[src] = 1;
       int count = 1;
       
       while(!q.isEmpty()) {
           int cur = q.poll();
           for(Edge edge: graph[cur]) {
               if(!vis[edge.nbr]) {
                   time[edge.nbr] = time[cur] + 1;
                   if(time[edge.nbr] > t) break;
                   else count++;
                   vis[edge.nbr] = true;
                   q.add(edge.nbr);
               }
           }
       }
       
       return count;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      boolean vis[] = new boolean[vtces];
      int count = infection(graph, src, t, vis);
      
      System.out.println(count);
      
      // write your code here
   }

}

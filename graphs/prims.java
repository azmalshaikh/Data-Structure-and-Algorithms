import java.util.*;
public class Prims {
	
	static class Edge implements Comparable<Edge> {
		int src, dest, weight;
		
		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}
	
	static class Graph {
		
		private static LinkedList<Edge> adj[];
		int v;
		
		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			
			for(int i=0; i<v; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int source, int destination, int weight) {
			Edge edge = new Edge(source, destination, weight);
			adj[source].add(edge);
			
			edge = new Edge(destination, source, weight);
			adj[destination].add(edge);
		}
		
		void PrimsAlgo() {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, -1, 0));
			boolean vis[] = new boolean[v];
			Edge result[] = new Edge[v];
			int e=0;
			
			while(pq.size() > 0) {
				Edge toAdd = pq.remove();
				
				if(vis[toAdd.src]) {
					continue;
				}
				
				vis[toAdd.src] = true;
				
				if(toAdd.dest != -1) result[e++] = toAdd;
				
				LinkedList<Edge> list = adj[toAdd.src];
				for(Edge a : list) {
					if(!vis[a.dest]) {
						pq.add(new Edge(a.dest, toAdd.src, a.weight));
					}
				}
			}
			int minCost = 0;
			for(int i=0; i<e; i++) {
				System.out.println(result[i].dest + " -- " + result[i].src + " => " + result[i].weight);
				minCost += result[i].weight;
			}
			System.out.println("Minimum Cost Spanning Tree " + minCost);
		}
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Vertices and Edges");
			int v = sc.nextInt();
			int e = sc.nextInt();
			Graph graph = new Graph(v);
			
			System.out.println("Enter "+ e +" Edges ");
			for(int i=0; i<e; i++) {
				int source = sc.nextInt();
				int destination = sc.nextInt();
				int weight = sc.nextInt();
				graph.addEdge(source, destination, weight);
			}
			
			graph.PrimsAlgo();
			
			sc.close();
		}
	}
}

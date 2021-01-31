package graphAlgo;

import java.util.*;

class Edge {
	int source, destination, weight;
	
	public Edge(int source, int destination, int weight) {
		this.destination = destination;
		this.source = source;
		this.weight = weight;
	}
}

public class BellmanFord {
	
	public static void bellmanFord(List<Edge> edges, int source, int V) {
		int distance[] = new int [V];
		int parent[] = new int [V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		Arrays.fill(parent, -1);
		
//		Relaxation step
		for(int i=0; i<V-1; i++) {
			for(Edge edge: edges) {
				int u = edge.source;
				int v = edge.destination;
				int w = edge.weight;
				
				if(distance[u] + w < distance[v]) {
					distance[v] = distance[u] + w;
					parent[v] = u;
				}
			}
		}
		
//		Run Relaxation step one more time
		for(Edge edge: edges) {
			int u = edge.source;
			int v = edge.destination;
			int w = edge.weight;
			
			if(distance[u] + w < distance[v]) {
				System.out.println("Graph contains Negative weight cycle");
				return;
			}
		}
		
		for(int i=0; i<V; i++) {
			System.out.println("Distance of vertex " + i + 
					" from the source is " + distance[i] + " Route => [");
			printPath(parent, i);
			System.out.println("]");
		}
	}
	
	static void printPath(int parent[], int i) {
		if(i < 0) return;
		
		printPath(parent, parent[i]);
		System.out.print(i + " ");
	}

	public static void main(String[] args) {
		
		List<Edge> edges = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices and edges");
		int V= sc.nextInt();
		int E = sc.nextInt();
		
		System.out.println("Enter Edges [source destination weight]");
		for(int i=0; i<E; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			edges.add(new Edge(source, destination, weight));
		}
 
        bellmanFord(edges, 0, V);
        sc.close();
	}

}

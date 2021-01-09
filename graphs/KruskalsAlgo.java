import java.util.*;

public class Graph {
	
	class Edge implements Comparable<Edge> {
		int src, dest, weight;
		
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}
	
	int V, E;
	Edge edge[];
	
	Graph(int V, int E) {
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for(int i=0; i<E; i++) {
			edge [i] = new Edge();
		}
	}
	
	int find(int parent[], int i) {
		if(parent[i] == -1) return i;
		
		return find(parent, parent[i]);
	}
	
	void union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	
	void kruskalMST() {
		Edge result[] = new Edge[V];
		
		int e=0;
		
		for(int i=0; i<V; i++) {
			result[i] = new Edge();
		}
		
		Arrays.sort(edge);
		
		int parent[] = new int [V];
		Arrays.fill(parent, -1);
		int i=0;
		
		while(e < V-1) {
			Edge toAdd = new Edge();
			toAdd = edge[i++];
			
			int x = find(parent, toAdd.src);
			int y = find(parent, toAdd.dest);
			
			if(x != y) {
				result[e++] = toAdd;
				union(parent, x, y);
			}
		}
		int minCost = 0;
		for(i=0; i<e; i++) {
			System.out.println(result[i].src + " -- " + 
							result[i].dest + " => " + result[i].weight);
			
			minCost += result[i].weight;
		}
		System.out.println("Minimum Cost Spanning Tree " + minCost);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No of Vertices and Edges");
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Graph graph = new Graph(V,E);
		System.out.println("Enter "+ E +" Edges");
		for(int i=0; i<E; i++) {
			graph.edge[i].src = sc.nextInt();
			graph.edge[i].dest = sc.nextInt();
			graph.edge[i].weight = sc.nextInt();
		}
		
		graph.kruskalMST();
		
		sc.close();
	}

}

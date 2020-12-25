package graphs;
import java.util.* ;

public class Graph {
	
	private LinkedList<Integer> adj [];
	
	public Graph(int v) {
		adj = new LinkedList [v];
		
		for(int i=0 ; i<v ; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	public int bfs(int source, int destination) {
		
		boolean visited[] = new boolean [adj.length];
		int parent[] = new int [adj.length];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		parent[source] = -1;
		visited[source] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			if(cur == destination) break;
			
			for(int neighbor : adj[cur]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true ;
					q.add(neighbor);
					parent[neighbor] = cur;
				}
			}
		}
		
		int cur = destination;
		int distance = 0;
		while(parent[cur] != -1) { 
			System.out.print(cur+" -> ");
			cur = parent[cur];
			distance++ ;
		}
		System.out.println(cur);
		return distance ;
		
	}
	
	private boolean dfsUtil(int source, int destination, boolean visited[]) {
		if(source == destination) return true ;
		
		for(int neighbor : adj[source]) {
			if(!visited[neighbor]) {
				visited[neighbor] = true;
				boolean connected = dfsUtil(neighbor, destination, visited);
				if(connected) return true;
			}
		}
		return false;
	}
	
	public boolean dfs(int source, int destination) {
		boolean visited[] = new boolean [adj.length];
		visited[source] = true;
		return dfsUtil(source, destination, visited);
	}
	
	public boolean dfsStack(int source, int destination) {
		boolean visited[] = new boolean [adj.length];
		visited[source] = true;
		
		Stack<Integer> s = new Stack <>();
		s.push(source);
		
		while(!s.isEmpty()) {
			int cur = s.pop();
			
			if(cur == destination) return true;
			for(int neighbor: adj[cur]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					s.push(neighbor);
				}
			}
		}
		return false ;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter no of vertices and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph graph = new Graph(v);
		System.out.println("Enter "+ e + " edges");
		
		for(int i=0 ; i<e ; i++) { 
			int source = sc.nextInt();
			int destination = sc.nextInt();
			
			graph.addEdge(source, destination);
		}
		
		System.out.println("Enter Source and destination");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		
		System.out.println("Min distance "+graph.bfs(source, destination));
		sc.close();
		
//		System.out.println("Possible " + graph.dfsStack(source, destination));
	}

}

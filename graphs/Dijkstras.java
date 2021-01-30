import java.util.*; 

public class Dijkstras { 
    private int dist[]; 
    private boolean vis[];
    private PriorityQueue<Node> pq; 
    private int V;
    private LinkedList<Node> adj []; 
    private List<Integer> route;
    private int prev[];
    
    private static void getRoute(int prev[], int i, List<Integer> route) {
    	if(i >= 0) {
    		getRoute(prev, prev[i], route);
    		route.add(i);
    	}
    }
  
    public Dijkstras(int V) { 
        this.V = V; 
        dist = new int[V]; 
        vis = new boolean [V]; 
        pq = new PriorityQueue<Node>(V, new Node()); 
        route = new ArrayList<>();
        prev = new int [V];
    } 
  
    
    public void dijkstra(LinkedList<Node> adj[], int src) { 
        this.adj = adj; 
  
        for (int i = 0; i < V; i++) 
            dist[i] = Integer.MAX_VALUE; 
  
        pq.add(new Node(src, 0)); 
  
        dist[src] = 0; 
        prev[src] = -1;
        while (!pq.isEmpty()) { 
  
            int u = pq.remove().vertex; 

            vis[u] = true; 
  
            e_Neighbours(u); 
        } 
    } 

    private void e_Neighbours(int u) { 
        int edgeDistance = -1; 
        int newDistance = -1; 
   
        for (int i = 0; i < adj[u].size(); i++) { 
            Node v = adj[u].get(i); 
  
            if (!vis[v.vertex]) { 
                edgeDistance = v.weight; 
                newDistance = dist[u] + edgeDistance; 
 
                if (newDistance < dist[v.vertex]) {
                    dist[v.vertex] = newDistance; 
                    prev[v.vertex] = u;
                }
                
                pq.add(new Node(v.vertex, dist[v.vertex])); 
            } 
        } 
    } 
  
    // Driver code 
    public static void main(String arg[]) { 
        int V = 9; 
        int s = 0; 
  
        LinkedList<Node> adj []= new LinkedList[V]; 
  
        for (int i = 0; i < V; i++) { 
            adj[i] = new LinkedList<>(); 
        } 
        
        System.out.println("Enter no of edges");
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        System.out.println("Enter edges (Source Destination Weight");
        for(int i=0; i<e; i++) {
        	int source = sc.nextInt();
        	int destination = sc.nextInt();
        	int weight = sc.nextInt();
        	adj[source].add(new Node(destination, weight));
        	adj[destination].add(new Node(source, weight));
        }
        
        Dijkstras dpq = new Dijkstras(V); 
        dpq.dijkstra(adj, s); 
  
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) {
        	getRoute(dpq.prev, i, dpq.route);
            System.out.println("Path => " + s + " to " + i + ": Minimum Cost = "+ dpq.dist[i] + ", Route = " + dpq.route);
            dpq.route.clear();
        }
        	
        sc.close();
    } 
} 
 
class Node implements Comparator<Node> { 
    public int vertex; 
    public int weight; 
  
    public Node() { 
    	
    } 
  
    public Node(int vertex, int weight) { 
        this.vertex = vertex; 
        this.weight = weight; 
    } 
  
    @Override
    public int compare(Node node1, Node node2) { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

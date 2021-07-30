import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(new Edge(v, 0));
			graph.get(v).add(new Edge(u, 1));
		}

		LinkedList<Edge> q = new LinkedList<>();
		boolean[] vis = new boolean[n];
		vis[0] = true;
		q.addLast(new Edge(0, 0));
		
		while(!q.isEmpty()) {
		    Edge temp = q.removeFirst();
		    
		    if(temp.vt == n-1) {
		        System.out.println(temp.wt);
		        return;
		    }
		    
		    for(Edge edge : graph.get(temp.vt)) {
		        if(!vis[edge.vt]) {
		            vis[edge.vt] = true;
    		        if(edge.wt == 0) {
    		            q.addFirst(new Edge(edge.vt, temp.wt + 0));
    		        } else {
    		            q.addLast(new Edge(edge.vt, temp.wt + 1));
    		        }
		        }
		    }
		}
		
		System.out.println(-1);
	}
	
	public static class Edge{
	    int vt, wt;
	    
	    Edge(int vt, int wt) {
	        this.vt = vt;
	        this.wt = wt;
	    }
	}
}

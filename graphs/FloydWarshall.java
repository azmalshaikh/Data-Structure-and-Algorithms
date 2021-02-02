package graphAlgo;

public class FloydWarshall {
	
	final static int inf = 99999;
	
	private static void printPath(int path[][], int i, int j) {
		if(path[i][j] == i) return;
		
		printPath(path, i, path[i][j]);
		System.out.print(path[i][j] + " ");
	}
	
	private static void printSolution(int dist[][], int path[][], int V) {
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				if(i != j) {
					System.out.print("Shortest Distance from " + i + " -> " + 
							j + " is " + dist[i][j]);
					System.out.print(" Route => " + i + " ");
					printPath(path, i, j);
					System.out.println(j);
				}
			}
		}
	}
	
	public static void floydWarshall(int graph[][], int V) {
		int dist[][] = new int [V][V];
		int path[][] = new int [V][V];
		
		int i, j, k;
		
		for(i=0; i<V; i++) {
			for(j=0; j<V; j++) {
				dist[i][j] = graph[i][j];
				
				if(i == j) {
					path[i][j] = 0;
				} else if(dist[i][j] != inf) {
					path[i][j] = i;
				} else {
					path[i][j] = -1;
				}
			}
		}
		
		for(k=0; k<V; k++) {
			for(i=0; i<V; i++) {
				for(j=0; j<V; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
				}
				
				if(dist[i][i] < 0) {
					System.out.println("Negative weight Cycle Found");
					return;
				}
			}
		}
		
		printSolution(dist, path, V);
	}

	public static void main(String[] args) {

		int graph[][] = {
                    { 0, inf, -2, inf },
                    { 4, 0, 3, inf },
                    { inf, inf, 0, 2 },
                    { inf, -1, inf, 0 }
//				{0, 9, -4, inf},
//				{6, 0, inf, 2},
//				{inf, 5, 0, inf},
//				{inf, inf, 1, 0}
		};
		
		floydWarshall(graph, 4);
	}

}

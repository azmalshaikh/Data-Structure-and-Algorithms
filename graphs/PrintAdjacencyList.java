class Adjacency 
{
    static void printGraph(ArrayList<ArrayList<Integer>> adj, int V) {
	   for(int i=0; i<V; i++) {
	       System.out.print(i);
	       for(int j=0; j<adj.get(i).size(); j++) {
	           System.out.print("-> "+ adj.get(i).get(j));
	       }
	       System.out.println();
	   }
	}
}

{
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }
  
  static int[] parent;
  static int[] rank;

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }
  
  public static int find(int i) {
      if(parent[i] == i) return i;
      
      return parent[i] = find(parent[i]);
  }
  
  public static boolean union(int x, int y) {
    int lx = find(x);
    int ly = find(y);

    if (lx == ly) {
      return true;
    }

    if (rank[lx] > rank[ly]) {
      parent[ly] = lx;
    } else if (rank[lx] < rank[ly]) {
      parent[lx] = ly;
    } else {
      parent[lx] = ly;
      rank[ly]++;
    }

    return false;
  }

  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    Pair[] edges = new Pair[pipes.length + wells.length];

    for (int i = 0; i < pipes.length; i++) {
      int u = pipes[i][0];
      int v = pipes[i][1];
      int wt = pipes[i][2];
      edges[i] = new Pair(u, v, wt);
    }

    int idx = pipes.length;
    for(int i=0; i<wells.length; i++) {
        edges[idx++] = new Pair(0, (i+1), wells[i]);
    }

    int ans = 0;
    Arrays.sort(edges);
    parent = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    
    for(int i=0; i<edges.length; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int wt = edges[i].wt;
        
        boolean flag = union(u, v);
        if (flag == false) {
            ans += wt;
        }
    }
    
    return ans;
  }
}

class Solution {
    
    static class Pair {
        int x, y;
        int dis;
 
        public Pair(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(knightPos[0], knightPos[1], 0));
        boolean vis[][] = new boolean[N+1][N+1];
        vis[knightPos[0]][knightPos[1]] = true;
        
        while(!q.isEmpty()) {
            Pair temp = q.remove();
            
            if(temp.x == targetPos[0] && temp.y == targetPos[1]) {
                return temp.dis;
            }
            
            for(int i=0; i<8; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                
                if(isInside(x, y, N) && !vis[x][y]) {
                    vis[x][y] = true;
                    q.add(new Pair(x, y, temp.dis + 1));
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    static boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }
}

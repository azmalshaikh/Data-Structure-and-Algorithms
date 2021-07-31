// M-I
class Solution {
    public int orangesRotting(int[][] grid) {
        HashSet<String> fresh = new HashSet<>();
        HashSet<String> rotten = new HashSet<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh.add("" + i + j);
                } else if(grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }
        int minutes = 0;
        int directions[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(fresh.size() > 0) {
            HashSet<String> infected = new HashSet<>();
            
            for(String s: rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                
                for(int direction[]: directions) {
                    int nexti = i + direction[0];
                    int nextj = j + direction[1];
                    if(fresh.contains("" + nexti + nextj)) {
                        fresh.remove("" + nexti + nextj);
                        infected.add("" + nexti + nextj);
                    }
                }
            }
            
            if(infected.size() == 0) {
                return -1;
            }
            rotten = infected;
            minutes++;
        }
        
        return minutes;
    }
}


// M - ii
public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<String> queue = new LinkedList<>();
    int fresh = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 2) {
                queue.add("" + i + j);
            } else if (grid[i][j] == 1) {
                fresh++;
            }
        }
    }
    if (fresh == 0)
        return 0;

    int count = -1;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    while (!queue.isEmpty()) {
        ++count;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String s = queue.remove();
            for (int dir[] : dirs) {
                int x = s.charAt(0) - '0' + dir[0];
                int y = s.charAt(1) - '0'+ dir[1];
                if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                    continue;
                grid[x][y] = 2;
                queue.add("" + x + y);
                fresh--;
            }
        }
    }

    return fresh == 0 ? count : -1;
}

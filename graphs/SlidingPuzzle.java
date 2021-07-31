class Solution {
    
    public String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    } 
    
    public int slidingPuzzle(int[][] board) {
        Queue<String> q = new LinkedList<>();
        
        String target = "123450";
        HashSet<String> set = new HashSet<>();
        int directions[][] = {{ 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }};
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) sb.append(board[i][j]);
        }
        
        String initial = sb.toString();
        q.add(initial);
        set.add(initial);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                String temp = q.remove();

                if(temp.equals(target)) return level;

                // Find where is 0
                int idx = -1;
                for(int i=0; i<temp.length(); i++) 
                    if(temp.charAt(i)=='0') idx = i;

                // Visiting Neighbors
                int move[] = directions[idx];
                for(int i=0; i<move.length; i++) {
                    String toAdd = swap(temp, idx, move[i]);
                    if(!set.contains(toAdd)) {
                        q.add(toAdd);
                        set.add(toAdd);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

class Solution {
    static int minThrow(int N, int arr[]){
        Queue<int []> q = new LinkedList<>();
        HashMap<Integer, Integer> ladder = new HashMap<>();
        HashMap<Integer, Integer> snake = new HashMap<>();
        
        for(int i=0; i<2*N; i+=2) {
            if(arr[i] < arr[i+1]) {
                ladder.put(arr[i], arr[i+1]);
            } else {
                snake.put(arr[i], arr[i+1]);
            }
        }
        int node[] = {1, 0};
        q.add(node);
        boolean vis[] = new boolean [31];
        vis[1] = true;
        
        while(!q.isEmpty()) {
            int top[] = q.remove();
            if(top[0] == 30) return top[1];
            
            for(int i=0; i<=6; i++) {
                int next = top[0] + i;
                if(next < 31 && !vis[next]) {
                    int val[] = new int[2];
                    if(ladder.containsKey(next)) {
                        val[0] = ladder.get(next);
                        val[1] = top[1] + 1;
                    } else if(snake.containsKey(next)) {
                        val[0] = snake.get(next);
                        val[1] = top[1] + 1;
                    } else {
                        val[0] = top[0]+ i;
                        val[1] = top[1] + 1;
                    }
                    
                    q.add(val);
                }
            }
        }
        
        return -1;
    }
}

class Solution {
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        // Step 1 Create HashMap
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++) {
            for(int j=0; j<routes[i].length; j++) {
                ArrayList<Integer> temp = map.getOrDefault(routes[i][j], new ArrayList<>());
                temp.add(i);
                map.put(routes[i][j], temp);
            }
        }
        
        // Step 2 Create vis but stop and bus no also
        HashSet<Integer> busStop = new HashSet<>();
        HashSet<Integer> busNo = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        busStop.add(source);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int temp = q.remove();
                
                if(temp == target) return level;
                
                ArrayList<Integer> list = map.get(temp);
                for(int bus: list) {
                    if(!busNo.contains(bus)) {
                        int arr[] = routes[bus];
                        for(int e: arr) {
                            if(!busStop.contains(e)) {
                                q.add(e);
                                busStop.add(e);
                            }
                        }
                        busNo.add(bus);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}

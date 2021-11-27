class Solution {
    
    public class Pair implements Comparable<Pair> {
        int val, index;
        
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        
        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        int n = nums.length;
        Pair arr[] = new Pair[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr);
        
        boolean vis[] = new boolean[n];
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            if(vis[i] == true || arr[i].index == i) {
                continue;
            }
            
            int cycle = 0;
            int j = i;
            while(vis[j] == false) {
                cycle++;
                vis[j] = true;
                j = arr[j].index;
            }
            
            ans += cycle - 1;
        }
        
        return ans;
    }
}

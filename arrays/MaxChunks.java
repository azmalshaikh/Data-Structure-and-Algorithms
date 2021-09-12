class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int left[] = new int[n+1]; // Left Max 0 -> i(included)
        int right[] = new int[n+1]; // Right Min i(included) -> n-1
        
        left[0] = arr[0];
        int max = arr[0];
        for(int i=1; i<n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        
        right[n] = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--) {
            min = Math.min(min, arr[i]);
            right[i] = min;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(left[i] <= right[i+1]) ans++;
        }
        
        return ans;
    }
}

class Solution {
    int median(int arr[][], int r, int c) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i=0; i<r; i++) {
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][c-1]);
        }
        
        int req = (r*c + 1) / 2; // Elements less than or equal to median
        while(min < max) {
            int mid = (min+max)/2;
            
            int cur = 0;
            for(int i=0; i<r; i++) {
                // This will give the element index and if it not present it will give -(insertionpoint) - 1
                int idx = Arrays.binarySearch(arr[i], mid);
                
                if(idx < 0) idx = Math.abs(idx) - 1;
                
                // Present in arr
                else {
                    while(idx<c && arr[i][idx] == mid) idx += 1; // It can contain duplicates
                }
                
                cur += idx;
            }
            
            if(cur < req) min = mid+1;
            else max = mid;
        }
        
        return min;
    }
}

class Solution {
    int findMissing(int[] arr, int n) {
        int diff = (arr[n-1] - arr[0]) / n;
        
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid+1] - arr[mid] != diff) {
                return arr[mid] + diff;
            }
            
            if(mid > 0 && arr[mid] - arr[mid-1] != diff) return arr[mid-1] + diff;
            
            if(arr[0] + mid * diff == arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return -1;
    }
}

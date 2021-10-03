class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        int low = 0, high = n-1; 
        int rIndex = arr.length, lIndex = -1;
         
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == x) {
                lIndex = mid-1;
                rIndex = mid+1;
                break;
            }
            else if(arr[mid] < x) {
                lIndex = Math.max(mid,lIndex);
                low = mid+1;
            }
            else {
                rIndex = Math.min(mid,rIndex);
                high = mid-1;
            }
        }
        
        int ans[] = new int[k];
        int vidx = 0;
        
        while(lIndex >= 0 && rIndex < arr.length && k>0) {
            
            if(arr[lIndex] == x) {
                lIndex--;
                continue;
            }
            
            if(arr[rIndex] == x) {
                rIndex++;
                continue;
            }
            
            if(Math.abs(arr[lIndex]  - x) >= Math.abs(arr[rIndex] - x)) {
                ans[vidx++] = arr[rIndex];
                rIndex++;
            } else {
                ans[vidx++] = arr[lIndex];
                lIndex--;
            }
            k--;
        }
        
        while(lIndex >= 0 && k>0) {
            ans[vidx++] = arr[lIndex];
            lIndex--;
            k--;
        }
        
        while(rIndex < arr.length && k>0) {
            ans[vidx++] = arr[rIndex];
            rIndex++;
            k--;
        }
        
        return ans;
    }
}

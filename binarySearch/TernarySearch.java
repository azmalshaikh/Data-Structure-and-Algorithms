class Solution{

    static int ternarySearch(int arr[], int n, int k) {
        
        int low=0, high=n-1;
        
        while(low <= high) {
            int mid1 = low + (high-low)/3;
            int mid2 = high - (high-low)/3;
            
            if(arr[mid1] == k) return 1;
            else if(arr[mid2] == k) return 1;
            
            else if(arr[mid1] > k) {
                high = mid1-1;
            } else if(arr[mid2] < k) {
                low = mid2+1;
            } else {
                low = mid1+1;
                high = mid2-1;
            }
        }
        
        return -1;
    }
}

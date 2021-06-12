class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr ,int n ,int k){
        int min = max(arr);
        int max = sum(arr);
        int res = 0;
        
        while(min <= max) {
            int mid = (min+max) / 2;
            
            if(isFeasible(arr, k, mid)) {
                res = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        
        return res;
    }
    
    static boolean isFeasible(int arr[], int k, int res) {
        int student = 1, curSum = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(curSum + arr[i] > res) {
                student++;
                curSum = arr[i];
            } else {
                curSum += arr[i];
            }
        }
        
        return student <= k;
    }
    
    static int max(int arr[]) {
        int max = 0;
        for(int i: arr) {
            if(i > max) max = i;
        }
        
        return max;
    }
    
    static int sum(int arr[]) {
        int sum = 0;
        for(int i: arr) sum += i;
        
        return sum;
    }
};

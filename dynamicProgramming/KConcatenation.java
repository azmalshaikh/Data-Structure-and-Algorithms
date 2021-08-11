class Solution {
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1) {
            return kadanes(arr);
        } else {
            int sum = 0;
            for(int i=0; i<arr.length; i++) {
                sum += arr[i];
            }
            
            if(sum < 0) {
                int ans = kadanesTwo(arr); 
                if(ans < 0) return 0;
                return ans;
            } else {
                return kadanesTwo(arr) + (k-2)*sum;
            }
        }
    }
    
    public int kadanes(int arr[]) {
        int ans = Integer.MIN_VALUE, curMax = 0;
        
        for(int i=0; i<arr.length; i++) {
            curMax += arr[i];
            
            if(ans < curMax) ans = curMax;
            
            if(curMax < 0) curMax = 0;
        }
        
        return ans;
    }
    
    public int kadanesTwo(int arr[]) {
        int temp[] = new int[arr.length * 2];
        for(int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }
        
        for(int i=0; i<arr.length; i++) {
            temp[i + arr.length] = arr[i];
        }
        
        return kadanes(temp);
    }
}

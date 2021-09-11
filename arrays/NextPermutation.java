class Solution {
    static List<Integer> nextPermutation(int n, int arr[]) {
        List<Integer> ans = new ArrayList<>();
        
        int k = -1;
        
        // Step 1
        for(int i=0; i<n-1; i++) {
            if(arr[i] < arr[i+1]) k = i; 
        }
        
        if(k == -1) {
            for(int i=n-1; i>=0; i--) ans.add(arr[i]);
            return ans;
        } 
        
        // Step 2
        int l = 0;
        for(int i=k+1; i<n; i++) {
            if(arr[k] < arr[i]) l = i;
        }
        
        // Swap k and l
        int temp = arr[k];
        arr[k] = arr[l];
        arr[l] = temp;
        
        // Reverse from k+1 to n
        reverse(arr, k+1,n-1);
        
        for(int i=0; i<n; i++) ans.add(arr[i]);
        
        return ans;
    }
    
    static void reverse(int arr[], int l, int r) {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            
            l++;
            r--;
        }
    }
}

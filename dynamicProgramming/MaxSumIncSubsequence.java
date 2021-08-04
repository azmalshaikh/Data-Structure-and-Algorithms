class Solution
{
	public int maxSumIS(int arr[], int n)  {  
	    int dp[] = new int[n];
	    
	    dp[0] = arr[0];
	    for(int i=1; i<n; i++) {
	        int sum = 0;
	        for(int j=0; j<i; j++) {
	            if(arr[j] < arr[i]) {
	                sum = Math.max(sum, dp[j]);
	            }
	        }
	        dp[i] = sum + arr[i];
	    }
	    
	    int ans = 0;
	    for(int i=0; i<n; i++) ans = Math.max(ans, dp[i]);
	    
	    return ans;
	}  
}

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr, int idx, int m, int k, int prefix[], int dp[][]){
	    
	    if(m == 0) {
	        return 0;
	    }
	    
	    if(idx >= arr.length) {
	        return 0;
	    }
	    
	    if(dp[idx][m] != 0) {
	        return dp[idx][m]; 
	    }
	    
	    int exclude = 0 + solution(arr, idx+1, m, k, prefix, dp);
		int include = prefix[idx] + solution(arr, idx+k, m-1, k, prefix, dp);
		
		dp[idx][m] = Math.max(exclude, include);
		return dp[idx][m];
	}
	
	// Tabulation
	public static int solution(int[] arr, int m, int k){
		int dp[][] = new int[m+1][arr.length+1];
		int prefixSum[] = new int[arr.length];
		
		int wsum = 0;
		for(int i=arr.length-1; i>=arr.length-k; i--) {
			wsum += arr[i];
		}

		prefixSum[arr.length-1] = wsum;
		for(int i=arr.length-k-1, j=arr.length-1; i>=0; i--,j--) {
			wsum = wsum + arr[i] - arr[j];
			prefixSum[i + k - 1] = wsum;
		}

		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				dp[i][j] = dp[i][j-1];

				if(j >= k) dp[i][j] = Math.max(dp[i][j], prefixSum[j-1] + dp[i-1][j-k]);
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        
		int prefix[] = new int[n];
		
		int sum = 0;
		for(int i=0; i<k; i++) sum += arr[i];
		
		prefix[0] = sum;
		for(int i=k, j=0; i<n; i++,j++) {
		    sum = sum + arr[i] - arr[j];
		    prefix[i-k+1] = sum;
		}
        int dp[][] = new int[n][m+1];
        System.out.println(solution(arr, 0, m , k, prefix, dp));
	}

}

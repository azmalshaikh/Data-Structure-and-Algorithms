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

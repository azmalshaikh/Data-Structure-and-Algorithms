class Solution{
    static int matrixMultiplication(int N, int arr[]) {
        int dp[][] = new int[N-1][N-1];
        
        for(int gap=0; gap<dp.length; gap++) {
            for(int i=0,j=gap; j<dp.length; i++,j++) {
                if(gap == 0) {
                    dp[i][j] = 0;
                } else if(gap == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j+1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++) {
                        int left = dp[i][k];
                        int right = dp[k+1][j];
                        int mcost = arr[i] * arr[k+1] * arr[j+1];   
                    
                        min = Math.min(min, left + right + mcost);
                    }
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][dp.length-1];
    }
}

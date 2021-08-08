class Solution{
    static int palindromicPartition(String str) {
        int n = str.length();
        boolean dp1[][] = new boolean[n][n];
        
        for(int gap=0; gap<n; gap++) {
            for(int i=0,j=gap; j<n; i++,j++) {
                if(gap == 0) {
                    dp1[i][j] = true;
                } else if(gap == 1) {
                    dp1[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
                } else {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp1[i][j] = dp1[i+1][j-1];
                    } else {
                        dp1[i][j] = false;
                    }
                }
            }
        }
        
        int dp2[] = new int[n];
        dp2[0] = 0;
        for(int j=1; j<n; j++) {
            if(dp1[0][j]) {
                dp2[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for(int i=j; i>=1; i--) {
                    if(dp1[i][j]) {
                        min = Math.min(min, dp2[i-1]);
                    }
                }
                dp2[j] = min + 1;
            }
        }
        
        return dp2[n-1];
    }
}

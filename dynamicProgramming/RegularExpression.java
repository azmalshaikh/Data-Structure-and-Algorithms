class Solution {
    public boolean isMatch(String str, String pat) {
        boolean dp[][] = new boolean [pat.length()+1][str.length()+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    if(pat.charAt(i-1) == '*') {
                        dp[i][j] = dp[i-2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char pc = pat.charAt(i-1);
                    char sc = str.charAt(j-1);
                    
                    if(pc == '*') {
                        dp[i][j] = dp[i-2][j];
                        char ch = pat.charAt(i-2);
                        if(ch == sc || ch == '.') {
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                    } else if(pc == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if(pc == sc) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}

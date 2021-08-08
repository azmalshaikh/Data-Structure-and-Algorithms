public int[] FindExitPoint(int[][] matrix) {
        int ans[] = new int[2];
        int i=0, j=0, d = 0;
        
        while(true) {
            d = (d + matrix[i][j])%4;
            
            if(d == 0) {
                j++;
            } else if(d == 1) {
                i++;
            } else if(d == 2) {
                j--;
            } else if(d == 3) {
                i--;
            }
            
            if(i < 0) {
                i++;
                ans[0] = i;
                ans[1] = j;
                break;
            } else if(j < 0) {
                j++;
                ans[0] = i;
                ans[1] = j;
                break;
            } else if(i == matrix.length) {
                i--;
                ans[0] = i;
                ans[1] = j;
                break;
            } else if(j == matrix[0].length) {
                j--;
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }
        
        return ans;
    }

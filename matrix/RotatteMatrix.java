class Solution {
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) { 
        // Transpose
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int j=0; j<n; j++) {
            int li = 0, ri = n-1;
            
            while(li < ri) {
                
                int temp = matrix[li][j];
                matrix[li][j] = matrix[ri][j];
                matrix[ri][j] = temp;
                
                li++;
                ri--;
            }
        }
    }
}

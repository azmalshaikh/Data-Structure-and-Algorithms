class Solution {
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();
         
        int minr=0, maxr=r-1, minc=0, maxc=c-1, te = r*c, cc = 0;
         
        while(cc < te) {
            // Top Wall
            for(int i=minr,j=minc; j<=maxc && cc < te; j++) {
                list.add(matrix[i][j]);     
                cc++;
            }
            minr++;
             
            // Right Wall
            for(int i=minr,j=maxc; i<=maxr && cc < te; i++) {
                list.add(matrix[i][j]); 
                cc++;
            }
            maxc--;
            
            // Bottom Wall
            for(int i=maxr,j=maxc; j>=minc && cc < te; j--) {
                list.add(matrix[i][j]); 
                cc++;
            }
            maxr--;
            
            // Left Wall
            for(int i=maxr,j=minc; i>=minr && cc < te; i--) {
                list.add(matrix[i][j]); 
                cc++;
            }
            minc++;
        }
        
        return list;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = getRow(matrix, target);
        
        if(row == -1) return false;
        
        return binarySearch(matrix, target, row);
    }
    
    public int getRow(int matrix[][], int target) {
        int low = 0, high = matrix.length-1;
        int n = matrix[0].length-1;
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            if(matrix[mid][0] <= target && matrix[mid][n] >= target) return mid;
            
            else if(matrix[mid][0] < target) {
                low = mid+1;
            } 
            
            else {
                high = mid-1;
            }
        }
        
        return -1;
    }
    
    public boolean binarySearch(int matrix[][], int target, int row) {
        int low = 0, high = matrix[0].length-1;
        
        while(low<=high) {
            int mid = (low+high)/2;
            
            if(matrix[row][mid] > target) {
                high = mid-1;
            } else if(matrix[row][mid] < target) {
                low = mid+1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

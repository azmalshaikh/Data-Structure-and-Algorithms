class Solution {
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][]) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        
        if(isEmpty) {
            return true;
        }
        
        for(int i=1; i<=9; i++) {
            if(isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                
                if(SolveSudoku(grid)) {
                    return true;
                }
                
                grid[row][col] = 0;
            }
        }
        
        return false;
    }
    
    static boolean isSafe(int grid[][], int row, int col, int num) {
        // row check
        for(int i=0; i<9; i++) {
            if(grid[i][col] == num) return false;
        }
        
        // Column Check
        for(int i=0; i<9; i++) {
            if(grid[row][i] == num ) return false;
        }
        
        int x = row - row%3, y = col - col%3;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(grid[i+x][j+y] == num) return false;
            }
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][]) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    
    boolean cols[] = new boolean[n];
    boolean nd[] = new boolean[2*n-1];
    boolean rd[] = new boolean[2*n-1];
    
    nqueens(board, 0, cols, nd, rd, "");
  }
  
  static void nqueens(boolean board[][], int row, boolean cols[], boolean nd[], boolean rd[], String asf) {
      
      if(row == board.length) {
          System.out.println(asf + ".");
          return;
      }
      
      
      for(int i=0; i<board[0].length; i++) {
          if(!cols[i] && !nd[row+i] && !rd[row-i+board.length-1]) {
              cols[i] = nd[row+i] = rd[row-i+board.length-1] = true;
              board[row][i] = true;
              
              nqueens(board, row+1, cols, nd, rd, asf + row + "-" + i + ", ");
              
              board[row][i] = false;
              cols[i] = nd[row+i] = rd[row-i+board.length-1] = false;
          }
      }
      
  }

}

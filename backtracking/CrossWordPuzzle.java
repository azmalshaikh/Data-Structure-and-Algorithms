import java.io.*;
import java.util.*;

public class Main {
    //          Code
    // Level -> Parameter
    // Calls -> Loop
  public static void solution(char[][] arr, String[] words, int vidx) {
      
      if(vidx == words.length) {
          print(arr);
          return;
      }
    
    String word = words[vidx];
    
    for(int i=0; i<arr.length; i++) {
        for(int j=0; j<arr[0].length; j++) {
            if(canPlaceWordHorizontally(arr, word, i, j)) {
                boolean wePlaced[] = placeHorizontally(arr, word, i, j);
                solution(arr, words, vidx+1);
                unplaceHorizontally(arr, wePlaced, i, j);
            }
            
            if(canPlaceWordVertically(arr, word, i, j)) {
                boolean wePlaced[] = placeVertically(arr, word, i, j);
                solution(arr, words, vidx+1);
                unplaceVertically(arr, wePlaced, i, j);
            }
        }
    }
    
  }
  
  public static boolean canPlaceWordHorizontally(char arr[][], String word, int i, int j) {
      if(j-1>=0 && arr[i][j-1] != '+') return false;
      
      else if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+') return false;
      
      for(int jj=0; jj<word.length(); jj++) {
          
          if(j+jj >= arr[0].length) return false;
          
        if(arr[i][j+jj] == '-' || arr[i][j+jj] == word.charAt(jj)) continue;
        else return false;
      }
      
      return true;
  }

  public static boolean canPlaceWordVertically(char arr[][], String word, int i, int j) {
      if(i-1>=0 && arr[i-1][j] != '+') return false;
      
      else if(i+word.length() < arr.length && arr[i+word.length()][j] != '+') return false;
      
      for(int ii=0; ii<word.length(); ii++) {
          
          if(i+ii >= arr.length) return false;
          
        if(arr[i+ii][j] == '-' || arr[i+ii][j] == word.charAt(ii)) continue;
        else return false;
      }
      
      return true;
  }
  
  public static boolean[] placeHorizontally(char arr[][], String word, int i, int j) {
      boolean wePlaced[] = new boolean[word.length()];
      
      for(int jj=0; jj<word.length(); jj++) {
          if(arr[i][j+jj] == '-') {
              arr[i][j+jj] = word.charAt(jj);
              wePlaced[jj] = true;
          }
      }
      
      return wePlaced;
  }
  
  public static boolean[] placeVertically(char arr[][], String word, int i, int j) {
      boolean wePlaced[] = new boolean[word.length()];
      
      for(int ii=0; ii<word.length(); ii++) {
          if(arr[i+ii][j] == '-') {
              arr[i+ii][j] = word.charAt(ii);
              wePlaced[ii] = true;
          }
      }
      
      return wePlaced;
  }
  
  public static void unplaceHorizontally(char arr[][], boolean wePlaced[], int i, int j) {
      for(int jj=0; jj<wePlaced.length; jj++) {
          if(wePlaced[jj] == true) {
              arr[i][j+jj] = '-';
          }
      }
  }

  public static void unplaceVertically(char arr[][], boolean wePlaced[], int i, int j) {
      for(int ii=0; ii<wePlaced.length; ii++) {
          if(wePlaced[ii] == true) {
              arr[i+ii][j] = '-';
          }
      }
  }

  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}

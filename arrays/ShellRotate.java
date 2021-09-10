import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(br.readLine());
         }
      }

      int s = Integer.parseInt(br.readLine());
      int r = Integer.parseInt(br.readLine());
      
      shellRotate(arr, s, r);
      display(arr);
    }
    
    public static void shellRotate(int arr[][], int s, int r) {
        int oned[] = fillOnedFromShell(arr, s);
        rotate(oned, r);
        fillShellFromOned(arr, s, oned);
    }
    
    public static int[] fillOnedFromShell(int arr[][], int s) {
        int minr = s-1, minc = s-1;
        int maxr = arr.length-s, maxc = arr[0].length-s;
        
        // No of Element in shell
        // lw + bw + rw + tw - 4(corner Repeated 2 times)
        // 2 * lw + 2 * tw - 4
        // 2 * (maxr - minr + 1) + 2 * (maxc - minc + 1) - 4
        // 2 * (maxr - minr + maxc - minc)
        
        int size = 2 * (maxr - minr + maxc - minc);
        
        int oned[] = new int[size];
        int idx = 0;
        
        // lw
        for(int i=minr,j=minc; i<=maxr; i++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // bw 
        for(int i=maxr, j=minc+1; j<=maxc; j++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // rw
        for(int i=maxr-1,j=maxc; i>=minr; i--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        
        // tw 
        for(int i=minr, j=maxc-1; j>=minc+1; j--) {
            oned[idx] = arr[i][j];
            idx++;
        }
        
        return oned;
    }
    
    public static void fillShellFromOned(int arr[][], int s, int oned[]) {
        int minr = s-1, minc = s-1;
        int maxr = arr.length-s, maxc = arr[0].length-s;
        
        int idx = 0;
        
        // lw
        for(int i=minr,j=minc; i<=maxr; i++) {
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // bw 
        for(int i=maxr, j=minc+1; j<=maxc; j++) {
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // rw
        for(int i=maxr-1,j=maxc; i>=minr; i--) {
            arr[i][j] = oned[idx];
            idx++;
        }
        
        // tw 
        for(int i=minr, j=maxc-1; j>=minc+1; j--) {
            arr[i][j] = oned[idx];
            idx++;
        }
    }
    
    public static void rotate(int oned[], int r) {
        r = r%oned.length;
        
        if(r < 0) {
            r += oned.length;
        }
        
        reverse(oned, 0, oned.length-r-1);
        reverse(oned, oned.length-r, oned.length-1);
        reverse(oned, 0, oned.length-1);
    }
    
    public static void reverse(int oned[], int l, int r) {
        while(l<r) {
            int temp = oned[l];
            oned[l] = oned[r];
            oned[r] = temp;
            l++;
            r--;
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

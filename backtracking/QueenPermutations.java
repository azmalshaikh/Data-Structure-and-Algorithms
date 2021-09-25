// M - I
import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        
         int n = chess.length;
        
        if(qpsf == tq) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(chess[i][j] == 0) sb.append("-" + "\t");
                    else sb.append("q" + chess[i][j] + "\t");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(chess[i][j] == 0) {
                    chess[i][j] = qpsf+1;
                    queensPermutations(qpsf+1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}

// M - II
import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        
        
        int nr = 0, nc = 0;
        char sep;
        if(col == tq-1) {
            nr = row + 1;
            nc = 0;
            sep = '\n';
        } else {
            nr = row;
            nc = col+1;
            sep = '\t';
        }
        
        for(int i=0; i<queens.length; i++) {
            if(queens[i] == false) {
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i+1) + sep, queens);
                queens[i] = false;
            }
        }
        
        queensPermutations(qpsf, tq, nr, nc, asf + "-" + sep, queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}

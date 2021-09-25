// M-I
import java.io.*;
import java.util.*;

public class Main {
    
    // qpsf - queen placed so far

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
            }
            
            return;
        }
        
        int nr = 0, nc = 0;
        String nasf, yasf;
        if(col == tq-1) {
            nr = row+1;
            nc = 0;
            nasf = asf + "-" + "\n";
            yasf = asf + "q" + "\n";
        } else {
            nr = row;
            nc = col+1;
            nasf = asf + "-";
            yasf = asf + "q";
        }
        
        queensCombinations(qpsf+1, tq, nr, nc, yasf);
    
        queensCombinations(qpsf, tq, nr, nc, nasf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}

// M-II
import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        int n = chess.length;
        
        if(qpsf == tq) {
            StringBuilder sb = new StringBuilder();
            for(int x=0; x<n; x++) {
                for(int y=0; y<n; y++) {
                    if(chess[x][y] == false) sb.append("-" + "\t");
                    else sb.append("q" + "\t");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;
        }
        
        for(int x=i; x<n; x++) {
            for(int y=(x == i? j + 1: 0); y<n; y++) {
                chess[x][y] = true;
                queensCombinations(qpsf+1, tq, chess, x,y);
                chess[x][y] = false;
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}

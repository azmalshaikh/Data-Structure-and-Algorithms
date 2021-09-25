// M-I
import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    
    if(ci == ti+1) {
        for(int i=0; i<boxes.length; i++) System.out.print(boxes[i]);
        System.out.println();
        return;
    }
    
    for(int i=0; i<boxes.length; i++) {
        if(boxes[i] == 0) {
            boxes[i] = ci;
            permutations(boxes, ci+1, ti);
            boxes[i] = 0;
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}

// M-II
import java.io.*;
import java.util.*;

public class Main {

// items - to Check which item has been used
  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
    
    if(cb == tb+1) {
        if(ssf == ts) {
            System.out.println(asf);
        }
        
        return;
    }
    
    for(int i=0; i<ts; i++) {
        if(items[i] == 0) {
            items[i] = 1;
            permutations(cb+1, tb, items, ssf + 1, ts, asf + (i+1));
            items[i] = 0;
        }
    }
    
    // No Selection
    permutations(cb+1, tb, items, ssf, ts, asf + 0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}

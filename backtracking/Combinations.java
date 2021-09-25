// M-I
import java.io.*;
import java.util.*;

public class Main {

    // cb(current box), tb(total box), ssf(selection so far), ts(total selection)
  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    
    if(cb == tb+1) {
        if(ssf == ts) {
            System.out.println(asf);
        }
        return;
    }
    
    combinations(cb+1, tb, ssf+1, ts, asf + "i");
    combinations(cb+1, tb, ssf, ts, asf + "-");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}

// M-II
import java.io.*;
import java.util.*;

public class Main {

  // ci - current item
  // ti - total item
  // lb - last box
  public static void combinations(int[] boxes, int ci, int ti, int lb){
    if(ci > ti){
      for(int i = 0; i < boxes.length; i++){
        System.out.print(boxes[i] == 0? "-" : "i");
      }
      System.out.println();
      return;
    }
    for(int i = lb + 1; i < boxes.length; i++){
      if(boxes[i] == 0){
        boxes[i] = ci;
        combinations(boxes, ci + 1, ti, i);
        boxes[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}

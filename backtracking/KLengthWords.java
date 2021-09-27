// M - I
import java.io.*;
import java.util.*;

public class Main {

    // cc - current character
    // Levels - character
  public static void solve(int cc, String ustr, int ssf, int ts, Character spots[]) {
      
      if(cc == ustr.length()) {
          if(ssf == ts) {
              for(int i=0; i<spots.length; i++) {
                  System.out.print(spots[i]);
              }
              System.out.println();
          }
          return;
      }
      
      char ch = ustr.charAt(cc);
      
      for(int i=0; i<spots.length; i++) {
          if(spots[i] == null) {
              spots[i] = ch;
              solve(cc+1, ustr, ssf + 1, ts, spots);
              spots[i] = null;
          }
      }
      
      solve(cc+1, ustr, ssf, ts, spots);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    Character spots[] = new Character[k];
    solve(0, ustr, 0,k,spots);
  }

}








// M-II
import java.io.*;
import java.util.*;

public class Main {

    // cs - current spot
    public static void solve(int cs, int ts, String ustr, boolean used[], String asf) {
        
        if(cs == ts) {
            System.out.println(asf);
            return;
        }
        
        for(int i=0; i<ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if(used[i] == false) {
                used[i] = true;
                solve(cs+1, ts, ustr, used, asf + ch);
                used[i] = false;
            }
        }
    } 
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    boolean used[] = new boolean[ustr.length()];
    solve(0, k, ustr, used, "");
  }

}

import java.util.Scanner;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  static class Pair {
      int NTN=Integer.MIN_VALUE, RTN=0;
  }
  
  static int max(int... arr) {
      int maxsf = arr[0];
      for(int i=1; i<arr.length; i++) maxsf = Math.max(maxsf, arr[i]);
      
      return maxsf;
  }

  public static Pair maxPathSum1(TreeNode root) {
      
    if(root == null) return new Pair();
    
    Pair lp = maxPathSum1(root.left);
    Pair rp = maxPathSum1(root.right);
    
    Pair mp = new Pair();
    
    int rtnmax = Math.max(lp.RTN, rp.RTN) + root.val;
    int ntnmax = max(lp.NTN, rp.NTN, root.val, lp.RTN + rp.RTN + root.val, rtnmax);

    mp.NTN = ntnmax;
    mp.RTN = rtnmax;
      
    return mp;
  }
  
  public static int maxPathSum(TreeNode root) {
      return maxPathSum1(root).NTN;
  }

  // input_Section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}

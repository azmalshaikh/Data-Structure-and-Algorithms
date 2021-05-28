import java.util.*;

public class Main {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        minDifference(arr, 0, set1, set2, 0, 0);

        System.out.println(ans);
    }

    static int mindiff = Integer.MAX_VALUE;
    static String ans = "";

    static void minDifference(int arr[], int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2) {

        if(vidx == arr.length) {
            int diff = Math.abs(soset1 - soset2);
            if(diff < mindiff) {
                mindiff = diff;
                ans = set1 + " " + set2;
            }
            return;
        }

        if(set1.size() < (arr.length+1)/2) {
            set1.add(arr[vidx]);
            minDifference(arr, vidx+1, set1, set2, soset1 + arr[vidx], soset2);
            set1.remove(set1.size() - 1);
        }

        if(set2.size() < (arr.length+1)/2) {
            set2.add(arr[vidx]);
            minDifference(arr, vidx+1, set1, set2, soset1, soset2 + arr[vidx]);
            set2.remove(set2.size() - 1);
        }
    }
}

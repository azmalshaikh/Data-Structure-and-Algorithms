import java.util.*;

public class Main {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int arr[] = {1, 2, 3, 4};
        int k = 3;

        for(int i=0; i<k; i++) {
            ans.add(new ArrayList<>());
        }

        partition(arr, 0, k, 0, ans); 
    }

    static void partition(int arr[], int i, int k, int nes, ArrayList<ArrayList<Integer>> ans) {

        if(i > arr.length-1) {
            if(nes == k) {
                for(ArrayList<Integer> set : ans) {
                    System.out.print(set + " ");
                }
                System.out.println();
            }

            return;
        }

        for(int j=0; j<ans.size(); j++) {
            if(ans.get(j).size() > 0) {
                ans.get(j).add(arr[i]);
                partition(arr, i+1, k, nes, ans);
                ans.get(j).remove(ans.get(j).size()-1);
            } else {
                ans.get(j).add(arr[i]);
                partition(arr, i+1, k, nes+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                
                break;
            }
        }
    }
}

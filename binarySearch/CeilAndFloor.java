import java.util.*;

public class Main {
    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 6, 8, 13, 15};
        ceilandFloor(arr, 12);
    }

    static void ceilandFloor(int arr[], int key) {
        int low=0, high=arr.length-1, floor=Integer.MIN_VALUE, ceil=Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[mid] == key) {
                floor = mid;
                ceil = mid;
                break;
            } else if(arr[mid] > key) {
                high = mid-1;
                ceil = mid;
            } else {
                low = mid+1;
                floor = mid;
            }
        }

        System.out.println("Floor value => "+ floor + " Ceil Value => " + ceil);
    } 
}

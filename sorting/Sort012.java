import java.util.*;

public class Main {
    public static void main(String args[]) {

        int arr[] = {1, 1, 2, 2, 0, 1, 2, 2, 1, 0, 1, 2, 0, 2, 1};

        sort012(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort012(int arr[]) {
        int low=0, mid=0, high=arr.length-1;

        while(mid <= high) {
            if(arr[mid] == 1) mid++;

            else if(arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }

            else {
                swap(arr, mid, low);
                mid++;
                low++;
            }
        }
    }
}

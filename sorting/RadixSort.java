import java.util.*;

public class Main {
    public static void main(String args[]) {

        int arr[] = {213, 97, 718, 123, 37, 443, 982, 64, 375, 683};
        // countSort(arr);
        radixSort(arr);

        for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
    }

    static void radixSort(int arr[]) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int exp = 1;
        while(exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    static void countSort(int arr[], int exp) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) max = Math.max(max, arr[i]);

        int freq[] = new int [max+1];

        for(int i=0; i<n; i++) {
            freq[arr[i] / exp % 10]++;
        }

        for(int i=1; i<max+1; i++) {
            freq[i] += freq[i-1];
        }

        int output[] = new int [n];

        for(int i=n-1; i>=0; i--) {
            output[--freq[arr[i] / exp % 10]] = arr[i];
        }

        for(int i=0; i<n; i++) arr[i] = output[i];
    }
}

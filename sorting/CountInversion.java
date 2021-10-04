// M - I
class Solution {
    
    static long count; 

    static long inversionCount(long arr[], long N){
        count = 0L;
        
        long temp[] = new long[(int)N];
        mergeSort(arr, 0, N-1, temp);
        
        return count;
    }
    
    public static void mergeTwoArrays(long arr[], long low, long mid, long high, long merged[]) {
        
        // 1st array low - mid
        // 2nd array mid+1 - high
        
        long i=low, j=mid+1, vidx = low;
        
        while(i<=mid && j<=high) {
            if(arr[(int)i] <= arr[(int)j]) {
                merged[(int)vidx++] = arr[(int)i++];
            } else {
                count += mid + 1 - i;
                
                merged[(int)vidx++] = arr[(int)j++];
            }
        }
        
        while(i<=mid) {
            merged[(int)vidx++] = arr[(int)i++];
        }
        
        while(j<=high) {
            merged[(int)vidx++] = arr[(int)j++];
        }
        
        for(long val=low; val<=high; val++) {
            arr[(int)val] = merged[(int)val];
        }
    }
    
    public static void mergeSort(long arr[], long low, long high, long temp[]) {
        
        if(low < high) {
            long mid = (low+high) >> 1;
        
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid+1, high, temp);
        
            mergeTwoArrays(arr, low, mid, high, temp);
            // 1st array low - mid
            // 2nd array mid+1 - high
        }
    }
    
    
}


// M - II
private static int mergeCount(int[] arr, int l, int m, int r) { 

    int[] left = Arrays.copyOfRange(arr, l, m + 1); 

    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

    int i = 0, j = 0, k = l, swap = 0; 

    while (i < left.length && j < right.length)  
    { 
        if (left[i] <= right[j]) 
            arr[k++] = left[i++]; 
        else { 
            arr[k++] = right[j++]; 
            swap += (m + 1) - (l + i); 
        } 
    } 
    return swap; 
} 

private static int mergeSort(int[] arr, int l, int r) { 

    int count = 0; 

    if (l < r) { 
        int m = (l + r) / 2; 
        
        count += mergeSort(arr, l, m); 

        count += mergeSort(arr, m + 1, r); 

        count += mergeCount(arr, l, m, r); 
    } 

    return count; 
}


// M-II
import java.util.*;
import java.io.*;

public class Main {
    
    static int count;

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        count = 0;
        mergeSort(arr, 0, n-1);
        System.out.println(count);
    }
    
    public static int[] mergeTwoArrays(int left[], int right[]) {
        int merged[] = new int[left.length + right.length];
        
        int i=0, j=0, vidx = 0;
        
        while(i<left.length && j<right.length) {
            if(left[i] <= right[j]) {
                merged[vidx++] = left[i++];
            } else {
                count += left.length - i;
                
                merged[vidx++] = right[j++];
            }
        }
        
        while(i<left.length) {
            merged[vidx++] = left[i++];
        }
        
        while(j<right.length) {
            merged[vidx++] = right[j++];
        }
        
        return merged;
    }
    
    public static int[] mergeSort(int arr[], int low, int high) {
        if(low == high) {
            int temp[] = new int[1];
            temp[0] = arr[low];
            return temp;
        }
        
        int mid = (low+high)/2;
        
        int left[] = mergeSort(arr, low, mid);
        int right[] = mergeSort(arr, mid+1, high);
        
        int merged[] = mergeTwoArrays(left, right);
        
        return merged;
    }
}

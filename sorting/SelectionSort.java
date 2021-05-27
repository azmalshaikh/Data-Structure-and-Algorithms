public class Main {
    public static void main(String args[]) {
        int arr[] = {2, 1, 8, -3, 6, 4, 12};
        selectionSort(arr, 7);
        for(int e : arr) {
            System.out.print(e + " ");
        }
    } 

    static void selectionSort(int arr[], int n) {
        for(int i=0; i<n-1; i++) {
            int min = i;

            for(int j=i+1; j<n; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }

            if(min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
https://practice.geeksforgeeks.org/problems/selection-sort/1#

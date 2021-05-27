public class Main {
    public static void main(String args[]) {
        int arr[] = {2, 1, 8, -3, 6, 4, 12};
        insertionSort(arr, 7);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void insertionSort(int arr[], int n) {
        for(int i=1; i<n; i++) {
            int temp = arr[i], j = i-1;
            while(j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }
    }
}

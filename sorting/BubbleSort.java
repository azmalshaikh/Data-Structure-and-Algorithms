public class Main {
    public static void main(String args[]) {
        int arr[] = {2, 1, 8, -3, 6, 4, 12};
        bubbleSort(arr, 7);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bubbleSort(int arr[], int n) {
        for(int i=0; i<n-1; i++) {
            boolean sorted = true; 
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    sorted = false;
                }
            }

            if(sorted) break;
        }
    }
}

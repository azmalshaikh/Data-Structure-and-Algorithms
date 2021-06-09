public class Main {
    public static void main(String args[]) {
        int arr[] = {-5, 14, 20, 23, 42, 49, 52, 78};
        
        System.out.println(infiniteSorted(arr, 52));
    }

    static int infiniteSorted(int arr[], int key) {
        int low = 0;
        int high = 1;

        while(low <= high) {
            int mid = (low+high) / 2;
            if(arr[mid] == key) return mid;

            if(arr[mid] < key) {
                low = high;
                high = 2 * high;
            }
        }

        return binarySearch(arr, key, low, high);
    }

    static int binarySearch(int arr[], int key, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[mid] == key) return mid;

            else if(arr[mid] > key) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }
}

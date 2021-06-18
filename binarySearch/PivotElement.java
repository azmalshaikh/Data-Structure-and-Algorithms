public class Main {
    public static void main(String args[]) {
        int arr[] = {30, 40, 50, 0, 20};
        System.out.println(pivot(arr));
    }

    static int pivot(int arr[]) {
        int low = 0, high = arr.length-1;

        while(low < high) {
            int mid = (low+high) / 2;

            if(arr[mid] < arr[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return arr[low];
    }
}

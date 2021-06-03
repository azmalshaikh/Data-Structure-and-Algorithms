public class Main {
    public static void main(String args[]) {
        int arr[] = {9, 4, 7, 6, 3, 1, -5};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
    }

    static void mergeSort(int arr[], int l, int r) {
        if(l<r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    static void merge(int arr[], int l, int mid, int r) {
        int temp[] = new int [arr.length];
        int k = l, i=l, j=mid+1;

        while(i<=mid && j<=r) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i>mid) {
            while(j<=r) {
                temp[k++] = arr[j++];
            }
        } else {
            while(i<=mid) {
                temp[k++] = arr[i++];
            }
        }

        for(k=l; k<=r; k++) {
            arr[k] = temp[k];
        }
    }
}

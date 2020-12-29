static int partition(int arr[], int lb, int ub) {
    int pivot = arr[ub];
    int i = (lb-1);

    for(int j=lb; j<ub; j++) {
        if(arr[j] < pivot) {
            i++;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i+1];
    arr[i+1] = arr[ub];
    arr[ub] = temp;

    return i+1;
}

static void quickSort(int arr[], int start, int end) {
    if(start < end) {
        int p = partition(arr, start, end);
        quickSort(arr, start, p-1);
        quickSort(arr, p+1, end);
    }
}

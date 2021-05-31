static void quickSort(int arr[], int low, int high) {
    if(low < high) {
        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
}

static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

static int partition(int arr[], int low, int high) {
    int pivot = arr[low];

    int i = low;
    int j = high;

    while(i < j) {
        while(i <= j && pivot >= arr[i]) i++;

        while(i <= j && pivot < arr[j]) j--;

        if(i < j)
            swap(arr, i, j);
    }

    swap(arr, low, j);

    return j;
}

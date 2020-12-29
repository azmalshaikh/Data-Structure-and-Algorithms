void mergeSort(int arr[], int start, int end) {
    if(start < end) {
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        
        merge(arr,l,mid,r);
    }
}

void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int a[] = new int[n1];
    int b[] = new int[n2];

    for (int i = 0; i < n1; i++)
        a[i] = arr[l + i];

    for (int j = 0; j < n2; j++)
        b[j] = arr[m + 1 + j];

    int i=0, j=0, k=l;

    while (i < n1 && j < n2) {
        if (a[i] <= b[j]) {
            arr[k] = a[i];
            i++;
        }
        else {
            arr[k] = b[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = a[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = b[j];
        j++;
        k++;
    }
 }

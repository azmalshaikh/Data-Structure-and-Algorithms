static String isKSortedArray(int arr[], int n, int k) { 
    int a [] = new int [n];
    for(int i=0; i<n; i++) {
        a[i] = arr[i];
    }

    Arrays.sort(a);

    for(int i=0; i<n; i++) {
        int j = Arrays.binarySearch(a, arr[i]);
        if(Math.abs(i-j) > k) return "No";
    }

    return "Yes";
}

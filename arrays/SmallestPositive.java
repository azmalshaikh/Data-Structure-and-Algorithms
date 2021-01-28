long smallestpositive(long[] arr, int n){ 
        
    Arrays.sort(arr);

    long res = 1;
    for(int i=0; i<n && arr[i] <= res; i++) {
        res = res + arr[i];
    }
    return res;
}

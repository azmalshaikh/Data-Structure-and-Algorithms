public static int find3Numbers(int arr[], int n, int x) { 

    Arrays.sort(arr);
    int l, r;

    for(int i=0; i<n-2; i++) {
        l = i+1;
        r = n-1;

        while(l < r) {
            if(arr[i] + arr[l] + arr[r] == x) {
                return 1;
            } else if(arr[i] + arr[l] + arr[r] < x) {
                l++;
            } else {
                r--;
            }
        }
    }
    return 0;
}

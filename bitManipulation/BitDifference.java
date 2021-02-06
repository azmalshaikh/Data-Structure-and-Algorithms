public static long sumBitDiff(int arr[], int n) {
    int ans = 0;

    for(int i=0; i<32; i++) {
        int cur = 0;

        for(int j=0; j<n; j++) {
            if((arr[j] & (1<<i)) == 0) cur++;
        }
        ans += cur * (n - cur) * 2;
    }

    return ans;
}

// public static long sumBitDiff(int arr[], int n) { 
//     long ans = 0;

//     for(int i=0; i<n; i++) {
//         for(int j=i; j<n; j++) {
//             ans += one(arr[i] ^ arr[j]);
//         }
//     }

//     return ans*2;
// } 

// static int one(int n) {
//     int ans = 0;

//     while(n > 0) {
//         n = n & (n-1);
//         ans++;
//     }

//     return ans;
// }

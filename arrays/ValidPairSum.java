static long ValidPair(int a[], int n) {
        
    long ans=0;
    int p=0,q=n-1;
    Arrays.sort(a);
    while(p<q) {
        if(a[p]+a[q]>0) {
            ans += q-p;
            q--;
        }
        else p++;

    }
    return ans;
}

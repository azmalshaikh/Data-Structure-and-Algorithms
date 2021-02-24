static int majorityElement(int a[], int size) {
    int ans = a[0], freq = 1;

    for(int i=1; i<size; i++) {
        if(a[i] == ans) freq++;

        else {
            freq--;
        }

        if(freq == 0) {
            ans = a[i];
            freq = 1;
        }
    }
    freq = 0;
    for(int i=0; i<size; i++) {
        if(a[i] == ans) freq++;
    }

    if(freq > size/2) return ans;

    return -1;
}

int findNum(int n) {
        
    if(n == 1 ) return 5;

    int low = 0, high = 5*n;

    while(low < high) {
        int mid = (low+high) / 2;

        if(check(mid, n)) {
            high = mid;
        } else {
            low = mid+1;
        }
    }

    return low;

}

boolean check(int num, int n) {
    int count = 0, x = 5;

    while(x <= num) {
        count += num / x;
        x *= 5;
    }

    return count >= n;
}

public int josephus(int n, int k) {
    if(n == 1) return 1;

    return (josephus(n - 1, k) + k-1) % n + 1 ;
}

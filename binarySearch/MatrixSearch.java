static boolean search(int matrix[][], int n, int m, int x) {  
    int low = 0, high = m-1;

    while(low < n && high >= 0) {
        if(matrix[low][high] == x) return true;

        else if(matrix[low][high] > x) {
            high--;
        } else {
            low++;
        }
    }

    return false;
}

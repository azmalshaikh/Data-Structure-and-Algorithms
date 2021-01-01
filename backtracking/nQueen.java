public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
        int n = sc.nextInt();
        int arr[][] = new int [n][n];
        boolean ans = nQueen(arr, 0, n);
        if(!ans) System.out.print(-1);
        System.out.println();
    }

}

static void print(int arr[][], int n) {
    System.out.print("["); 
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(arr[i][j] == 1) System.out.print(j+1 + " ");
        }
    }
    System.out.print("] ");
} 

static boolean nQueen(int arr[][], int x, int n) {
    if(x == n) {
        print(arr, n);
        return true;
    }
    boolean ans = false; 
    for(int col=0; col<n; col++) {
        if(isSafe(arr, x, col, n)) {
            arr[x][col] = 1;

            if(nQueen(arr, x+1, n)) {
                ans = true;
            }

            arr[x][col] = 0;
        }
    }
    return ans;
}

static boolean isSafe(int arr[][], int x, int y, int n) {
    for(int i=0; i<x; i++) {
        if(arr[i][y] == 1) return false;
    }

    int row = x;
    int cols = y;
    while(row >= 0 && cols >= 0) {
        if(arr[row][cols] == 1) return false;
        row--;
        cols--;
    }

    row = x;
    cols = y;
    while(row >= 0 && cols < n) {
        if(arr[row][cols] == 1) return false;
        row--;
        cols++;
    }

    return true;
}

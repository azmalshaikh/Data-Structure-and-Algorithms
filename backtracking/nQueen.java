static ArrayList<ArrayList<Integer>> nQueen(int n) {
    int board[][] = new int [n][n];

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> list  = new ArrayList<>();

    nQueen(board, 0, n, ans, list);


    return ans;
}

static boolean isSafe(int board[][], int x, int y, int n) {
    for(int i=0; i<n; i++) {
        if(board[i][y] == 1) return false;
    }

    int row=x;
    int col=y;

    while(row >= 0 && col >= 0) {
        if(board[row][col] == 1) return false;

        row--;
        col--;
    }

    row = x;
    col = y;

    while(row >=0 && col < n) {
        if(board[row][col] == 1) return false;

        row--;
        col++;
    }

    return true;
}

static boolean nQueen(int board[][], int x, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
    if(x == n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    list.add(j+1);
                }
            }
        }
        ans.add(new ArrayList<>(list));
        list.clear();
        return false;
    }

    for(int col=0; col<n; col++) {
        if(isSafe(board, x, col, n)) {
            board[x][col] = 1;

            if(nQueen(board, x+1, n, ans, list)) {
                return true;
            }

            board[x][col] = 0;
        }
    }

    return false;
}

public class Main {
    public static void main(String args[]) {
        int board[][] = new int [8][8];
        knighttour(board, 0, 0, 1);
        
    }

    static void display(int board[][]) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    static boolean knighttour(int board[][], int r, int c, int move) {

        if(r < 0 || c < 0 || r >= board.length || c >= board.length || board[r][c] > 0) return false;
        else if(move == board.length * board.length) {
            board[r][c] = move;
            display(board);
            board[r][c] = 0;
            return true;
        }

        board[r][c] = move;
        if(knighttour(board, r-2, c+1, move+1)) return true;
        else if(knighttour(board, r-1, c+2, move+1)) return true;
        else if(knighttour(board, r+1, c+2, move+1)) return true;
        else if(knighttour(board, r+2, c+1, move+1)) return true;
        else if(knighttour(board, r+2, c-1, move+1)) return true;
        else if(knighttour(board, r+1, c-2, move+1)) return true;
        else if(knighttour(board, r-1, c-2, move+1)) return true;
        else if(knighttour(board, r-2, c-1, move+1)) return true;
        board[r][c] = 0;

        return false;
    }
}

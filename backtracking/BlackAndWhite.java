static int x = 1000000007;
    
// Suppose board has N rows and M columns.Now first consider knight to move 2 steps in horizontal direction and 1 step in vertical.
// So if we are at (i, j) after such moves we can reach at (i+2, j+1), (i+2, j-1), (i-2, j+1), (i-2, j-1).
// To have (i+2) inside board we can have our positions 0 to N-3 i.e we have to leave last two rows otherwise (i+2) will be out of board.
// similarly for (i-2) range possible if 2 to N.

// Similarly for (j+1) range will be 0 to N-2, and for (j+1) range will be 1 to M-1 i.e one column less in each case.
    
static long solve(int n, int m) {

    long a = (n%x * m%x) % x;

    long ans = ( a%x * (a - 1)%x ) % x;

    if(n >= 1 && m >= 2) {
        ans -= (4 * (n - 1) * (m - 2));
    } 

    if(n >= 2 && m >= 1) {
        ans -= (4 * (m - 1) * (n - 2));
    }

    return ans;
}

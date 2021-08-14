class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        long dp[] = new long[n+1];
        
        dp[1] = 1L;
        long p2 = 1L, p3 = 1L, p5 = 1L;
        for(int i=2; i<=n; i++) {
            long a = 2*dp[(int)p2], b = 3*dp[(int)p3], c = 5*dp[(int)p5];
            
            dp[i] = Math.min(a, Math.min(b, c));
            
            if(dp[i] == a) {
                p2++;
            }
            
            if(dp[i] == b) {
                p3++;
            }
            
            if(dp[i] == c) {
                p5++;
            }
        }
        
        return dp[n];
    }
}


// M-2
class Solution {
    
    class Pair {
        int primeNo, pointer, value;
        
        public Pair(int primeNo, int pointer, int value) {
            this.primeNo = primeNo;
            this.pointer = pointer;
            this.value = value;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        
        for(int i=0; i<primes.length; i++) {
            Pair toAdd = new Pair(primes[i], 1, primes[i]);
            pq.add(toAdd);
        }
        
        int dp[] = new int[n+1];
        
        dp[1] = 1;
        
        for(int i=2; i<=n;) {
            Pair temp = pq.remove();
            
            if(dp[i-1] != temp.value) {
                dp[i] = temp.value;
                i++;
            } 
            
            temp.pointer++;
            temp.value = temp.primeNo * dp[temp.pointer];
            pq.add(temp);
        }
        
        return dp[n];
    }
}

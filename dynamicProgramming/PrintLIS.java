public static class Pair {
    int l;
    int i;
    int v;
    String psf;

    Pair(int l, int i, int v, String psf){
        this.l = l;
        this.i = i;
        this.v = v;
        this.psf = psf;
    }
}

public static void solution(int []arr) {
    int n = arr.length, omax = 0;
    int dp[] = new int[n];

    for(int i=0; i<n; i++) {
        int max = 0;
        for(int j=0; j<i; j++) {
            if(arr[i] > arr[j]) max = Math.max(max, dp[j]);
        }

        dp[i] = max + 1;
        omax = Math.max(omax, dp[i]);
    }

    // l I V PSF
    Queue<Pair> q = new LinkedList<>();

    for(int i=0; i<n; i++) {
        if(dp[i] == omax) {
            q.add(new Pair(omax, i, arr[i], arr[i] + ""));
        }
    }

    System.out.println(omax);

    while(!q.isEmpty()) {
        Pair temp = q.remove();

        if(temp.l == 1) {
            System.out.println(temp.psf);
        } 

        for(int j=temp.i-1; j>=0; j--) {
            if(dp[j] == temp.l - 1 && arr[j] < temp.v) {
                q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + temp.psf));
            }
        }
    }
}

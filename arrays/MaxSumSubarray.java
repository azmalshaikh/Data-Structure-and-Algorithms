
// 1st Method
static int maximumSumSubarray(int k, ArrayList<Integer> a,int n){
        
    Deque<Integer> dq = new LinkedList<>();

    int i=0, sum=0;
    for(; i<k; i++) {
        sum += a.get(i);
        dq.addLast(a.get(i));
    }

    for(; i<n; i++) {
        dq.addLast(a.get(i));

        int curSum = sum + a.get(i) - dq.removeFirst();
        if(curSum > sum) sum = curSum;
    }

    return sum;
}

// 2nd Method
static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n) {
        int i=0, j=0;
        
        int curSum = 0, ans;
        
        for(; j<k; j++) curSum += arr.get(j);
        
        ans = curSum;
        
        for(; j<n; j++) {
            curSum += arr.get(j);
            curSum -= arr.get(i);
            i++;
            
            ans = Math.max(ans, curSum);
        }
        
        return ans;
    }

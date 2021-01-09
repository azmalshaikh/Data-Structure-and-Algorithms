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

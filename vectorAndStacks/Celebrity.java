int celebrity(int M[][], int n){
    Stack<Integer> s = new Stack<>();
    for(int i=0; i<n; i++) {
        s.push(i);
    }

    while(s.size() > 1) {
        int first = s.pop();
        int second = s.pop();

        if(M[first][second] == 1) s.push(second);

        else s.push(first);
    }

    if(s.size() == 0) return -1;

    int ans = s.pop();

    for(int i=0; i<n; i++) {
        if(i != ans && (M[i][ans] == 0 || M[ans][i] == 1)) {
            return -1;
        }
    }

    return ans;
}

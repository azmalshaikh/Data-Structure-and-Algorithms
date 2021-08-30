class StockSpanner {
    
    class Pair {
        int stock, index;
    }
    
    Stack<Pair> st;
    int idx = -1;

    public StockSpanner() {
        st = new Stack<>();
        Pair p = new Pair();
        p.stock = Integer.MAX_VALUE;
        p.index = -1;
        
        st.push(p);
    }
    
    public int next(int price) {
        while(st.peek().stock <= price) st.pop();
        idx++;
        int ans = idx - st.peek().index;
        
        Pair p = new Pair();
        p.stock = price;
        p.index = idx;
        
        st.push(p);
        
        return ans;
    }
}

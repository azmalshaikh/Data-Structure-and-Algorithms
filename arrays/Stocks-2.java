// M-I 
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                ans += prices[i] - prices[i-1];
            }
        }
        
        if(ans <= 0) return 0;
        
        return ans;
    }
}


// M-II For print solution
class Solution {
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int a = 0, b = 0;
        
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) {
                b = i;
            } 
            // Corner cases
            // 18
            // 11 42 49 96 23 20 49 26 26 18 73 2 53 59 34 99 25 2
            else if ( a!=b && arr[i] < arr[i-1] ) {
                list.add(a);
                list.add(b);
                
                ans.add(new ArrayList<>(list));
                list.clear();
                a = i;
                b = i;
            } 
            // Corner Cases
            // 9
            // 57 69 12 59 5 9 29 29 99
            else if(arr[i] != arr[i-1]){
                a = i;
                b = i;
            }
        }
        
        if(a != b) {
            list.add(a);
            list.add(b);
            ans.add(new ArrayList<>(list));
        }
        
        // System.out.println(ans);
        
        return ans;
    }
}

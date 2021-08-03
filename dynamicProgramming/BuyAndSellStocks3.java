class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0], ossp = 0;
        
        for(int i=1; i<prices.length; i++) {
            int nbsp = 0, nssp = 0;
            
            if(ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            } else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp) {
                nssp = obsp + prices[i] - fee;
            } else {
                nssp = ossp;
            }
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}

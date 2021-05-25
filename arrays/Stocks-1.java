public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int min = prices[0];

    for(int i=0; i<prices.length; i++) {
        if(min > prices[i]) {
            min = prices[i];
        }

        if(maxProfit < prices[i] - min) {
            maxProfit = prices[i] - min;
        }
    }

    if(maxProfit < 0) {
        return 0;
    }

    return maxProfit;
}

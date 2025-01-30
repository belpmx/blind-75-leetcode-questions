class MySolution02 {
    public int maxProfit(int[] prices) {
       //Note this solution takes extra time due the Min and Max functions
        //how to solve:
        //1. Determine if on the current iteration the profit is greater than previous profit
        //2. Determine if the min Price is less on current iteration
        int profit=0;
        //start with the first element of the array, then the for start a 1
        int minPrice=prices[0];
        for (int i=1; i<prices.length; i++){
            int currentPrice = prices[i];
            //profit start a 0, if the subtraction is less than the profit then the previous profit is set
            profit = Math.max(profit, currentPrice-minPrice);
            //minPrice is calculated against min price and current price
            minPrice = Math.min(minPrice,currentPrice);
        }
        return profit;
    }
} // TC: O(n), SC: O(1)

class MySolution002 {
    public int maxProfit(int[] prices) {
        //this solution is not using max and min and is intended to be easy to understand and read
        int profit =0;
        int leftSide =0;
        for (int i=1; i<prices.length; i++){
            int currentElement = prices[i];
            //validates if the current element is greater than the previous element (left)
            //this means that on this iteration we can calculate a new profit
             if (currentElement > prices[leftSide]){
                 int thisProfit = prices[i] - prices[leftSide];
                 //determine if current profit is greater than previous profit
                 if (thisProfit> profit){
                     profit =thisProfit;
                 }
             } else {
                 //no profit found on this iteration
                 leftSide = i;
             }
        }
        return profit;
    }
}

class MySolution0002 {
    public int maxProfit(int[] prices) {
        //this solution is optimized to be fast
        int profit =0;
        int leftSide =0;
        for (int i=1; i<prices.length; i++){
            //validates if the current element is greater than the previous element (left)
            //this means that on this iteration we can calculate a new profit
            if (prices[i] > prices[leftSide]){
                // current profit is evaluated on the left parenthesis and is greater than previous profit
                if ((prices[i] - prices[leftSide])> profit){
                    profit =prices[i] - prices[leftSide];
                }
            } else {
                //no profit found on this iteration
                leftSide = i;
            }
        }
        return profit;
    }
}




















class Solution02 {
    public int maxProfit(int[] prices) {
        int profit = 0, left = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[left]) {
                profit = Math.max(profit, prices[i] - prices[left]);
            } else {
                left = i;
            }
        }
        return profit;
    }
} // TC: O(n), SC: O(1)

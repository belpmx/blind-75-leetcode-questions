class Solution017 {
    public int coinChange(int[] coins, int amount) {
        int [] table = new int[amount+1];
        //assume this as close value to infinite
        for (int i =1; i<= amount; i++){
            //minimal need to be set every iteration of the ammont
            int minimal = Integer.MAX_VALUE;
            for (int j =0; j<coins.length; j++){
                //seek if our current pointer to the amount is greater or equal to our element of the coins array
                if(i >= coins[j]){
                    //determine the index of the table to look
                    int minIndex = i - coins[j];
                    //if value on the index is -1 then skip
                    if (table[minIndex]!= -1){
                        minimal = Math.min(minimal,table[minIndex]);
                    }
                }
            }
            //calculate if we found a solution for this i element
            if (minimal == Integer.MAX_VALUE){
                //this means that we did not find any value, then assign -1
                table[i] = -1;
            } else {
                table[i] = 1 + minimal;
            }
        }
        return table[amount];
    }
}












class Solution17 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
        }
        return dp[amount];
    }
} // TC: (n * amount), SC: O(amount)

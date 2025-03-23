class Solution022 {
    public int rob(int[] nums) {
        if (nums.length ==1) return nums[0];
        //base scenarios
        int val1 = nums[0];
        //determine what is most profitable, to take left (yesterday stash) or rob today (right)
        int val2 = Math.max(nums[0], nums[1]);
        for (int i=2; i < nums.length; i++){
            //take value from previous day and add it to i(today)
            int rob = nums[i] + val1;
            //determine what value is bigger, rob or to not rob.
            int stash = Math.max(rob, val2 );
            //update the index for next iteration
            val1 = val2;
            val2 = stash;
        }
        //today contain the max value accumulated on stash
        return val2;
    }
}


















class Solution22 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + dp[i - 2];
            int notRob = dp[i - 1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[nums.length - 1];
    }
} // TC: O(n), SC: O(n)

class Solution222 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
} // TC: O(n), SC: O(1)

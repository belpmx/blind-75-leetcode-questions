class Solution023 {
    public int rob(int[] nums) {
        if (nums.length ==1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //from 0 house until house -1
        int subArray1 = doRob(nums, 0, nums.length-2);
        //from house 1 to last hose
        int subArray2 = doRob(nums, 1, nums.length -1);
        return Math.max(subArray1,subArray2);
    }
    //this is the same logic as problem 22 on this list
    public int doRob(int [] nums, int startIndex, int endIndex){

        //base scenarios
        int val1 = nums[startIndex];
        //determine what is most profitable, to take left (yesterday stash) or rob today (right)
        int val2 = Math.max(nums[startIndex], nums[startIndex +1]);
        for (int i=startIndex +2; i <=endIndex; i++){
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


















class Solution23 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    public int rob(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
} // TC: O(n), SC: O(1),, max-cosecutives ones

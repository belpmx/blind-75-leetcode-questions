class Solution018 {
    public int lengthOfLIS(int[] nums) {
        int quantity = nums.length;
        //base case
        if (quantity ==1) return 1;
        //solves by dinamyc programing
        int [] computeArray = new int[quantity];
        computeArray[0] = 1;
        int longSequence = 0;
        for (int right=1; right<quantity; right++){
            //this must be restarted
            int length = 0;
            // index is the right element
            // is the left element
            for (int left=0; left< right; left++){
                //validate if right element is greater than left element
                //if no occurrence found then the length is zero
                if(nums[right] > nums[left]){
                    //calculate what is the length at this element
                    length = Math.max(length, computeArray[left]);
                }
            }//end for left
            computeArray[right] = length +1;
            longSequence = Math.max(longSequence, computeArray[right]);
        }//end for right
        return longSequence;
    }
}



















class Solution18 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            dp[i] = curr + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
} // TC: O(n), SC: O(n)
/*
[10, 9, 2, 5, 3, 7, 101, 18]
  1  1. 1  2  2  */

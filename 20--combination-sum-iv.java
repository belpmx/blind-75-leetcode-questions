class Solution020 {
    public int combinationSum4(int[] nums, int target) {
       int [] preSolutions = new int[target +1];
       preSolutions[0] =1;
       for (int i =1; i<= target; i++){
           //each  value of the target from 1 to target is iterated
           for (int thisNum:nums){
               //solution is found
               if (i >= thisNum){
                   //add what we have on the previous found pre solution
                   int difference = preSolutions[i] + preSolutions[i - thisNum];
                   preSolutions[i] = difference;
               }
           }//end for each
       }//end for
        return preSolutions[target];
    }
}





















class Solution20 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
} // TC: O(n * target), SC: O(target)

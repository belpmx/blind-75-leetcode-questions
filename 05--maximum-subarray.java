class Solution05 {
    public int maxSubArray(int[] nums) {
        //Set as default that max and current Sum is the base scenario when array.length is 1
        //Based on constrains is expected to array.length >= 1
     int currentSum = nums[0];
     int maxSum = nums[0];
     for (int i=1; i< nums.length;i++){
         //calculate as: the max element with the current number of nums[i] and the sum of CurrentSum and this current
         //element.
         //This means, is the current number bigger than the sum of currentSum and current number
         currentSum = Math.max(nums[i], (nums[i] + currentSum));
         //update the MaxSum in case that currentSum is bigger thatn MaxSum
         maxSum = Math.max(maxSum,currentSum);
     }
        return maxSum;
    }
}



















class Solution5 {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], nums[i] + curr);
            max = Math.max(max, curr);
        }
        return max;
    }
} // TC: O(n), SC: O(1)

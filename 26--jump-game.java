class Solution0026 {
    public boolean canJump(int[] nums) {
        int reachable =0;//at the start we can reach position 0
        for (int i=0;i< nums.length;i++){
            //validate if in this iteration we can still reach the end of the array
            if(i>reachable){
                return false;
            }
            //i holds the index that we are in, then we add the value of the element at this index
            reachable = Math.max(reachable, i+nums[i]);
            if(reachable>= nums.length-1){
                return true;
            }
        }
        return false;
    }
}








class Solution026 {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length && i <= reachable; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length - 1)
                return true;
        }
        return false;
    }
} // TC: O(n), SC: O(1)

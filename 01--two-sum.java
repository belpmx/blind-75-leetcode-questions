import java.util.HashMap;
class MySolution01{
    public int[] twoSum(int[] nums, int target) {
        //create HashMap to store the array elements
        HashMap<Integer, Integer> storageMap = new HashMap<>();
        //to store the result
        int[] index = new int[2];
        for (int i =0; i< nums.length; i++){
            int complement = target -nums[i];
            //if solution is not found
            if (!storageMap.containsKey(complement)){
            //store the current element as already visited with the index
                storageMap.put(nums[i], i);
            }
            else {
                //A solution is found then need to store the indices of numbers on result array
                //find the index of the complement
                index[0] = storageMap.get(complement);
                index[1] = i;
                break;
            }
        }
        return index;
    }
}




















class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // [nums[i], diff]
            if (!map.containsKey(diff)) {
                map.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = map.get(diff);
            }
        }
        return ans;
    }
} // TC: O(n), SC: O(n)


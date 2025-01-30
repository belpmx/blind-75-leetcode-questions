import java.util.HashSet;
import java.util.Set;

class Solution03 {
    public boolean containsDuplicate(int[] nums) {
    //Solving this using a SET Data structure, since Set does not allow duplicated
        // once that we found on our storedData a duplicate it means that we at least one time a duplicate and return true
        Set<Integer> storedData = new HashSet<>();
        for (int i = 0; i< nums.length; i++){
            if(storedData.contains(nums[i])){
                //found a duplicate on this iteration
                return true;
            }
            else {
                //no duplicate found then add it to our stored data
                storedData.add(nums[i]);
            }
        }
        return false;
    }
}





















class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
} // TC: O(n), SC: O(n)

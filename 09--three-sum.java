import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution09 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> output = new ArrayList<>();
       //minus 3 means that the array is without elements to do the minimum triplet
        for (int e =0; e<=nums.length -3; e++){
            //if the first element then move the cursors
            //Validate that current element and previous are different
            if(e==0 || nums[e] != nums[e-1]){
                //left is moving positive and right negative
                int left = e + 1;
                int right = nums.length -1;
                //target will be = j - k, then we need to know the value of target for given element
                int target = 0 - nums[e];
                while (left < right){
                    //if true a triplet is found
                    if (nums[left] + nums[right] == target){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[e]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        output.add(triplet);
                        //once a triplet is found move cursors to avoid duplicates
                        while(left < nums.length -1 && nums[left] ==nums[left +1])left++;
                        while (right >0 && nums[right] == nums[right -1]) right--;
                        left++;
                        right--;
                    }
                    //when no triplet found move cursors
                    else if (nums[left] + nums[right] < target){
                        //target is bigger thant the sum then increase the left that is the smaller
                        left++;
                    } else {
                        //target is smaller than sum then decrease right
                        right --;
                    }
                }
            }
        }
        return output;
    }
}

class Solution9 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                int target = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        triplets.add(triplet);

                        while (left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
                        while (right > 0 && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return triplets;
    }
} // TC: O(n log n) + O(n^2), SC: O(1)

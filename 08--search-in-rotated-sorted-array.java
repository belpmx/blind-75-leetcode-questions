class Solution08 {
    public int search(int[] nums, int target) {
        int size = nums.length-1;
        int left = 0;
        int right = size;

        while(left <= right){
            int middle = left + (right - left )/2;
            //base scenario
            if (nums[middle]==target) return middle;
            //find if the sorted part of the array
            if(nums[left] <= nums[middle]){//left to right is sorted
                //if true then the target is this segment of the array
                if(nums[left]<= target && target < nums[middle]){
                    right = middle -1;
                } else {
                    left = middle +1;
                }
            } else { //middle to right is sorted
                //if true then the target is this segment of the array
                if(nums[middle]< target && target <= nums[right]){
                    left = middle +1;
                } else {
                    right = middle -1;
                }
            }
        }
        return -1;
    }
}




























class Solution8 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) { // left to right is sorted
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { // mid to right is sorted
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
} // TC: O(log n), SC: O(1)

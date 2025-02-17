class Solution010 {
    public int maxArea(int[] height) {
        int output = 0;
        int left =0;
        int right = height.length -1;
        while (left < right){
            //determine the minimal of the two sides
            int min = Math.min(height[left], height[right]);
            //determine if previous output is less than the calculated area
            output = Math.max(output, min * (right -left));
            //determine which side is less that the other and move the cursor
            if (height[left]< height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return output;
    }
}














class Solution10 {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            ans = Math.max(ans, min * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
} // TC: O(n), SC: O(1)

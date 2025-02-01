class Solution06 {
    public int maxProduct(int[] nums) {
       //base scenario in case array has only element
        int result = nums[0];
        //Use 1 as initial value as every number multiplied by one will be equal to the provided number
        int minProduct = 1;
        int maxProduct=1;

        for (int i =0; i<nums.length; i++){
            //edge scenarion when nums[i] is equal to zero then reset min and max products to one
            if (nums[i]==0){
                minProduct = 1;
                maxProduct=1;
                result = Math.max(result, nums[i]);
                continue;
            }
            //Values of the previous iteration are used then we need to savepreviousMin
            int previousMin = minProduct;
            //minProduct is calculated from:
            //1. nums[i] is the lowest value OR
            //2. the product of nums[i] * minProduct is the lowest OR
            //3. the product of nums[i]* maxProduct is the lowest
            minProduct =Math.min(nums[i], Math.min(nums[i] * minProduct, nums[i]* maxProduct) );
            //maxProduct is calculated from:
            //1. nums[i] is the highest value OR
            //2. the product of nums[i] * minProduct is the highest OR
            //3. the product of nums[i]* maxProduct is the highest
            maxProduct = Math.max(nums[i], Math.max(nums[i] * previousMin, nums[i]* maxProduct));
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}

class Solution006 {

    /*
    Two pointer Approach
Explanation :
1.) If all the elements are positive or the negative elements are even then
the answer will be  the product of complete array in both prefix of suffix multiplication
2.) If negative elements are odd then is need it to remove one negative element: it will be either
right of max prefix product or left of max suffix product.
3.) If array contains 0 then left and right will become 0 at that point, then just update both left and right it to 1
to get the product ahead making another subarray.
     */
    public int maxProduct(int[] nums) {
        int result = nums[0];
        //left is prefix multiplication, left to right (natural order)
        int left = 1;
        //right is suffix multiplication, right to left (inverse order )
        int right=1;
        int suffixIndex = nums.length;
         for (int i=0; i<nums.length; i++){
             if (left ==0){left =1;}
             if (right==0){right =1;}
             //calculate prefix
              left = left * nums[i];
             //calculate suffix
             right = right * nums[suffixIndex -1-i];
             result = Math.max(result, Math.max(left,right));
         }
        return result;
    }
}



























class Solution6 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        
        int min = 1, max = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // -2, 0, -1
                min = 1;
                max = 1;
                ans = Math.max(ans, nums[i]);
                continue;
            }

            int tmp = min;
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * tmp, nums[i] * max));
            ans = Math.max(ans, max);
        }

        return ans;
    }
} // TC: O(n), SC: O(1)

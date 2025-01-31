class Solution04 {
    //this solution is not optimal, is intended to be easy to read
    public int[] productExceptSelf(int[] nums) {
        //prefixProduct is calculated from left (0 index) to right (array length)
        int[] prefixProduct = new int[nums.length];
        //suffix Product is calculated from right (array length) to right (0)
        int[] suffixProduct = new int[nums.length];
         // productResult equal to multiply sufixfixProduct[i] by prefixProduct[i]
        int[] productResult = new int[nums.length];
        //on prefix default value at left is one
        prefixProduct[0]=1;
        //iterate to fill PreFix array
        for (int p=1; p<nums.length;p++){
            prefixProduct[p] = prefixProduct[p-1] * nums[p-1];
        }
       //calculate first productResult outside for loop since loop starts at nums.length-2
        suffixProduct[nums.length-1] =1;
        productResult[nums.length-1] = prefixProduct[nums.length-1] * suffixProduct[nums.length-1];
        //iterate to fill Suffix  array
        for (int s=nums.length-2; s>=0;s--){
            suffixProduct[s] = suffixProduct[s+1] * nums[s+1];
            //since preFixArray is already calculated is possible to get the productResult value
            productResult[s] = prefixProduct[s] * suffixProduct[s];
        }
        return productResult;
    }
}

class Solution004 {
    //based on previous solution
    //there is no need to store both suffix or prefix
    public int[] productExceptSelf(int[] nums) {
        //prefixProduct is calculated from left (0 index) to right (array length)
        int[] prefixProduct = new int[nums.length];
        //create default value
        prefixProduct[0]= 1;
        for (int p=1; p<nums.length;p++){
            prefixProduct[p] = prefixProduct[p-1] * nums[p-1];
        }
        //create default value
        int suffixProduct = 1;
        for (int i = nums.length-1;i>=0;i--){
            prefixProduct[i]= prefixProduct[i] *suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }
        return prefixProduct;
    }
}

class Solution0004 {
    //Other solution found on leetcode note: this uses division
    //division is against the rules but this is a faster solution
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate product of all non-zero elements and count zeros
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
        }

        // Step 2: Handle the cases based on zero count
        if (zeroCount > 1) return result; // More than one zero, all elements will be zero
        if (zeroCount == 1) {
            // If there's exactly one zero, the product of all other elements is placed in that position
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) result[i] = product;
            }
        } else {
            // If there are no zeros, divide the total product by each element
            for (int i = 0; i < n; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}




class Solution4 {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        
        int suffixProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            prefixProduct[i] = prefixProduct[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }
        
        return prefixProduct;
    }
}

// TC: O(n) SC: O(n)

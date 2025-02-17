class Solution011 {
    public int getSum(int a, int b) {
        //iterate while b is different from zero
        while (b!=0){
            //1. Calculate carry using AND operation, this not and comparator
            int carry = a & b;
            //2. XOR(^) operator a to b (bitwise) and save it to a
            a = a ^ b;
            //3. Using the carry operation (<<1), apply left shift and save it to b\
            b = carry << 1;
        }
       return a;
    }
}




















class Solution11 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
} // TC: O(1), SC: O(1)

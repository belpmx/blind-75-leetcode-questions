
class Solution012 {
    public int hammingWeight(int n) {

        return 0;
    }
}


















class Solution12 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                count++;
            }
        }
        return count;
    }
} // TC: O(1), SC: O(1)

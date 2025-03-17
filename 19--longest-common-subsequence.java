class Solution019 {
    public int longestCommonSubsequence(String text1, String text2) {
        //base scenario is '' empty string then adding a extra row and column on the array.
        int [][] matrix = new int[text1.length() +1][text2.length()+1];
        for (int i = 1; i< matrix.length;i++){
            for (int j=1; j< matrix[0].length;j++){
                int compute = 0;
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    //we found a match
                    // -1 indexes are to validate the diagonal values
                    //increment from one on what we have on the diagonal
                    compute = 1 + matrix[i-1][j-1];
                } else {
                    //no match found
                    //to find the maximum value from the value at the left or value from a row above
                    //  [ ][x]
                    //  [x][element]
                    compute = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
                //save the computed occurrence on the diagonal
                matrix[i][j] = compute;
            }//end for j
        }//end for i
        //last element on the matrix diagonal will carry the result.
        return matrix[text1.length()][text2.length()];
    }
}



















class Solution19 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
} // TC: O(m * n), SC: O(m * n)

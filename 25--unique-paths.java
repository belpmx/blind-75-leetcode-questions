import java.util.Arrays;

class Solution025 {
    public int uniquePaths(int m, int n) {
    /*
    (Dynamic Programming - Tabulation)
    1. Fill all [0][n] with 1 as base scenario
    2. Fill all [m][0] with 1 as base scenario
    3.Need to sum what is left and up element
    example:
    [1,1] = up + left
    [1,1] = [row -1, 1] + [1,col-1]
    [1,1] = path[0,1] + path[1,-1]
    [1,1] = 1+1
    [1,1] = 2
    Return path[m-1][n-1]
     */
        int [][] path = new int[m][n];
        path[0][0] =1;
        Arrays.fill(path[0], 1); //First row
        for( int i =0; i<path.length;i++)//First column
            path[i][0] =1;

        for (int row =1; row <path.length; row ++ ){
            for (int col =1; col <path[0].length; col++ ){
                int up = path[row-1][col];
                int left = path[row][col-1];
                path[row][col] = up +left;
            }
        }
        return path[m-1][n-1];
    }
}

class Solution0025 {
    public int uniquePaths(int m, int n) {
        /*
        math combinatorics problem
We start at (0, 0) cell and move to (m-1, n-1) cell.
We need to make m-1 down-moves and n-1 right-moves to reach the destination cell.
Thus, we need to perform a total number of m+n-2 moves.
At each cell along the path, we can choose either the right-move or down-move and we need to find the number
of unique combinations of these choices (which eventually leads to unique paths).
This is nothing but calculating the number of different ways to choose m-1 down-moves and n-1 right-moves
from a total of m+n-2 moves.
     */
        long result = 1;//calculation might exceed range of int
        //calculate the total number of moves
        for (int i = m + n - 2, j = 1; i >= Math.max(m, n); i--, j++) {
            result = (result * i) / j;
        }
        return (int) result;
    }
}




















class Solution25 {
     int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        
        for (int i = 1; i < grid[0].length; i++) // first row
            grid[0][i] = 1;
        
        for (int i = 1; i < grid.length; i++) // first col
            grid[i][0] = 1;

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                int top = grid[r-1][c];
                int left = grid[r][c-1];
                grid[r][c] = top + left;
            }
        }
        return grid[m-1][n-1];
    }
} // TC: O(m * n), SC: O(m * n)

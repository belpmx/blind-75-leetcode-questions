class Solution0016 {
    public int climbStairs(int n) {
        //this is a Fibonacci number
        //base scenario when n =1 or n=2
        if (n <= 2)
            return n;
        int [] array = new int [n+1];
        //create base scenario
        array[0] =0;
        array[1] =1;
        array[2] =2;
        for (int i =3; i<= n; i++){
            //calculate using two previous elements
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }
}

class Solution00016 {
    public int climbStairs(int n) {
        if (n<=2)
            return n;
        //create base values
        int first =1;
        int second =2;
        for (int i =1; i<=n-2; i++){
            int calculate = first +second;
            //This calculates fibonacci numbers
            first = second;
            second = calculate;
        }
        return second;
    }
}



class Solution16 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
} // TC: O(n), SC: O(n)

class Solution016 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 1; i <= n-2; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
} // TC: O(n), SC: O(1)

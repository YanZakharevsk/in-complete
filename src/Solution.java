import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i ; j++) {
                int square = j * j;
                dp[i]  = Math.min(dp[i], 1+ dp[i - square]);
            }

        }
        return dp[n];
    }
}
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
//Example 2:
//
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 1 2 3 4  5  6  7  8  9  10
// 1 4 9 16 25 36 49 64 81 100
// 2 2 2
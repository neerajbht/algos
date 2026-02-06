package dp;

/**
 * https://leetcode.com/problems/ones-and-zeroes/description/
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Example 2:
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * 
 */
public class OnesZeros {

    public static int findMaxForm(String[] S, int M, int N) {
        int[][] dp = new int[M + 1][N + 1];
        for (String str : S) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray())
                if (c == '0')
                    zeros++;
                else
                    ones++;
            for (int i = M; i >= zeros; i--)
                for (int j = N; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }
        return dp[M][N];
    }

    public static void main(String[] argds) {
        String[] strs = { "10", "0001", "111001", "1", "0" };

        System.out.println(OnesZeros.findMaxForm(strs, 5, 3));
    }

}

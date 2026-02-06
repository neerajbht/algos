package dp;

import java.util.Arrays;

public class ClimbStairs {

    /** pre conditions we can only climb 1 or 2 at a given time */
    public int computeStepsDFS(int steps) {

        return dfs(steps, 0);

    }

    // 2^n Time, O(n) space
    private int dfs(int steps, int stepTaken) {
        if (stepTaken >= steps)
            return stepTaken == steps ? 1 : 0;
        return dfs(steps, stepTaken + 1) + dfs(steps, stepTaken + 2);
    }

    /** DP -- Top Down */

    public int computeStepsDPTopDown(int steps) {

        int[] dp = new int[steps];
        Arrays.fill(dp, -1);
        return dfsTD(steps, 0, dp);

    }

    private int dfsTD(int steps, int stepTaken, int[] dp) {
        if (stepTaken >= steps)
            return stepTaken == steps ? 1 : 0;
        if (dp[stepTaken] != -1)
            return dp[stepTaken];

        dp[stepTaken] = dfsTD(steps, stepTaken + 1, dp) + dfsTD(steps, stepTaken + 2, dp);
        System.out.println("dp now" + Arrays.toString(dp));
        return dp[stepTaken];
    }

    // bottom up approach

    public int computeStepsBu(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        System.out.println("dp init" + Arrays.toString(dp));

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

            System.out.println("dp now" + Arrays.toString(dp));

        }

        return dp[n];
    }

    // space optimized , O(1)
    public int climbStairs(int n) {
        int one = 1, two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }

    public static void main(String[] ards) {
        int steps = 5;
        ClimbStairs cs = new ClimbStairs();

        // System.out.println("Steps Taken Using DFS>>>>>" + cs.computeStepsDFS(steps));

        // System.out.println("Steps Taken Using Dp>>>>>" +
        // cs.computeStepsDPTopDown(steps));

        System.out.println("Steps Taken Using Bottom Up>>>>>" + cs.computeStepsBu(steps));

    }

}

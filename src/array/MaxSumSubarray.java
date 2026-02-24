package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumSubarray {

    /** https://leetcode.com/problems/maximum-subarray/ */

    /** kadane algo ---- */

    public static int maxSubArray(int[] arr) {
        int sum = arr[0];
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum = sum + arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // int[] arr = { 1, 0, 3, -2, 4, 5, 6 };
    // this give index of stat,end
    public static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int maxL = 0, maxR = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (curSum < 0) {
                curSum = 0;
                L = R;
            }
            curSum += nums[R];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxL = L;
                maxR = R;
            }
        }
        return new int[] { maxL, maxR };
    }

    public static List getMaxSumArray(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        int l = 0, r = 0;
        List<Integer> subArray = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = 0;
                l = i;
            }
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;

                r = i;

            }

        }

        for (int i = l; i <= r; i++) {
            subArray.add(arr[i]);
        }
        return subArray;

    }

    /** we use sliding window to get array back */

    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, -2, -6, 4, 5, 6 };

        System.out.println(MaxSumSubarray.maxSubArray(arr));

        System.out.println(MaxSumSubarray.getMaxSumArray(arr));

        System.out.println(Arrays.toString(MaxSumSubarray.slidingWindow(arr)));

    }

}
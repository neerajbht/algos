package array;

public class MaxSumSubarray {

    /** https://leetcode.com/problems/maximum-subarray/ */

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

    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, -2, 4, 5, 6 };
        System.out.println(MaxSumSubarray.maxSubArray(arr));
    }

}
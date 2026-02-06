
package array;

public class JumpElements {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        // int[] nums = { 3, 2, 1, 0, 4 };

        System.out.println(JumpElements.canJump1(nums));

    }

    /**
     * standard version
     * You are given an integer array nums. You are initially positioned at the
     * array's first index, and each element in the array represents your maximum
     * jump length at that position.
     * 
     * Return true if you can reach the last index, or false otherwise.
     * 
     * 
     */
    public static boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        System.out.println(lastPos == 0);
        return lastPos == 0;

    }

    /**
     * https://leetcode.com/problems/jump-game-iii/description/
     * another version if we can
     * Given an array of non-negative integers arr, you are initially positioned at
     * start index of the array. When you are at index i, you can jump to i + arr[i]
     * or i - arr[i], check if you can reach any index with value 0.
     * 
     * Notice that you can not jump outside of the array at any time.
     * 
     * Example 1:
     * 
     * Input: arr = [4,2,3,0,3,1,2], start = 5
     * Output: true
     * Explanation:
     * All possible ways to reach at index 3 with value 0 are:
     * index 5 -> index 4 -> index 1 -> index 3
     * index 5 -> index 6 -> index 4 -> index 1 -> index 3
     * Example 2:
     * 
     * Input: arr = [4,2,3,0,3,1,2], start = 0
     * Output: true
     * Explanation:
     * One possible way to reach at index 3 with value 0 is:
     * index 0 -> index 4 -> index 1 -> index 3
     * Example 3:
     * 
     * Input: arr = [3,0,2,1,2], start = 2
     * Output: false
     * Explanation: There is no way to reach at index 1 with value 0.
     * 
     */

}

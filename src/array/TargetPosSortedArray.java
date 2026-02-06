package array;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class TargetPosSortedArray {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

        int[] res = TargetPosSortedArray.searchRange(nums, 1);
        System.out.println(Arrays.toString(res));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums.length == 0)
            return result;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // target found find left most
                left = mid;
                right = mid;
                /**
                 * assuming there starting poistion is not far away ......and duplciates are not
                 * in major count
                 */
                while (left - 1 >= 0 && nums[left - 1] == nums[mid])
                    left--;
                while (right + 1 < nums.length && nums[right + 1] == nums[mid])
                    right++;

                result[0] = left;
                result[1] = right;
                return result;

            }

        }
        return result;

    }
}

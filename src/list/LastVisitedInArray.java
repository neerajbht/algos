package list;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/last-visited-integers/description/?q=Meta+%E2%80%93+Last+6+Months
 * 
 * Given an integer array nums where nums[i] is either a positive integer or -1.
 * We need to find for each -1 the respective positive integer, which we call
 * the last visited integer.
 * 
 * To achieve this goal, let's define two empty arrays: seen and ans.
 * 
 * Start iterating from the beginning of the array nums.
 * 
 * If a positive integer is encountered, prepend it to the front of seen.
 * If -1 is encountered, let k be the number of consecutive -1s seen so far
 * (including the current -1),
 * If k is less than or equal to the length of seen, append the k-th element of
 * seen to ans.
 * If k is strictly greater than the length of seen, append -1 to ans.
 */
public class LastVisitedInArray {

    public static List<Integer> lastVisted(int[] nums) {
        if (nums.length == 0)
            return null;

        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> seen = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != -1) {
                seen.add(nums[i]);
                count = seen.size();
            } else if (count == 0) {
                ans.add(-1);

            } else {
                ans.add(seen.get(--count));
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, -1, -1, -1, 3 };

        System.out.println(LastVisitedInArray.lastVisted(nums));
    }

}
package array;

import java.util.Arrays;

public class longestContiguousOnes {
    /**
     * Array has only 1s and 0s ...
     * only 1 flip allowed
     * Objective: Determine the length of the longest contiguous sequence of ones in
     * a binary array while permitting a single flip from 0 to 1
     * Example 1:
     * Input: [1, 1, 0, 1, 0]
     * Output: 4
     * Solution: Flip the 0 at index 2 to 1.
     * Example 2:
     * Input: [1, 0, 0, 1, 0]
     * Output: 2
     * Solution: Flip any of the 0 elements.
     * 
     * Example 3:
     * Input: [0, 0, 0, 0, 0]
     * Output: 1
     * Solution: Flip any of the 0 elements.
     * 
     * Example 4:
     * Input: [1, 1, 1, 1, 1]
     * Output: 5
     * No flip required.
     * 
     */

    public static int getContigousOnesLength(int[] input) {
        int left = 0, right = 0, flip = 0, max = 0;
        // * Input: [1, 0, 0, 1, 0]

        while (right < input.length) {
            if (input[right] == 1)
                right++;
            else {
                if (flip < 1) {
                    flip++;
                    right++;
                } else {
                    // reset flip and left index
                    if (input[left++] == 0)
                        flip--;
                }
            }
            max = Math.max(max, (right - left));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = { 1, 1, 0, 0, 1, 1, 1, 0, 1 };
        System.out.println("Input: " + Arrays.toString(input));
        int max = getContigousOnesLength(input);
        System.out.println("Longest contiguous 1's with one flip allowed: " + max);
    }

}

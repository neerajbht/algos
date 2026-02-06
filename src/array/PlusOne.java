package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * 
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        /** pre condition is each pos has single digit */
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;

        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] arsd) {
        int[] nums = { 9, 8, 9 };

        System.out.println(Arrays.toString(PlusOne.plusOne(nums)));

    }
}

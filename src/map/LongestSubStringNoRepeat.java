package map;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and
 * "cab" are also correct answers.
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 */
public class LongestSubStringNoRepeat {
    // Input: s = "abcabcbb"
    public static int lenOfLongestSubString(String s) {

        int len = s.length();
        if (len == 0)
            return 0;
        int index = 0, tracker = 0, maxCount = 0;
        Set<Character> dict = new HashSet<Character>();
        while (index < len && tracker < len) {
            if (dict.add(s.charAt(index))) {

                index++;
                maxCount = Math.max(maxCount, index - tracker); // important here (index -tracker -----> is effective
                                                                // len)

            } else {

                dict.remove(s.charAt(tracker++));

            }

        }
        return maxCount;
    }

    public static void main(String[] args) {

        String abc = "abcabcbb";

        System.out.println(LongestSubStringNoRepeat.lenOfLongestSubString(abc));
        System.exit(0);

    }

}

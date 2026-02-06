package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Zigjag {

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        // create list to hold individual rows

        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        /**
         * we iterate through the characters of string so we go down and up
         * increment based on numRows , once numRows is reached we decrement and add
         * charater respective list
         * like for idx 0 -3 ---- first 4 characters get added to each list respectively
         * after that we drecrement d=-1
         * so idx is 3,2,1 or 2,1 ,0 list representing those indexes we add character c
         */
        for (char c : s.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] argds) {

        String s = "PAYPALISHIRING";

        System.out.println("Converted String " + convert(s, 4));

    }

}

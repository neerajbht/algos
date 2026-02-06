package leetcode;

class Solution {
    public static void main(String[] args) {

        System.out.println(Solution.getWrongAnswers(3, "ABA"));

    }

    public static String getWrongAnswers(int N, String C) {
        // Write your code here
        char[] answers = C.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : answers) {
            switch (c) {
                case 'A': {
                    sb.append('B');
                }
                    break;
                case 'B': {
                    sb.append('A');
                }
                    break;
                default: {
                    throw new Error("Invalid Choice found");
                }

            }
        }
        return sb.toString();
    }

}

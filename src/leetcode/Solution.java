// Write any import statements here
package leetcode;

class Solution {
    public static void main(String[] argds) {
        String abc = "ABA";
        System.out.println(Solution.getWrongAnswers(3, abc));

        String ss = new String();
        ss.charAt(1);
    }

    public static String getWrongAnswers(int N, String C) {
        // Write your code here
        char[] answers = C.toCharArray();
        char[] solution = new char[N];
        int index = 0;
        for (char c : answers) {
            switch (c) {
                case 'A': {
                    solution[index++] = 'B';
                }
                    break;
                case 'B': {
                    solution[index++] = 'A';
                }
                    break;
                default: {
                    throw new Error("Invalid Choice found");
                }

            }
        }

        return solution.toString();
    }

}

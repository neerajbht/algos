package leetcode;

import java.util.HashMap;

class Anagram {
    public static void main(String[] argcds) {

        String s = "abc";
        String t = "cab";
        System.out.println("is anagram " + Anagram.isAnagram2(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }

    public static boolean isAnagram2(String s, String t) {
        int sum = 0;
        if (s.length() != t.length()) {
            return false;
        }

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum = s.charAt(i) ^ t.charAt(i);

        }
        if (sum == 0)
            return true;
        return false;

    }

}

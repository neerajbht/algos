package string;

public class ValidAbbrevation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0')
                    return false; // Leading zero invalid
                int val = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    val = val * 10 + (abbr.charAt(j++) - '0');
                }
                i += val;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++))
                    return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }

}

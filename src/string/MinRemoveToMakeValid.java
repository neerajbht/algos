package string;

public class MinRemoveToMakeValid {

    public static String minRemove(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {

            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0)
                    continue;
                open--;
            }
            sb.append(c);

        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }

    public static void main(String[] sr) {
        System.out.println(MinRemoveToMakeValid.minRemove("abc(222))abc((asdb0)"));
    }

}
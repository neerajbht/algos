package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> parenth = new HashMap<Character, Character>();

        parenth = getParent(parenth);

        for (char c : s.toCharArray()) {
            if (parenth.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == parenth.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

    private Map<Character, Character> getParent(Map<Character, Character> parenth) {
        if (parenth == null) {
            parenth = new HashMap<Character, Character>();
        }
        parenth.put(')', '(');
        parenth.put('}', '{');
        parenth.put(']', '[');
        return parenth;
    }

    public static void main(String[] ards) {

        Parentheses pp = new Parentheses();

        System.out.println("is valid " + pp.isValid("[{{()}}]"));
        System.out.println("is valid " + pp.isValid("[{{()})}]"));

    }

}
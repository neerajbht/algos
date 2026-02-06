package stack;

import java.util.ArrayList;
import java.util.Stack;

public class ListStack {

    ArrayList<Integer> stack = new ArrayList<Integer>();

    public ListStack() {

    }

    public void push(int data) {
        stack.add(data);
    }

    public void pop() {
        stack.removeLast();
    }

    public static void main(String[] ards) {

        Stack<Integer> jStack = new Stack<Integer>();

        jStack.pop();

        ListStack ls = new ListStack();
        ls.push(1);
        ls.push(2);

        System.out.println(ls.stack);
        ls.pop();

        System.out.println(ls.stack);

    }

}

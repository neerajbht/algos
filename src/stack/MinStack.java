package stack;

import java.util.Stack;

/**
 * one way is to maintain two stack and minStack
 * we only push when value being pushed in main stack is less than
 * minStack.peek()
 * while pop main stack check if its minStack.peek() then we pop from both
 * getMin return minStack.peek()
 */
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min)
                min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        long pop = stack.pop();

        if (pop < 0)
            min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] argds) {
        MinStack ms = new MinStack();

        ms.push(1);
        ms.push(2);

        ms.push(-1);

        System.out.println(ms.getMin());
        System.out.println(ms.stack);

        ms.pop();

        System.out.println(ms.getMin());
        System.out.println(ms.stack);

    }
}

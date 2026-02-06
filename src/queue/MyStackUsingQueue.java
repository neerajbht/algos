package queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStackUsingQueue {

    Queue<Integer> stack;
    Queue<Integer> q2;

    public MyStackUsingQueue() {
        stack = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();

    }

    public void push(int x) {
        q2.offer(x);

        while (!stack.isEmpty()) {
            q2.offer(stack.poll());
        }
        Queue<Integer> temp = stack;
        stack = q2;
        q2 = temp;

    }

    public int pop() {
        return stack.poll();

    }

    public int top() {
        return stack.peek();

    }

    public boolean empty() {
        return stack.isEmpty();

    }
}

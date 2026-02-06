package stack;

public class ArrayStack {
    int[] stack;
    int top;

    public ArrayStack(int size) {
        this.stack = new int[size];
        this.top = -1;

    }

    public void push(int data) {

        if (top == stack.length - 1) {
            throw new IllegalArgumentException("stack is full");
        } else {
            stack[++top] = data;
        }
    }

    public void printStack() {
        System.out.println(stack);
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);

        }
    }

    public static void main(String[] args) {

        ArrayStack as = new ArrayStack(5);
        as.push(1);
        as.push(2);
        as.push(5);

        as.printStack();

    }
}

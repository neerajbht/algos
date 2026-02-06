package stack;

import java.util.Stack;

public class BrowserHistoryStack {
    private Stack<String> backHistory;
    private Stack<String> forwardHistory;

    BrowserHistoryStack(String homepage) {
        backHistory = new Stack<String>();
        forwardHistory = new Stack<>();
        backHistory.push(homepage);
    }

    public void visit(String url) {
        backHistory.push(url);
        forwardHistory = new Stack<>();

    }

    public String back(int steps) {
        while (steps > 0 && backHistory.size() > 1) {
            forwardHistory.push(backHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardHistory.isEmpty()) {
            backHistory.push(forwardHistory.pop());
            steps++;
        }
        return backHistory.peek();

    }

    public static void main(String[] argds) {
        BrowserHistoryStack st = new BrowserHistoryStack("google.com");
        st.visit("freeworkd.com");
        System.out.println(st.backHistory);
        System.out.println(st.back(1));
        System.out.println(st.forwardHistory);

    }
}

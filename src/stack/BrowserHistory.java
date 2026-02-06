package stack;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private List<String> history;
    private int curr;
    private int n;

    BrowserHistory(String page) {
        history = new ArrayList<String>();
        history.add(page);
        curr = 0;
        n = 1;

    }

    public void visit(String url) {
        curr++;
        if (curr == history.size()) {
            history.add(url); // append to last
            n++;
        } else {
            // orreplace
            history.set(curr, url);
            n = curr + 1;

        }
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(n - 1, curr + steps);
        return history.get(curr);
    }
}

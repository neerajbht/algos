package queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4 };
        int k = 2;
        TopKElements tk = new TopKElements();
        int[] ans = tk.topk(nums, k);

        System.out.println("Top K");
        for (int a : ans) {
            System.out.println(a);
        }
    }

    public int[] topk(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> record = new HashMap<Integer, Integer>();

        for (int a : nums) {
            record.put(a, record.getOrDefault(a, 0) + 1);
        }

        record.forEach((key, val) -> {
            System.out.println("key " + key + " val " + val);
        });

        // add elemens to heap topk
        Queue<Integer> heap = new PriorityQueue<Integer>((n, m) -> record.get(n) - record.get(m));

        for (int n : record.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        for (int i = k - 1; i >= 0; --i) {
            ans[i] = heap.poll();
        }

        return ans;

    }

}

package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };

        List t = new ArrayList<>();
        t.add(intervals);

        var abc = t.toArray();

        System.out.println(abc[0]);

        InsertInterval inIv = new InsertInterval();
        int[] newInterval = { 4, 8 };
        intervals = inIv.insertBinary(intervals, newInterval);

        for (int[] a : intervals) {
            System.out.print(" " + "{");
            for (int i : a) {
                System.out.print(" " + i + " ");
            }
            System.out.print(" " + "}, ");
        }

    }

    // O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int idx = 0;
        List<int[]> ans = new ArrayList<int[]>();

        // pre intervals

        while (idx < n && intervals[idx][0] < newInterval[0]) {
            ans.add(intervals[idx]);
            idx++;
        }
        // merge range

        while (idx < n && newInterval[1] >= intervals[idx][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        ans.add(newInterval);

        // greater

        while (idx < n) {
            ans.add(intervals[idx]);
            idx++;
        }

        // Convert List to array
        return ans.toArray(new int[ans.size()][]);

    }

    // nlogn

    public int[][] insertBinary(int[][] intervals, int[] newInterval) {
        // If the intervals vector is empty, return a vector containing the newInterval
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;

        // Binary search to find the position to insert newInterval
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Insert newInterval at the found position
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        result.add(newInterval);

        for (int i = left; i < n; i++) {
            result.add(intervals[i]);
        }

        // Merge overlapping intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result) {
            // If res is empty or there is no overlap, add the interval to the result
            if (merged.isEmpty() ||
                    merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
                // If there is an overlap, merge the intervals by updating the end of the last
                // interval in res
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(
                        merged.get(merged.size() - 1)[1],
                        interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }

}

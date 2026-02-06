package array;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        NonOverlappingIntervals np = new NonOverlappingIntervals();

        System.out.println(np.eraseOverlapIntervals(intervals));

    }

    public int eraseOverlapIntervals(int[][] intervals) {

        // sort intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int k = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];

            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                count++;
            }
        }

        return count;

    }

}

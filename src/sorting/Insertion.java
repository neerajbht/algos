package sorting;

import java.util.Arrays;

public class Insertion {
    // usess swap
    public static int[] sort(int[] data) {

        for (int i = 1; i < data.length; i++) { // start from second position
            int j = i - 1;
            // iterate compare and swap values all items on the right with j (leftmost)
            /**
             * Swap-based: if 10 positions then 10 steps * 3 (temp swaps) = 3- write to
             * memory
             */
            while (j >= 0 && data[j] > data[j + 1]) {
                int temp = data[j + 1];
                data[j + 1] = data[j];
                data[j] = temp;
                j--;
            }
        }
        return data;

    }

    public static void sort(Comparable[] a) {
        int n = a.length;

        // put smallest element in position to serve as sentinel
        int exchanges = 0;
        for (int i = n - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0)
            return;

        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static int[] sort2(int[] data) {
        for (int i = 1; i < data.length; i++) {
            // Step 1: Pick up the current element (the "key")
            int key = data[i];
            int j = i - 1;

            // Step 2: Shift elements of data[0..i-1] that are
            // greater than the key to one position ahead
            // iterate compare and swap values all items on the right with j (leftmost)
            /**
             * Swap-based: if 10 positions then 10 shifts + 1 pick up and 1 drop =12 wrote
             * to memory
             * memory
             */
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j]; // Only 1 assignment here!
                j = j - 1;
            }

            // Step 3: Drop the key into its correct spot
            data[j + 1] = key;
        }
        return data;
    }

    public static void main(String[] args) {
        int[] unsortedData = { 3, 5, 4, 1, 2 };

        int[] sortedData = Insertion.sort2(unsortedData);

        System.out.println(Arrays.toString(sortedData));

        Arrays.sort(unsortedData);

    }

}

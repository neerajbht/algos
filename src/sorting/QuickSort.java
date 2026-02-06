package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(Comparable[] arr) {
        Shuffle.kshuffle(arr);

        sort(arr, 0, arr.length - 1);
    }

    public static void sortDP(Comparable[] arr) {
        Shuffle.kshuffle(arr);

        sort(arr, 0, arr.length - 1);
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w)
            return false; // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);

    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.

    public static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = arr[lo];

        while (true) {
            // find left item to swaps
            while (less(arr[++i], v)) {
                if (i == hi)
                    break;
            }
            // find right
            while (less(v, arr[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;

            exch(arr, i, j);

        }
        // put partitioning item v at a[j]

        exch(arr, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    // dijkastra's 3 way

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    public static void sortQ(Comparable[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo;
        int gt = hi;

        // arr[lo] is v
        /**
         * arr[i] < v --- exchange arr[lt] with arr[i] ,then increment both lt and i
         * arr[i] > v ------ exchange arr[gt] with arr[i] ,then decrement gt
         * arr[i] ==v , increment i
         */
        Comparable v = arr[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)
                exch(arr, lt++, i++); // increment both i and lt
            else if (cmp > 0)
                exch(arr, i, gt--); // ddecrement gt
            else
                i++;
        }
        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sortQ(arr, lo, lt - 1);
        sortQ(arr, gt + 1, hi);

    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    public static void sortDP(Comparable[] arr, int lo, int hi) {
        if (lo <= hi)
            return;
        // make sure a[lo] <= a[hi]

        if (less(arr[hi], arr[lo]))
            exch(arr, lo, hi);

        int lt = lo + 1;
        int gt = hi - 1;
        int i = lo + 1;

        while (i <= gt) {
            if (less(arr[i], arr[lo]))
                exch(arr, lt++, i++);
            else if (less(arr[hi], arr[i]))
                exch(arr, i, gt--);
            else
                i++;
        }
        exch(arr, lo, --lt);
        exch(arr, hi, ++gt);

        // recursively sort three subarrays
        sort(arr, lo, lt - 1);
        if (less(arr[lt], arr[gt]))
            sort(arr, lt + 1, gt - 1);
        sort(arr, gt + 1, hi);

    }

    // Dikastra--
    private static void sortDualPivot(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        // make sure a[lo] <= a[hi]
        if (less(a[hi], a[lo]))
            exch(a, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if (less(a[i], a[lo]))
                exch(a, lt++, i++);
            else if (less(a[hi], a[i]))
                exch(a, i, gt--);
            else
                i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        sort(a, lo, lt - 1);
        if (less(a[lt], a[gt]))
            sort(a, lt + 1, gt - 1);
        sort(a, gt + 1, hi);

    }

    /** find top K element in the array */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        Shuffle.kshuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if (i > k)
                hi = i - 1;
            else if (i < k)
                lo = i + 1;
            else
                return a[i];
        }
        return a[lo];
    }

    public static void main(String[] args) {

        Comparable[] colors = { 1, 0, 1, 2 }; // 0 is red , 1 is white and 2 is blue

        QuickSort.sortDP(colors);

        System.out.println(Arrays.toString(colors));
    }

}

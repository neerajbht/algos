package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeX {
    private static final int CUTOFF = 7; // cutoff to insertion sort

    // This class should not be instantiated.
    private MergeX() {
    }

    /**
     * 3. Stability and "One-Way" Merging
     * In your merge loop, you handle the four cases of pointer management:
     * 
     * Exhausted Left: If i > mid, just pull from the right side.
     * 
     * Exhausted Right: If j > hi, just pull from the left side.
     * 
     * Comparison: Use less(src[j], src[i]).
     * 
     * The Stability Note: By taking the element from the left side (src[i]) when
     * the values are equal (the else case), you ensure the sort is stable. This
     * means if you have two "4s", the one that appeared first in the original list
     * will stay first.
     * 
     * 
     * @param src
     * @param dst
     * @param lo
     * @param mid
     * @param hi
     */

    private static void merge1(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                dst[k] = src[j++];
            else if (j > hi)
                dst[k] = src[i++];
            else if (less(src[j], src[i]))
                dst[k] = src[j++]; // to ensure stability
            else
                dst[k] = src[i++];
        }

        // postcondition: dst[lo .. hi] is sorted subarray

    }

    private void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        /**
         * unsorted dst = { 4, 4, 3, 1, 6, 2 };
         * src [] = {3,4,4 ,1,2,6}
         * src has two sorted array seprated at mid as bove
         * i is index used to move in fist half of the array
         * i start with lo or 0th position and make sure it does not cross mid
         * j is index used to move second half of the array and has to be less than hi
         * 
         * private static void merge(Comparable[] src, Comparable[] dst, int lo, int
         * mid, int hi) {
         * 
         * // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
         * assert isSorted(src, lo, mid);
         * assert isSorted(src, mid+1, hi);
         * 
         * int i = lo, j = mid+1;
         * for (int k = lo; k <= hi; k++) {
         * if (i > mid) dst[k] = src[j++];
         * else if (j > hi) dst[k] = src[i++];
         * else if (less(src[j], src[i])) dst[k] = src[j++]; // to ensure stability
         * else dst[k] = src[i++];
         * }
         * 
         * // postcondition: dst[lo .. hi] is sorted subarray
         * assert isSorted(dst, lo, hi);
         * }
         * 
         */

        for (int k = lo; k <= hi; k++) {
            /**
             * case 1 make sure i does not corss mid , if it has then we use second half of
             * array or j to copy data this means all values from lo to mid are copied as
             * for loop is valid or k is valid
             */
            if (i > mid)
                dst[k] = src[j++];
            /**
             * case 2
             * make sure j does not cross hi or upper bound if it is then this means all
             * values from second
             * half of the array are coped and we just need from first half as for loop is
             * stil valid or k is valid
             */
            else if (j > hi)
                dst[k] = src[i++];
            /*
             * acutal comparision of value two halfs in the array
             * check if right half value is less if so take it other wise take left half and
             * move i,j accordingly
             */
            else if (less(src[j], src[i]))
                dst[k] = src[j++]; // to ensure stability
            else
                dst[k] = src[i++];
        }

        // postcondition: dst[lo .. hi] is sorted subarray

    }

    /**
     * 1. The "Ping-Pong" Buffer (Avoiding Array Allocation)
     * In a standard Merge Sort, the merge method creates a new temporary array
     * every single time it runs. Allocating memory in Java is expensive.
     * 
     * @param src
     * @param dst
     * @param lo
     * @param hi
     * 
     *            Notice the recursive calls: sort(dst, src, lo, mid).
     * 
     *            You swap the roles of the arrays at each level of recursion.
     * 
     *            The "source" of one level becomes the "destination" of the next.
     *            This eliminates the need to create new arrays during the merge
     *            process, saving significant time and memory.
     */

    private void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        // if (hi <= lo) return;
        /*
         * The Concept: For very small arrays (usually between 7 and 15 elements), the
         * overhead of recursion (stack frames, calculating midpoints) is actually
         * slower than a simple Insertion Sort.
         * 
         * Professional libraries (like Arrays.sort()) use this exact trick to
         * "clean up" the bottom of the recursion tree.
         * if (hi <= lo + CUTOFF) {
         * insertionSort(dst, lo, hi);
         * return;
         * }
         */

        if (hi <= lo) {

            return;
        }

        int mid = lo + (hi - lo) / 2;
        // recursively sort left
        sort(dst, src, lo, mid); // Note: sort(src) initializes dst[] and sets
        // recursively sort right
        sort(dst, src, mid + 1, hi); // dst[i] = src[i] for each i.
        // copy dst array
        // using System.arraycopy() is a bit faster than the above loop
        // copy sorted valued in dst for merge
        // otherwise merge array needs to do this copy
        /**
         * optimize if array already sorted
         * 2. The "Pre-Sorted" Check
         * Standard Merge Sort always merges, even if the data is already in order.
         */
        if (!less(src[mid + 1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi); // switch roles of dst[] and src[] as we want to do merge on dst keeping src
                                      // intact
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * 
     * @param a the array to be sorted
     */
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);

    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    /*******************************************************************
     * Utility methods.
     *******************************************************************/

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is a[i] < a[j]?
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // is a[i] < a[j]?
    private static boolean less(Object a, Object b, Comparator comparator) {
        return comparator.compare(a, b) < 0;
    }

    private static void insertionSort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--)
                exch(a, j, j - 1);
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them
     * (using an optimized version of mergesort);
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        Comparable[] a = { 4, 4, 3, 1, 6, 2 };
        MergeX mx = new MergeX();
        mx.sort(a);
        System.out.println("After sort " + Arrays.toString(a));
    }
}

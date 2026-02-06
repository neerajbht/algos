package sorting;

import java.util.Arrays;

public class SortColor {

    public static void sort(int[] colors) {

        sortnb(colors, 0, colors.length - 1);

    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    private static void sort(Comparable[] a, int lo, int hi) {
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

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    private static void sortnb(int[] a, int lo, int hi) {
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
        sortnb(a, lo, lt - 1);
        if (less(a[lt], a[gt]))
            sortnb(a, lt + 1, gt - 1);
        sortnb(a, gt + 1, hi);

    }

    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[two++] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            } else if (nums[i] == 1) {
                nums[two++] = 2;
                nums[one++] = 1;
            } else {
                nums[two++] = 2;
            }
        }
    }

    public static void main(String[] ards) {

        int[] colors = { 1, 0, 1, 2 }; // 0 is red , 1 is white and 2 is blue

        SortColor.sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }

}

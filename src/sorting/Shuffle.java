package sorting;

import java.util.Random;

public class Shuffle {

    public static void shuffle(Object[] arr) {

        Random r = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            // pick random index
            int j = r.nextInt(i++);
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    // important Knuth shuffle
    public static void kshuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

}

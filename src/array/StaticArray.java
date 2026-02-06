package array;

public class StaticArray {
    public void insertEnd(int[] arr, int n, int len, int capacity) {
        if (len < capacity) {
            arr[len] = n;
        }
    }

    public void removeEnd(int[] arr, int len) {
        if (len > 0) {
            arr[len - 1] = 0;
        }

    }

    public void insertMiddle(int[] arr, int pos, int a, int len) {
        // shift element right
        for (int i = len - 1; i > pos - 1; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = a;

    }

    public void removeMiddle(int[] arr, int i, int length) {
        // Shift starting from i + 1 to end.
        for (int index = i + 1; index < length; index++) {
            arr[index - 1] = arr[index];
        }
        // No need to 'remove' arr[i], since we already shifted
    }
}

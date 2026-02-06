package search;

public class BinarySearch {

    public static int search(Comparable[] data, Comparable target) {

        int result = -1;
        int left = 0, right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = target.compareTo(data[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }

        return result;

    }

    public static void main(String[] args) {

        Comparable[] data = { 1, 3, 4, 5, 6, 8, 9 };
        Comparable target = 7;
        System.out.println("Target Search , index of search = " + BinarySearch.search(data, target));

    }

}

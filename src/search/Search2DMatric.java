package search;

public class Search2DMatric {

    public static boolean searchMatrix(Comparable[][] data, Comparable target) {
        boolean result = false;
        /*
         * get
         * 
         * midCol do binary search on row if -1
         * 
         */
        int row = data.length;
        int col = data[0].length;

        int l = 0;
        int r = row - 1;
        while (l <= r) {

            int rowMid = l + (r - l) / 2;
            int cmp = target.compareTo(data[rowMid][0]);
            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                l = rowMid + 1;

            } else {
                r = rowMid - 1;
            }
            int res = BinarySearch.search(data[rowMid], target);
            if (res >= 0)
                return true;
            // else keep searching while all rows are not done

        }

        return result;

    }

    public static void main(String[] args) {

        Comparable[][] data = { { 1, 2, 3 }, { 4, 5, 6 }, { 6, 7, 8 } };

        Comparable target = 9;
        System.out.println("Target Search , index of search = " + Search2DMatric.searchMatrix(data, target));

    }

}

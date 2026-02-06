
class Solution {

    public static boolean searchMatrix(int[][] data,
            int target) {
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
            int cmp = target - (data[rowMid][0]);
            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                l = rowMid + 1;

            } else {
                r = rowMid - 1;
            }
            int res = bsearch(data[rowMid], target);
            if (res >= 0)
                return true;
            // else keep searching while all rows are not done

        }

        return result;

    }

    public static int bsearch(int[] data, int target) {

        int result = -1;
        int left = 0, right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = target - (data[mid]);
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
}

package leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] sortedArr = { 1, 3, 4, 6, 8, 10, 13 };
        int target = 6;

        System.out.println(TwoSum.hasTargetSum(sortedArr, target));
    }

    public static boolean hasTargetSum(int[] arr, int target) {

        int i = 0;
        int r = arr.length - 1;
        int sum = 0;
        while (i < r) {
            sum = arr[i] + arr[r];
            if (sum == target)
                return true;
            else if (sum < target) {
                i++;
            } else {
                r--;
            }
        }
        return false;
    }
}

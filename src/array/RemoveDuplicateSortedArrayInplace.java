package array;

public class RemoveDuplicateSortedArrayInplace {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        RemoveDuplicateSortedArrayInplace.removeDuplicateInPlace(nums);

    }

    public static int[] removeDuplicateInPlace(int[] nums) {

        int lastDupPos = 1;

        System.out.println("Before");
        for (int a : nums)
            System.out.print(" " + a);
        System.out.println("");

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[lastDupPos] = nums[i];
                lastDupPos++;

            }
        }

        System.out.println("After");
        for (int a : nums)
            System.out.print(" " + a);

        return nums;

    }

}

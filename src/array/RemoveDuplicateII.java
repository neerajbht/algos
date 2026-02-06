package array;

public class RemoveDuplicateII {

    /**
     * class removes duplicate in sorted array
     * max 2 duplicate allowed
     * retuns length of altered array
     * Input: nums = [1,1,1,2,2,3]
     * inde positio= [0,1,2,3,4,5]
     * 
     */

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 1; // Pointer to iterate through the array
        int j = 1; // Pointer to track position for valid elements
        int count = 1; // Count of occurrences of the current element

        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    i++;
                    continue;
                }
            } else {
                count = 1;
            }
            nums[j++] = nums[i++];

        }

        // Java arrays can't be resized like C++ vectors,
        // so we return the size directly.
        return j;
    }

    public static void main(String[] argds) {
        int[] sample = { 1, 1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6 };
        System.out.println(RemoveDuplicateII.removeDuplicates(sample));

    }

}

package leetcode;

public class MajorityElement {

    /**
     * majority element assumptions
     * 1 - majority element exists and is greater than median array lenght
     * 
     */
    public int majorityElement(int[] nums) {
        /**
         * so with assumption that majority element exixt
         * we can iterate over the elements
         * increase count if element is majority else decrase
         * eventually by the end of loop we will have majority element selected
         */
        int majElement = nums[0];
        int count = 0;
        for (int a : nums) {
            // select maj element or reselect majority element
            if (count == 0) {
                /** there is no element selected yet */
                majElement = a;
                count++;
            } else {
                // there is element already
                if (majElement == a) {
                    count++;
                } else {
                    count--;
                }

            }

        }
        return majElement;
    }

    public static void main(String[] argds) {
        int[] nums = { 1, 2, 1, 2, 3, 2, 1, 2, 3, 1, 1, 6, 2, 3, 3, 3, };
        MajorityElement mm = new MajorityElement();

        System.out.println("majority element is " + mm.majorityElement(nums));

    }
}

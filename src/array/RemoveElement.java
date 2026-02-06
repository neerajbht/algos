package array;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 3, 4, 1, 4, 4, 5 };
        int val = 4;

        System.out.println(RemoveElement.removeElement(nums, val));

    }

    public static int removeElement(int[] nums, int val) {
        int matchIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[matchIndex] = nums[i];
                matchIndex++;
            }
        }
        for (int a : nums)
            System.out.print(a + " ");

        return matchIndex;
    }
}

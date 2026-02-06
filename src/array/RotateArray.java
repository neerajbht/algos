package array;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2 };

        RotateArray.rotate(arr, 3);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int[] temp = new int[k];
        int len = nums.length;
        System.arraycopy(nums, len - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);

    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        printArray(nums);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

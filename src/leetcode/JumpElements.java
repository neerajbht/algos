
package leetcode;

public class JumpElements {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        System.out.println(lastPos == 0);

    }

}

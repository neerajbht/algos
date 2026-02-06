package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* claas subset without duplicate */

public class SubSet {

    // // Time: O(n * 2^n), Space: O(n)

    public static List<List<Integer>> subSetsNoDuplicate(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        List<Integer> curSet = new ArrayList<>();

        generateSubSetNoDuplicate(0, nums, curSet, subset);

        return subset;
    }

    public static void generateSubSetNoDuplicate(int i, int[] nums, List<Integer> curSet,
            List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]);
        generateSubSetNoDuplicate(i + 1, nums, curSet, subsets);
        // remove curr at the end of recurison
        curSet.remove(curSet.size() - 1);
        generateSubSetNoDuplicate(i + 1, nums, curSet, subsets);

    }

    public static List<List<Integer>> subSetsWithDuplicate(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        List<Integer> curSet = new ArrayList<>();
        Arrays.sort(nums); // important

        generateSubSetwithDuplicate(0, nums, curSet, subset);

        return subset;
    }

    public static void generateSubSetwithDuplicate(int i, int[] nums, List<Integer> curSet,
            List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]);
        generateSubSetwithDuplicate(i + 1, nums, curSet, subsets);
        // remove curr at the end of recurison
        curSet.remove(curSet.size() - 1);
        // ignore duplicate
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        generateSubSetwithDuplicate(i + 1, nums, curSet, subsets);

    }

    public static void main(String[] ards) {

        int[] nums = { 1, 2, 3 };

        int[] nums2 = { 3, 4, 4, 5 };

        System.out.println("No duplciate");

        List<List<Integer>> data = SubSet.subSetsNoDuplicate(nums);

        for (List<Integer> lst : data) {
            System.out.println(lst.toString());
        }

        System.out.println("with duplciate");

        List<List<Integer>> data2 = SubSet.subSetsWithDuplicate(nums2);

        for (List<Integer> lst : data2) {
            System.out.println(lst.toString());
        }

    }

}

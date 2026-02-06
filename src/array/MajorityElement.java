package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] elements = { 2, 2, 1, 1, 1, 2, 2 };

        MajorityElement mm = new MajorityElement();

        System.out.println(mm.majorityElementsHashmap(elements));

    }

    public int majorityElements(int[] nums) {
        int count = 0;
        int element = 0;
        for (int a : nums) {
            if (count == 0) {
                element = a;
            }
            if (a == element) {
                count++;
            } else {
                count--;
            }

        }
        return element;

    }

    public int majorityElementsHashmap(int[] nums) {

        int len = nums.length;
        int majoritMak = (len >> 1) + 1;
        Map<Integer, Integer> record = new HashMap<>();

        for (int a : nums) {
            int counter = record.getOrDefault(a, 0) + 1;
            if (counter >= majoritMak) {
                return a;
            } else {
                record.put(a, counter);
            }

        }

        return -1;

    }

}

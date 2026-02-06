package array;

import java.util.HashSet;
import java.util.Set;;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nummArray = { 1, 2, 3, 4, 6, 6 };

        System.out.println("duplicate exists >>>>" + ContainsDuplicate.hasDuplicateNumber(nummArray));

    }

    public static boolean hasDuplicateNumber(int[] arr) {
        Set<Integer> filteredRec = new HashSet<Integer>();

        for (int a : arr) {
            if (filteredRec.contains(a))
                return true;
            else
                filteredRec.add(a);
        }
        return false;

    }

}

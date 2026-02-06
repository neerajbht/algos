package array;

/** https://leetcode.com/problems/contains-duplicate/ */
import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {

  public boolean containsDuplicate(int[] nums) {
    boolean isUnique = false;
    Set<Integer> ss = new HashSet<Integer>();
    for (int a : nums) {
      isUnique = ss.add(a);
      if (!isUnique) {
        return true;
      }
    }
    return false;

  }

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 4, 4, 5, 6, 6, 7, 7 };
    DuplicateInArray dd = new DuplicateInArray();
    System.out.println(dd.containsDuplicate(arr));
  }

}

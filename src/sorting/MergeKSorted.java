package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeKSorted {

    private List<Integer> mergeKSorted(List<List<Integer>> list) {

        List<Integer> result = new ArrayList<>();

        if (list.size() == 0)
            return result;

        for (int i = 1; i < list.size(); i++) {
            if (result.size() == 0)
                result = sortList(list.get(i - 1), list.get(i));
            else {
                result = sortList(result, list.get(i));
            }
        }

        return result;

    }

    private List<Integer> sortList(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0, j = 0;
        if (size1 == 0) {
            result.addAll(list2);
        }
        if (size2 == 0) {
            result.addAll(list1);
        }

        while (i < size1 && j < size2) {
            if (list1.get(i) > list2.get(j)) {
                result.add(list2.get(j++));

            } else if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));

            } else if (list1.get(i) == list2.get(j)) {
                result.add(list1.get(i++));
                result.add(list2.get(j++));

            }
        }
        // pending itgems

        while (i < size1) {
            result.add(list1.get(i++));
        }
        while (j < size2) {
            result.add(list2.get(j++));
        }
        return result;

    }

    public static void main(String[] ards) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        l2.add(5);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(6);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        MergeKSorted ms = new MergeKSorted();

        List<Integer> sorted = ms.mergeKSorted(list);

        System.out.println(sorted.toString());

    }
}
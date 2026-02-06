package map;

import java.util.Set;
import java.util.TreeSet;

public class TreeMapDemo implements Comparable<TreeMapDemo> {
    int key;
    int value;

    public TreeMapDemo(int k, int v) {
        this.key = k;
        this.value = v;

    }

    /**
     * in desc order we use o.value ,this.value
     * in asc order we use thisvalue,o.value
     */
    @Override
    public int compareTo(TreeMapDemo o) {

        return Integer.compare(o.value, this.value);

    }

    @Override
    public String toString() {
        return this.key + " " + String.valueOf(this.value);
    }

    public static void main(String[] ards) {

        TreeMapDemo td1 = new TreeMapDemo(1, 2);
        TreeMapDemo td2 = new TreeMapDemo(2, 3);
        TreeMapDemo td3 = new TreeMapDemo(3, 1);

        // Sort by value field in descending order (highest first)
        Set<TreeMapDemo> data = new TreeSet<TreeMapDemo>();
        data.add(td1);
        data.add(td2);
        data.add(td3);

        System.out.println(data);

    }

}

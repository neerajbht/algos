import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test {
    public static void main(String[] args) {
        /**
         * nput: s = "P A Y P A L I S H I R I N G", numRows = 4
         * Output : ="P I N A L S I G Y A H R P I"
         * Explanation:
         * P I N
         * A L S I G
         * Y A H R
         * P I
         */

        String[] arr = "123.5".split(".");

        int sum = ((((1 ^ 5) ^ 2) ^ 5) ^ 2) ^ 1;

        System.out.println(sum);

        System.out.println("sum>>>>>>>>>>>> " + 13 % 10);

        String aa = "PAYPALISHIRING";
        System.out.println("string len " + aa.length());
        int len = aa.length();

        String abc = "123";
        long test = Integer.valueOf(abc);
        long t = 1360826667806852920L;

        System.out.println(">>>>>>>" + len / 4);
        System.out.println(">>>>>>>" + len % 4);

        int[][] a = new int[2][5];

        int[] nums = { 1, 2, 3, 4, 5, 5, };
        Arrays.asList(nums);

        Queue<Integer> dd = new PriorityBlockingQueue<>();

        ArrayList<Integer> as = new ArrayList<>();

        as.reversed();

        List<Character>[] rows = new ArrayList[2];

        System.out.println('a' ^ 'b');

        Test.printArray(a);
        Test.findDiagonalOrder(a);

    }

    private static void printArray(int[][] a) {

        System.out.println("xor is " + ('a' ^ 'b'));

        System.out.println(a[0].length);

        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }

        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        try {
            long numA = Long.valueOf(12123);
            long numB = Long.valueOf(223423423);

            String bc = String.valueOf(numA * numB);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int[] res = new int[1];
        System.out.print(m);
        return res;

    }
}
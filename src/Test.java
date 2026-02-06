
public class Test {
    public static void main(String[] args) {

        int[][] a = new int[2][5];

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
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int[] res = new int[1];
        System.out.print(m);
        return res;

    }
}
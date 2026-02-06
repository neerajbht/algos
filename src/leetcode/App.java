package leetcode;

import java.util.Arrays;

@SuppressWarnings("rawtypes")

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] rating = { 1, 2, 3 };

        Arrays.stream(rating).forEach(ra -> {
            System.out.print("     " + ra);
        });

        System.out.println("  ");
        System.out.println("  ");

        System.out.println("  ");

        System.out.println(Math.sqrt(6));

        int[][] arry = new int[10][20];
        System.out.println(arry.length);

        for (int i = 0; i < arry.length; i++) {
            System.out.println("");
            for (int j = 0; j < arry.length; j++) {
                System.out.print(" " + arry[i][j]);
            }
            System.out.println("");
        }

    }
}

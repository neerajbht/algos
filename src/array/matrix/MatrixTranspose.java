package array.matrix;

import java.util.Arrays;

public class MatrixTranspose {

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int[][] transposed = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transposed[j][i] = arr[i][j];
            }
        }

        System.out.println("Original Matrix:" + Arrays.deepToString(arr));
        System.out.println("Transposed Matrix:" + Arrays.deepToString(transposed));

    }

}

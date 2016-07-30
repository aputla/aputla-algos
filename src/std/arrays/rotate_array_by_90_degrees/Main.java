package std.arrays.rotate_array_by_90_degrees;

import java.util.Arrays;

class Main {
    private static void display(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }
        System.out.println();
    }

    private static void rotate(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                int temp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = temp;
            }
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length / 2; j++) {
                int temp = M[i][j];
                M[i][j] = M[i][M.length - 1 -j];
                M[i][M.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[3][];
        for (int i = 0; i < M.length; i++) {
            M[i] = new int[3];
        }

        int k = 100;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                M[i][j] = k++;
            }
        }
        display(M);
        rotate(M);
        display(M);
    }
}


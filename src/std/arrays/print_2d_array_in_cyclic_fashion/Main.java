package std.arrays.print_2d_array_in_cyclic_fashion;

public class Main {

    private static void print(int[][] M) {
        int w = M[0].length;
        int h = M.length;
        for (int i = 0; i < h / 2; i++) {
            printTopRow(M, i, i, w - i - 1);
            printRightCol(M, w - i - 1, i + 1, h - i - 1);
            printBottomRow(M, h - i - 1, w - i - 2, i);
            printLeftCol(M, i, h - i - 2, i + 1);
        }
    }

    private static void printTopRow(int[][] M, int row, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(M[row][i]);
        }
    }

    private static void printBottomRow(int[][] M, int row, int start, int end) {
        for (int i = start; i >= end; i--) {
            System.out.println(M[row][i]);
        }
    }

    private static void printRightCol(int[][] M, int col, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(M[i][col]);
        }
    }

    private static void printLeftCol(int[][] M, int col, int start, int end) {
        for (int i = start; i >= end; i--) {
            System.out.println(M[i][col]);
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                { 1,  2,  3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10,  9,  8, 7}
            };
       print(M);
    }
}

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        solveNQueens(arr, 0, n);
        System.out.println("--------All possible solutions--------");
    }

    public static void solveNQueens(int[][] arr, int x, int n) {
        if (x == n) {
            printBoard(arr);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(arr, x, col, n)) {
                arr[x][col] = 1;
                solveNQueens(arr, x + 1, n);
                arr[x][col] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] arr, int x, int y, int n) {
        for (int row = 0; row < x; row++) {
            if (arr[row][y] == 1) {
                return false;
            }
        }

        int row = x;
        int col = y;
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = x;
        col = y;
        while (row >= 0 && col < n) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }

        return true;
    }

    public static void printBoard(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    System.out.print("[Q]");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
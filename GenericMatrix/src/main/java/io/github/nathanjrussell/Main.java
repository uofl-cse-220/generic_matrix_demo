package io.github.nathanjrussell;

import io.github.nathanjrussell.betterNumber.BetterInteger;
import io.github.nathanjrussell.betterNumber.BetterNumber;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void profileMatrix(int rows, int cols, int sums) {
        long startTime = System.nanoTime();
        Matrix<BetterInteger> matrix3 = new Matrix<>(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix3.setEntry(i, j, new BetterInteger(i + j));
            }
        }
        for (int i = 0; i < sums; i++) {
            matrix3 = matrix3.add(matrix3);
        }

        long endTime = System.nanoTime();
        System.out.println("Matrix Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    public static void profileSuppressMatrix(int rows, int cols, int sums) {
        long startTime = System.nanoTime();
        SuppressErrorMatrix<BetterInteger> matrix = new SuppressErrorMatrix<>(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setEntry(i, j, new BetterInteger(i + j));
            }
        }

        for (int i = 0; i < sums; i++) {
            matrix = matrix.add(matrix);
        }
        long endTime = System.nanoTime();
        System.out.println("Suppress Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    public static void profileIntegerMatrix(int rows, int cols, int sums) {
        long startTime = System.nanoTime();
        IntegerMatrix matrix = new IntegerMatrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setEntry(i, j, i + j);
            }
        }
        for (int i = 0; i < sums; i++) {
            matrix = matrix.add(matrix);
        }
        long endTime = System.nanoTime();
        System.out.println("Integer Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    public static void profileDoubleMatrix(int rows, int cols, int sums) {
        long startTime = System.nanoTime();
        DoubleMatrix matrix = new DoubleMatrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setEntry(i, j, i + j);
            }
        }
        for (int i = 0; i < sums; i++) {
            matrix = matrix.add(matrix);
        }
        long endTime = System.nanoTime();
        System.out.println("Double Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    public static void profileBoxedMatrix(int rows, int cols, int sums) {
        long startTime = System.nanoTime();
        BoxedMatrix<Integer> matrix = new BoxedMatrix<>(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setEntry(i, j, i + j);
            }
        }
        for (int i = 0; i < sums; i++) {
            matrix = matrix.add(matrix);
        }
        long endTime = System.nanoTime();
        System.out.println("Boxed Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    public static void main(String[] args) {
        // Example usage of IntegerMatrix
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        IntegerMatrix intMatrix1 = new IntegerMatrix(data);
        int[][] data2 = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        IntegerMatrix intMatrix2 = new IntegerMatrix(data2);
        IntegerMatrix intMatrix3 = intMatrix1.add(intMatrix2);
        System.out.println(intMatrix3.getEntry(0, 0));


        // Example usage of DoubleMatrix
        double[][] doubleData = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}, {7.7, 8.8, 9.9}};
        double[][] doubleData2 = {{10.1, 11.1, 12.1}, {13.1, 14.1, 15.1}, {16.1, 17.1, 18.1}};
        DoubleMatrix doubleMatrix = new DoubleMatrix(doubleData);
        DoubleMatrix doubleMatrix2 = new DoubleMatrix(doubleData2);
        DoubleMatrix doubleMatrix3 = doubleMatrix.add(doubleMatrix2);
        System.out.println(doubleMatrix3.getEntry(0, 0));

        int rows = 5000;
        int cols = 5000;
        int sums = 2;
        profileMatrix(rows, cols, sums);
        profileSuppressMatrix(rows, cols, sums);
        profileIntegerMatrix(rows, cols, sums);
        profileDoubleMatrix(rows, cols, sums);
        profileBoxedMatrix(rows, cols, sums);
    }
}
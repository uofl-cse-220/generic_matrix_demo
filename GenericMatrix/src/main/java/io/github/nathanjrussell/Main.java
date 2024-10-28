package io.github.nathanjrussell;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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

    }
}
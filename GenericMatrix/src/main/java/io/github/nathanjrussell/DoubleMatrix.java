package io.github.nathanjrussell;

public class DoubleMatrix {
    int numRows;
    int numCols;
    double[][] entries;

    public DoubleMatrix(int numRows, int numCols) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("Number of rows must be greater than 0");
        }
        if (numCols <= 0) {
            throw new IllegalArgumentException("Number of columns must be greater than 0");
        }
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = new double[numRows][numCols];
    }

    public DoubleMatrix(double[][] data) {
        if (data.length == 0) {
            throw new IllegalArgumentException("Data cannot be empty");
        }
        this.numRows = data.length;
        this.numCols = data[0].length;
        for (int i = 1; i < data.length; i++) {
            if (data[i].length != this.numCols) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
        }
        this.entries = data;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double getEntry(int row, int col) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Invalid row index");
        }
        if (col < 0 || col >= numCols) {
            throw new IndexOutOfBoundsException("Invalid column index");
        }
        return entries[row][col];
    }

    public void setEntry(int row, int col, double value) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Invalid row index");
        }
        if (col < 0 || col >= numCols) {
            throw new IndexOutOfBoundsException("Invalid column index");
        }
        entries[row][col] = value;
    }

    public DoubleMatrix add(DoubleMatrix other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }
        DoubleMatrix result = new DoubleMatrix(numRows, numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.setEntry(i, j, this.getEntry(i, j) + other.getEntry(i, j));
            }
        }
        return result;
    }
}

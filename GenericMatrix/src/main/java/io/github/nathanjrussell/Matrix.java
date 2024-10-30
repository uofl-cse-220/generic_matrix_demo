package io.github.nathanjrussell;

public class Matrix<T extends BetterInteger> {
    int numRows;
    int numCols;
    T[][] entries;

    public Matrix(int numRows, int numCols) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("Number of rows must be greater than 0");
        }
        if (numCols <= 0) {
            throw new IllegalArgumentException("Number of columns must be greater than 0");
        }
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = new T[numRows][numCols];
    }

    public Matrix(T[][] data) {
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

    public T getEntry(int row, int col) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Invalid row index");
        }
        if (col < 0 || col >= numCols) {
            throw new IndexOutOfBoundsException("Invalid column index");
        }
        return entries[row][col];
    }

    public void setEntry(int row, int col, T value) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Invalid row index");
        }
        if (col < 0 || col >= numCols) {
            throw new IndexOutOfBoundsException("Invalid column index");
        }
        entries[row][col] = value;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }
        Matrix<T> result = new Matrix<T>(numRows, numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.setEntry(i, j, this.getEntry(i, j).add(other.getEntry(i, j)));
            }
        }
        return result;
    }
}

package io.github.nathanjrussell;

import io.github.nathanjrussell.betterNumber.BetterNumber;

public class SuppressErrorMatrix<T extends BetterNumber<T>> {
    protected int numRows;
    protected int numCols;
    protected T[][] entries;

    @SuppressWarnings("unchecked")
    public SuppressErrorMatrix(int numRows, int numCols) {
        validateDimensions(numRows, numCols);
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = (T[][]) new BetterNumber[numRows][numCols];
    }

    public SuppressErrorMatrix(T[][] data) {
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
        validateIndices(row, col);
        return entries[row][col];
    }

    public void setEntry(int row, int col, T value) {
        validateIndices(row, col);
        entries[row][col] = value;
    }

    @SuppressWarnings("unchecked")
    public SuppressErrorMatrix<T> add(SuppressErrorMatrix<T> other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        T[][] newEntries = (T[][]) new BetterNumber[this.numRows][this.numCols];
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                newEntries[i][j] = this.entries[i][j].add(other.entries[i][j]);
            }
        }
        return new SuppressErrorMatrix<T>(newEntries);
    }

    private void validateIndices(int row, int col) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Invalid row index");
        }
        if (col < 0 || col >= numCols) {
            throw new IndexOutOfBoundsException("Invalid column index");
        }
    }

    private void validateDimensions(int numRows, int numCols) {
        if (numRows <= 0) {
            throw new IllegalArgumentException("Number of rows must be greater than 0");
        }
        if (numCols <= 0) {
            throw new IllegalArgumentException("Number of columns must be greater than 0");
        }
    }
}

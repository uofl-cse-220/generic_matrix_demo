package io.github.nathanjrussell;

import io.github.nathanjrussell.betterNumber.BetterNumber;
import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends BetterNumber<T>> {
    protected int numRows;
    protected int numCols;
    protected List<List<T>> entries;

    public Matrix(int numRows, int numCols) {
        validateDimensions(numRows, numCols);
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = new ArrayList<>(numRows);

        // Initialize the 2D list structure
        for (int i = 0; i < numRows; i++) {
            List<T> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(null); // Initially setting each cell to null
            }
            entries.add(row);
        }
    }

    public Matrix(List<List<T>> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }
        this.numRows = data.size();
        this.numCols = data.get(0).size();

        // Verify all rows have the same length
        for (List<T> row : data) {
            if (row.size() != this.numCols) {
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
        return entries.get(row).get(col);
    }

    public void setEntry(int row, int col, T value) {
        validateIndices(row, col);
        entries.get(row).set(col, value);
    }

    public Matrix<T> add(Matrix<T> other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }

        List<List<T>> newEntries = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<T> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                row.add(this.entries.get(i).get(j).add(other.entries.get(i).get(j)));
            }
            newEntries.add(row);
        }

        return new Matrix<>(newEntries);
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

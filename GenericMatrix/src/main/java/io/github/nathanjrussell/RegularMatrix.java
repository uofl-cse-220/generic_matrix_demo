package io.github.nathanjrussell;

import java.util.ArrayList;
import java.util.List;

public class RegularMatrix<T extends Number> {
    protected int numRows;
    protected int numCols;
    protected List<List<T>> entries;

    public RegularMatrix(int numRows, int numCols) {
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

    public RegularMatrix(List<List<T>> data) {
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

    public RegularMatrix<T> add(RegularMatrix<T> other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }

        List<List<T>> newEntries = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<T> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                T a = this.entries.get(i).get(j);
                T b = other.entries.get(i).get(j);
                T result;

                // Using instanceof to handle both Integer and Double
                if (a instanceof Integer && b instanceof Integer) {
                    result = (T) Integer.valueOf(a.intValue() + b.intValue());
                } else if (a instanceof Double && b instanceof Double) {
                    result = (T) Double.valueOf(a.doubleValue() + b.doubleValue());
                } else {
                    throw new IllegalArgumentException("Matrices must contain the same type of number (Integer or Double)");
                }

                row.add(result);
            }
            newEntries.add(row);
        }

        return new RegularMatrix<>(newEntries);
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

package io.github.nathanjrussell;

import java.util.ArrayList;
import java.util.List;

public class BoxedMatrix<T extends Number> {
    protected int numRows;
    protected int numCols;
    protected List<List<T>> entries;

    public BoxedMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        validateDimensions(numRows, numCols);
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

    public BoxedMatrix(List<List<T>> data) {
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

    public BoxedMatrix<T> add(BoxedMatrix<T> other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }

        List<List<T>> newEntries = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<T> row = new ArrayList<>(numCols);
            for (int j = 0; j < numCols; j++) {
                T sum = addNumbers(this.entries.get(i).get(j), other.entries.get(i).get(j));
                row.add(sum);
            }
            newEntries.add(row);
        }

        return new BoxedMatrix<>(newEntries);
    }

    @SuppressWarnings("unchecked")
    private T addNumbers(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
        if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
        throw new UnsupportedOperationException("Addition not supported for type " + a.getClass());
    }


    private void validateIndices(int row, int col) {
        if (row < 0 || row >= this.numRows) {
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

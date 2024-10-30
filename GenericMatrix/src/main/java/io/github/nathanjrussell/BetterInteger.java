package io.github.nathanjrussell;

public class BetterInteger extends Number {
    private final int value;

    public BetterInteger(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public short shortValue() {
        return (short) value;
    }

    @Override
    public byte byteValue() {
        return (byte) value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    // Additional methods can be added here
    public BetterInteger add(BetterInteger other) {
        return new BetterInteger(this.value + other.value);
    }

    public BetterInteger subtract(BetterInteger other) {
        return new BetterInteger(this.value - other.value);
    }

    public BetterInteger multiply(BetterInteger other) {
        return new BetterInteger(this.value * other.value);
    }

    public BetterInteger divide(BetterInteger other) {
        if (other.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new BetterInteger(this.value / other.value);
    }
}

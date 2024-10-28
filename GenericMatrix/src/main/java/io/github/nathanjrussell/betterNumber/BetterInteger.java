package io.github.nathanjrussell.betterNumber;

public class BetterInteger extends Number implements BetterNumber<BetterInteger> {
    protected final int value;

    public BetterInteger(int i){
        this.value = i;
    }

    public BetterInteger add(BetterInteger other) {
        return new BetterInteger(this.value + other.value);
    }

    public BetterInteger add(int other) {
        return new BetterInteger(this.value + other);
    }

    public BetterInteger additiveInverse() {
        return new BetterInteger(-this.value);
    }

    public BetterInteger multiply(BetterInteger other) {
        return new BetterInteger(this.value * other.value);
    }

    public int getValue() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long)this.value;
    }

    public float floatValue() {
        return (float)this.value;
    }

    public double doubleValue() {
        return (double)this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

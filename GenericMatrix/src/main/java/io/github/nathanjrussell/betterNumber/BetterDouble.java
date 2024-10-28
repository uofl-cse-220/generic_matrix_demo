package io.github.nathanjrussell.betterNumber;

public class BetterDouble extends Number implements BetterNumber<BetterDouble> {
    protected final double value;

    public BetterDouble(double i){
        this.value = i;
    }

    public BetterDouble add(BetterDouble other) {
        return  new BetterDouble(this.value + other.value);

    }

    public BetterDouble add(double other) {
        return new BetterDouble(this.value + other);
    }

    public BetterDouble additiveInverse() {
        return new BetterDouble(-this.value);
    }

    public BetterDouble multiply(BetterDouble other) {
        return new BetterDouble(this.value * other.value);
    }

    public double getValue() {
        return this.value;
    }

    public int intValue() {
        return (int)this.value;
    }

    public long longValue() {
        return (long)this.value;
    }

    public float floatValue() {
        return (float)this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public String toString() {
        return Double.toString(this.value);
    }
}
